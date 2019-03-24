package com.anp.ussd.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anp.ussd.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

}
