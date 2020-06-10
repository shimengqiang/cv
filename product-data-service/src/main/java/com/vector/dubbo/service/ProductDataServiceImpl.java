package com.vector.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.vector.dubbo.dao.mapper.SeckillMapper;
import com.vector.dubbo.dao.mapper.SuccessKilledMapper;
import com.vector.dubbo.dao.model.Seckill;
import com.vector.dubbo.dao.model.SuccessKilled;
import com.vector.dubbo.dto.ProductDto;
import com.vector.dubbo.dto.ProductSeckillDetail;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
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

	@PostConstruct
	public void init(){
		System.out.println("init");
	}

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
        List<Seckill> seckills = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Seckill seckill = new Seckill();
			seckill.setSeckillId(1L);
			seckill.setName("1L");
			seckill.setNumber(100);
			seckills.add(seckill);
		}

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
        // SuccessKilled successKilled = successKilledMapper.queryByIdWithSeckill(seckillId);
        SuccessKilled successKilled = new SuccessKilled();
		successKilled.setSeckillId(1L);
		successKilled.setUserPhone(13051200847L);
        ProductSeckillDetail detail = new ProductSeckillDetail();
        Optional.ofNullable(successKilled).ifPresent(successKilled1 -> {
            log.info("{}", successKilled.toString());
            BeanUtils.copyProperties(successKilled, detail);

        });
        return detail;
    }

}
