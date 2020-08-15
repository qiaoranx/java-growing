package service;

import dao.StudentDAO;
import domain.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    @Resource
    //dao对象是set注入
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public int addStudent(Student student) {
        int res=studentDAO.insertStudent(student);
        return res;
    }

    @Override
    public List<Student> queryStudent() {
        return studentDAO.selectStudents();
    }
}
