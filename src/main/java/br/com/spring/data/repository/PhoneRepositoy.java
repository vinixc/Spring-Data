package br.com.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.spring.data.entity.Phone;

public interface PhoneRepositoy extends JpaRepository<Phone, Long>{

}
