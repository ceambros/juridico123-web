package br.com.juridico.conf;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class JpaConfigurator {

    @Bean
    public DataSource getDataSource() throws PropertyVetoException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("org.postgresql.Driver");
        dataSource.setUser("postgres");
        dataSource.setPassword("postges");
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/juridico");

        dataSource.setMinPoolSize(3);
        dataSource.setMaxPoolSize(5);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPersistenceUnitName("juridicoEntityMF");
        entityManagerFactory.setPackagesToScan("br.com.juridico");
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties props = new Properties();

        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.setProperty("hibernate.show_sql", "true");
        //props.setProperty("hibernate.format_sql", "true");        
        
        //props.setProperty("log4j.logger.org.hibernate.SQL", "DEBUG");
        //props.setProperty("log4j.logger.org.hibernate.type=", "TRACE");
        
        //props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        //props.setProperty("hibernate.cache.use_second_level_cache", "true");
        //props.setProperty("hibernate.cache.use_query_cache", "true");
        //props.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");

        entityManagerFactory.setJpaProperties(props);
        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager getTransactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

}
