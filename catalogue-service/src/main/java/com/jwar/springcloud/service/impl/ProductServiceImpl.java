package com.jwar.springcloud.service.impl;

import com.google.common.primitives.Longs;
import com.jwar.springcloud.dao.IProductDao;
import com.jwar.springcloud.entity.Product;
import com.jwar.springcloud.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    public ProductServiceImpl(IProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addProduct(Product productVo) {
        productDao.save(productVo);
    }

    @Override
    public List<Product> getProducts() {
        return productDao.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.delete(id);
    }

    @Override
    public List<Product> getProductsByIds(long[] productIds) {
        return productDao.findAll(Longs.asList(productIds));
    }
}
