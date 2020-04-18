package br.com.alura.gerenciador2.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataBase {
	private static List<Company> companies = new ArrayList<>();
	private static List<User> userList = new ArrayList<>();
	private static Integer seqKey = 1;
	
	static {
		Company company = new Company();
		company.setNome("Alura");
		company.setId(seqKey++);
		Company company2 = new Company();
		company2.setNome("Caelum");
		company2.setId(seqKey++);
		DataBase.companies.add(company);
		DataBase.companies.add(company2);
		
//		User u1 = new User("Me", "123456");
//		User u2 = new User("Nico", "123456");
		User u1 = new User();
		u1.setLogin("Me");
		u1.setPassword("123456");
		User u2 = new User();
		u2.setLogin("Nico");
		u2.setPassword("123456");
		DataBase.userList.add(u1);
		DataBase.userList.add(u2);
		
		
	}
	
	public void adicionar(Company company) {
		company.setId(DataBase.seqKey++);
		companies.add(company);
		
	}
	
	public void remover(Integer id) {
		Iterator<Company> it = companies.iterator();
		while(it.hasNext()) {
			Company cp = it.next();
			if(cp.getId().equals(id)) {
				it.remove();
			}
		}
	}
	

	public List<Company> getCompany() {
		return DataBase.companies;
	}
	
	public Company getCompanyById(Integer id) {
		Iterator<Company> it = companies.iterator();
		while(it.hasNext()) {
			Company cp = it.next();
			if(cp.getId()==id) {
				return cp;
			}
		}
		return null;
	}
	
	public User userExists(String login, String password) {
		for(User u : userList) {
			if(u.equals(login, password)) {
				return u;
			}
		}
		return null;
	}

}
