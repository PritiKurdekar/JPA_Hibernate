package com.cg.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.jpademo.entities.Customer;
import com.cg.jpademo.entities.Department;
import com.cg.jpademo.entities.Employee;

public class JpaExperiment3 {
	 private EntityManager entityManager;

	    public static void main(String args[]) {
	        JpaExperiment3 experiment=new JpaExperiment3();
	        experiment.start();
	    }
	    public void start() {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("emp-ms");
	        entityManager = emf.createEntityManager();
	        Customer priti=new Customer(100,"Priti",22);
	        Customer tom=new Customer(200,"Tom",25);        
	        priti=add(priti);
	        tom=add(tom);
	        System.out.println("added customer successfully...");
	        
	        tom.setAge(27);
	        update(tom);
	        System.out.println("updated successfully...");
	        
	       // Customer fetched = findCustomerById(tom.getId());
	        //display(fetched);
	        emf.close();
	        
	    }
	    public Customer add(Customer customer){
	    	EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        Customer saved=entityManager.merge(customer);
	        transaction.commit();
	        return saved;
	    }

	    public Customer update(Customer customer) {
	    	EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        Customer saved=entityManager.merge(customer);
	        transaction.commit();
	        return saved;
	    	
//	        EntityTransaction transaction = entityManager.getTransaction();
//	        transaction.begin();
//	        customer=entityManager.merge(customer);
//	        transaction.commit();
//	        return customer;
	    }

	    public Customer findCustomerById(int id) {
	        Customer fetched = entityManager.find(Customer.class, id);
	        return fetched;
	    }
	    void display(Customer customer) {
	        System.out.println("fetched object details=" + customer.getId() + " -" + customer.getName() + "-" + customer.getAge());

	    }

	    
}
