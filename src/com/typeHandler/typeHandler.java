package com.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//BaseTypeHandler<java类型>
/*
 true 是男 false 是女
 preparedStatement 对象
 i  对象操作的参数位置
 aBoolean java的值
 jdbcType jdbc操作的数据库类型
 */
public class typeHandler extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        if(s.equals("男")){
            preparedStatement.setInt(i,0);
        }else {
            preparedStatement.setInt(i,1);
        }
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println(s);
        if(resultSet.getInt(s)==1){
            return "女";
        }else {
            return "男";
        }

    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        if(resultSet.getInt("sexBoolean")==1){
            return "女";
        }else {
            return "男";
        }
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        if(callableStatement.getInt("sexBoolean")==1){
            return "女";
        }else {
            return "男";
        }
    }


//    set 是 java>db <boolean>number>
    //gei 是db>java

}
