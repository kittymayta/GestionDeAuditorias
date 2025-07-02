package com.auditoriasys.SysAuditorias.controller;

import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entities.Interrogantes;
import com.auditoriasys.SysAuditorias.services.InterrogantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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