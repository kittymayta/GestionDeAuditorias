package com.auditoriasys.SysAuditorias.repositories;

import com.auditoriasys.SysAuditorias.entities.SolicitudAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudAuditoriaRepository extends JpaRepository<SolicitudAuditoria, Integer>{

}
