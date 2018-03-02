### 在spring中使用security
1.继承AbstractSecurityWebApplicationInitializer
2.继承WebSecurityConfigurerAdapter
3.在2的类上添加@EnableWebSecurity注解

### 添加用户信息
1.调用inMemoryAuthentication()
2.自定义用户，需要实现UserDetailsServic接口，通过userDetailsService()方法将其设置到安全配置中

### 关于logout需要注意的地方
security默认是开启CSRF防护的，将LogoutFilter更改为了只能用POST请求才可以，
需要退出添加CSRF的token,解决方案：
1.使用form表单退出，如果使用的是thymeleaf模板，只需要form表单的action属性添加thymeleaf命名空间前缀即可。
如果是JSP，可以使用spring的表单绑定,sf:form即可
2.http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

### 关于添加自己的登录页面
1.提交的表单需要添加csrf的token
2.修改logpage()为自己的url,并添加如下代码

    @RequestMapping("mylogin")
        public String mylogin(){
            return "mylogin";
        }
