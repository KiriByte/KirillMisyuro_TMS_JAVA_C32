package org.example.hometask46.service.impl;

import org.example.hometask46.dto.CourseDto;
import org.example.hometask46.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    private List<CourseDto> courses = new ArrayList<>();

    @Override
    public CourseDto getById(UUID uuid) {
        return courses.stream()
                .filter(courseDto -> courseDto.getId().equals(uuid))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("course not found"));
    }

    @Override
    public CourseDto save(CourseDto courseDto) {
        courseDto.setId(UUID.randomUUID());
        courses.add(courseDto);
        return courseDto;
    }

    @Override
    public CourseDto update(CourseDto courseDto) {
        var course = getById(courseDto.getId());
        course.setName(courseDto.getName());
        course.setDays(courseDto.getDays());
        course.setPrice(courseDto.getPrice());
        course.setActive(courseDto.isActive());
        return courseDto;
    }

    @Override
    public void delete(UUID uuid) {
        courses.removeIf(courseDto -> courseDto.getId().equals(uuid));
    }

    @Override
    public List<CourseDto> getAll() {
        return new ArrayList<>(courses);
    }
}
