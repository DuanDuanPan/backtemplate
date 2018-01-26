/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.web.conver
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-26 11:27 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.web.conver;

import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

/**
 * @author :  panduanduan
 * @Description :  conver string type request paramter to uuid
 * @Creation Date:  2018-01-26 11:27 AM
 */
public class StringToUUIDConverter implements Converter<String, UUID> {
    public UUID convert(String source) {
        return UUID.fromString(source);
    }
}