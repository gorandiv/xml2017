package centralbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import centralbank.bean.Banka;



public interface BankDAO extends JpaRepository<Banka, Long>{

	Banka findBySwiftCode(String swiftCode);
	
}
