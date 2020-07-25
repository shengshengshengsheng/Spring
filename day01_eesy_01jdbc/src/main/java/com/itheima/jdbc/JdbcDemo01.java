package com.itheima.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 *      耦合：程序间的依赖关系
 *          包括：类之间的依赖
 *              方法之间的依赖
 *      解耦：降低程序之间的依赖关系
 *      实际开发中我们应该做到编译期不依赖，运行时才依赖
 *      解耦的思路：
 *          第一步：使用反射来创建对象，避免使用new关键字
 *          第二步：通过读取配置文件来获取要创建的对象的全限定类名
 * @author Administrator
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //使用DriverManager.registerDriver(xx)在编译期如果xx不存在就会报错，属于编译期依赖
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //使用Class.forName(xx);在编译期不会报错，运行时如果xx不存在就会报错，属于运行时依赖
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8&useSSL=false","root","123456");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.执行sql得到结果集
        ResultSet resultSet = pstm.executeQuery();
        //5.遍历结果集
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
        }
        //6.释放资源
        resultSet.close();
        pstm.close();
        conn.close();
    }
}
