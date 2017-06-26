package bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.bean.Banka;

public interface BankDAO extends JpaRepository<Banka, Long>{

	Banka findBySwiftCode(String swiftCode);
	Banka findById(Integer id);
	
}
