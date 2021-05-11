package com.redhat.store.customer.repository;

import com.redhat.store.customer.repository.entity.Customer;
import com.redhat.store.customer.repository.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
        Customer findByNumberID(String numberID);
        List<Customer> findByLastName(String lastName);
        List<Customer> findByRegion(Region region);
}
