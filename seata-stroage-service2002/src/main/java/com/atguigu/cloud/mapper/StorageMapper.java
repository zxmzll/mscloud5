package com.atguigu.cloud.mapper;

import com.atguigu.cloud.entities.Storage;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper

public interface StorageMapper extends Mapper<Storage> {

    /**
     * 扣减库存
     */
//    @Update("update t_storage set used = used + #{count} and residue = residue - #{count} WHERE product_id = #{productId}")
//    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}