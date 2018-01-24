/**
 * @Project Name :  base
 * @Package Name :  com.orient.config
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-23 7:22 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.config;

import com.orient.config.properties.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author :  panduanduan
 * @Description :  属性自动装配
 * @Creation Date:  2018-01-23 7:22 PM
 */
@Configuration
@EnableConfigurationProperties({JwtProperties.class})
public class OrientPropertiesConfig {
}