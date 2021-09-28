package com.code.show.demo.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author chengzhiqi
 * @date 2021/9/8 10:34 下午
 **/
public interface DemoMapper {

    @Select("select 1234 + 4321")
    String print();
}
