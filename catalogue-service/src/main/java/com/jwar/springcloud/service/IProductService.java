package com.jwar.springcloud.service;


import com.jwar.springcloud.entity.Product;

import java.util.List;


public interface IProductService {

    void addProduct(Product productVo);

    List<Product> getProducts();

    void deleteProduct(Long id);

    List<Product> getProductsByIds(long[] productIds);
}
