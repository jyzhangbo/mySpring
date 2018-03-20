package mvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import service.HomeService;

import java.util.ArrayList;
import java.util.List;

/**
 * zhangbo
 */
@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("home")
    public String home(){
        System.out.println("进入control");
        List<String> list=new ArrayList<>();
        list.add("user");
        list.add("zhangbo");
        List<String> strings = homeService.home6(list);

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
