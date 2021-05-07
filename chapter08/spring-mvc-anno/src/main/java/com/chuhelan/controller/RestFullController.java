package com.chuhelan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-06 14:52
 **/

@RestController
@RequestMapping("/api")
public class RestFullController {

    @GetMapping("/say")
    public String say() {
        return "this is a restful style";
    }

    @GetMapping("/say/{name}")
    public ResponseEntity say(@PathVariable(name = "name") String name) {
        String result = "Hello, I am " + name;
        return ResponseEntity.ok(result);
    }
}