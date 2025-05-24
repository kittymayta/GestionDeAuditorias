package com.auditoriasys.SysAuditorias.controller;

import com.auditoriasys.SysAuditorias.entity.Interrogantes;
import com.auditoriasys.SysAuditorias.service.InterrogantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/interrogantes")
public class InterrogantesController {
    @Autowired
    private InterrogantesService interrogantesService;

    @GetMapping
    public List<Interrogantes> listarInterrogantes() {
        return interrogantesService.getInterrogantes();
    }

    @GetMapping("/{id}")
    public Optional<Interrogantes> buscarPorId(@PathVariable Integer id) {
        return interrogantesService.findInterroganteById(id);
    }

    @PostMapping("create")
    public Interrogantes crear(@RequestBody Interrogantes interrogantes) {
        return interrogantesService.createInterrogante(interrogantes);
    }

    @PostMapping("update/{id}")
    public Interrogantes actualizar(@RequestBody Interrogantes interrogantes, @PathVariable Integer id) {
        interrogantes.setCodigoInterrogante(id);
        return interrogantesService.updateInterrogante(interrogantes);
    }

    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Integer id) {
        interrogantesService.deleteInterrogante(id);
    }

    @GetMapping("/micro/{codigoMicro}")
    public List<Interrogantes> getMethodName(@PathVariable Integer codigoMicro) {
        return interrogantesService.findInterroganteByMicroAuditoria(codigoMicro);
    }
}
