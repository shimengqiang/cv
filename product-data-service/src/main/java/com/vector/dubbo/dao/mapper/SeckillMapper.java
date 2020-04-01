package com.vector.dubbo.dao.mapper;

import com.vector.dubbo.dao.model.Seckill;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeckillMapper {

    Seckill selectByPrimaryKey(Long seckillId);

    List<Seckill> selectAll(@Param("offset") int offset, @Param("limit") int limit);


    int reduceNumber(@Param("id") long id, @Param("time") Date time);
}