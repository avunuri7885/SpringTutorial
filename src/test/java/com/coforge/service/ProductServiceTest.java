package com.coforge.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    @Test
    public void getProductsTest(){
    ProductService productService  = new ProductServiceImpl();
        Assertions.assertEquals(1, productService.getProducts().size());
    }
}
