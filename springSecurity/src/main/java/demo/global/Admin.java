package demo.global;

import demo.vo.CurrentUserDetails;
import demo.vo.Permission;
import org.assertj.core.util.Lists;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/4 17:45
 */
public class Admin {
    public static final CurrentUserDetails user = new CurrentUserDetails();

    static {
        user.setId("1");
        user.setUsername("root");
        user.setPassword("root");
        Permission permission = new Permission();
        permission.setId("1");
        permission.setName("admin");
        user.setPermissions(Lists.newArrayList(permission));
    }

    private Admin(){};
}
