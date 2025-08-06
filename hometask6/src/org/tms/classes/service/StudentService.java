package org.tms.classes.service;

import org.tms.classes.model.Student;

public class StudentService {

    public int getCountStudentsInGroup(Student[] students, int group) {
        int count = 0;
        for (var student : students) {
            if (student.getNumberGroup() == group) {
                count++;
            }
        }
        return count;
    }
}
