package global;

import global.MyPasswordEncoder;
import global.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

/**
 * zhangbo
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home/admin").hasRole("ADMIN")
                .antMatchers("/home/**").hasAnyAuthority("ROLE_USER")
                .anyRequest().permitAll().and()
                .formLogin().loginPage("/mylogin").and()
                .rememberMe().tokenValiditySeconds(100)
                .key("securityKey").and()
                .logout().logoutSuccessUrl("/").logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
                .withUser("user").password("123").roles("USER").and()
                .withUser("admin").password("111").roles("USER","ADMIN");
        /* ldap暂时还不好使
        auth.ldapAuthentication().userSearchFilter("(uid={0})")
                .groupSearchFilter("member={0}")
                .contextSource()
                .url("ldap://tds02.xinaogroup.com:389/DC=ENN,DC=COM").managerDn("cn=users")
                .managerPassword("000");*/

       //auth.userDetailsService(new MyUserDetailService()).passwordEncoder(new MyPasswordEncoder());

    }
}
