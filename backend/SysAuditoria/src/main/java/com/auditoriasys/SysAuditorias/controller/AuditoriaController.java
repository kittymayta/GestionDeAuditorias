package com.auditoriasys.SysAuditorias.controller;

import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entities.Auditoria;
import com.auditoriasys.SysAuditorias.services.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auditorias")
public class AuditoriaController {

    @Autowired
    AuditoriaService auditoriaService;

    @GetMapping
    public List<Auditoria> listarAuditorias() {
        return auditoriaService.getAuditorias();
    }

    @GetMapping("/{id}")
    public Optional<Auditoria> buscarPorId(@PathVariable Integer id) {
        return auditoriaService.findAuditoriaById(id);
    }

    @PostMapping("create")
    public Auditoria crear(@RequestBody Auditoria auditoria) {
        return auditoriaService.createAuditoria(auditoria);
    }

    @PostMapping("update/{id}")
    public Auditoria actualizar(@RequestBody Auditoria auditoria, @PathVariable Integer id) {
        auditoria.setCodigoAuditoria(id);
        return auditoriaService.updateAuditoria(auditoria);
    }

    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Integer id) {
        auditoriaService.deleteAuditoria(id);
    }

    @GetMapping("/auditorLider")
    public List<Auditoria> buscarPorAuditorLider() {
        return auditoriaService.findAuditoriasConAuditorLider();
    }

    @GetMapping("/auditorLider/{codigo_auditorLider}")
    public List<Auditoria> buscarPorCodigoAuditorLider(@PathVariable Integer codigo_auditorLider) {
        return auditoriaService.findAuditoriasByCodigoAuditorLider(codigo_auditorLider);
    }
}