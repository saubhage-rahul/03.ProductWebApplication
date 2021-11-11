package com.app.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.product.entity.Product;
import com.app.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public boolean saveProduct(Product product) {
		product.setActiveSwitch("Y");
		Product saveProduct = repository.save(product);
		return saveProduct.getProductId() != null;
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findByActiveSwitch("Y");
	}

	@Override
	public Product getProductById(Integer productId) {

		Optional<Product> findById = repository.findById(productId);

		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteProductById(Integer productId) {
		Product product = repository.findById(productId).get();
		product.setActiveSwitch("N");
		repository.save(product);

		// repository.deleteById(productId);

		return true;
	}

}
