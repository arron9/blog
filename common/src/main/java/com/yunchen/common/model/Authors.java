package com.yunchen.common.model;

import javax.persistence.*;

@Table(name = "authors")
public class Authors {
    @Id
    private Integer id;

    private String name;

    private String nick;

    /**
     * 性别  0 男  1 女  默认0
     */
    private Byte sex;

    private String descrition;

    private String connact;

    private String profession;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * @param nick
     */
    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    /**
     * 获取性别  0 男  1 女  默认0
     *
     * @return sex - 性别  0 男  1 女  默认0
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别  0 男  1 女  默认0
     *
     * @param sex 性别  0 男  1 女  默认0
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * @return descrition
     */
    public String getDescrition() {
        return descrition;
    }

    /**
     * @param descrition
     */
    public void setDescrition(String descrition) {
        this.descrition = descrition == null ? null : descrition.trim();
    }

    /**
     * @return connact
     */
    public String getConnact() {
        return connact;
    }

    /**
     * @param connact
     */
    public void setConnact(String connact) {
        this.connact = connact == null ? null : connact.trim();
    }

    /**
     * @return profession
     */
    public String getProfession() {
        return profession;
    }

    /**
     * @param profession
     */
    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }
}