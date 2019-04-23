//package cn.wmyskz.springboot.util;
//
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
///**
// * @author haiyun.guo
// * @Description:
// * @date 2018年12月25日 19:41
// */
//@Configuration
//public class Config {
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//        factory.setDataSource(dataSource);
//
//
//        //添加XML目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
////        // 使用驼峰命名法转换字段
////        factory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
//        return factory.getObject();
//    }
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
//        mapperScannerConfigurer.setBasePackage("cn.wmyskz.springboot.upload.mapper");
//
////        //配置通用Mapper，详情请查阅官方文档
////        Properties properties = new Properties();
////        properties.setProperty("mappers", MAPPER_INTERFACE_REFERENCE);
////        properties.setProperty("notEmpty", "false");//insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
////        properties.setProperty("IDENTITY", "MYSQL");
////        mapperScannerConfigurer.setProperties(properties);
//
//        return mapperScannerConfigurer;
//    }
//}
