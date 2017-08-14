package com.ideabook;

import com.ideabook.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: lzh
 * @Description:　第一部分：基础测试
 * @Date: Created in 2017/8/10 10:17
 */
//@RunWith(SpringJUnit4ClassRunner.class) //引入Spring-test框架支持
//@WebAppConfiguration // Web项目，Junit需要模拟ServletContext，测试类加上@WebAppConfiguration。
/*一、注解 */
@RunWith(SpringRunner.class) //引入Spring-test框架支持,SpringRunner继承SpringJUnit4ClassRunner
@SpringBootTest(classes = MockServletConfig.class)
public class JunitApplicationTest {

    private MockMvc mvc;

    /*
    二、 MockServletContext
    由于这是一个新建项目,只有一个helloWord路由,所以我们使用MockServletContext来测试
    使用MockServletContext来构建一个空的WebApplicationContext，这样我们创建的HelloController
    就可以在@Before函数中创建并传递到MockMvcBuilders.standaloneSetup（）函数中。
    */
    @Before
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    /*注意 status() content() equalTo()三个方法
       import static org.hamcrest.Matchers.equalTo;
       import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
       import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
    */
    @Test
    public void getHello() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello!!!")));
    }

    /*
    //所有测试方法执行前.执行一次，作用:整体初始化
    @BeforeClass

    //所有测试方法完成后,执行一次，作用:销毁和释放资源
    @AfterClass

    //每个测试方法前执行，作用:初始化方法
    @Before

    //每个测试方法后执行,作用:还原现场
    @After

    // 测试方法超过1000毫秒,记为超时,测试失败
    @Test(timeout = 1000)

    // 测试方法期望得到的异常类，如果方法执行没有抛出指定的异常，则测试失败
    @Test(expected = Exception.class)

    // 执行测试时将忽略掉此方法，如果用于修饰类，则忽略整个类
    @Ignore(“not ready yet”)
    @Test

    @RunWith
    在JUnit中有很多个Runner，他们负责调用你的测试代码，每一个Runner都有各自的特殊功能，你要根据需要选择不同的Runner来运行你的测试代码。

    如果我们只是简单的做普通Java测试，不涉及spring Web项目，你可以省略@RunWith注解，这样系统会自动使用默认Runner来运行你的代码。

    */

}