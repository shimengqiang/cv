package com.vector.dubbo.api;

import com.vector.dubbo.entity.ProductDto;
import java.util.Date;
import java.util.List;

public interface PoductDataService {

    /**
     * 减库存
     *
     * @param seckillId
     * @param killTime
     * @return 插入行数
     */
    int reduceNumber(long seckillId, Date killTime);

    /**
     * 查询秒杀对象
     *
     * @param seckillId
     * @return Seckill
     */
    ProductDto querySeckillById(long seckillId);

    /**
     *
     * @param offset
     * @param limit
     * @return Seckills
     */
    List<ProductDto> queryAllSeckill(int offset, int limit);

    int insertSuccessKilled(Long seckillId, long userPhone);

    Object querySuccessKillByIdWithSeckill(long seckillId);
}