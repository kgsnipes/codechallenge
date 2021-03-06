package com.microservices.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.microservices.services.CalculationService;
import com.microservices.services.DataLoadService;
import com.microservices.services.OrderService;
import com.microservices.services.PricingService;
import com.microservices.services.ProductService;
import com.microservices.services.StockService;
import com.microservices.services.UserService;
import com.microservices.services.impl.DefaultCalculationService;
import com.microservices.services.impl.DefaultDataLoadService;
import com.microservices.services.impl.DefaultOrderService;
import com.microservices.services.impl.DefaultPricingService;
import com.microservices.services.impl.DefaultProductService;
import com.microservices.services.impl.DefaultStockService;
import com.microservices.services.impl.DefaultUserService;
/* this class holds all the beans declarations required for the application - this is synonymous to the spring XML config */
@Configuration
@EnableCaching
@ComponentScan({ "com.microservices.*" })
@EnableJpaRepositories(basePackages={"com.microservices"})	
@PropertySource("classpath:application.properties")
public class AppConfig {
	
	@Value("${app.jdbc.url}")
	private String jdbcURL;
	@Value("${app.jdbc.user}")
	private String jdbcUserName;
	@Value("${app.jdbc.pass}")
	private String jdbcPassword;
	
	//defining user service bean
	@Bean 
	public UserService userService()
	{
		return new DefaultUserService();
	}
	
	//defining pricing service
	@Bean 
	public PricingService pricingService()
	{
		return new DefaultPricingService();
	}
	
	// defining the calculation service
	@Bean
	public CalculationService calculationService()
	{
		return new DefaultCalculationService();
	}
	
	// defining the order service
	@Bean
	public OrderService orderService()
	{
		return new DefaultOrderService();
	}
	
	// defining the stock service
	@Bean
	public StockService stockService()
	{
		return new DefaultStockService();
	}
	
	//defining the product service
	@Bean
	public ProductService productService()
	{
		return new DefaultProductService();
	}
	
	//defining the cache manager for data caching
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}
   
	// defining the EHCACHE manager bean required for the spring cache manager
	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}
	
	// defining the data load service which will load the inital product data to the system 
	@Bean 
	public DataLoadService dataLoadService()
	{
		return new DefaultDataLoadService();
	}
	
	
	//defining the dataSource bean for mysql
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl(jdbcURL);
	    dataSource.setUsername(jdbcUserName);
	    dataSource.setPassword(jdbcPassword);
		return dataSource;
	}
	
	
	/* defining the entity manager bean for JPA*/
	@Bean
	public EntityManager entityManager() {
	    return entityManagerFactory().getObject().createEntityManager();
	}
	
	/* defining the JPA dialect bean for JPA*/
	@Bean
	public HibernateJpaDialect jpaDialect() {
	    return new HibernateJpaDialect();
	}
	
	/* defining the entity manager factory bean for JPA*/
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	    em.setDataSource(dataSource());
	    em.setPackagesToScan("com.microservices");
	    HibernateJpaVendorAdapter jpaVendorAdapter=new HibernateJpaVendorAdapter();
	    jpaVendorAdapter.setShowSql(false);
	    jpaVendorAdapter.setGenerateDdl(true);
    	jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
	    em.setJpaVendorAdapter(jpaVendorAdapter);
	    em.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);
	    return em;
	}
	
	/* defining the transaction manager for JPA*/
	 @Bean
	    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	        return new JpaTransactionManager(entityManagerFactory);
	    }
	
}
