package br.com.rd.ved.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.rd.ved.model.Uf;

public interface UfRepository extends JpaRepository<Uf, Integer>,  CrudRepository<Uf,Integer>{

}
