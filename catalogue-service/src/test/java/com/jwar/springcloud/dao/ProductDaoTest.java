package com.jwar.springcloud.dao;

import com.jwar.springcloud.CatalogueServiceApplication;
import com.jwar.springcloud.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CatalogueServiceApplication.class)
@WebAppConfiguration
@ActiveProfiles(profiles = "dev")
public class ProductDaoTest {

    @Autowired
    IProductDao productDao;

    @Test
    public void test2GetProductsByIds() {
        List<Long> productIds = new ArrayList<>();
        productIds.add(1L);
        productIds.add(2L);
        List<Product> productDtos = productDao.findAll(productIds);
        Assert.assertTrue(productDtos.size() == 2);
    }

    @Test
    public void test1FindAll() {
        List<Product> productDtos = productDao.findAll();
        Assert.assertTrue(productDtos.size() == 4);

    }

    @Test
    public void test3Delete() {
        productDao.delete(1L);
        List<Product> productDtos = productDao.findAll();
        Assert.assertTrue(productDtos.size() == 3);
    }

    @Test
    public void test4Save() {
        Product productDto = new Product();
        productDto.setId(5L);
        productDto.setCategory("A");
        productDto.setName("SWIFT");
        productDto.setCost(new BigDecimal(100.0));
        productDao.save(productDto);
        List<Product> productDtos = productDao.findAll();
        Assert.assertTrue(productDtos.size() == 4);

    }
}
