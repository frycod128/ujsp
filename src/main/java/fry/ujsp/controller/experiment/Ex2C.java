package fry.ujsp.controller.experiment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ex2")
public class Ex2C {
    /*
    编写三个JSP 页面inputGuess.jsp、result.jsp和success.jsp，实现猜数字游戏。具体要求如下：
    1.inputGuess.jsp
    用户请求inputGuess.jsp时，用随机函数产生一个大于等于1且小于等于100的整数。该页面同时负责将这个数字存在用户的session对象中。该页面提供表单，用户使用该表单输入自己猜测的整数，并提交给result.jsp页面。
    2.result.jsp
    result.jsp页面负责判断inputGuess.jsp提交的猜测是否和用户的session对象中存放的那个数字相同，如果相同就重定向到success.jsp；如果不相同就显示“猜大了”或“猜小了”，用户使用超链接回到inputGuess.jsp继续猜数。
    该页面在session对象中保存累计猜测次数和开始猜测时间与结束时间。
    3.success.jsp
    success.jsp页面负责显示用户成功的消息，并输出session对象中保存的随机整数、猜测次数和猜测耗时。
    */
    @GetMapping("/inputGuess")
    public String inputGuess(Model model) {
        return "ex2/inputGuess";
    }

    @PostMapping("/result")
    public String result(
            @RequestParam(name = "guess", defaultValue = "2") int guess,
            Model model) {
        model.addAttribute("guess", guess);
        return "ex2/result";
    }

    @GetMapping("/success")
    public String success(Model model) {
        return "ex2/success";
    }
}