package com.code.show.demo.service;

import com.code.show.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengzhiqi
 * @date 2021/9/8 11:06 下午
 **/

@Service
public class DemoService {

    @Autowired(required = false)
    private DemoMapper demoMapper;

    public String print() {
        return demoMapper.print();
    }
}
