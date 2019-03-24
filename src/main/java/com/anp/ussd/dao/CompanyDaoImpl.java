package com.anp.ussd.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anp.ussd.entity.CompanyEntity;
import com.anp.ussd.repositiry.CompanyRepository;
import com.anp.ussd.utils.Manager;

import javassist.bytecode.stackmap.TypeData.ClassName;

@Service
public class CompanyDaoImpl implements CompanyDao {
	private static final String TAG = ClassName.class.getName();

	@Autowired
	CompanyRepository companyRepo;
	
	@Override
	public CompanyEntity addCompany(CompanyEntity company) {
		if (Manager.LOGGER == true) {
			System.out.println("Company {\n\t" + company + "\n},\n saved");
		}
		return companyRepo.save(company);
	}

	@Override
	public CompanyEntity updateCompany(CompanyEntity company) {
		if (Manager.LOGGER == true) {
			System.out.println("Company {\n\t" + company.getName() + "\n},\n updated");
		}
		return companyRepo.saveAndFlush(company);
	}

	@Override
	public CompanyEntity getComapny(long companyId) {
		// TODO Auto-generated method stub
		if (Manager.LOGGER == true) {
			System.out.println("Company {\n\t" + companyId + "\n}");
		}
		return companyRepo.getOne(companyId);
	}

	@Override
	public List<CompanyEntity> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepo.findAll();
	}

	@Override
	public void deleteCompany(long companyId) {
		// TODO Auto-generated method stub
		companyRepo.deleteById(companyId);
	}

}
