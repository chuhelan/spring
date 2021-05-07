package com.chuhelan.service.impl;

import com.chuhelan.domain.Fruit;
import com.chuhelan.service.FruitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-06 14:24
 **/

@Service
public class FruitServiceImpl implements FruitService {
    @Override
    public List<Fruit> getAllFruit() {
        List<Fruit> fruitList = new ArrayList<>();
        Fruit apple = Fruit.builder()
                .name("苹果")
                .price(8.8)
                .producing_area("山东烟台")
                .build();
        Fruit pear = Fruit.builder()
                .name("梨子")
                .price(4.5)
                .producing_area("汤山")
                .build();
        Fruit banana = Fruit.builder()
                .name("香蕉")
                .price(3.5)
                .producing_area("海南")
                .build();
        fruitList.add(apple);
        fruitList.add(pear);
        fruitList.add(banana);

        return fruitList;
    }
}