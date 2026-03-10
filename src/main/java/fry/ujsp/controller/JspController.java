package fry.ujsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class JspController {
    /**
     * 处理根路径"/"的GET请求，返回index视图
     * @param model 用于向视图传递数据
     * @return 返回index视图的名称
     */
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    /**
     * 处理/hello路径的GET请求，返回hello.jsp页面
     * @param name 请求参数name，默认值为"访客"
     * @param model 用于向视图传递数据
     * @return 视图名称"hello"
     */
    @GetMapping("/hello.jsp")  // 映射GET请求到/hello路径
    public String hello(
            @RequestParam(name = "name", defaultValue = "访客") String name,  // 请求参数name，默认值为"访客"
            Model model) {  // Model对象用于向视图传递数据
        // 向模型中添加消息属性
        model.addAttribute("message", "欢迎使用 JSP 页面！");
        // 向模型中添加名称属性
        model.addAttribute("name", name);
        // 向模型中添加当前时间属性
        model.addAttribute("time", LocalDateTime.now());
        // 创建并添加项目列表属性
        List<String> items = Arrays.asList("Java", "Spring Boot", "JSP", "Maven");
        model.addAttribute("items", items);
        // 返回视图名称
        return "hello";
    }

    @GetMapping("/1.jsp")
    public String i1(Model model) {
        return "1";
    }

    @GetMapping("/2.jsp")
    public String i2(Model model) {
        return "2";
    }
    @GetMapping("/2-1.jsp")
    public String i2_1(
            @RequestParam(name = "name", defaultValue = "访客") String name,
            @RequestParam(name = "n", defaultValue = "2") int n,
            @RequestParam(name = "m", defaultValue = "1") int m,
            Model model) {
        model.addAttribute("name", name);
        model.addAttribute("n", n);
        model.addAttribute("m", m);
        return "2-1";
    }

    @GetMapping("/3.jsp")
    public String i3(Model model) {
        return "3";
    }
}