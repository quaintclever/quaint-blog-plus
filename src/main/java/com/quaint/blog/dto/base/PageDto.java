package com.quaint.blog.dto.base;

import java.io.Serializable;

/**
 * @Description: 分页参数封装，用于统一使用分页属性
 * @author: qi cong
 * @Date: Created in 2019-12-03 18:43
 */
public class PageDto implements Serializable {

    // @ApiModelProperty(value = "页数", name = "页数")
    private Integer pageNum;

    // @ApiModelProperty(value = "分页大小", name = "分页大小")
    private Integer pageSize;

    // 获取 limit 开始 的数字
    public Integer getStartNum(){
        if (getPageNum() == null || getPageSize() == null)
            return null;
        return (getPageNum()-1)*getPageSize();
    }

    public Integer getPageNum() {
        if (pageNum == null)
            return null;
        return pageNum > 0 ? pageNum : null;
    }

    public Integer getPageSize() {
        if (pageSize == null)
            return null;
        return pageSize > 0 ? pageSize : null;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
