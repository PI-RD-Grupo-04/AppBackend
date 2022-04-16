package br.com.rd.ved.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.ved.modell.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>, CrudRepository<Usuario,Integer>{

}