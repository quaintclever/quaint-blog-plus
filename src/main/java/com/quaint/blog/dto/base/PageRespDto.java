package com.quaint.blog.dto.base;

import lombok.Data;

/**
 * @author qi cong
 * @date 2019-12-21 14:01
 */
@Data
public class PageRespDto<T> {

    /**
     * 数据集合
     */
    private T body;

    /**
     * 数据总数
     */
    private Integer totalCount;

    /**
     * 消息
     */
    private String msg;

    /**
     * 状态码
     */
    private Integer code;


}
