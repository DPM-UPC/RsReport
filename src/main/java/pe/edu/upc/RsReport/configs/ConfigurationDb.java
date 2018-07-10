package pe.edu.upc.RsReport.configs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("pe.edu.upc.RsReport.mappers")
public class ConfigurationDb {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DataSource reportDataSource() {
        return DataSourceBuilder.create().build();
    }
}