package com.yunchen.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunchen.common.beans.PageQuery;
import com.yunchen.common.utils.GenericUtils;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.orderbyhelper.OrderByHelper;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @param <T>  model
 * @param <PK> key
 */
public interface BaseService<T, PK> {
    BaseMapper<T> getBaseMapper();

    default int deleteByPrimaryKey(PK key) {
        return getBaseMapper().deleteByPrimaryKey(key);
    }

    default int insert(T record) {
        return getBaseMapper().insert(record);
    }

    default int insertSelective(T record) {
        return getBaseMapper().insertSelective(record);
    }

    default T selectByPrimaryKey(PK key) {
        return getBaseMapper().selectByPrimaryKey(key);
    }

    default int updateByPrimaryKeySelective(T record) {
        return getBaseMapper().updateByPrimaryKeySelective(record);
    }

    default int updateByPrimaryKey(T record) {
        return getBaseMapper().updateByPrimaryKey(record);
    }

    default int delete(T record) {
        return getBaseMapper().delete(record);
    }

    default boolean existsWithPrimaryKey(PK key) {
        return getBaseMapper().existsWithPrimaryKey(key);
    }

    default int selectCount(T record) {
        return getBaseMapper().selectCount(record);
    }

    default T selectOne(T record) {
        return getBaseMapper().selectOne(record);
    }

    default List<T> selectAll() {
        return getBaseMapper().selectAll();
    }

    default List<T> selectAll(String orderBy) {
        OrderByHelper.orderBy(orderBy);

        return selectAll();
    }

    default PageInfo<T> selectAll(PageQuery pageQuery, String orderBy) {
        PageHelper.startPage(pageQuery.getPage(), pageQuery.getPageSize(), pageQuery.isCountable());

        return new PageInfo<>(selectAll(orderBy));
    }

    default PageInfo<T> selectAll(PageQuery pageQuery) {
        return selectAll(pageQuery, null);
    }

    default List<T> select(T record) {
        return getBaseMapper().select(record);
    }

    default List<T> select(T record, String orderBy) {
        OrderByHelper.orderBy(orderBy);

        return select(record);
    }

    default PageInfo<T> select(T record, PageQuery pageQuery, String orderBy) {
        PageHelper.startPage(pageQuery.getPage(), pageQuery.getPageSize(), pageQuery.isCountable());

        return new PageInfo<>(select(record, orderBy));
    }

    default PageInfo<T> select(T record, PageQuery pageQuery) {
        return select(record, pageQuery, null);
    }

    default T keyToRecord(PK key) {
        Class<T> klass = GenericUtils.getEntityClass(getClass(), BaseService.class);
        if (null == klass) {
            throw new RuntimeException("can't locate entity class");
        }

        Field idField = null;
        for (Field field : klass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                idField = field;
                break;
            }
        }

        if (null == idField) {
            throw new RuntimeException("can't locate key field");
        }

        try {
            T instance = klass.newInstance();
            idField.setAccessible(true);
            idField.set(instance, key);

            return instance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
