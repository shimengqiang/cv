package com.vector.dubbo.conf;

import com.alibaba.dubbo.config.annotation.Reference;
import com.vector.dubbo.service.PoductDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author smq
 */
@Configuration
public class DubboConfig {

	@Reference
	private PoductDataService poductDataService;
	@Bean("productService")
	public PoductDataService poductDataService(){
		return poductDataService;
	}
}
