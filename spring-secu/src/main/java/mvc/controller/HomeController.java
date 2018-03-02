package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * zhangbo
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("home")
    public String home(){
        return "home";
    }

    @RequestMapping("home/admin")
    public String adminHome(){
        return "adminHome";
    }

    @RequestMapping("mylogin")
    public String mylogin(){
        return "mylogin";
    }
}
