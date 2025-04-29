package com.auditoriasys.SysAuditorias.repository;

import com.auditoriasys.SysAuditorias.entity.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Integer>{

}
