package com.study.mb.models;

import org.apache.ibatis.type.Alias;

@Alias("product_color")
public class Product_ColorModel {
    private final int index;
    private final  String name;
    private final  String color;

    public Product_ColorModel(int index, String name, String color) {
        this.index = index;
        this.name = name;
        this.color = color;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
