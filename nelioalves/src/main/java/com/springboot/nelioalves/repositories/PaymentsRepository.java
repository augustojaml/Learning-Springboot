package com.springboot.nelioalves.repositories;

import com.springboot.nelioalves.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepository extends JpaRepository<PaymentEntity, Integer> {

}
