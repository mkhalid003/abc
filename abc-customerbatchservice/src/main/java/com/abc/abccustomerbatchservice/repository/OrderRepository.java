package com.abc.abccustomerbatchservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.abc.abccustomerbatchservice.entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

}
