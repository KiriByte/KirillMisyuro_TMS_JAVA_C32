package org.example.hometask46.controller;

import org.example.hometask46.dto.CourseDto;
import org.example.hometask46.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/get")
    public CourseDto getCourseByParam(@RequestParam UUID uuid) {
        return courseService.getById(uuid);
    }

    @GetMapping("/{uuid}")
    public CourseDto getCourseByPath(@PathVariable UUID uuid) {
        return courseService.getById(uuid);
    }

    @GetMapping("/getAll")
    public List<CourseDto> getCourses() {
        return courseService.getAll();
    }

    @PostMapping("/add")
    public CourseDto createCourse(@RequestBody CourseDto courseDto) {
        return courseService.save(courseDto);
    }

    @PutMapping("/update")
    public CourseDto updateCourse(@RequestBody CourseDto courseDto) {
        return courseService.update(courseDto);
    }

    @DeleteMapping("/delete")
    public void deleteCourse(@RequestParam UUID uuid) {
        courseService.delete(uuid);
    }


}
