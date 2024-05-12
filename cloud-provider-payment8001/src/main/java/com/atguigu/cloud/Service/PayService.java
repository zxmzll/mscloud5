package com.atguigu.cloud.Service;

import com.atguigu.cloud.entities.pay;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface PayService {
    public int add(pay pay);
    public int delete(Integer id);
    public int update(pay pay);
    public pay getByid(Integer id);
    public List<pay> getall();

}
