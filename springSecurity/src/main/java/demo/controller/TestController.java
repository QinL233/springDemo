package demo.controller;

import demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/test1")
    @PreAuthorize("hasAuthority('admin')")
    public String test1() {
        return "hello1";
    }

    @GetMapping("/test2")
    @PreAuthorize("hasAuthority('admin2')")
    public String test2() {
        return "hello2";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String token = loginService.login();
        response.addHeader(tokenHeader, tokenHead + token);
        return "loginSuccess:" + token;
    }
}
