package com.atguigu.cloud.entitier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.math.BigDecimal;

;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayDTO implements Serializable {
    private Integer id;
    private String payNo;
    private String orderNo;
    private Integer userId;
    private BigDecimal amount;
}
