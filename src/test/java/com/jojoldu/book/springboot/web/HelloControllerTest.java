package com.jojoldu.book.springboot.web;


import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/*테스트를 진행할 시에 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다
여기서는 SpringRunner를 스프링 실행자를 샤용*/
@RunWith(SpringRunner.class)

/*여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있음
선언시에 @Controller 사용 가능하지하지만 @Service, @Component, @Repository 사용 불가
*/
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    //Bean 주입
    @Autowired
    //웹 API를 테스트할 때 사용
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        //MockMvc를 통해 /hello 주소로 HTTP GET 요청함, 체이닝 지원
        mvc.perform(get("/hello"))
                //Status가 OK인지 검증
                .andExpect(status().isOk())
                //리턴값이 hello가 맞는지 검증
                .andExpect(content().string(hello));
    }

}
