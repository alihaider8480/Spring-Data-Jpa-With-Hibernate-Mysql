package com.spring.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.PlatformTransactionManager;

@ComponentScan(basePackages={"com.spring.*"})
@Configuration
@EnableAsync
@PropertySource(value={"classpath:Hibernate-Jpa.properties"})
@EnableJpaRepositories("com.spring.repository")
public class AppConfiguration 
{
	@Autowired 
    private Environment environment;
	
	 /************* Start Spring JPA config details **************/
	
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());
        lcemfb.setDataSource(dataSource());
        lcemfb.setPersistenceUnitName("myJpaPersistenceUnit");
        lcemfb.setPackagesToScan("com.spring");
        lcemfb.setJpaProperties(hibernateProperties());
        return lcemfb;
    }

    @Bean
    public JpaVendorAdapter getJpaVendorAdapter() {
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        return adapter;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager txManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(
            getEntityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }
	
    /************* End Spring JPA config details **************/
    
    /************* Start Hibernate config details **************/
    
	@Bean
	public DataSource dataSource() 
	{
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		driverManagerDataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		driverManagerDataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		driverManagerDataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return driverManagerDataSource;
	}
	 
	 @Bean           
	 public Properties hibernateProperties() 
	 {
		 Properties properties = new Properties();
		 properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		 properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		 properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));		
		 properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		 return properties;        
       }
	 
	  /************* End Hibernate config details **************/
	 
	 /************* Start Thread like Async config details **************/
	 
	 
	/* @Bean(name = "asyncExecutor")
	    public Executor asyncExecutor() {
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(1);
	        executor.setMaxPoolSize(1);
	        executor.setQueueCapacity(0);
	        executor.setThreadNamePrefix("Ali Haider Thread");
	        executor.initialize();
	        return executor;
	 }  */
	        
	 /************* End Thread like Async config details **************/
}
