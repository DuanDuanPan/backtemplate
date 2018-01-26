/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.config
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-26 11:32 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.web.config;

import com.orient.web.conver.LocalDateTimeConverter;
import com.orient.web.conver.StringToUUIDConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author :  panduanduan
 * @Description :  config springmvc
 * @Creation Date:  2018-01-26 11:32 AM
 */
@EnableWebMvc
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToUUIDConverter());
        registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd"));
        registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss.SSS"));
    }
}