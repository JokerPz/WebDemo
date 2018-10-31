package com.joker.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.valves.JDBCAccessLogValve;

import com.joker.pojo.Dept;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

public class Dao {
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException{
		return (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/exercise2?characterEncoding=UTF-8", "root", "123456");
	}
	
	public List<Dept> list(){
		List<Dept> list=new ArrayList<>();
		try(Connection c=getConnection();
			Statement s=c.createStatement();){
			String sql="select * from dept";
			ResultSet rs=(ResultSet) s.executeQuery(sql);
			while(rs.next()){
				Dept dept=new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				list.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return list;
		}
	}
}
