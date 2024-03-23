package org.techhub.Service;

import java.util.List;

import org.techhub.model.Register;

public interface RegisterService {

	public boolean addRegister(Register reg);
	public List<Register> GetDetails();
	public Register searchById(Integer id);
	public boolean DeletebyID(Integer id);
	public int UpdateByAll(String name,Integer sal,Integer id);
}
