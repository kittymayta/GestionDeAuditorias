package com.auditoriasys.SysAuditorias.repository;

import com.auditoriasys.SysAuditorias.entity.SolicitudAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudAuditoriaRepository extends JpaRepository<SolicitudAuditoria, Integer> {
}
