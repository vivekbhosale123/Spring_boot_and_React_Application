package org.techhub.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.Reporitory.RegisterRepository;
import org.techhub.model.Register;

@Service("RegServ")
public class RegisterServiceImple implements RegisterService{

	@Autowired
	RegisterRepository RegRepo;

	public boolean addRegister(Register reg) {
	 
		Register r=RegRepo.save(reg);
		if(r!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public List<Register> GetDetails() {
		List<Register>list=RegRepo.findAll();
		return list;
	}
	@Override
	public Register searchById(Integer id) {
		Optional<Register>o=RegRepo.findById(id);
		if(o.isPresent())
		{
			return o.get();
		}
		else
		{
			return null;
		}	
	}
	@Override
	public boolean DeletebyID(Integer id) {
		Optional<Register>r=RegRepo.findById(id);
		if(r.isPresent())
		{
			RegRepo.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public int UpdateByAll(String name,Integer sal, Integer id) {
		int result=RegRepo.updateData(name, sal, id);
		return result;
	}

	public Register isLogin(String name, int sal) {
		
		Register r=RegRepo.findByNameAndSal(name,sal);
		return r;
	}
}
