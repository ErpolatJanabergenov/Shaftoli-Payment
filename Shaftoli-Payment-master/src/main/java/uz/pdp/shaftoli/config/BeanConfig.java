package uz.pdp.shaftoli.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@RequiredArgsConstructor
@EnableTransactionManagement
public class BeanConfig {
    private final Environment environment;
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
        dataSource.setUrl(environment.getRequiredProperty("db.url"));
        dataSource.setUsername(environment.getRequiredProperty("db.username"));
        dataSource.setPassword(environment.getRequiredProperty("db.password"));
        return dataSource;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("uz.pdp.shaftoli.entity");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
        return hibernateTransactionManager;
    }
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show-sql", environment.getRequiredProperty("hibernate.show-sql"));
        properties.put("hibernate.format-sql", environment.getRequiredProperty("hibernate.format-sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }
}
