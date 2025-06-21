package com.auditoriasys.SysAuditorias.repository;

import com.auditoriasys.SysAuditorias.entity.EstadoAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstadoAuditoriaRepository extends JpaRepository<EstadoAuditoria, Integer>{

}
