package org.cms.Repository;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.cms.DataSource.*;
import org.cms.Model.*;



	
	



public class CourseRepository {
	private MySqlDBConnection connection;
//alt shift s
	public CourseRepository(MySqlDBConnection connection) {
		super();
		this.connection = connection;
	}
	public MySqlDBConnection getConnection() {
		return connection;
	}
	public void setConnection(MySqlDBConnection connection) {
		this.connection = connection;
	}

public int insertCourse(Course s) {
	
String sql="insert into cource values(?,?,?,?)";
	int r=0; 
	try {
	PreparedStatement ps=connection.getConnection().prepareStatement(sql);
	ps.setString(1, s.getCid());
	ps.setString(2, s.getCname());
	ps.setString(3,s.getCredit());
	ps.setString(4, s.getCtype());

	 r=ps.executeUpdate();
	
	}catch(Exception e) {}
	return r;
	
	 
	
}

	public List<Course> fetchAllCourse(){
	List<Course> list=new ArrayList<Course>();
	Course s;
	try {
		String sql="select * from cource";
		Statement st=connection.getConnection().createStatement();
		ResultSet set=st.executeQuery(sql);
		while(set.next()) {
			String id=set.getString(1);
			String name=set.getString(2);
			String credit=set.getString(3);
			String type=set.getString(4);			
			s=new Course(id,name,credit,type);
			list.add(s);
		}
				
	}catch(Exception e) {
		
	}
	return list;
	
}
public int updateCourse(Course s,String sid) {
	int r=0;
	try {
		String sql="update student set coursename=?,credit=? where courseid=?";
		PreparedStatement ps=connection.getConnection().prepareStatement(sql);
		ps.setString(1,s.getCname());
		ps.setString(2,s.getCredit());
		ps.setString(3,s.getCid());
		r=ps.executeUpdate();
		
	}catch(Exception e) {}
	return r;
}
public int deleteCourse(String sid) {
	int r=0;
	try {
		String sql="delete from cource where courseid=?";
		PreparedStatement ps=connection.getConnection().prepareStatement(sql);
		
		ps.setString(1, sid);
		r=ps.executeUpdate();
		
	}catch(Exception e) {}
	return r;
}
public Course fetchOneCourse(String id) {
	Course s=new Course();
	try {
		String sql="select * from cource where courseid=?";	
		PreparedStatement ps=connection.getConnection().prepareStatement(sql);
		ps.setString(1,id);
		ResultSet r=ps.executeQuery();
		while(r.next()) {
		s.setCid(r.getString(1));
		s.setCname(r.getString(2));
		s.setCredit(r.getString(3));
		s.setCtype(r.getString(4));
		
		}
		System.out.print(s);
	}catch(Exception e) {
		System.out.println(e);
	}
	return s;

	
}


}
