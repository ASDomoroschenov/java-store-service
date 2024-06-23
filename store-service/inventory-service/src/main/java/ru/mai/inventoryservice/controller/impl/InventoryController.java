package ru.mai.inventoryservice.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mai.inventoryservice.controller.IInventoryController;
import ru.mai.inventoryservice.dto.request.InventoryRequest;
import ru.mai.inventoryservice.dto.response.InventoryResponse;
import ru.mai.inventoryservice.service.InventoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory-service")
public class InventoryController implements IInventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/retrieveAll")
    public List<InventoryResponse> retrieveAll() {
        return inventoryService.retrieveAll();
    }

    @GetMapping("/retrieveAllByIds")
    public List<InventoryResponse> retrieveAllByIds(@RequestBody List<Long> ids) {
        return inventoryService.retrieveAllByIds(ids);
    }

    @PostMapping("/save")
    public List<InventoryResponse> save(@RequestBody List<InventoryRequest> requests) {
        return inventoryService.save(requests);
    }

    @DeleteMapping("/remove")
    public void remove(@RequestBody List<Long> ids) {
        inventoryService.remove(ids);
    }

}
