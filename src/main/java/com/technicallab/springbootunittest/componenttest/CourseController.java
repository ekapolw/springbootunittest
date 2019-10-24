package com.technicallab.springbootunittest.componenttest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(path = "/courses/add")
    public Course enrollCourse(
            @Valid @RequestBody Course course) {

        return courseService.add(course);

    }

    @GetMapping(path = "/courses")
    public List<Course> getAllCourses() {

        return courseService.getAll();

    }

    @GetMapping(path = "/courses/{courseCode}")
    public Course getCourse(
            @PathVariable("courseCode") String courseCode ) {

        Optional<Course> enrollingCourse = courseService.get(courseCode);

        return enrollingCourse.isPresent() ? enrollingCourse.get() : null;

    }

    @GetMapping("/callapi")
    public String callExternalAPI() {
        return courseService.callExternalAPI();
    }

}
