package com.yunchen.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "admin_users")
public class AdminUsers {
    @Id
    private Integer id;

    private String useranme;

    private String password;

    private String token;

    @Column(name = "token_expire")
    private Date tokenExpire;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

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
     * @return useranme
     */
    public String getUseranme() {
        return useranme;
    }

    /**
     * @param useranme
     */
    public void setUseranme(String useranme) {
        this.useranme = useranme == null ? null : useranme.trim();
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
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * @return token_expire
     */
    public Date getTokenExpire() {
        return tokenExpire;
    }

    /**
     * @param tokenExpire
     */
    public void setTokenExpire(Date tokenExpire) {
        this.tokenExpire = tokenExpire;
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
}