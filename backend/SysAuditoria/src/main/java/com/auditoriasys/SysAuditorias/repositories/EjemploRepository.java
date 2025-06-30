package com.auditoriasys.SysAuditorias.repositories;

import java.util.List;

import com.auditoriasys.SysAuditorias.entities.Ejemplo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjemploRepository extends JpaRepository<Ejemplo,Integer>{

    List<Ejemplo> findByCodigoSubItem(Integer codigo_item);

}
