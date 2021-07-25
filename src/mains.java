import com.dao.student;
import mapper.studentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

public class mains {
    public static void main(String[] args) {
//        queryStuNoByStuNO();
//        updateStuParaHashMap();
//        queryAllStuResultTypeMap();
        queryAllToHashMapResultType();
    }
//    使用HashMap查询单个学生
    public static void queryStuNoByStuNO(){
       SqlSession session = getSession();
        studentMapper studentMapper = session.getMapper(studentMapper.class);
        HashMap<String,Object> stuMap = studentMapper.queryStuNoByStuNO(2);
        System.out.println(stuMap);
        session.close();
    }
    //结果为HashMap的集合
    public static void queryAllStuResultTypeMap(){
        SqlSession session = getSession();
       studentMapper studentMapper =  session.getMapper(studentMapper.class);
       List<HashMap<String,Object>> stuMaps = studentMapper.queryAllStuResultTypeMap();
        for (HashMap<String, Object> stuMap : stuMaps) {
            System.out.println(stuMap.toString());
        }
        session.close();
    }
//    输入参数为HashMap
    public static void updateStuParaHashMap(){
        SqlSession session = getSession();
        studentMapper studentMapper =  session.getMapper(studentMapper.class);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("userName","你好啊");
        hashMap.put("sex","女");
        hashMap.put("id",2);
        studentMapper.updateStuParaHashMap(hashMap);
        session.commit();
        session.close();
    }
    private static SqlSession getSession() {
        String configPath = "config.xml";
        try {
            Reader reader =   Resources.getResourceAsReader(configPath);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            return  sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //使用hashMap+resultType解决实体类属性与数据库列明不匹配的问题
    public static void queryAllToHashMapResultType(){
        SqlSession session = getSession();
        studentMapper studentMapper =  session.getMapper(studentMapper.class);
       List<student> stuJIhe = studentMapper.queryAllToHashMapResultType();
        for (student student : stuJIhe) {
            System.out.println(student);
        }
        session.close();
    }
}
