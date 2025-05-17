package com.auditoriasys.SysAuditorias.repository;

import com.auditoriasys.SysAuditorias.entity.TipoLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoLinkRepository extends JpaRepository<TipoLink, Integer> {

}
