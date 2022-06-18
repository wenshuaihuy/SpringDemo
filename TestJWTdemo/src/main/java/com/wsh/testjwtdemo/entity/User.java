package com.wsh.testjwtdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author huwenshuai
 * @date 2022/6/13 20:13
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor(staticName = "name")
public class User {

    private String id;
    private String name;
    private String password;

}
