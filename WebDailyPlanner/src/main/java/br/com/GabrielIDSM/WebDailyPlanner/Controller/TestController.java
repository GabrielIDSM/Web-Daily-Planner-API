package br.com.GabrielIDSM.WebDailyPlanner.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/Test")
    public String Home(){
        return "test";
    }
}
