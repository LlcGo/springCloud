package com.lc.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Lc
 * @Date 2023/5/22
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommResult<T> {
    private Integer code;
    private String message;
    private T  data;

    public CommResult(Integer code, String message) {
//        this.code = code;
//        this.message = message;
        this(code,message,null);
    }

}
