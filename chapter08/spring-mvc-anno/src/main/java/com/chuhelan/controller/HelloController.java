package com.chuhelan.controller;

import com.chuhelan.domain.Fruit;
import com.chuhelan.service.FruitService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ConcurrentModel;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-27 11:07
 **/

@Controller
@RequestMapping("/helloController")
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","springMVC");
        return "hello";
    }

//    实现简单数据类型的绑定

    @RequestMapping("/getId/{id}")
    public String getId(@PathVariable(name="id") Integer id, Model model){
        Integer result = id;
        model.addAttribute("msg","结果为:id="+result);
        return "hello";
    }

//    实现类数据的绑定

    @RequestMapping("/fruit")
    public String getFruit(Fruit fruit, Model model){
        model.addAttribute("msg","水果信息："+fruit.toString());
        return "hello";
    }

    @Resource
    FruitService fruitService;
    @RequestMapping("/allFruit")
    public String getAllFruit(Model model){
        List<Fruit> fruitList = fruitService.getAllFruit();
        model.addAttribute("fruitList",fruitList);
        return "fruit";
    }

}