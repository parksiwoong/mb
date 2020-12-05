package com.study.mb.services;

import com.study.mb.mappers.ProductMapper;
import com.study.mb.models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
  public   ArrayList<ProductModel> getProducts(){
        return this.productMapper.selectProducts();
  } //있는상품 다

    public  ProductModel getProduct(int productIndex){
        return this.productMapper.selectProduct(productIndex);
    }

    public boolean addProduct(String productName, int productPrice){
        return this.productMapper.insertProduct(productName, productPrice);
    }
    public boolean addProduct_color(String productName, String color){
        return this.productMapper.insertProduct_color(productName, color);
    }

    public boolean deleteProduct(int productIndex){
        return this.productMapper.deleteProduct(productIndex);
    }

    public boolean modifyProduct(int productIndex, String productName, int productPrice){
        return this.productMapper.updateProduct(productIndex, productName, productPrice);
    }

}
