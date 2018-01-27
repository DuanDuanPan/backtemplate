/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.common.mybatis
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-26 11:01 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.config.mybatis;

import com.orient.common.mybatis.BaseOrientMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * @author :  panduanduan
 * @Description :  config mybatis mapperScanner
 * @Creation Date:  2018-01-26 11:01 PM
 */
@Configuration
public class MyBatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.orient.persistent.*.mapper");
        mapperScannerConfigurer.setMarkerInterface(BaseOrientMapper.class);
        Properties properties = new Properties();
        //for oracle sequence
        properties.setProperty("ORDER", "BEFORE");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }

}