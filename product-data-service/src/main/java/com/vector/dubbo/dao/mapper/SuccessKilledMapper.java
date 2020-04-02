package com.vector.dubbo.dao.mapper;

import com.vector.dubbo.dao.model.SuccessKilled;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuccessKilledMapper {
    int deleteByPrimaryKey(@Param("seckillId") Long seckillId, @Param("userPhone") Long userPhone);

    int insert(SuccessKilled record);

    SuccessKilled selectByPrimaryKey(@Param("seckillId") Long seckillId, @Param("userPhone") Long userPhone);

//    List<SuccessKilled> selectAll();

    int insertSuccessKilled(@Param("id") Long id, @Param("phone") long phone);

    SuccessKilled queryByIdWithSeckill(Long seckillId);
}