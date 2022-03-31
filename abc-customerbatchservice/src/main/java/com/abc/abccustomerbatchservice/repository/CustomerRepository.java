package com.abc.abccustomerbatchservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abc.abccustomerbatchservice.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long>{

}
