package com.auditoriasys.SysAuditorias.repositories;

import com.auditoriasys.SysAuditorias.entities.EstadoAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoAuditoriaRepository extends JpaRepository<EstadoAuditoria, Integer>{

}
