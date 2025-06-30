package com.auditoriasys.SysAuditorias.repositories;

import java.util.List;

import com.auditoriasys.SysAuditorias.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<Item,Integer>{

    List<Item> findByCodigoNormaIso (Integer codigoNorma);

}
