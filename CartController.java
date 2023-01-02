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

import com.cg.osa.dto.CartDTO;
import com.cg.osa.dto.ProductDTO;
import com.cg.osa.exception.CartException;
import com.cg.osa.repository.ICategoryRepository;
import com.cg.osa.service.ICartServiceImpl;
import com.cg.osa.service.ICategoryServiceImpl;



@RestController
@RequestMapping("/onlineshoppingapplication")
public class CartController {
	@Autowired
	ICartServiceImpl cartService;
	
	/* @author Tanaaz Anjum Tamboli 
	 * @return cart
	 * @description this method updates the product quantity in the cart
	 */
	@PutMapping("/updateproductqnt/{cid}/{pid}/{qnt}")
	public CartDTO updateproductsquantity(@PathVariable ("cid") int cid, @PathVariable ("pid") int pid,@PathVariable ("qnt")int qnt) throws CartException {
	
		return cartService.updatequantity(cid, pid, qnt);
	}
	
	/* @author Tanaaz Anjum Tamboli 
	 * @return cart
	 * @description this method adds the product in the cart
	 */
    @PostMapping("addproducttocart/{cid}")
	public CartDTO addProductToCart(@PathVariable ("cid") int cid,@Valid @RequestBody ProductDTO p) throws CartException {
		return cartService.addProductToCart(cid, p);
		
	}
    
    /* @author Tanaaz Anjum Tamboli 
	 * @return cart
	 * @description this method deletes the product in the cart
	 */
	@PutMapping("/deleteprod/{cid}/{pid}")
	public CartDTO removeProductFromCart(  @PathVariable("cid") int cid,@PathVariable ("pid") int pid)throws CartException{
		return cartService.removeProductFromCart( cid,pid);
	}
	
	/* @author Tanaaz Anjum Tamboli 
	 * @return cart
	 * @description this method gives the cart details and product details in the cart
	 */
	
	@GetMapping("/allproductsfromcart/{cid}")
	public CartDTO viewAllProducts(@PathVariable ("cid") int cid) throws CartException {
		return cartService.viewAllProducts(cid);
	}
	
	/* @author Tanaaz Anjum Tamboli 
	 * @return cart
	 * @description this remove all the products and returns an empty cart
	 */
     @DeleteMapping("/removeallproducts/{cid}")
     public CartDTO removeAllProducts(@PathVariable ("cid") int cid) throws CartException {
	     return cartService.removeAllProducts(cid);
}

}