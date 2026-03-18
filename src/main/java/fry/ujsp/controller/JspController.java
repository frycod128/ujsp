package fry.ujsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/hello")  // 映射GET请求到/hello路径
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

    /*
    在JSP页面中完成下列算法：
    1、随机产生1百万个1~6的整数，分别统计1~6出现的次数。
    2、输出6~100000中的全部自幕数。
    */
    @GetMapping("/1")
    public String i1(Model model) {
        return "homework/1";
    }

    /*
    创建两个jsp页面，第一个页面输入姓名、整数n和m，提交到第二个页面。
    第二个页输出姓名，以及从n开始的m个连续的素数。
    */
    @GetMapping("/2")
    public String i2(Model model) {
        return "homework/2";
    }
    @PostMapping("/2-1")
    public String i2_1(
            @RequestParam(name = "name", defaultValue = "访客") String name,
            @RequestParam(name = "n", defaultValue = "2") int n,
            @RequestParam(name = "m", defaultValue = "1") int m,
            Model model) {
        model.addAttribute("name", name);
        model.addAttribute("n", n);
        model.addAttribute("m", m);
        return "homework/2-1";
    }

    /*
    等待中，暂时是占位预留。
    */
    @GetMapping("/3")
    public String i3(Model model) {
        return "homework/3";
    }
}