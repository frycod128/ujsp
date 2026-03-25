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

    /**
     * 判断整数的各位数字之和是否等于6
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

    /**
     * 校验字符串是否为有效的整数
     */
    private boolean isValidInteger(String str) {
        if (str == null || str.trim().isEmpty()) {
            return true;
        }
        String trimmed = str.trim();
        return !trimmed.matches("-?\\d+");
    }
}