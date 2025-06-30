package com.auditoriasys.SysAuditorias.controller;

import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entities.Procesos;
import com.auditoriasys.SysAuditorias.services.ProcesosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/procesos")
public class ProcesosController {

    @Autowired
    ProcesosService procesosService;

    @GetMapping
    public List<Procesos> listarProcesos() {
        return procesosService.getProcesos();
    }

    @GetMapping("/{id}")
    public Optional<Procesos> buscarPorId(@PathVariable Integer id) {
        return procesosService.findProcesosById(id);
    }

    @PostMapping("create")
    public Procesos crear(@RequestBody Procesos Procesos) {
        return procesosService.createProcesos(Procesos);
    }

    @PostMapping("update/{id}")
    public Procesos actualizar(@RequestBody Procesos Procesos, @PathVariable Integer id) {
        Procesos.setCodigoProceso(id);
        return procesosService.updateProcesos(Procesos);
    }

    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Integer id) {
        procesosService.deleteProcesos(id);
    }

    @GetMapping("/entidad/{id}")
    public List<Procesos> getMethodName(@PathVariable Integer id) {
        return procesosService.findByCodigoEntidad(id);
    }

}