package com.auditoriasys.SysAuditorias.controller;

import com.auditoriasys.SysAuditorias.entities.Item;
import com.auditoriasys.SysAuditorias.services.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    @Test
    void listarItems() {
        List<Item> items = Arrays.asList(
                new Item(1, "Item 1", 1001, true),
                new Item(2, "Item 2", 1002, true)
        );
        when(itemService.getItems()).thenReturn(items);

        List<Item> result = itemController.listarItems();

        assertEquals(2, result.size());
    }

    @Test
    void buscarPorId_Existente() {
        Item item = new Item(1, "Item 1", 1001, true);
        when(itemService.findItemById(1)).thenReturn(Optional.of(item));

        Optional<Item> result = itemController.buscarPorId(1);

        assertTrue(result.isPresent());
        assertEquals("Item 1", result.get().getNombreItem());
    }

    @Test
    void buscarPorId_NoExistente() {
        when(itemService.findItemById(99)).thenReturn(Optional.empty());

        Optional<Item> result = itemController.buscarPorId(99);

        assertTrue(result.isEmpty());
    }

    @Test
    void crearItem() {
        Item newItem = new Item(0, "Nuevo Item", 1001, true);
        Item savedItem = new Item(1, "Nuevo Item", 1001, true);
        when(itemService.createItem(newItem)).thenReturn(savedItem);

        Item result = itemController.crear(newItem);

        assertEquals(1, result.getCodigoItem());
    }

    @Test
    void actualizarItem() {
        Item updatedItem = new Item(1, "Item Actualizado", 1001, true);
        when(itemService.updateItem(updatedItem)).thenReturn(updatedItem);

        Item result = itemController.actualizar(updatedItem, 1);

        assertEquals("Item Actualizado", result.getNombreItem());
    }

    @Test
    void eliminarItem() {
        doNothing().when(itemService).deleteItem(1);

        itemController.eliminar(1);

        verify(itemService).deleteItem(1);
    }

    @Test
    void getItemsByCodigoNorma() {
        List<Item> items = Arrays.asList(
                new Item(1, "Item 1", 1001, true),
                new Item(2, "Item 2", 1001, false)
        );
        when(itemService.finItemByCodigoNormaIso(1001)).thenReturn(items);

        List<Item> result = itemController.getItemsByCodigoNorma(1001);

        assertEquals(2, result.size());
    }

    @Test
    void cambiarEstado() {
        Item changedItem = new Item(1, "Item 1", 1001, false);
        when(itemService.cambiarEstado(1)).thenReturn(changedItem);

        Item result = itemController.cambiarEstado(1);

        assertFalse(result.isEstadoUso());
    }

    @Test
    void getActivos() {
        List<Item> activeItems = Collections.singletonList(
                new Item(1, "Item Activo", 1001, true)
        );
        when(itemService.activos()).thenReturn(activeItems);

        List<Item> result = itemController.getActivos();

        assertEquals(1, result.size());
        assertTrue(result.get(0).isEstadoUso());
    }
}