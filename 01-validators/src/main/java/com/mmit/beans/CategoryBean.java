package com.mmit.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mmit.shop.model.entity.Category;
import com.mmit.shop.model.service.CategoryService;

@Named
@RequestScoped
public class CategoryBean {
	
	@Inject
	private CategoryService service;
	private Category category;
	private List<Category> categories;
	
	@PostConstruct
	private void init() {
		categories=service.findAll();
		categories=new ArrayList<Category>();
		category=new Category();
		
	}
	
	public String save() {
		service.save(category);
		return "/views/categories?faces-redirect=true";
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
