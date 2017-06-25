package centralbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import centralbank.bean.Bank;

public interface BankDAO extends JpaRepository<Bank, Long>{

	Bank findBySwiftCode(String swiftCode);
	
}
