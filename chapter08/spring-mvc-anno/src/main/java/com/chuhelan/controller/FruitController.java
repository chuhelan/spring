package com.chuhelan.controller;

import com.chuhelan.domain.Fruit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-06 14:59
 **/

@RestController
@RequestMapping("/api")
public class FruitController {

    @GetMapping("/fruits/{name}")
    public ResponseEntity<Fruit> getFruit(@PathVariable("name") String name){
        Fruit fruit = Fruit.builder()
                .name(name)
                .price(20.0)
                .producing_area("泰国")
                .build();
        return ResponseEntity.ok(fruit);
    }

    @PostMapping("/fruits")
    public ResponseEntity<String> saveFruit(@RequestBody Fruit fruit){
        return ResponseEntity.ok("保存成功！");
    }

    @PutMapping("/fruits")
    public ResponseEntity<String> updateFruit(@RequestBody Fruit fruit){
        return ResponseEntity.ok("更新成功！");
    }

    @DeleteMapping("/fruits/{name}")
    public ResponseEntity<String> deleteFruit(@PathVariable("name") String name){
        return ResponseEntity.ok("删除成功！");
    }
}