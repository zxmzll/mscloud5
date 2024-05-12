package com.atguigu.cloud.entities;

import javax.persistence.GeneratedValue;

/**
 * 表名：cc
*/
public class cc {
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
}