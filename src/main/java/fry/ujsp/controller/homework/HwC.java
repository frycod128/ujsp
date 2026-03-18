package fry.ujsp.controller.homework;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/homework")
public class HwC {
    /*
    在JSP页面中完成下列算法：
    1、随机产生1百万个1~6的整数，分别统计1~6出现的次数。
    2、输出6~100000中的全部自幕数。
    */
    @GetMapping("/1")
    public String homework1(Model model) {
        return "homework/1";
    }

    /*
    创建两个jsp页面，第一个页面输入姓名、整数n和m，提交到第二个页面。
    第二个页输出姓名，以及从n开始的m个连续的素数。
    */
    @GetMapping("/2")
    public String homework2(Model model) {
        return "homework/2";
    }

    @PostMapping("/2-1")
    public String homework2_1(
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
    public String homework3(Model model) {
        return "homework/3";
    }
}