package com.auditoriasys.SysAuditorias.repository;

import com.auditoriasys.SysAuditorias.entity.MicroAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroAuditoriaRepository extends JpaRepository<MicroAuditoria, Integer> {

}
