package com.anp.ussd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anp.ussd.dao.CompanyDao;
import com.anp.ussd.entity.CompanyEntity;

@RestController
@RequestMapping("/api")
public class CompanyController {

	@Autowired
	CompanyDao dao;

	@PostMapping("/add")
	public CompanyEntity addCompany(@Valid @RequestBody CompanyEntity company) {
		return dao.addCompany(company);
	}

	@PutMapping("/update/{compnayId}")
	public ResponseEntity<CompanyEntity> updateCompany(@PathVariable(value="companyId") long companyId, @Valid @RequestBody CompanyEntity company) {
		CompanyEntity comp = dao.getComapny(companyId);
		if (comp == null) {
			return ResponseEntity.notFound().build();
		}

		comp = new CompanyEntity.Builder()
				.id(company.getId())
				.name(company.getName())
				.phoneNumber(company.getPhoneNumber())
				.address(company.getAddress())
				.complains(company.getCompanyComplains())
				.build();

		CompanyEntity update = dao.updateCompany(comp);
		return ResponseEntity.ok().body(update);
	}

	@GetMapping("/by/{companyId}")
	public ResponseEntity<CompanyEntity> getCompany(@PathVariable(value="companyId") long companyId) {
		CompanyEntity comp = dao.getComapny(companyId);

		if (comp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(comp);
	}

	@GetMapping("/all")
	public List<CompanyEntity> getAllCompanies() {
		return dao.getAllCompanies();
	}

	@DeleteMapping("/delete/{companyId}")
	public ResponseEntity<CompanyEntity> deletCompany(@PathVariable(value="companyId") long companyId) {
		CompanyEntity comp = dao.getComapny(companyId);
		if (comp == null) {
			return ResponseEntity.notFound().build();
		}
		dao.deleteCompany(companyId);
		return ResponseEntity.ok().build();
	}
}
