package com.opq.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by opq.chen on 2017/3/8.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public Integer index(){
        return new Integer(100);
    }
}
