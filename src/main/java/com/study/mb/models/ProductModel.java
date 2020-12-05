package com.study.mb.models;

import org.apache.ibatis.type.Alias;

@Alias("product")
public class ProductModel {
    private final int index;
    private final  String name;
    private final  int price;

    public ProductModel(int index, String name, int price) {
        this.index = index;
        this.name = name;
        this.price = price;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
