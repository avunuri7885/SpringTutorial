package com.coforge.service;

import com.coforge.entity.Product;
import com.coforge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {
    List<Product> prodList = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getProducts() {

        Product prod = new Product();
        prod.setName("prod1");
        prod.setPid(1);
        prod.setType("S");
        prodList.add(prod);
        prod = new Product();
        prod.setName("prod2");
        prod.setPid(2);
        prod.setType("N");
        prodList.add(prod);

        return prodList.stream().filter(prod1 -> !"S".equalsIgnoreCase(prod1.getType())).collect(Collectors.toList());
       /* List<Product> products=new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products.stream().filter(product -> !"S".equalsIgnoreCase(product.getType()))
                .sorted(Comparator.comparing(Product::getName))
                .sorted(Comparator.comparing(Product::getPid))
                .collect(Collectors.toList());*/
    }
}
