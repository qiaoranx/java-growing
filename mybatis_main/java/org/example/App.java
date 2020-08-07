package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.entity.Student;
import org.example.util.MybatisUtil;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

            SqlSession sqlSession= MybatisUtil.getSqlSession();
            String sqlId="org.example.dao.StudentDao.selectStudents";
            List<Student> studentList=sqlSession.selectList(sqlId);
            studentList.forEach(stu-> System.out.println(stu.getName()));
            sqlSession.close();
        }

    }

