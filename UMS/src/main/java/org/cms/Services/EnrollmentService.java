package org.cms.Services;

import java.util.List;

import org.cms.Model.Enrollment;

interface EnrollmentService {
	 public int insertEnrollment(Enrollment S);
	 public int updateEnrollment(Enrollment s, String cid);
	 public int deleteStudent(String s);
	 public List<Enrollment> fetchAll();
	 public Enrollment fetchOneEnrollment(String id,String cid);
	 
	 

}
