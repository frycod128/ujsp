package fry.ujsp.controller.experiment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ex3")
public class Ex3C {
    /*
     1.	通过index.jsp的表单向servlet提交用户名和二个正整数（比如10和10000）。
     2.	在servlet（名称自定义）中定义一个方法（方法名自定义），用于判断整数的各个数字之和是否等于6。
     3.	在上述servlet中获取提交的信息：
        （1）若用户名为空或值有错，则将信息“请输入正确的用户名或整数！”转发到index.jsp页面；
        （2）若输入正确，则在该servlet中计算出这二个数之间所有的整数各个数字之和等于6的数，然后转发到show.jsp页面，输出用户名以及数字之和等于6的全部整数。
     */
    private boolean isDigitSumEqualsSix(int number) {
        int n = Math.abs(number);
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum == 6;
    }

    @GetMapping("index")
    public String showForm() {
        return "ex3/index";
    }

    @PostMapping("/show")
    public String calculate(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "num1", required = false) String num1Str,
            @RequestParam(value = "num2", required = false) String num2Str,
            Model model,
            HttpServletRequest request) {

        if (username == null || username.trim().isEmpty() ||
                num1Str == null || num2Str == null ||
                isValidInteger(num1Str) || isValidInteger(num2Str)) {

            model.addAttribute("errorMsg", "请输入正确的用户名或整数！");
            return "ex3/index";
        }

        try {
            int num1 = Integer.parseInt(num1Str.trim());
            int num2 = Integer.parseInt(num2Str.trim());

            int start = Math.min(num1, num2);
            int end = Math.max(num1, num2);

            List<Integer> resultList = new ArrayList<Integer>();
            for (int i = start; i <= end; i++) {
                if (isDigitSumEqualsSix(i)) {
                    resultList.add(i);
                }
            }

            model.addAttribute("username", username);
            model.addAttribute("start", start);
            model.addAttribute("end", end);
            model.addAttribute("resultList", resultList);

            return "ex3/show";

        } catch (NumberFormatException e) {
            model.addAttribute("errorMsg", "请输入正确的用户名或整数！");
            return "ex3/index";
        }
    }

    private boolean isValidInteger(String str) {
        if (str == null || str.trim().isEmpty()) {
            return true;
        }
        String trimmed = str.trim();
        return !trimmed.matches("-?\\d+");
    }
}