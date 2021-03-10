package com.yunchen.admin.mapper;

import com.yunchen.admin.model.Authors;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface AuthorsMapper extends BaseMapper<Authors> {
}