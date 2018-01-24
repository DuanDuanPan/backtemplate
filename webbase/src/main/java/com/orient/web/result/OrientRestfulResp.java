/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.web.result
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-24 1:56 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.web.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author :  panduanduan
 * @Description :  restful response
 * @Creation Date:  2018-01-24 1:56 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrientRestfulResp<T> implements Serializable {

    /**
     * 响应业务状态
     */
    private Integer status;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 提示信息
     */
    private String error;
}