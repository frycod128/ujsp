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
//    /**
//     * 处理根路径"/"的GET请求，返回index视图
//     * @param model 用于向视图传递数据
//     * @return 返回index视图的名称
//     */
//    @GetMapping("/")
//    public String index(Model model) {
//        return "index";
//    }
//    /**
//     * 处理/hello路径的GET请求，返回hello.jsp页面
//     * @param name 请求参数name，默认值为"访客"
//     * @param model 用于向视图传递数据
//     * @return 视图名称"hello"
//     */
//    @GetMapping("/hello")  // 映射GET请求到/hello路径
//    public String hello(
//            @RequestParam(name = "name", defaultValue = "访客") String name,  // 请求参数name，默认值为"访客"
//            Model model) {  // Model对象用于向视图传递数据
//        // 向模型中添加消息属性
//        model.addAttribute("message", "欢迎使用 JSP 页面！");
//        // 向模型中添加名称属性
//        model.addAttribute("name", name);
//        // 向模型中添加当前时间属性
//        model.addAttribute("time", LocalDateTime.now());
//        // 创建并添加项目列表属性
//        List<String> items = Arrays.asList("Java", "Spring Boot", "JSP", "Maven");
//        model.addAttribute("items", items);
//        // 返回视图名称
//        return "hello";
//    }
//
//    /*
//    在JSP页面中完成下列算法：
//    1、随机产生1百万个1~6的整数，分别统计1~6出现的次数。
//    2、输出6~100000中的全部自幕数。
//    */
//    @GetMapping("/1")
//    public String i1(Model model) {
//        return "homework/1";
//    }
//
//    /*
//    创建两个jsp页面，第一个页面输入姓名、整数n和m，提交到第二个页面。
//    第二个页输出姓名，以及从n开始的m个连续的素数。
//    */
//    @GetMapping("/2")
//    public String i2(Model model) {
//        return "homework/2";
//    }
//    @PostMapping("/2-1")
//    public String i2_1(
//            @RequestParam(name = "name", defaultValue = "访客") String name,
//            @RequestParam(name = "n", defaultValue = "2") int n,
//            @RequestParam(name = "m", defaultValue = "1") int m,
//            Model model) {
//        model.addAttribute("name", name);
//        model.addAttribute("n", n);
//        model.addAttribute("m", m);
//        return "homework/2-1";
//    }
//
//    /*
//    等待中，暂时是占位预留。
//    */
//    @GetMapping("/3")
//    public String i3(Model model) {
//        return "homework/3";
//    }
//
//    /*
//    实现一个页面，要求：
//    1.在页面中定义计算最大公约数的函数和最小公倍数的函数，函数使用JSP注释说明函数的功能。
//    2.定义二个整数，调用上述函数计算并输出它们的最大公约数和最小公倍数。
//    */
//    @GetMapping("/ex1/index")
//    public String ex1(Model model) {
//        return "/ex1/index";
//    }
//
//    /*
//    编写三个JSP 页面inputGuess.jsp、result.jsp和success.jsp，实现猜数字游戏。具体要求如下：
//    1.inputGuess.jsp
//    用户请求inputGuess.jsp时，用随机函数产生一个大于等于1且小于等于100的整数。该页面同时负责将这个数字存在用户的session对象中。该页面提供表单，用户使用该表单输入自己猜测的整数，并提交给result.jsp页面。
//    2.result.jsp
//    result.jsp页面负责判断inputGuess.jsp提交的猜测是否和用户的session对象中存放的那个数字相同，如果相同就重定向到success.jsp；如果不相同就显示“猜大了”或“猜小了”，用户使用超链接回到inputGuess.jsp继续猜数。
//    该页面在session对象中保存累计猜测次数和开始猜测时间与结束时间。
//    3.success.jsp
//    success.jsp页面负责显示用户成功的消息，并输出session对象中保存的随机整数、猜测次数和猜测耗时。
//    */
//    @GetMapping("/ex2/inputGuess")
//    public String ex2_1(Model model) {
//        return "ex2/inputGuess";
//    }
//    @PostMapping("/ex2/result")
//    public String ex2_2(
//            @RequestParam(name = "guess", defaultValue = "2") int guess,
//            Model model) {
//        model.addAttribute("guess", guess);
//        return "/ex2/result";
//    }
//    @GetMapping("/ex2/success")
//    public String ex2_3(Model model) {
//        return "/ex2/success";
//    }

}