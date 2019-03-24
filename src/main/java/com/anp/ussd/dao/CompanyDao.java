package com.anp.ussd.dao;

import java.util.List;

import com.anp.ussd.entity.CompanyEntity;

public interface CompanyDao {
	CompanyEntity addCompany(CompanyEntity company);
	
	CompanyEntity updateCompany(CompanyEntity company);
	
	CompanyEntity getComapny(long companyId);
	
	List<CompanyEntity> getAllCompanies();
	
	void deleteCompany(long companyId);
}
