/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.web
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-24 1:44 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.web.base;

import com.orient.web.exception.OrientServiceProcessException;
import com.orient.web.result.OrientRestfulResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author :  panduanduan
 * @Description :  TODO
 * @Creation Date:  2018-01-24 1:44 PM
 */
@Transactional(rollbackFor = {Exception.class})
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 处理返回值
     *
     * @param processor
     * @return
     */
    protected OrientRestfulResp restProcessor(ResultProcessor processor) {
        OrientRestfulResp result = null;
        try {
            result = processor.process();
        } catch (OrientServiceProcessException e1) {
            logger.error("ServiceProcess Error Log :" + e1.getLocalizedMessage(), e1);
            result = OrientRestfulResp.builder().error(e1.getMessage()).build();
        } catch (Exception e) {
            logger.error("Error Log :" + e.getLocalizedMessage(), e);
            result = OrientRestfulResp.builder().error("服务器出现异常").build();
        }
        return result;
    }
}