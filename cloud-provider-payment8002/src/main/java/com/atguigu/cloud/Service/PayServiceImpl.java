package com.atguigu.cloud.Service;

import com.atguigu.cloud.entities.pay;
import com.atguigu.cloud.mapper.payMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


;
@Service
public class PayServiceImpl implements PayService{
    @Resource
    private payMapper payMapper;

    @Override
    public int add(pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public pay getByid(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<pay> getall() {
        return payMapper.selectAll();
    }
}
