package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.repo.CoursesRepo;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CoursesRepo repo;
	
	List<Course> list;
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Course(145,"java Core","basics of java"));	
		list.add(new Course(146,"spring boot","creating restapi"));
		list.add(new Course(147,"react js","learning react"));
		}
	
	@Override
	public List<Course> getCourses() {
//		return list;
		return repo.findAll();
	}
	@Override
	public Course getCourse(long courseId) {
		
//		Course c=null;
//		for(Course course:list)
//		{
//			if(course.getId()==courseId)
//			{
//				c=course;
//				break;
//			}
//		}
//		return c;
		
		Optional<Course> c=repo.findById(courseId);
		if(c.isPresent())
		{
			return c.get();
		}
		return null;
	}

	@Override
	public Course addCourse(Course course) {
		
//		list.add(course);
		
//		System.out.println(list);
		repo.save(course);
		return course;
	}
	
	public Course deleteCourse(long courseId)
	{
//		Course c=null;
//		for(Course course:list)
//		{
//			if(course.getId()==courseId)
//			{
//				c=course;
//				list.remove(course);
//				break;
//			}
//		}
//		return c;
		
		Optional<Course> c=repo.findById(courseId);
		
		repo.deleteById(courseId);
		if(c.isPresent())
		{
			return c.get();
		}
		return null;
	}

	public Course updateCourse(long courseId,Course updatedCourse)
	{
//		Course c=null;
//		for(Course course:list)
//		{
//			if(course.getId()==courseId)
//			{
//				c=course;
//				if(course.getId()!=updatedCourse.getId())
//					course.setId(updatedCourse.getId());
//				if(course.getTitle()!=updatedCourse.getTitle())
//					course.setTitle(updatedCourse.getTitle());
//				if(course.getDescription()!=updatedCourse.getDescription())
//					course.setDescription(updatedCourse.getDescription());
//				break;
//			}
//		}
//		return c;
		
		repo.save(updatedCourse);
		return(updatedCourse);
	}
}
