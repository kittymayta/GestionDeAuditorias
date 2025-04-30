package com.auditoriasys.SysAuditorias.service;

import com.auditoriasys.SysAuditorias.entity.Item;
import com.auditoriasys.SysAuditorias.repository.ItemRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> getItems() {
		return itemRepository.findAll();
	}
	
	public Item createItem(Item item) {
		return itemRepository.save(item);
	}
	
	public Item updateItem(Item item) {
		return itemRepository.save(item);
	}
	
	public void deleteItem(Integer id) {
		itemRepository.deleteById(id);
	}
	
	public Optional<Item> findItemById(Integer id) {
		return itemRepository.findById(id);
	}
	
	public List<Item> finItemByCodigoNormaIso(Integer id) {
		return itemRepository.findByCodigoNormaIso(id);
	}
	
	public Item cambiarEstado(Integer id) {
		Item i = findItemById(id).get();
		if(i.isEstadoUso()) i.setEstadoUso(false);
		else i.setEstadoUso(true);
		
		updateItem(i);
		
		return i;
	}
	
	public List<Item> activos() {
		return getItems().stream().filter(i -> i.isEstadoUso()==true).toList();
	}
}
