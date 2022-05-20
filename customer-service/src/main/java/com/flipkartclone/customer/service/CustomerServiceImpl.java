package com.flipkartclone.customer.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkartclone.customer.exception.CustomerAlreadyExistException;
import com.flipkartclone.customer.model.Customer;
import com.flipkartclone.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	private CustomerRepository ctmrepo;
	
//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		Customer foundCustomer = ctmrepo.findByUsername(userName);
//		if(foundCustomer == null)
//			return null;
//		String email1 = foundCustomer.getEmail();
//		String password  = foundCustomer.getPassword();
//		
//		return new User(email1, password, new ArrayList<>());
//	}

	@Autowired
	public CustomerServiceImpl(CustomerRepository ctmrepo) {
		super();
		this.ctmrepo = ctmrepo;
	}

	@Override
	public Customer addNewCustomer(Customer ctm) throws CustomerAlreadyExistException {
		
		if(ctmrepo.existsById(ctm.getCustomerId())) {
			throw new CustomerAlreadyExistException();
		}

		Customer saveCutomer = ctmrepo.save(ctm);
		return saveCutomer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return (List<Customer>) ctmrepo.findAll();
	}

	@Override
	public Optional<Customer> getByCutomerId(int ctmId) {
		// TODO Auto-generated method stub
		return (Optional<Customer>) ctmrepo.findById(ctmId);
	}

	@Override
	public void deleteCustomerByCustomerId(int ctmId) {
		// TODO Auto-generated method stub
		ctmrepo.deleteById(ctmId);
	}

}
