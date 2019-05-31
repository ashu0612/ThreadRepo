package com.hostel;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//this is the java configuration that has been done to get the 
//session factory as we want hibernate api to be used with 
//getting the session object not entity manager api 
//spring gives direct support to JPA that is we don't have to implement the
//session factory bean to get the things done for DAO layer.
@Configuration
@EnableTransactionManagement
public class SessionFactoryUtil {
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
       sessionFactory.setPackagesToScan("com.hostel");
        sessionFactory.setHibernateProperties(hibernateProperties());
 
        return sessionFactory;
    }
 
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://172.27.235.17:5433/TestHibernateDB");
        dataSource.setUsername("lak_lpf");
        dataSource.setPassword("lakanaplat");
 
        return dataSource;
    }
 
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
 
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.setProperty(
                "hibernate.show_sql", "true");
       
        return hibernateProperties;
    }
	
	
	     
}
