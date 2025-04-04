package org.cms.Repository;

import org.cms.DataSource.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import org.cms.Model.Enrollment;

public class EnrollmentRepository {
	private MySqlDBConnection connection;

	public MySqlDBConnection getConnection() {
		return connection;
	}

	public void setConnection(MySqlDBConnection connection) {
		this.connection = connection;
	}

	public EnrollmentRepository(MySqlDBConnection connection) {
		super();
		this.connection = connection;
	}

	public int insertEnrollment(Enrollment s) {
	
		String sql="insert into enrollment values(?,?)";
		int r=0;
		try {
				PreparedStatement ps=connection.getConnection().prepareStatement(sql);
				ps.setString(1, s.getStudid());
				ps.setString(2, s.getCourseid());
	
				r=ps.executeUpdate();
	
		}catch(Exception e) {}
		return r;
	
	 
	
	}
	public List<Enrollment> fetchAllEnrollment(){
		List<Enrollment> list=new ArrayList<Enrollment>();
		Enrollment s;
		try {
			String sql="select * from enrollment";
			Statement st=connection.getConnection().createStatement();
			ResultSet set=st.executeQuery(sql);
			while(set.next()) {
				String sid=set.getString(1);
				String cid=set.getString(2);
						
				s=new Enrollment(sid,cid);
				list.add(s);
			}
					
		}catch(Exception e) {
			
		}
		return list;
		
	}
	
	//updateENROLLMENT
	//deleteENROLLMENT
}
