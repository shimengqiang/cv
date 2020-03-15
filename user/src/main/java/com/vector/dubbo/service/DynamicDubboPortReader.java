// package com.vector.dubbo.service;
//
// import com.alibaba.dubbo.common.utils.NetUtils;
// import com.alibaba.dubbo.config.ProtocolConfig;
// import java.util.Map;
// import javax.annotation.PostConstruct;
// import org.springframework.beans.BeansException;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.ApplicationContextAware;
// import org.springframework.context.ConfigurableApplicationContext;
// import org.springframework.stereotype.Component;
//
// /**
//  * @author smq
//  */
// @Component
// public class DynamicDubboPortReader implements ApplicationContextAware {
//
//     @Autowired
//     private ApplicationContext applicationContext;
//
//     private int port = 9011;
//
//     @PostConstruct
//     public void init(){
//         Map<String, ProtocolConfig> map = applicationContext.getBeansOfType(ProtocolConfig.class);
//         for(Map.Entry<String,ProtocolConfig> con: map.entrySet()){
//             port = NetUtils.getAvailablePort();
//             System.out.println("=========="+port);
//             con.getValue().setPort(port);
//         }
//     }
//     @Override
//     public void setApplicationContext(ApplicationContext context) throws BeansException {
//         this.applicationContext = (ConfigurableApplicationContext)applicationContext;
//     }
// }
