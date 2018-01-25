/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.persistent.base
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-25 11:37 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.persistent.base;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

/**
 * @author :  panduanduan
 * @Description :  持久化bean中CreateBy注解及LastModifiedBy注解赋值
 * @Creation Date:  2018-01-25 11:37 AM
 */
@Configuration
public class UserIDAuditorBean implements AuditorAware<Long> {

    /**
     * TODO 后期采用系统安全框架中当前用户
     *
     * @return
     */
    @Override
    public Long getCurrentAuditor() {
        return -1l;
    }
}