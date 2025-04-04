package org.cms.Services;

import java.util.List;

import org.cms.Model.Course;
import org.cms.Repository.CourseRepository;


public class CourseServiceImpl implements CourseService{
	private CourseRepository repository;
	public CourseServiceImpl(CourseRepository repository) {
		this.repository = repository;
	}
	
		public int insertCourse(Course s) {
			return repository.insertCourse(s);
		}
		public int updateCourse(Course s, String id) {
			return repository.updateCourse(s,id);
		}
		public int deleteCourse(String id) {
			return repository.deleteCourse(id);
		}
		public List<Course> fetchAllCourse(){
			return repository.fetchAllCourse();
		}		
		
		public Course fetchOneCourse(String s) {
			// TODO Auto-generated method stub
			return null;
		}

		
}
