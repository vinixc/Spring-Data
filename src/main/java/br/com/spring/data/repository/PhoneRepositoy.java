package br.com.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.spring.data.entity.Phone;
import br.com.spring.data.entity.Phone.TypePhone;

@Transactional(readOnly = true)
public interface PhoneRepositoy extends JpaRepository<Phone, Long>{

	@Modifying
	@Query("update Phone p set p.number = ?1 where p.id = ?2")
	@Transactional(readOnly = false)
	int setPhoneNumber(String number, Long id);
	
	@Modifying
	@Transactional(readOnly = false)
	@Query("update Phone p set p.type = ?1 where p.id = ?2")
	int setPhoneType(TypePhone type, Long id);
	
	@Modifying
	@Transactional(readOnly = false)
	@Query("delete from Phone p where p.number like ?1")
	int deleteByNumber(String number);

}
