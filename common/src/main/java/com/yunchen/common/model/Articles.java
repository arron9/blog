package com.yunchen.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "articles")
public class Articles {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String title;

    private String description;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "pulished_at")
    private Date pulishedAt;

    /**
     * 点击统计
     */
    @Column(name = "view_cnt")
    private Integer viewCnt;

    /**
     * 点赞统计
     */
    @Column(name = "star_cnt")
    private Integer starCnt;

    /**
     * 评论统计
     */
    @Column(name = "comment_cnt")
    private String commentCnt;

    @Column(name = "authors_id")
    private Integer authorsId;

    @Column(name = "category_id")
    private Integer categoryId;

    private String content;

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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    /**
     * @return pulished_at
     */
    public Date getPulishedAt() {
        return pulishedAt;
    }

    /**
     * @param pulishedAt
     */
    public void setPulishedAt(Date pulishedAt) {
        this.pulishedAt = pulishedAt;
    }

    /**
     * 获取点击统计
     *
     * @return view_cnt - 点击统计
     */
    public Integer getViewCnt() {
        return viewCnt;
    }

    /**
     * 设置点击统计
     *
     * @param viewCnt 点击统计
     */
    public void setViewCnt(Integer viewCnt) {
        this.viewCnt = viewCnt;
    }

    /**
     * 获取点赞统计
     *
     * @return star_cnt - 点赞统计
     */
    public Integer getStarCnt() {
        return starCnt;
    }

    /**
     * 设置点赞统计
     *
     * @param starCnt 点赞统计
     */
    public void setStarCnt(Integer starCnt) {
        this.starCnt = starCnt;
    }

    /**
     * 获取评论统计
     *
     * @return comment_cnt - 评论统计
     */
    public String getCommentCnt() {
        return commentCnt;
    }

    /**
     * 设置评论统计
     *
     * @param commentCnt 评论统计
     */
    public void setCommentCnt(String commentCnt) {
        this.commentCnt = commentCnt == null ? null : commentCnt.trim();
    }

    /**
     * @return authors_id
     */
    public Integer getAuthorsId() {
        return authorsId;
    }

    /**
     * @param authorsId
     */
    public void setAuthorsId(Integer authorsId) {
        this.authorsId = authorsId;
    }

    /**
     * @return category_id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}