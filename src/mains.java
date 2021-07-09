import com.dao.student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class mains {
    public static void main(String[] args) {
        Reader reader = null;
        try {
           reader = Resources.getResourceAsReader("config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader,"development"); //第二个参数可选可手动配置 environment 对应的id
        SqlSession session = sessionFactory.openSession();
        String StatMent = "mapper.studentMapper.queryById";
        List<student> list  = session.selectList(StatMent);
        for (student student : list) {
            System.out.println(student);
        }
        student stu = new student();
        stu.setUserName("月月");
        stu.setSex("女");
        String statment = "mapper.studentMapper.addStudent";
        int row = session.insert(statment,stu);
        if(row>0){
            System.out.println("插入成功！");
        }
        //修改
        String updateStatment = "mapper.studentMapper.updateStudent";
        student student = new student();
        //需要修改的学生编号
        student.setId(6);
        //修改后的值
        student.setUserName("哈哈");
        student.setSex("女");
        session.update(updateStatment,student);
        //提交事务
        session.commit();
        //删除
        String delSql = "mapper.studentMapper.delStudent";
        session.delete(delSql,1);
        session.commit();
        List<student> listt  = session.selectList(StatMent);
        for (student sa : listt) {
            System.out.println(sa);
        }
    }
}
