package com.project.internship;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DBConfig {
    @Bean("SqlDataSource")
    public OracleDataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser("softwares");
        dataSource.setPassword("softwares@123");
        dataSource.setURL("jdbc:oracle:thin:@//localhost:11521/ORDERDB");
        //dataSource.setFastConnectionFailoverEnabled(true);
        dataSource.setImplicitCachingEnabled(true);
        //dataSource.setConnectionCachingEnabled(true);
        return dataSource;
    }
    @Bean("orderJdbcTemplate")
    public JdbcTemplate getJdbcTemplate(@Qualifier("SqlDataSource") OracleDataSource datasource){
        return new JdbcTemplate(datasource);

    }
}
