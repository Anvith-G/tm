package org.cms.Services;

import java.util.List;

import org.cms.Model.Student;

//@Service- Stereotype annotation
//@Component
//@Repository
//@bean

interface StudentService {
	public int insertStudent(Student S);
	 public int updateStudent(Student s, String id);
	 public int deleteStudent(String s);
	 public List<Student> fetchAll();
	 public Student fetchOneStudent(String s);


}
 