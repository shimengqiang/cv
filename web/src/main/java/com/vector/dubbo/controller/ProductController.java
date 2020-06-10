package com.vector.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.vector.dubbo.dto.ProductDto;
import com.vector.dubbo.dto.ProductSeckillDetail;
import com.vector.dubbo.service.PoductDataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Autowired
	@Qualifier(value = "productService")
	private PoductDataService productService;

    @GetMapping("/list")
    public Object products(Integer offset, Integer limit){
		// List<ProductDto> list = (List<ProductDto>) iProduct001Service.getList();
        List<ProductDto> list = productService.queryAllSeckill(offset, limit);
        list.forEach(p->{
            ProductSeckillDetail o  = productService.querySuccessKillByIdWithSeckill(p.getSeckillId());
            System.out.println(o.toString());

        });
        return list;
    }
}
