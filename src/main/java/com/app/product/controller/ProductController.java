package com.app.product.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.constant.AppConstants;
import com.app.product.entity.Product;
import com.app.product.props.AppProperties;
import com.app.product.service.ProductService;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService service;

	@Autowired
	private AppProperties appProperties;

	@GetMapping("/loadProduct")
	public String loadProductForm(Model model) {

		logger.debug("loadProductForm() method exection started*********************");

		model.addAttribute("product", new Product());

		logger.debug("loadProductForm() method exection ended*********************");

		logger.info("Form is Loded ***********************************************");

		return AppConstants.INDEX_VIEW;
	}

	@PostMapping("/saveProduct")
	public String handleProduct(@ModelAttribute("product") Product product, Model model) {

		Map<String, String> messages = appProperties.getMessages();

		logger.debug("handleProduct() method execution is started ****************************");

		String msgText = null;

		if (product.getProductId() == null) {
			msgText = messages.get(AppConstants.SAVE_SUCCESS);
		} else {
			msgText = messages.get(AppConstants.UPDATE_SUCCESS);
		}

		boolean saveProduct = service.saveProduct(product);

		if (saveProduct) {
			logger.info("Product is Save Successfully **********************************");
			model.addAttribute(AppConstants.SUCCESS_MSG, msgText);
		} else {
			logger.info("Product is not Save Successfully **********************************");
			model.addAttribute(AppConstants.FAIL_MSG, messages.get(AppConstants.SAVE_FAIL));
		}
		logger.debug("handleProduct() method execution is ended ****************************");

		logger.info("Product is Store Successfully ********************************* " + product);

		return AppConstants.INDEX_VIEW;
	}

	@GetMapping("/viewAllProducts")
	public String diaplayAllProducts(Model model) {

		logger.debug("diaplayAllProducts() method execution is started **************************");

		List<Product> products = service.getAllProducts();

		if (products.isEmpty()) {
			logger.info("Product List is Empty************************** " + products);
		}

		model.addAttribute("product", products);

		logger.debug("diaplayAllProducts() method execution is ended **************************");

		logger.info("All Products Display successfully ******************************************");

		return "viewAllProducts";
	}

	@GetMapping("/updateProduct")
	public String updateProduct(@RequestParam("pid") Integer pid, Model model) {

		logger.debug("updateProductmethod() execution is started *******************************");

		Product product = service.getProductById(pid);
		model.addAttribute("product", product);

		logger.debug("updateProductmethod() execution is ended *******************************");

		logger.info("Product is Edited successfully ******************************************");

		return AppConstants.INDEX_VIEW;
	}

	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("pid") Integer pid) {

		logger.debug("deleteProduct() method execution is started ********************************");

		service.deleteProductById(pid);

		logger.debug("deleteProduct() method execution is ended ********************************");

		logger.info("Product is Deleted successfully ********************************************");

		return "redirect:/viewAllProducts";
	}
}
