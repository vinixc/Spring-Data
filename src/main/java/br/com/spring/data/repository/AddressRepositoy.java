package br.com.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.spring.data.entity.Address;

public interface AddressRepositoy extends JpaRepository<Address, Long>{

}
