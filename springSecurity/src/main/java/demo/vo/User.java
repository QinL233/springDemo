package demo.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/4 16:59
 */
public class User implements Serializable {
    private static final long serialVersionUID = 5754073904880319896L;
    private String id;
    private String username;
    private String password;
    private List<Permission> permissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
