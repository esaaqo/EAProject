package mum.cs544.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.cs544.project.domain.User;
import mum.cs544.project.service.UserService;



@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
UserService userService;
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String createEmployee(@ModelAttribute("user") User user){
		System.out.println("addUser method");
		return "addUser";
	}
	
	@RequestMapping(value="/userList",method=RequestMethod.GET)
	public String getUsers(Model model){
		System.out.println("get users");
		List<User> users=userService.getAll();
		model.addAttribute("userList",users);
		return "userList";
	}
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") Integer id){
		userService.delete(id);
		return "redirect:/admin/userList";
	}
	@RequestMapping(value="/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model){
		System.out.println("The id to update is "+id);
		User user=userService.findById(id);
		System.out.println(user);
		model.addAttribute("user",user);
		return "edit";
	}
	
}
