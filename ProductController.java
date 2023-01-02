package com.cg.osa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.osa.dto.ProductDTO;
import com.cg.osa.exception.ProductException;
import com.cg.osa.service.IProductService;
import com.cg.osa.service.IProductServiceImpl;


@RestController
@RequestMapping("/onlineshoppingapplication")
public class ProductController {

	@Autowired
	private IProductServiceImpl service;
	/* @author Gayathri.M
	 * @return list of products
	 * @description this method gives all the products
	 
	 */
	@GetMapping("/allproducts")
	public List<ProductDTO> viewAllProducts(){
	return service.viewAllProducts();
	}
	/* @author Gayathri.M
	 * @return product
	 * @description this method adds the product 
	 */
	 
	@PostMapping("/addproduct")
	public ProductDTO addProduct(@Valid @RequestBody ProductDTO product) {
		return service.addProduct(product);
	}
	@PutMapping("/updateproduct")
	public ProductDTO updateProduct(@Valid @RequestBody ProductDTO product) throws ProductException {
		return service.updateProduct(product);
	}
	/* @author Gayathri.M
	 * @return product
	 * @description this method gives product details of given id
	 
	 */
	@GetMapping("/productbyid/{id}")
	public ProductDTO viewProductbyid(@PathVariable int id)throws ProductException{
		return service.viewProductbyid(id);
	}
	/* @author Gayathri.M
	 * @return list of products products
	 * @description this method gives products based on category 
	 
//	 */
	@GetMapping("/productbycname/{cname}")
	public List<ProductDTO> viewProductByCategoryName(@PathVariable ("cname") String cname) throws ProductException{
		List<ProductDTO> list=service.viewProductsByCatname(cname);
		return list;
	}
	/* @author Gayathri.M
	 * @return deleted product
	 * @description removes product  by id if id doesn't exists it throws exception
	 
	 */
	@DeleteMapping("/deletebyid/{id}")
	public ProductDTO removeProduct(@PathVariable int id)throws ProductException{
		return service.removeProduct(id);
	}
	

}
