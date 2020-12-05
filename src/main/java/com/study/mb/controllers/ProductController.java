package com.study.mb.controllers;

import com.study.mb.models.ProductModel;
import com.study.mb.services.ProductService;
import com.study.mb.utilities.Converter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/product", method = RequestMethod.GET)
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/get-products",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String getProducts(HttpServletRequest request, HttpServletResponse response) {
        JSONArray jsonResponse = new JSONArray();
        ArrayList<ProductModel> products = this.productService.getProducts();
        for (ProductModel product : products) {
            JSONObject jsonProduct = new JSONObject();
            jsonProduct.put("index", product.getIndex());
            jsonProduct.put("name", product.getName());
            jsonProduct.put("price", product.getPrice());
            jsonResponse.put(jsonProduct);
        }
        return jsonResponse.toString(4);
    }

    @RequestMapping(
            value = "/add-product",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String addProduct(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(name = "name", defaultValue = "") String name,
                             @RequestParam(name = "price", defaultValue = "-1") String priceString) {
        JSONObject jsonResponse = new JSONObject();
        int price = Converter.StringToInt(priceString, -1);
        if (price < 0) {
            jsonResponse.put("result", "price_below_zero");
        } else {
            if (this.productService.addProduct(name, price)) {
                jsonResponse.put("result", "success");
            } else {
                jsonResponse.put("result", "failure");
            }
        }
        return  jsonResponse.toString(4);
    }

    @RequestMapping(
            value = "/add-product",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String addProduct_color(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(name = "name", defaultValue = "") String name,
                             @RequestParam(name = "color", defaultValue = "") String color) {
        JSONObject jsonResponse = new JSONObject();
        if (jsonResponse != null) {
            this.productService.addProduct_color(name,color);
            jsonResponse.put("result", "success");
        } else {
                jsonResponse.put("result", "failure");
            }
        return  jsonResponse.toString(4);
    }
}
