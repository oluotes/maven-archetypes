package com.rhc.services;

import com.rhc.aggregates.Customer;
import com.rhc.entities.Address;

public interface CustomerService {

	public Long startCustomerOnboardProcess( Customer customer );
	
	public int getNumberOfCustomerOnboardProcessesInProgress();
	
	public boolean isProcessComplete( Long processId );
	
	public void addCustomerAddress(Address address, Long processId);
}
