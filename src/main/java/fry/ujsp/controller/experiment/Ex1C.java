package fry.ujsp.controller.experiment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex1")
public class Ex1C {
    /*
    实现一个页面，要求：
    1.在页面中定义计算最大公约数的函数和最小公倍数的函数，函数使用JSP注释说明函数的功能。
    2.定义二个整数，调用上述函数计算并输出它们的最大公约数和最小公倍数。
    */
    @GetMapping("/index")
    public String ex1Index(Model model) {
        return "ex1/index";
    }
}