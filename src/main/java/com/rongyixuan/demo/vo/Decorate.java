package com.rongyixuan.demo.vo;

import lombok.Data;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public enum Decorate implements TypeHandler<Decorate> {
    MALE(1,"毛坯"),
    FEMALE(2,"普通装修"),
    UNKNOW(3,"精装修");

    private Integer dbValue;

    private String value;

    public Integer getDbValue() {
        return dbValue;
    }

    public void setDbValue(Integer dbValue) {
        this.dbValue = dbValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    Decorate(Integer dbValue, String value){

        this.dbValue = dbValue;
        this.value = value;
    }

    public static Decorate dbValueOf(Integer dbValue){

        for (Decorate decorate : Decorate.values()){
            if(decorate.getDbValue().equals(dbValue)){
                return decorate;
            }
        }
        return null;
    }
    //请求时转换
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Decorate decorate, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,String.valueOf(decorate.getValue()));
    }
    //返回时转换
    @Override
    public Decorate getResult(ResultSet resultSet, String s) throws SQLException {
        String value = resultSet.getString(s);
        return Decorate.dbValueOf(Integer.parseInt(value));
    }

    @Override
    public Decorate getResult(ResultSet resultSet, int i) throws SQLException {
        System.out.print("getResult2");
        return null;
    }

    @Override
    public Decorate getResult(CallableStatement callableStatement, int i) throws SQLException {
        System.out.print("getResult3");
        return null;
    }
}

