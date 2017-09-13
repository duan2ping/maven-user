package com.duan2ping.my.base;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库通用工具类
 * Created by duan2ping on 2017/9/11.
 */
public class BaseDao{
    private String url;
    private static String USER_NAME ;
    private static String USER_PASSWORD ;
    private static String URL ;
    private Connection conn;
    protected ResultSet rs;
    // 加载初始化连接参数
    static{
        Properties pro = new Properties();
        //File file = new File("\\src\\main\\resources\\jdbcconfig.properties");
        try {
            pro.load(BaseDao.class.getClassLoader().getResource("jdbcconfig.properties").openStream());
            USER_NAME = pro.getProperty("jdbc.username");
            USER_PASSWORD = pro.getProperty("jdbc.password");
            URL = pro.getProperty("jdbc.url");
        } catch (IOException e) {
            System.err.println("×：加载配置错误--"+e.getMessage());
        }
    }

    // 打开数据库
    private void open(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER_NAME,USER_PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("×：加载驱动错误--"+e.getMessage());
        } catch (SQLException e) {
            System.err.println("×：打开数据库错误--"+e.getMessage());
        }
    }


    /**
     * 通用查询
     * @param sql     查询的sql语句
     * @param paras  参数
     * @return       返回结果
     */
    protected ResultSet executeQuery(String sql,Object...paras){
        open();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            if(paras != null) {
                for (int i = 0; i < paras.length; i++) {
                    pre.setObject(i + 1, paras[i]);
                }
            }
            rs = pre.executeQuery();
        } catch (SQLException e) {
            System.err.println("×：执行【"+sql+"】错误--"+e.getMessage());
        }

        return rs;
    }


    // 关闭数据库
    protected void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("×：关闭数据库错误--"+e.getMessage());
        }
    }

}