package org.example.hometask46.service;

import org.example.hometask46.dto.CourseDto;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    public CourseDto getById(UUID id);

    public CourseDto save(CourseDto courseDto);

    public CourseDto update(CourseDto courseDto);

    public void delete(UUID id);

    public List<CourseDto> getAll();

}
