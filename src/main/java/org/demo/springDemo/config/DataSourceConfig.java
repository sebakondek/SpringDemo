package org.demo.springDemo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@Setter
@Getter
@ConfigurationProperties(prefix = "db.datasource")
public class DataSourceConfig extends HikariConfig {

    private String url;
    private String username;
    private String password;

    @Bean
    public DataSource getDataSource() {
        super.setJdbcUrl(url);
        super.setUsername(username);
        super.setPassword(password);

        System.out.println("jdbcUrl: " + url);

        return new HikariDataSource(this);
    }
}
