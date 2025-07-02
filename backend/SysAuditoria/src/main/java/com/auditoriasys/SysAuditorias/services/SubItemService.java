package com.auditoriasys.SysAuditorias.services;

import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entities.SubItem;
import com.auditoriasys.SysAuditorias.repositories.SubItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubItemService {

    @Autowired
    private SubItemRepository subItemRepository;

    public List<SubItem> getSubItems() {
        return subItemRepository.findAll();
    }

    public SubItem createSubItem(SubItem subItem) {
        return subItemRepository.save(subItem);
    }

    public SubItem updateSubItem(SubItem subItem) {
        return subItemRepository.save(subItem);
    }

    public void deleteSubItem(Integer id) {
        subItemRepository.deleteById(id);
    }

    public Optional<SubItem> findSubItemById(Integer id) {
        return subItemRepository.findById(id);
    }

    public List<SubItem> findByCodigoItem(Integer id) {
        return getSubItems().stream().filter( s->s.getItem().getCodigoItem()==id).toList();
    }

    public SubItem cambiarEstado(Integer id) {
        SubItem i = findSubItemById(id).get();
        if(i.isEstadoUso()) i.setEstadoUso(false);
        else i.setEstadoUso(true);

        updateSubItem(i);

        return i;
    }

    public List<SubItem> activos() {
        return getSubItems().stream().filter( sub -> sub.isEstadoUso()==true).toList();
    }
}