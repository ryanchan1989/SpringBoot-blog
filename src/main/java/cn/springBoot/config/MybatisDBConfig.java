package cn.springBoot.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
public class MybatisDBConfig  implements TransactionManagementConfigurer {

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
    @Autowired
    private  DataSource dataSource;
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

    public PlatformTransactionManager annotationDrivenTransactionManager() {
        
        return new DataSourceTransactionManager(this.dataSource);
        
    }
    
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(this.dataSource);
        //分页插件
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);
//
//        //添加插件
//        bean.setPlugins(new Interceptor[]{pageHelper});
        //添加XML目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        try {
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
