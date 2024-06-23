package ru.mai.inventoryservice.dto.mapper;

import ru.mai.inventoryservice.dto.request.InventoryRequest;
import ru.mai.inventoryservice.dto.response.InventoryResponse;
import ru.mai.inventoryservice.model.Inventory;

public class InventoryMapper {

    private InventoryMapper() {
    }

    /**
     * Преобразование сущности в ответ
     *
     * @param model - сущность
     * @return InventoryResponse - ответ
     */
    public static InventoryResponse modelToResponse(Inventory model) {
        return InventoryResponse.builder()
                .id(model.getId())
                .productId(model.getProductId())
                .stock(model.getStock())
                .warehouseAddress(model.getWarehouseAddress())
                .build();
    }

    /**
     * Преобразование запроса в сущность
     *
     * @param request - запрос
     * @return Inventory - сущность
     */
    public static Inventory requestToModel(InventoryRequest request) {
        return Inventory.builder()
                .id(request.getId())
                .productId(request.getProductId())
                .stock(request.getStock())
                .warehouseAddress(request.getWarehouseAddress())
                .build();
    }

}
