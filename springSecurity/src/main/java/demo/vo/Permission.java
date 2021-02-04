package demo.vo;

import java.io.Serializable;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/4 17:00
 */
public class Permission implements Serializable {
    private static final long serialVersionUID = 5940753431424284676L;
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
