package com.yunchen.admin.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "book")
public class Authors implements Serializable {
    private static final long serialVersionUID = 7552410889130690129L;

    @Id
    @Column(name = "book_id")
    @GeneratedValue(generator = "JDBC")
    private Integer BookId;

    /**
     * 作者名字
     */
    @Column(name = "author")
    private String author;

    /**
     * 作品名称
     */
    @Column(name = "title")
    private String title;

    /**
     * 作品副标题，如果没有，请留
     */
    @Column(name = "sub_title")
    private String subTitle;

    /**
     * 作品封面清图⽚的绝对 URL， ⾄少 200 * 250 px 不允许GIF格式
     */
    @Column(name = "thumb_url")
    private String thumbUrl;

    /**
     * 作品简介，不少5字
     */
    @Column(name = "description")
    private String description;

    /**
     * 创作状态，取值：0 (已完结)；1 (连载中)
     */
    @Column(name = "creation_status")
    private Integer creationStatus;

    /**
     * 作品体裁：取值：0 (⼩说) 1 (漫画) 2 (其他)
     */
    @Column(name = "genre")
    private Integer genre;

    /**
     * 篇幅类型，取值：0 (⻓篇) 1 (中篇) 2 (短篇)
     */
    @Column(name = "length_type")
    private Integer lengthType;

    /**
     * 是否收费书籍，取值：0 (免费) 1 (按章节收费) 2 (按整本)
     */
    @Column(name = "sale_status")
    private Integer saleStatus;

    /**
     * 书本定价 int 类型，单位为：分
     */
    @Column(name = "price")
    private Integer price;

    /**
     * 收费章节时必须填 0
     */
    @Column(name = "sale_chapter_id")
    private Integer saleChapterId;

    /**
     * 作品发布时间，只接受 %Y-%m-%d %H:%M:%S 格式，不接受时间戳
     */
    @Column(name = "pub_date")
    private Date pubDate;

    /**
     * 多级分类之间用英文逗号分隔
     */
    @Column(name = "category")
    private String category;

    /**
     * 多个tag之间用英文逗号分隔
     */
    @Column(name = "tag")
    private String tag;

    @Column(name = "origin_url")
    private String originUrl;

    @Column(name = "view_count")
    private Integer viewCount;

    @Column(name = "favorite_count")
    private Integer favoriteCount;
}
