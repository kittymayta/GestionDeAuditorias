package com.auditoriasys.SysAuditorias.repositories;

import java.util.List;

import com.auditoriasys.SysAuditorias.entities.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer>{

    List<Documento> findByCodigoSubItem(Integer codigo_item);

}
