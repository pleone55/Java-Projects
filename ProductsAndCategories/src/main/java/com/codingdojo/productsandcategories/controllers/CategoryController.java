package com.codingdojo.productsandcategories.controllers;

import java.util.List;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.services.CategoryService;
import com.codingdojo.productsandcategories.services.ProductService;

@Controller
public class CategoryController {
	//dependency injection
	private final CategoryService catService;
	private final ProductService proService;
	
	public CategoryController(CategoryService catService, ProductService proService) {
		this.catService = catService;
		this.proService = proService;
	}
	
	@GetMapping("/categories/new")
	public String categoryIndex(@ModelAttribute("category") Category category) {
		return "/categories/newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "categories/newCategory.jsp";
		}else {
			catService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@PutMapping("/categories/{id}")
	public String updateCategory(@PathVariable("id") Long categoryId, @RequestParam("id") Long productId) {
		Category category = catService.findCategory(categoryId);
		Product product = proService.findProduct(productId);
		
		
		category.getProducts().add(product);
		catService.createCategory(category);
		
		return "redirect:/categories/{id}";
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = catService.findCategory(id);
		List<Product> products = proService.allProducts();
		List<Product> removeProducts = new ArrayList<Product>();
		
		//remove the categories after they have been linked to the product
		for(Product product : products) {
			for(Category cat : product.getCategories()) {
				if(cat.getId().equals(id)) {
					removeProducts.add(product);
				}
			}
		}
		
		products.removeAll(removeProducts);
		
		model.addAttribute("category", category);
		model.addAttribute("products", products);
		return "/categories/show.jsp";
	}
}
