package fry.ujsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller  // 注意这里是 @Controller，不是 @RestController
public class JspController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "访客") String name,
                        Model model) {
        model.addAttribute("message", "欢迎使用 JSP 页面！");
        model.addAttribute("name", name);
        model.addAttribute("time", LocalDateTime.now());
        List<String> items = Arrays.asList("Java", "Spring Boot", "JSP", "Maven");
        model.addAttribute("items", items);
        return "hello";
    }
}