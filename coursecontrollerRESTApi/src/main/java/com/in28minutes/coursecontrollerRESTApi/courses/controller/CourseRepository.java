package com.in28minutes.coursecontrollerRESTApi.courses.controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
