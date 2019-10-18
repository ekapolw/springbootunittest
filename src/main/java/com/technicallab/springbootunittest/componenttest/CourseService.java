package com.technicallab.springbootunittest.componenttest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

  @Autowired private CourseRepository courseRepository;

  public Course add(Course course) {
    return courseRepository.save(course);
  }

  public Optional<Course> get(String courseCode) {
    return courseRepository.findById(Integer.getInteger(courseCode));
  }

  public List<Course> getAll() {
    List<Course> courses = new ArrayList<Course>();
    courseRepository.findAll().forEach(courses::add);
    return courses;
  }
}
