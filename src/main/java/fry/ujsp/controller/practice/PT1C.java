package fry.ujsp.controller.practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ai1")
public class PT1C {
    @GetMapping("/index")
    public String index(Model model) {
        return "ai1/index";
    }
}