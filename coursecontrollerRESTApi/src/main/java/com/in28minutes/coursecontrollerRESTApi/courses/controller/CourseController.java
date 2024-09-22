package com.in28minutes.coursecontrollerRESTApi.courses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository repository;
	
	//http://localhost:8080/actuator
	
	//http://localhost:8080/courses
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
          return repository.findAll();
		//return Arrays.asList(new Course(1, "Learn MicroServices", "in28minutes"), new Course(2, "Learn AWS", "in28minutes"));		
	}
	
	//http://localhost:8080/courses/1
	@GetMapping("/courses/{id}")
	public Course getCourseDetails(@PathVariable long id) {
		Optional<Course> course = repository.findById(id);
		if(course.isEmpty()) {
			throw new RuntimeException("Course not found with id: "+ id);
		}
		return course.get();
		//return new Course(1, "Learn Java", "in28minutes");		
	}
	
	//POST - Create a new resource (/courses)
	@PostMapping("/courses")
	public ResponseEntity<String> createCourse(@RequestBody Course course) {
	    try {
	        repository.save(course);
	        return ResponseEntity.status(HttpStatus.CREATED).body("Course created successfully");
	    } catch (Exception e) {
	        // Log the exception (you can use a logging framework like SLF4J)
	        System.err.println("Error creating course: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating course");
	    }
	}
	/*
	 * @PostMapping("/courses") public void createCourse(@RequestBody Course course)
	 * { repository.save(course); }
	 */
	
	//PUT - Update/Replace a resource (/course/1)	
	@PutMapping("/courses/{id}") public void updateCourse(@PathVariable long id, @RequestBody Course course) { 
		repository.save(course); 
		}
	 


	
	//Delete - Delete a resource (/courses/1)
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable long id) {
	 repository.deleteById(id);
	}

}
