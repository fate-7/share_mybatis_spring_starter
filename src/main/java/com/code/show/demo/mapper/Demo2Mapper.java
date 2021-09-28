package com.code.show.demo.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author chengzhiqi
 * @date 2021/9/14 10:33 上午
 **/
public interface Demo2Mapper {

    @Select("select 'demo2'")
    String print();
}
