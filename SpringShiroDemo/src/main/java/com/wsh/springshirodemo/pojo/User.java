package com.wsh.springshirodemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huwenshuai
 * @date 2022/6/15 16:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String name;
    private String password;
    private String perms;


}
