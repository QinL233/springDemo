package demo.controller;

import demo.service.LoginService;
import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/4 17:27
 */
@RestController
public class TestController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private LoginService loginService;

    @GetMapping("/test")
    public String print(){
        return "hello";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        String token = loginService.login();
        response.addHeader(tokenHeader,tokenHead+token);
        return "loginSuccess:"+token;
    }
}
