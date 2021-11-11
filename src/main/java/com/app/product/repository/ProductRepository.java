package com.app.product.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Serializable> {

	public List<Product> findByActiveSwitch(String activeSwitch);

}
