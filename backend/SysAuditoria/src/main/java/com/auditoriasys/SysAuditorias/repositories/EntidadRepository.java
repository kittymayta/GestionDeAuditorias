package com.auditoriasys.SysAuditorias.repositories;

import com.auditoriasys.SysAuditorias.entities.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Integer>{

}
