package com.auditoriasys.SysAuditorias.repository;

import com.auditoriasys.SysAuditorias.entity.SubItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubItemRepository extends JpaRepository<SubItem,Integer> {

}
