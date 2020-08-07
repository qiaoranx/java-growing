package org.example.dao;

import org.example.entity.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> selectStudents();
    public int insertStudent(Student stu);
}
