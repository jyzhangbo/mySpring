package global;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

/**
 * 表达式处理器.
 *
 * zhangbo
 */
public class MyPermissionEvaluator implements PermissionEvaluator{
    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o1) {
        String s=(String)o;
        if("delete".equals(o1)){
            if(s.equals(authentication.getName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
