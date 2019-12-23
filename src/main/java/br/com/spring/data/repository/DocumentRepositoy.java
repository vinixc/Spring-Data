package br.com.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.spring.data.entity.Document;

public interface DocumentRepositoy extends JpaRepository<Document, Long>{
	
	//#{#entityName} para caso a entidade esteja com nome diferente da class.
	
	@Query("select d from Document d where d.cpf like :start%")
	List<Document> findByCPFStartWith(@Param("start") String start);

}
