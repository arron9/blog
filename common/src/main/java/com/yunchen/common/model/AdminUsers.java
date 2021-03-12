package com.yunchen.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "admin_users")
public class AdminUsers {
    @Id
    private Integer id;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String username;

    /**
     * 账号类型 1：oa账号 2：渠道用户
     */
    private Short type;

    private String password;

    /**
     * 状态 1 启用，2 禁用
     */
    private Boolean status;

    private String email;

    private String position;

    /**
     * 接口授权token
     */
    @Column(name = "api_token")
    private String apiToken;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "token_expire_time")
    private Date tokenExpireTime;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 当前用户拥有GM权限的区服
     */
    @Column(name = "gm_servers")
    private String gmServers;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取真实姓名
     *
     * @return name - 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置真实姓名
     *
     * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取邮箱
     *
     * @return username - 邮箱
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置邮箱
     *
     * @param username 邮箱
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取账号类型 1：oa账号 2：渠道用户
     *
     * @return type - 账号类型 1：oa账号 2：渠道用户
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置账号类型 1：oa账号 2：渠道用户
     *
     * @param type 账号类型 1：oa账号 2：渠道用户
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取状态 1 启用，2 禁用
     *
     * @return status - 状态 1 启用，2 禁用
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置状态 1 启用，2 禁用
     *
     * @param status 状态 1 启用，2 禁用
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * 获取接口授权token
     *
     * @return api_token - 接口授权token
     */
    public String getApiToken() {
        return apiToken;
    }

    /**
     * 设置接口授权token
     *
     * @param apiToken 接口授权token
     */
    public void setApiToken(String apiToken) {
        this.apiToken = apiToken == null ? null : apiToken.trim();
    }

    /**
     * @return created_at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return updated_by
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * @return token_expire_time
     */
    public Date getTokenExpireTime() {
        return tokenExpireTime;
    }

    /**
     * @param tokenExpireTime
     */
    public void setTokenExpireTime(Date tokenExpireTime) {
        this.tokenExpireTime = tokenExpireTime;
    }

    /**
     * @return updated_at
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return last_login_ip
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * @param lastLoginIp
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    /**
     * @return last_login_time
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取当前用户拥有GM权限的区服
     *
     * @return gm_servers - 当前用户拥有GM权限的区服
     */
    public String getGmServers() {
        return gmServers;
    }

    /**
     * 设置当前用户拥有GM权限的区服
     *
     * @param gmServers 当前用户拥有GM权限的区服
     */
    public void setGmServers(String gmServers) {
        this.gmServers = gmServers == null ? null : gmServers.trim();
    }
}