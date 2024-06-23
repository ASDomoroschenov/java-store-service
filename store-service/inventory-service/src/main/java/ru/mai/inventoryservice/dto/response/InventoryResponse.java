package ru.mai.inventoryservice.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {

    @Schema(
            name = "id",
            description = "Уникальный идентификатор",
            type = "Long"
    )
    private Long id;

    @Schema(
            name = "productId",
            description = "Внешний ключ продукта",
            type = "Long"
    )
    private Long productId;

    @Schema(
            name = "stock",
            description = "Количество продукта на складе",
            type = "Integer"
    )
    private Integer stock;

    @Schema(
            name = "warehouseAddress",
            description = "Адрес склада",
            type = "String"
    )
    private String warehouseAddress;

}
