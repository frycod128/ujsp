package fry.ujsp.controller.practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ai2")
public class PT2C {
    /*
    1、在第一个jsp页面中使用表单输入整数n，并定义一个HashMap对象，保存至少4个网站的网名与网址的键值对，该对象存储于session中。
    2、在第二个jsp页面中获取n，使用EL和JSTL输出n行杨辉三角形；获取HashMap对象中的键值对，使用标签库中的forEach与url在网页上输出友情链接。
    */
    @GetMapping("/index")
    public String ai2Index(Model model) {
        return "ai2/index";
    }

    @PostMapping("/yanghui")
    public String ai2Yanghui(
            @RequestParam(name = "n", defaultValue = "2") int n,
            Model model) {
        model.addAttribute("n", n);
        return "ai2/yanghui";
    }
}