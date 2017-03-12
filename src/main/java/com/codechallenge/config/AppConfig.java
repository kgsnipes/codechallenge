package com.codechallenge.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.codechallenge.services.DataLoadService;
import com.codechallenge.services.impl.DefaultDataLoadService;

@Configuration
@EnableCaching
@ComponentScan({ "com.codechallenge.*" })
@EnableJpaRepositories(basePackages={"com.codechallenge"})	
public class AppConfig {
	
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}
	
	@Bean 
	public DataLoadService dataLoadService()
	{
		return new DefaultDataLoadService();
	}
	
	@Bean
	public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
	    dataSource.setUrl("jdbc:hsqldb:mem:testdb");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	    return dataSource;
	}
	
	@Bean
	public EntityManager entityManager() {
	    return entityManagerFactory().getObject().createEntityManager();
	}
	
	@Bean
	public HibernateJpaDialect jpaDialect() {
	    return new HibernateJpaDialect();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	    em.setDataSource(dataSource());
	    em.setPackagesToScan("com.codechallenge");
	    HibernateJpaVendorAdapter jpaVendorAdapter=new HibernateJpaVendorAdapter();
	    jpaVendorAdapter.setShowSql(false);
	    jpaVendorAdapter.setGenerateDdl(true);
	    jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
	    em.setJpaVendorAdapter(jpaVendorAdapter);
	   em.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);
	    return em;
	}
	
	 @Bean
	    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	        return new JpaTransactionManager(entityManagerFactory);
	    }
	
}
