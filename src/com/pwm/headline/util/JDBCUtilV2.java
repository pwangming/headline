package com.pwm.headline.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName: JDBCUtilV2
 * Package: com.demo.senior.util
 * Description: JDBC工具类v2.0
 *  1、维护一个连接池对象，维护了一个线程绑定变量的 ThreadLocal 对象
 *  2、对外提供在 ThreadLocal中获取连接方法
 *  3、对外提供回收连接的方法，回收过程中，将要回收的连接从 ThreadLocal 中移除
 *  注意：工具类仅对外提供共性的功能代码，所以方法均为静态方法
 *  注意：使用 ThreadLocal 就是为了一个线程在多次数据库操作过程中，使用的时同一个连接
 *
 * @Author: pengwangming
 * @Create: 2024/7/10 - 23:46
 * @Version: v1.0
 */
public class JDBCUtilV2 {
    // 创建连接池引用，因为要提供给当前项目的全局使用，所以创建为静态的
    private static DataSource dataSource;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();


    // 在项目启动时，即创建连接池对象，复制给 dataSource
    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 对外提供在连接池中获取连接的方法
    public static Connection getConnection() {
        try {
            // 在 ThreadLocal 中获取 Connection
            Connection connection = threadLocal.get();
            // 在 ThreadLocal 里没有存储 Connection，也就是第一次获取
            if (connection == null) {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 对外提供回收连接的方法
    public static void release() {
        try {
            Connection connection = threadLocal.get();
            if (connection != null) {
                // 从 threadLocal 中移除当前已经存储的 Connection 对象
                threadLocal.remove();
                // 如果开启了事务的手动提交，操作完毕后，归还给连接池之前，要将事务的自动提交改为true
                connection.setAutoCommit(true);
                // 对 Connection 对象归还连接池
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
