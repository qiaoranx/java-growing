package org.example.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    //整个项目只需要创建一次即可
   private static SqlSessionFactory factory = null;

    static {
           String config="mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
             factory=builder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if(factory!=null){
            sqlSession=factory.openSession();
        }
        return sqlSession;
    }
}
