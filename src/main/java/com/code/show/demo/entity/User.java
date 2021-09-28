package com.code.show.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chengzhiqi
 * @date 2021/9/2 5:57 下午
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    private String name;
}
