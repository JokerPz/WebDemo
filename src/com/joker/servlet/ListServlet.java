package com.joker.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joker.dao.Dao;
import com.joker.pojo.Dept;

public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建数据库操作对象
		Dao dao=new Dao();
		
		//获取查询数据
		List<Dept> list=null;
		list=dao.list();
		//for each遍历
//		for(Dept d:list){
//			resp.getWriter().println(d.toString()+"</br>");
//		}
		
		Iterator<Dept> it=list.iterator();
		while(it.hasNext()){
			Dept d=it.next();
			resp.getWriter().println(d.toString()+"</br>");
		}
	}
}
