package org.cms.Services;

import java.util.List;

import org.cms.Model.Enrollment;
import org.cms.Repository.EnrollmentRepository;

public class EnrollmentServiceImpl {
private EnrollmentRepository repository;
	public EnrollmentServiceImpl(EnrollmentRepository repository) {
		this.repository = repository;
}
	public int insertEnrollment(Enrollment S) {
				return repository.insertEnrollment(S);
	}	
	public int updateEnrollment(Enrollment s, String cid) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int deleteStudent(String s) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Enrollment> fetchAll() {
		// TODO Auto-generated method stub
		return repository.fetchAllEnrollment();
	}

	
	public Enrollment fetchOneEnrollment(String id, String cid) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
