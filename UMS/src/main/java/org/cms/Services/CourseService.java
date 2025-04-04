package org.cms.Services;

import java.util.List;

import org.cms.Model.Course;

interface CourseService {
	 public int insertCourse(Course S);
	 public int updateCourse(Course s, String id);
	 public int deleteCourse(String s);
	 public List<Course> fetchAllCourse();
	 public Course fetchOneCourse(String s);
	 

}
