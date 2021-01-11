package com.zyj.transaction.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author zhongyj
 * @since 2021-01-11 15:23
 */
@EnableTransactionManagement
@Configuration
@ComponentScan("com.zyj.transaction")
public class TransactionConfig {
    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource source = new BasicDataSource();
        source.setUrl("jdbc:mysql://localhost/test?useUnicode=true");
        source.setUsername("root");
        source.setPassword("123456");
        source.setDriverClassName("com.mysql.jdbc.Driver");
        return source;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
