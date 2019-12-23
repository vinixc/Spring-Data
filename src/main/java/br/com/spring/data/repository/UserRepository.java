package br.com.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.spring.data.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
