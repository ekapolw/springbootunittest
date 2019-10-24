package com.technicallab.springbootunittest.componenttest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course add(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> get(String courseCode) {
        return courseRepository.findById(Integer.getInteger(courseCode));
    }

    public List<Course> getAll() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public String callExternalAPI() {
        final String url = "http://ekapolw.com/someapi";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
