package com.vector.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.vector.dubbo.dao.mapper.SeckillMapper;
import com.vector.dubbo.dao.mapper.SuccessKilledMapper;
import com.vector.dubbo.dao.model.Seckill;
import com.vector.dubbo.dao.model.SuccessKilled;
import com.vector.dubbo.dto.ProductDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.vector.dubbo.dto.ProductSeckillDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author smq
 */
@Service
@Component
@Slf4j
public class ProductDataServiceImpl implements PoductDataService {

    @Autowired
    private SeckillMapper seckillMapper;

    @Autowired
    private SuccessKilledMapper successKilledMapper;

    @Override
    public int reduceNumber(long seckillId, Date killTime) {
        return seckillMapper.reduceNumber(seckillId, killTime);
    }

    @Override
    public ProductDto querySeckillById(long seckillId) {
        ProductDto dto = new ProductDto();
        Seckill seckill = seckillMapper.selectByPrimaryKey(seckillId);
        if (seckill != null){
            BeanUtils.copyProperties(seckill, dto);
        }
        return dto;
    }

    @Override
    public List<ProductDto> queryAllSeckill(int offset, int limit) {
        List<ProductDto> dtoList = new ArrayList<>();
        List<Seckill> seckills = seckillMapper.selectAll(offset, limit);
        System.out.println(seckills.toString());
        seckills.forEach(seckill -> {
            ProductDto dto = new ProductDto();
            BeanUtils.copyProperties(seckill, dto);
            dtoList.add(dto);

        } );
        return dtoList;
    }

    @Override
    public int insertSuccessKilled(Long seckillId, long userPhone) {
        return successKilledMapper.insertSuccessKilled(seckillId, userPhone);
    }

    @Override
    public ProductSeckillDetail querySuccessKillByIdWithSeckill(long seckillId) {
        log.info("seckillId{}",seckillId);
        SuccessKilled successKilled = successKilledMapper.queryByIdWithSeckill(seckillId);
        ProductSeckillDetail detail = new ProductSeckillDetail();
        Optional.ofNullable(successKilled).ifPresent(successKilled1 -> {
            log.info("{}", successKilled.toString());
            BeanUtils.copyProperties(successKilled, detail);

        });
        return detail;
    }

}
