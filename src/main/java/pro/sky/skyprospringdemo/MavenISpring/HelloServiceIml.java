package pro.sky.skyprospringdemo.MavenISpring;

import org.springframework.stereotype.Service;


@Service
public class HelloServiceIml implements HelloServiceInterface {
    public String hello() {
        return "hello";
    }

    public String answerHello(String userName) {
        return "<b>hello</b> "+ userName;
    }

}
