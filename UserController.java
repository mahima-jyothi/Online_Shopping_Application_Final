package com.cg.osa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.osa.dto.UserDTO;
import com.cg.osa.exception.UserException;
import com.cg.osa.service.IUserServiceImpl;


@RestController
@RequestMapping("/onlineshoppingapplication")
public class UserController {
	@Autowired
	private IUserServiceImpl impl;
	
	/* @author Mahima Jyothi Shala
	 * @return user
	 * @description this method adds the users
	 */
	@PostMapping("/adduser")
	public UserDTO addUser(@Valid @RequestBody UserDTO user) throws UserException
	{
		return impl.addUser(user);
	}
	/* @author Mahima Jyothi Shala
	 * @return user
	 * @description this method deletes the user based on id
	 */
	@DeleteMapping("/deluser/{id}")
	public UserDTO removeUser(@PathVariable("id") int id) throws UserException
	{
		return impl.removeUser(id);
	}
	/* @author Mahima Jyothi Shala
	 * @return the particular user
	 * @description this method gives user details based on id 
	 */
	@GetMapping("/viewuser/{id}")
	public UserDTO viewUser(@PathVariable("id")int id) throws UserException
	{
		return impl.viewUser(id);
	}
	/* @author Mahima Jyothi Shala
	 * @return boolean
	 * @description this method is for signout
	 */
	@GetMapping("/signoutuser")
	public boolean signOut(UserDTO user)
	{
		return impl.signOut(user);
	}
	/* @author Mahima Jyothi Shala
	 * @return List
	 * @description this method gives user details based on id and password 
	 */
	@GetMapping("/login/{id}/{pwd}")
	public UserDTO validateUser(@PathVariable("id") int id,@PathVariable("pwd") String password)throws UserException
	{
		return impl.validateUser(id, password);
	}

}
