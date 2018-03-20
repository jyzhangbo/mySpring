package service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

/**
 * zhangbo
 */
@Service
public class HomeService {

    //在方法调用之前执行,判断是否有权限执行方法
    @PreAuthorize("hasRole('ADMIN')")
    public String home() {
        System.out.println("有权限执行");
        return "home";
    }
    //在方法调用之后执行
    @PostAuthorize("returnObject.equals('home')")
    public String home3() {
        System.out.println("有权限执行");
        return "home3";
    }

    //过滤请求
    @PreFilter(value = "filterObject.equals(principal.username)")
    public List<String> home5(List<String> list){

        return list;
    }

    //过滤请求
    @PreFilter("hasPermission(filterObject,'delete')")
    public List<String> home6(List<String> list){

        return list;
    }

    //过滤返回值
    @PostFilter("filterObject.startsWith(principal.username)")
    public List<String> home4() {
        System.out.println("有权限执行");
        List<String> list=new ArrayList<>();
        list.add("home");
        list.add("home1");
        list.add("user");

        return list;
    }

    @Secured("ROLE_ADMIN")
    public String home1(){
        System.out.println("有权限执行");
        return "home";
    }

    @RolesAllowed("ROLE_ADMIN")
    public String home2(){
        System.out.println("有权限执行");
        return "home";
    }
}
