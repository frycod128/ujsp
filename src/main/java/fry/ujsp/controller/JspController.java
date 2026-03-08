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
    @GetMapping("/")  // 访问根路径
    public String index(Model model) {
        return "index";
    }
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
    @GetMapping("/1")
    public String i1(Model model) {
        return "1";
    }
    @GetMapping("/2")
    public String i2(Model model) {
        return "2";
    }
    @GetMapping("/3")
    public String i3(Model model) {
        return "3";
    }
}