package com.cg.osa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.osa.dto.CategoryDTO;
import com.cg.osa.exception.CategoryException;
import com.cg.osa.service.ICategoryServiceImpl;


@RestController
@RequestMapping("/onlineshoppingapplication")
public class CategoryController {
	@Autowired
	ICategoryServiceImpl categoryservice;
	
	/* @author Gayathri.M
	 * @return CategoryDTO
	 * @description this method adds the category
	 
	 */
	@PostMapping("/addcategory")
	public CategoryDTO addCategory(@Valid @RequestBody CategoryDTO category) {
		return categoryservice.addCategory(category);
	}
	
	/* @author Gayathri.M
	 * @return CategoryDTO
	 * @description this method updates the category details of the existing category id
	 
	 */
	@PutMapping("/updatecategory")
	public CategoryDTO updateCategory(@Valid @RequestBody CategoryDTO category) throws CategoryException{
		
		return categoryservice.updateCategory(category);
	}

	/* @author Gayathri.M
	 * @return CategoryDTO
	 * @description this method deletes the category
	 
	 */
	@DeleteMapping("/deletecategory/{id}")
	public CategoryDTO removeCategory(@PathVariable("id") String id) throws CategoryException{
		return categoryservice.removeCategory(id);
	}
	
	
	/* @author Gayathri.M
	 * @return list of CategoryDTO
	 * @description this method gives all the categories
	 
	 */
	@GetMapping("/getcategory")
	public List<CategoryDTO> viewAllCategories() {
		return categoryservice.viewAllCategories();
	}

}
