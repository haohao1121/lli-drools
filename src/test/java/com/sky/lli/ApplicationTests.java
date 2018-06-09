package com.sky.lli;

import com.sky.lli.util.spring.SpringContextUtil;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
//指定SpringBoot工程的Application启动类
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ApplicationTests {

    @Resource
    private ApplicationContext applicationContext;

    @Before
    public void initApplication() {
        SpringContextUtil.setApplicationContext(applicationContext);
    }

}
