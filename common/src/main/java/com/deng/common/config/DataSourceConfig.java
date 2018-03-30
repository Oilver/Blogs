package com.deng.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.sql.SQLException;

@EnableTransactionManagement
@Primary
@Data
@ConfigurationProperties(prefix="spring.datasource")
public class DataSourceConfig implements TransactionManagementConfigurer {
    private Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    private String url;
    private String username;
    private String password;
    private String driverClassName;

    private String initialSize;
    private String minIdle;
    private String maxActive;
    private String maxWait;
    private String timeBetweenEvictionRunsMillis;
    private String minEvictableIdleTimeMillis;

    private String validationQuery;
    private String testWhileIdle;
    private String testOnBorrow;
    private String testOnReturn;
    private String poolPreparedStatements;
    private String maxPoolPreparedStatementPerConnectionSize;

    private String filters;
    private String connectionProperties;

    @Bean     //声明其为Bean实例
    public DataSource dataSource() {
        //DruidDataSource datasource = new DruidDataSource();
        //datasource.setUrl(url);
        //datasource.setUsername(username);
        //datasource.setPassword(password);
        //datasource.setDriverClassName(driverClassName);
        //
        ////configuration
        //datasource.setInitialSize(DataSourceUtils.getInt(initialSize));
        //datasource.setMinIdle(DataSourceUtils.getInt(minIdle));
        //datasource.setMaxActive(DataSourceUtils.getInt(maxActive));
        //datasource.setMaxWait(DataSourceUtils.getInt(maxWait));
        //datasource.setTimeBetweenEvictionRunsMillis(DataSourceUtils.getInt(timeBetweenEvictionRunsMillis));
        //datasource.setMinEvictableIdleTimeMillis(DataSourceUtils.getInt(minEvictableIdleTimeMillis));
        //
        //datasource.setValidationQuery(validationQuery);
        //datasource.setTestWhileIdle(DataSourceUtils.getBoolean(testWhileIdle));
        //datasource.setTestOnBorrow(DataSourceUtils.getBoolean(testOnBorrow));
        //datasource.setTestOnReturn(DataSourceUtils.getBoolean(testOnReturn));
        //datasource.setPoolPreparedStatements(DataSourceUtils.getBoolean(poolPreparedStatements));
        //datasource.setMaxPoolPreparedStatementPerConnectionSize(DataSourceUtils.getInt(maxPoolPreparedStatementPerConnectionSize));
        //try {
        //    datasource.setFilters(filters);
        //} catch (SQLException e) {
        //    logger.error("druid configuration initialization filter", e);
        //}
        //datasource.setConnectionProperties(connectionProperties);

        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl("jdbc:mysql://127.0.0.1:3306/blogs");
        datasource.setUsername("root");
        datasource.setPassword("");
        datasource.setDriverClassName("com.mysql.jdbc.Driver");

        //configuration
        datasource.setInitialSize(5);
        datasource.setMinIdle(5);
        datasource.setMaxActive(20);
        datasource.setMaxWait(60000);
        datasource.setTimeBetweenEvictionRunsMillis(60000);
        datasource.setMinEvictableIdleTimeMillis(300000);

        datasource.setValidationQuery("select 1 from dual");
        datasource.setTestWhileIdle(true);
        datasource.setTestOnBorrow(false);
        datasource.setTestOnReturn(false);
        datasource.setPoolPreparedStatements(true);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(20);
        try {
            datasource.setFilters("stat,wall,log4j");
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties("druid.stat.mergeSql=true;druid.stat.slowSqlmillis=5000");
        return datasource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource());
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}