package com.atguigu.cloud.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 表名：t_pay
 * 表注释：支付交易表
*/
@Table(name = "t_pay")
@Schema(title = "支付交易表实体类")
public class pay {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Schema(title = "ID")
    private Integer id;

    @Column(name = "pay_no")
    @Schema(title = "支付流水号")
    private String payNo;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    @Schema(title = "订单流水号")
    private String orderNo;

    /**
     * 用户账号id
     */
    @Column(name = "user_id")
    @Schema(title = "用户账号id")
    private Integer userId;

    /**
     * 交易金额
     */
    @Schema(title = "交易金额")
    private BigDecimal amount;

    /**
     * 删除标志，默认0不删除，1删除
     */

    private Byte deleted;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @Schema(title = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @Schema(title = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

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

    /**
     * @return payNo
     */
    public String getPayNo() {
        return payNo;
    }

    /**
     * @param payNo
     */
    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    /**
     * 获取订单号
     *
     * @return orderNo - 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单号
     *
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取用户账号id
     *
     * @return userId - 用户账号id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户账号id
     *
     * @param userId 用户账号id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取交易金额
     *
     * @return amount - 交易金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置交易金额
     *
     * @param amount 交易金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取删除标志，默认0不删除，1删除
     *
     * @return deleted - 删除标志，默认0不删除，1删除
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     * 设置删除标志，默认0不删除，1删除
     *
     * @param deleted 删除标志，默认0不删除，1删除
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return updateTime - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}