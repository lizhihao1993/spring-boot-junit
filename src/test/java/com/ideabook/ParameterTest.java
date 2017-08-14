package com.ideabook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @Author: lzh
 * @Description:  第二部分：参数化测试
 * @Date: Created in 2017/8/10 10:48
 */
@RunWith(Parameterized.class)
public class ParameterTest {
    private String name;
    private String password;


    //1.初始化测试参数
    @Parameters
    public static Collection<?> data(){
        System.out.println("===data===========");
        return Arrays.asList(new Object[][]{
                {"Test","123"},
                {"ATest","12"},
                {"BTest","123"},
        });
    }

    //2.将@Parameters注解的方法中的Object数组中值的顺序对应
    public ParameterTest(String name, String password) {
        super();
        System.out.println("===ParameterTest===================");
        this.name = name;
        this.password = password;
    }

    //3.逻辑测试
    /*
      import static org.junit.Assert.assertTrue;
      assertTrue():断言，如果结果为true，啥事没有
                       否则，就会弹出“java.lang.AssertionError” + 错误信息（红红的错误很醒目，还以为代码写错了，囧~~~）
    */
    @Test
    public void test() {
        System.out.println("==test==========");
        assertTrue(name.contains("Test")==true);
        assertTrue(password.equals("12"));
    }


    /*
    Assert断言方法介绍

     1、assertEquals

　　函数原型1：assertEquals([String message],expected,actual)

    参数说明：
        message是个可选的消息，假如提供，将会在发生错误时报告这个消息。
     　 expected是期望值，通常都是用户指定的内容。
        actual是被测试的代码返回的实际值。
    例：assertEquals("equals","1","1");
    */
    private String getStr(){
        return "asd";
    }
    @Test
    public void testAssertEquals1(){
        assertEquals("不相等","a",getStr());
        assertEquals("不相等","as",getStr());
    }

    /*
    函数原型2：assertEquals([String message],expected,actual,tolerance)
    参数说明：
        message是个可选的消息，假如提供，将会在发生错误时报告这个消息。

    　　expected是期望值，通常都是用户指定的内容。

    　　actual是被测试的代码返回的实际值。

    　　tolerance是误差参数，参加比较的两个浮点数在这个误差之内则会被认为是相等的。
     */
    @Test
    public void testAssertEquals2(){
        assertEquals("你又不乖了。。。",3.33,10/3,0.04);
    }

    /*
    2、assertTrue

　　 函数原型：assertTrue ([String message],Boolean condition)

　　 参数说明：

        message是个可选的消息，假如提供，将会在发生错误时报告这个消息。

　　    condition是待验证的布尔型值。

　　    该断言用来验证给定的布尔型值是否为真，假如结果为假，则验证失败。当然，更有验证为假的测试条件：

　　 函数原型：assertFalse([String message],Boolean condition)

　　        该断言用来验证给定的布尔型值是否为假，假如结果为真，则验证失败。

       例： assertTrue("true",1==1);
            assertFalse("false",2==1);
    */
    /*
    3、assertNull

　　函数原型：assertNull([String message],Object object)

    参数说明：

        message是个可选的消息，假如提供，将会在发生错误时报告这个消息。

　　    object是待验证的对象。

　　    该断言用来验证给定的对象是否为null，假如不为null，则验证失败。相应地，还存在能够验证非null的断言：

　　函数原型：assertNotNull([String message],Object object)

         该断言用来验证给定的对象是否为非null，假如为null，则验证失败。

        例：assertNull("null",null);

           assertNotNull("not null",new String());
    */
    @Test
    public void testAssertNull(){
        //assertNull("null",null);

//        List list = new ArrayList();
//        assertNull("new ArrayList is not null" ,list);

        List  list1 = Collections.emptyList();
        assertNull("emptyList is not null",list1);
    }

    /*
    　4、assertSame

　　函数原型：assertSame ([String message], expected,actual)

    参数说明：

        message是个可选的消息，假如提供，将会在发生错误时报告这个消息。

　　    expected是期望值。

    　　actual是被测试的代码返回的实际值。

　　    该断言用来验证expected参数和actual参数所引用的是否是同一个对象，假如不是，则验证失败。

　　函数原型：assertNotSame ([String message], expected,actual)

        该断言用来验证expected参数和actual参数所引用的是否是不同对象，假如所引用的对象相同，则验证失败。

        例：assertSame("same",2,4-2);
            assertNotSame("not same",2,4-3);
     */
    @Test
    public void testSame(){
//        assertSame("same:这俩对象真不一样！！！",2,4-2);
        //assertSame("same:这俩对象真不一样！！！",2L,4-2);
      //  assertSame("same:这俩对象真不一样！！！",new String("aaa"),new String("aaa"));
        //assertSame("same:这俩对象一样！！！","aaa","aaa");
       // assertSame("same:这俩对象真不一样！！！","aaa",new String("aaa"));

        String a,b;
        a = "aaaaa";
        b = a;
        assertSame("same:这俩对象一样！！！",a,b);
        assertSame("same:这俩对象一样！！！",a,"aaaaa");
    }

    /*
    5、fail

　　函数原型：fail([String message])

    参数说明：

        message是个可选的消息，假如提供，将会在发生错误时报告这个消息。

    　　该断言会使测试立即失败，通常用在测试不能达到的分支上（如异常）。
        测试方法是否进行完毕，如果没有则报错并中断，如下：i 的值不同，结果不同。
     */
    @Test
    public void testFail(){
        for (int i = 0 ; i < 10 ; i ++){
            if (i == 5){
                fail("fail....");
            }
            System.out.println(i);
        }
    }

    /*
    6、assertArrayEquals
    函数原型：assertArrayEquals([String message], Object[] expecteds,Object[] actuals)
    参数说明：
        message是个可选的消息，假如提供，将会在发生错误时报告这个消息,以及不一致的具体信息（数组长度、首次出现不一致的地方..）

        expecteds 是多个期望值。

    　　actuals是被测试的代码返回的实际值。
     */
    @Test
    public void testAssertArrayEquals(){
        //assertArrayEquals("这俩数组不一样？？",new Integer[]{1,3,5,7,9},new Integer[]{1,3,5});
        /* java.lang.AssertionError: 这俩数组不一样？？: array lengths differed, expected.length=5 actual.length=3 */

        //assertArrayEquals("这俩数组不一样？？",new Integer[]{1,3,5,7,9},new Integer[]{1,3,5,7,9});

        //assertArrayEquals("这俩数组不一样？？",new Integer[]{1,3,5,7,9},new Integer[]{2,4,6,8,10});
        /*这俩数组不一样？？: arrays first differed at element [0]; .... */

        assertArrayEquals("这俩数组不一样？？",new Integer[]{1,3,5,7,9},new Integer[]{1,3,6,8,10});
        /* 这俩数组不一样？？: arrays first differed at element [2];
            Expected :5
            Actual   :6
         */
    }

}
