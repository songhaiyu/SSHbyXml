package com.shy.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDao extends HibernateDaoSupport {

	/**��ѯ*/  
    public <T> List<T> getObjects(String queryString){  
        return (List<T>)this.getHibernateTemplate().find(queryString);  
    }  
      
    /**��ѯ����*/  
    public <T> List<T> getAllObjects(Class<T> clazz){  
        return this.getHibernateTemplate().loadAll(clazz);  
    }  
      
    /**����һ��*/  
    public <T> void addObject(T clazz){  
        this.getHibernateTemplate().save(clazz);  
    }  
      
    /**����ָ����*/  
    public <T> void updateObject(T clazz){  
        this.getHibernateTemplate().update(clazz);  
    }  
  
    /**ɾ��ָ����*/  
    public <T> void deleteObject(T clazz){  
        this.getHibernateTemplate().delete(clazz);  
    }  
      
    /**ͨ��id��ȡ*/  
    public <T> T getObject(Class<T> clazz,Serializable id){  
        return this.getHibernateTemplate().get(clazz, id);  
    }  
}