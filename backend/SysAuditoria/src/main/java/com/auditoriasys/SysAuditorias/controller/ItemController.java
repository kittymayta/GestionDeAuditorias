package com.auditoriasys.SysAuditorias.controller;

import com.auditoriasys.SysAuditorias.entity.Item;
import com.auditoriasys.SysAuditorias.service.ItemService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/items")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping
	public List<Item> listarItems() {
		return itemService.getItems();
	}
	
	@GetMapping("/{id}")
	public Optional<Item> buscarPorId(@PathVariable Integer id) {
		return itemService.findItemById(id);
	}
	
	@PostMapping("create")
	public Item crear(@RequestBody Item item) {
		return itemService.createItem(item);
	}
	
	@PostMapping("update/{id}")
	public Item actualizar(@RequestBody Item item, @PathVariable Integer id) {
		item.setCodigoItem(id);
		return itemService.updateItem(item);
	}
	
	@DeleteMapping("delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		itemService.deleteItem(id);
	}
	
	@GetMapping("/listarByCodigoNorma/{codigo_norma}")
	public List<Item> getItemsByCodigoNorma(@PathVariable Integer codigo_norma) {
		return itemService.finItemByCodigoNormaIso(codigo_norma);
	}
	
	@GetMapping("/{id}/cambiarEstado")
	public Item cambiarEstado(@PathVariable Integer id) {
		return itemService.cambiarEstado(id);
	}
	
	@GetMapping("/activos")
	public List<Item> getActivos() {
		return itemService.activos();
	}
	
}
