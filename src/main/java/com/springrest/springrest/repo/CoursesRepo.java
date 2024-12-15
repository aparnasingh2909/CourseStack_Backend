package com.springrest.springrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.entities.Course;

@Repository
public interface CoursesRepo extends JpaRepository<Course,Long>{

}
