package com.rhc.customer;

import java.io.File;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.KieServices;

import com.rhc.aggregates.Customer;
import com.rhc.entities.Address;
import com.rhc.services.AbstractBusinessServicesTest;

public class CustomerServiceTest extends AbstractBusinessServicesTest{
	
	@BeforeClass
	public static void init(){
		// ensure the latest version of the KieJar is on the classpath
		KieServices.Factory.get().newKieBuilder( new File(getKieJarPath()) ).buildAll();
	}
	
	@Test
	public void shouldSuccessfullyStartAndCompleteACustomerOnboardProcess(){
		// given
		Customer customer = new Customer("Leia", "Organa");
	
		// when 
		Long processId = customerService.startCustomerOnboardProcess(customer);
		boolean processComplete = customerService.isProcessComplete(processId);
		if (!processComplete) {
			Address address = new Address();
			address.setStreet1("Apt 300");
			address.setStreet2("6716 Hunterview Drive NW");
			address.setCity("Calgary");
			address.setState("Alberta");
			address.setPostalCode("T2K 5C8");
			address.setCountry("Canada");
			customerService.addCustomerAddress(address, processId);
			
		}
		
		// then
		Assert.assertEquals( new Long(1), processId);
		Assert.assertTrue( customerService.isProcessComplete(processId));
	}
	
	
	public static String getKieJarPath(){
		String dir = System.getProperty("user.dir");
		return dir.substring(0, dir.lastIndexOf("/")) + "/bpmsuite-monolith-knowledge";
	}
}
