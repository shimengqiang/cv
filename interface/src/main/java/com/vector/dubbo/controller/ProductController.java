package com.vector.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.vector.dubbo.api.PoductDataService;
import com.vector.dubbo.entity.ProductDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smq
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Reference
    private PoductDataService poductDataService;

    @GetMapping("/list")
    public Object products(Integer offset, Integer limit){
        List<ProductDto> list = poductDataService.queryAllSeckill(offset, limit);
        list.forEach(p->{
            Object o  = poductDataService.querySuccessKillByIdWithSeckill(p.getSeckillId());
            System.out.println(o.toString());

        });
        return list;
    }
}