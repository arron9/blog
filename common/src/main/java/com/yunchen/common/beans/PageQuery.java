package com.yunchen.common.beans;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class PageQuery {
    public static final Integer DEFAULT_PAGE_SIZE = 20;
    public static final Integer MAX_PAGE_SIZE = 100;

    private Integer page;
    private Integer pageSize;

    @Setter(AccessLevel.NONE)
    private boolean countable;

    public PageQuery() {
        this(1, DEFAULT_PAGE_SIZE);
    }

    public PageQuery(Integer page) {
        this(page, DEFAULT_PAGE_SIZE);
    }

    public PageQuery(Integer page, Integer pageSize) {
        this(page, pageSize, true);
    }

    public PageQuery(Integer page, Integer pageSize, boolean countable) {
        if (page == null || page < 1) {
            page = 1;
        }

        if (null == pageSize || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }

        this.page = page;
        this.pageSize = pageSize;
        this.countable = countable;
    }
}
