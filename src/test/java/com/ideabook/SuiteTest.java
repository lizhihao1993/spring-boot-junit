package com.ideabook;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @Author: lzh
 * @Description: 第三部分：打包测试
                 打包测试，就是新增一个类，将其他测试类配置在一起，运行这个类达到运行多个测试类的目的
                  具体测试，还有待实验。。。囧。。。。
 * @Date: Created in 2017/8/10 14:20
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({JunitApplicationTest.class,JunitApplicationTest.class,SpringBootJunitApplicationTests.class})
public class SuiteTest {
    // 类中不需要编写代码
}
