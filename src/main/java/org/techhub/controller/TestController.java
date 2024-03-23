package org.techhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.techhub.Service.RegisterServiceImple;
import org.techhub.model.Register;

@RestController
public class TestController {

	@Autowired
	RegisterServiceImple RegServ;
	@PostMapping(value="/save")
	public String addData(@RequestBody Register reg)
	{
		boolean b=RegServ.addRegister(reg);
		if(b)
		{
			return "Added successfully";
		}
		else
		{
			return "Not Added successfully";
		}
	}
	@GetMapping(value="/view")
	public List<Register>GetData()
	{
		List<Register>list=RegServ.GetDetails();
		return list;
	}
	@GetMapping(value="/search/{id}")
	public String searchById(@PathVariable("id")Integer id)
	{
		Register r=RegServ.searchById(id);
		if(r!=null)
		{
			return "found "+r.toString();
		}
		else
		{
			return "not found ";
		}
	}
	@DeleteMapping(value="/delete/{id}")
	public String DeleteData(@PathVariable("id")Integer id)
	{
		boolean b=RegServ.DeletebyID(id);
		if(b)
		{
		   return "Deleted successfully";
		}
		else
		{
			return "Not Delete Successfully";
		}
	}
	@PutMapping(value="/update/{name}/{sal}/{id}")
	public String UpdateData(@PathVariable("name")String name,@PathVariable("sal")Integer sal,
			@PathVariable("id")Integer id)
	{
		int re=RegServ.UpdateByAll(name, sal, id);
		if(re>0)
		{
			return "Updated";
		}
		else
		{
			return "not Updated";
		}
	}
	@GetMapping(value="/login/{name}/{sal}")
	public String login(@PathVariable("name") String name,@PathVariable("sal") int sal)
	{
		System.out.println("Inside thhe controller");
		
		
		Register r=RegServ.isLogin(name,sal);
		if(r!=null)
		{
			
			return "login successs"; 
		}
		else
		{
		     return "login failed";
		}
		
	}
}
