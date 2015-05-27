/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.footballwc.service;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	private HibernateUtil(){
		
	}
	
	static{
		try{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable e){
			throw new ExceptionInInitializerError(e); 
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}
	
	
	
	
}
