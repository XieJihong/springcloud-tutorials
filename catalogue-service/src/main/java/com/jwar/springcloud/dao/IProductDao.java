package com.jwar.springcloud.dao;


import com.jwar.springcloud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductDao extends JpaRepository<Product, Long> {
}
