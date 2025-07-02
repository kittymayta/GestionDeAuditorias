package com.auditoriasys.SysAuditorias.controller;

import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entities.SubItem;
import com.auditoriasys.SysAuditorias.services.SubItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/subItems")
public class SubItemController {

    @Autowired
    SubItemService subItemService;

    @GetMapping
    public List<SubItem> listarSubItems() {
        return subItemService.getSubItems();
    }

    @GetMapping("/{id}")
    public Optional<SubItem> buscarPorId(@PathVariable Integer id) {
        return subItemService.findSubItemById(id);
    }

    @PostMapping("create")
    public SubItem crear(@RequestBody SubItem subItem) {
        return subItemService.createSubItem(subItem);
    }

    @PostMapping("update/{id}")
    public SubItem actualizar(@RequestBody SubItem subItem, @PathVariable Integer id) {
        subItem.setCodigoSubItem(id);
        return subItemService.updateSubItem(subItem);
    }

    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Integer id) {
        subItemService.deleteSubItem(id);
    }

    @GetMapping("/listarByCodigoItem/{codigo_item}")
    public List<SubItem> getSubItemsByCodigoItem(@PathVariable Integer codigo_item) {
        return subItemService.findByCodigoItem(codigo_item);
    }

    @GetMapping("/{id}/cambiarEstado")
    public SubItem cambiarEstado(@PathVariable Integer id) {
        return subItemService.cambiarEstado(id);
    }

    @GetMapping("/activos")
    public List<SubItem> activos(){
        return subItemService.activos();
    }
}