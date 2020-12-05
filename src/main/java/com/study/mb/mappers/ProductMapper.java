package com.study.mb.mappers;

import com.study.mb.models.ProductModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface ProductMapper {
    //dao
    ArrayList<ProductModel> selectProducts(); //있는상품 다

    ProductModel selectProduct(int productIndex);
//
//    private static String na = "com.study.mappers.ProductMapper";
//
//    @Override
//    public void sig(ProductMapper productMapper) throws Exception{
//        .insert()
//    };
    boolean insertProduct(String productName, int productPrice);

    boolean insertProduct_color(String productName, String color);

    boolean deleteProduct(int productIndex);

    boolean updateProduct(int productIndex, String productName, int productPrice);

    boolean insertColorProduct(String productName, String productColor);

}
