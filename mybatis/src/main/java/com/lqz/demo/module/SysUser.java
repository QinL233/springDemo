package com.lqz.demo.module;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable {
    private Integer id;

    /**
     * 用户名
     *
     * @mbggenerated
     */
    private String username;

    /**
     * 密码/加密
     *
     * @mbggenerated
     */
    private String password;

    /**
     * 昵称
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     * 手机
     *
     * @mbggenerated
     */
    private String moblie;

    /**
     * 邮箱
     *
     * @mbggenerated
     */
    private String email;

    /**
     * 头像
     *
     * @mbggenerated
     */
    private String avatar;

    /**
     * 创建用户
     *
     * @mbggenerated
     */
    private Integer createUser;

    /**
     * 更新用户
     *
     * @mbggenerated
     */
    private Integer updateUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 有效时间
     *
     * @mbggenerated
     */
    private Date validTime;

    /**
     * 有效标志(y/n)
     *
     * @mbggenerated
     */
    private String validFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", moblie=").append(moblie);
        sb.append(", email=").append(email);
        sb.append(", avatar=").append(avatar);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", validTime=").append(validTime);
        sb.append(", validFlag=").append(validFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}