package br.com.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.spring.data.entity.Document;

public interface DocumentRepositoy extends JpaRepository<Document, Long>{

}
