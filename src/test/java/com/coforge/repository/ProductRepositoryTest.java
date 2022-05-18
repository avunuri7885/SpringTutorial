package com.coforge.repository;

import com.coforge.entity.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Rollback(false)
    @Order(1)
    public void saveTest(){

        Product product = new Product();
        product.setName("pName");
        product.setType("N");
        Product productDB = productRepository.save(product);
        Assertions.assertEquals(1, productDB.getPid());

    }

    @Test
    @Rollback(false)
    @Order(2)
    public void getProductTest(){
        Product productDB = productRepository.findById(1).get();
        Assertions.assertEquals(1, productDB.getPid());

    }

}
