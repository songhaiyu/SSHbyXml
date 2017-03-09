package com.shy.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shy.entity.Userinfo;
import com.shy.service.UserManagerService;

/** 
 * 用户管理控制器 
 * */  
public class UserManagerAct extends ActionSupport {
	
	private Userinfo userinfo = new Userinfo();   
    
    private UserManagerService<Userinfo> userService;  
      
    private List<Userinfo> users;  
      
    private String searchText;
    
    public String doLogin(){  
    	if(this.userinfo.getUname()==null||this.userinfo.getPassword()==null){
    		return INPUT;
    	}
        try {  
            Userinfo user = userService.doLogin(this.userinfo.getUname(), this.userinfo.getPassword());  
            if(user != null){  
                ActionContext.getContext().getSession().put("userinfo", user);  
                return this.doQuery();  
            }else  
                return INPUT;  
        } catch (Exception e) {  
            return ERROR;  
        }  
    }  
    public String doQuery(){  
        searchText = getParam("queryText");  
        users = userService.queryUsers(searchText,Userinfo.class);  
        return SUCCESS;  
    }  
    public String doAdd(){  
        String result = "";  
        try {  
            String param = getParam("param");  
            if(Integer.parseInt(param) > 0){  
                userinfo.setId(0);  
                userService.addUser(userinfo);  
                result = doQuery();  
            }else  
                result = "addUser";  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
    
    public String doEdit(){  
        try {  
            Integer param = Integer.parseInt(getParam("param"));  
            if(param == 0){  
                Integer id = Integer.parseInt(getParam("id"));  
                userinfo = userService.getUser(Userinfo.class, id);  
                return "editUser";  
            }else if(param == 1){  
                userService.modifyUser(userinfo);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return doQuery();  
    }  
    
    
    
    public String doDelete(){  
        try {  
            Integer param = Integer.parseInt(getParam("id"));  
            userService.deleteUser(param,Userinfo.class);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return doQuery();  
    }  
    

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}




	protected String getParam(String key){  
        return ServletActionContext.getRequest().getParameter(key);  
    }  

	public Userinfo getUser() {
		return userinfo;
	}

	public void setUser(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public UserManagerService<Userinfo> getUserService() {
		return userService;
	}

	public void setUserService(UserManagerService<Userinfo> userService) {
		this.userService = userService;
	}

	public List<Userinfo> getUsers() {
		return users;
	}

	public void setUsers(List<Userinfo> users) {
		this.users = users;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}  
    
    

}
