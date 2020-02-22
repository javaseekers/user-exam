package com.exam.qa.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource("classpath:/multiple-data-bases.properties")
@EnableJpaRepositories(basePackages = "com.exam.qa.repo", entityManagerFactoryRef = "questionEntityManager", transactionManagerRef = "questionTransactionManager")
public class QuestionConfig
{
	@Autowired
	private Environment env;
	@Bean
	@ConfigurationProperties(prefix = "spring.first.datasource")
	public DataSource questionDataSource()
	{
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean questionEntityManager()
	{
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(questionDataSource());
		em.setPackagesToScan(new String[]{"com.exam.qa.entities"});
		em.setPersistenceUnitName("questions");

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto",
			env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect",
			env.getProperty("hibernate.dialect"));
		
		properties.put("show_sql", "true");
		
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Bean
	public PlatformTransactionManager questionTransactionManager()
	{

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager
			.setEntityManagerFactory(questionEntityManager().getObject());
		return transactionManager;
	}

	
}
