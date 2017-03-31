//package cn.springBoot.config;
//
//import java.sql.SQLException;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import com.alibaba.druid.pool.DruidDataSource;
//
///**
// * DruidDBConfig类被@Configuration标注，用作配置信息； DataSource对象被@Bean声明，为Spring容器所管理，
// * 
// * @Primary表示这里定义的DataSource将覆盖其他来源的DataSource。
// * @author ZSX jdbc.url=${jdbc.url} 最新的支持方式如下: jdbc.url=@jdbc.url@
// */
//@PropertySource(value="classpath:application.properties")
////@EnableTransactionManagement(proxyTargetClass=true)
//@Configuration
//@EnableJpaRepositories(basePackages={"cn.springBoot.dao"})
////@EnableJpaRepositories(entityManagerFactoryRef)
////@EnableTransactionManagement
//public class DruidDBConfig  {
//    @Value("${spring.datasource.url}")
//    private String dbUrl;
//    @Value("${spring.datasource.type}")
//    private String type;
//
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    @Value("${spring.datasource.driverClassName}")
//    private String driverClassName;
//
//    @Value("${spring.datasource.initialSize}")
//    private int initialSize;
//
//    @Value("${spring.datasource.minIdle}")
//    private int minIdle;
//
//    @Value("${spring.datasource.maxActive}")
//    private int maxActive;
//
//    @Value("${spring.datasource.maxWait}")
//    private int maxWait;
//
//    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
//    private int timeBetweenEvictionRunsMillis;
//
//    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
//    private int minEvictableIdleTimeMillis;
//
//    @Value("${spring.datasource.validationQuery}")
//    private String validationQuery;
//
//    @Value("${spring.datasource.testWhileIdle}")
//    private boolean testWhileIdle;
//
//    @Value("${spring.datasource.testOnBorrow}")
//    private boolean testOnBorrow;
//
//    @Value("${spring.datasource.testOnReturn}")
//    private boolean testOnReturn;
//
//    @Value("${spring.datasource.poolPreparedStatements}")
//    private boolean poolPreparedStatements;
//
//    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
//    private int maxPoolPreparedStatementPerConnectionSize;
//
//    @Value("${spring.datasource.filters}")
//    private String filters;
//
//    @Value("{spring.datasource.connectionProperties}")
//    private String connectionProperties;
//    @Bean
//    @Primary
//    public DruidDataSource  dataSource() {
//        DruidDataSource datasource = new DruidDataSource();
////        datasource.setDbType(type);
//        datasource.setUrl(this.dbUrl);
//        datasource.setUsername(username);
//        datasource.setPassword(password);
//        datasource.setDriverClassName(driverClassName);
//        // configuration
//        datasource.setInitialSize(initialSize);
//        datasource.setMinIdle(minIdle);
//        datasource.setMaxActive(maxActive);
//        datasource.setMaxWait(maxWait);
//        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        datasource.setValidationQuery(validationQuery);
//        datasource.setTestWhileIdle(testWhileIdle);
//        datasource.setTestOnBorrow(testOnBorrow);
//        datasource.setTestOnReturn(testOnReturn);
//        datasource.setPoolPreparedStatements(poolPreparedStatements);
//        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//        try {
//            datasource.setFilters(filters);
//        } catch (SQLException e) {
//
//        }
//        datasource.setConnectionProperties(connectionProperties);
//
//        return datasource;
//    }
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//      vendorAdapter.setGenerateDdl(true);
//
//      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//      factory.setJpaVendorAdapter(vendorAdapter);
//      factory.setPackagesToScan("cn.springBoot.model");
//      factory.setDataSource(dataSource());
//      return factory;
//    }
////    @Bean
////    public PlatformTransactionManager transactionManager() {
////
////      JpaTransactionManager txManager = new JpaTransactionManager();
////      txManager.setEntityManagerFactory(entityManagerFactory());
////      return txManager;
////    }
//}
