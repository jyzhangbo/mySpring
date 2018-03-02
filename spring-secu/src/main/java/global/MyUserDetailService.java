package global;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * zhangbo
 */
public class MyUserDetailService  implements UserDetailsService{
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        List<GrantedAuthority> authoritys=new ArrayList<>();
        if("zhangbo".equals(name)) {
            authoritys.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        authoritys.add(new SimpleGrantedAuthority("ROLE_USER"));
        User user=new User(name,"123",authoritys);
        return user;
    }
}
