package com.primix.service;

import java.util.Optional;
import com.primix.model.exam.Course;
import com.primix.respositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseService{

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/api/course")
    public Iterable<Course> findAllCourses(){
        return courseRepository.findAll();
    }

    @GetMapping("/api/course/{courseId}")
    public Course findCourseById(@PathVariable("courseId") int id){
        Optional<Course> data = courseRepository.findCourseById(id);
        if(data.isPresent()){
            return data.get();
        }
        else{
            return null;
        }
    }
    @PostMapping("/api/course")
    public Course createCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @DeleteMapping("/api/course/{courseId}")
    public void deleteCourse(@PathVariable("courseId") int id){
        courseRepository.deleteById(id);
    }
}