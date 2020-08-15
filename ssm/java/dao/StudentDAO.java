package dao;

import domain.Student;

import java.util.List;

public interface StudentDAO {
    int insertStudent(Student student);
    List<Student> selectStudents();
}
