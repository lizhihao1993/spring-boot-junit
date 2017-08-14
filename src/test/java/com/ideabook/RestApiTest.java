package com.ideabook;

import com.ideabook.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * @Author: lzh
 * @Description:
 * @Date: Created in 2017/8/10 14:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)// 使用0表示端口号随机，也可以指定端口
public class RestApiTest {
    private String dateReg;
    private Pattern pattern;
    private RestTemplate template = new TestRestTemplate().getRestTemplate();

    @Value("${local.server.port}")// 注入端口号
    private int port;

    @Test
    public void testApi_Get() throws URISyntaxException {

        URI uri = new URI("http://tingapi.ting.baidu.com/v1/restserver/ting?" +
                "format=json%E6%88%96xml&calback=&from=webapp_music" +
                "&method=baidu.ting.billboard.billList&type=1&size=10&offset=0");
        String result = template.getForObject(uri, String.class);
        System.err.println(result);
    }

    @Test
    public void testApi_Post() throws URISyntaxException {

        String url = "http://localhost:"+port+"/hello";
        System.out.println("");
        System.err.println("url = " + url);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("name", "value1");
        String result = template.postForObject(url, map, String.class);
        System.err.println(result);
    }

    //put测试方法，没有返回值,改用exchange
    //exchange 以json形式请求,所以要定义Header，不然会报错，说是不支持这种MediaType。
    //而对应的Api方法如下，换了方式就很难测试成功，也是醉醉哒！！
    //         @RequestMapping(value = "/hello",method = RequestMethod.PUT)
    //         public String helloPut(@RequestBody User user){}
    @Test
    public void testApi_Put() throws Exception {
        String reqJsonStr = "{\"age\":\"200\",\"name\":\"zsssss\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(reqJsonStr,headers);
        String url = "http://localhost:"+port+"/hello";
        ResponseEntity<String> exchange = template.exchange(url, HttpMethod.PUT, entity, String.class);
        String body = exchange.getBody();
        System.err.println(body);
        System.err.println(exchange);
    }

    @Test
    public void testApi_Delete() throws Exception {
        String reqJsonStr = "{\"age\":\"200\",\"name\":\"zsssss\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(reqJsonStr,headers);
        String url = "http://localhost:"+port+"/hello";
        ResponseEntity<String> exchange = template.exchange(url, HttpMethod.DELETE, entity, String.class);
        String body = exchange.getBody();
        System.err.println(body);
        System.err.println(exchange);
    }

    // put delete 虽然说是测试通过了，但是限制忒多，感觉不实用。
    // 如 entity的设置，貌似只能用json形式的参数。 其他形式试了很久也没成功，囧。。。。欢迎补充
}
