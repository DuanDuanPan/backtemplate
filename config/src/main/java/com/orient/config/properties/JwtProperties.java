/**
 * @Project Name :  base
 * @Package Name :  com.orient.properties
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-23 9:48 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author :  panduanduan
 * @Description :  jwt properties
 * @Creation Date:  2018-01-23 9:48 AM
 */
@ConfigurationProperties(prefix = "orient.custom.jwt")
@Data
@Component
public class JwtProperties {

    private String salt;
}