package com.sky.lli;

import com.sky.lli.util.spring.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.sky.lli.dao")
public class Application {

    //项目启动主方法
    public static void main(String[] args) {
        //项目启动返回上下文
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        //将上下文注入到spring工具类中
        SpringContextUtil.setApplicationContext(applicationContext);
    }
}