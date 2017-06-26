package company.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import company.bean.Banka;

public interface BankDAO extends JpaRepository<Banka, Long>{

	Banka findBySwiftCode(String swiftCode);
	
}
