package ru.mai.orderservice.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {

    @Schema(
            name = "productId",
            description = "Уникальный идентификатор продукта",
            type = "Long"
    )
    private Long productId;

    @Schema(
            name = "quantity",
            description = "Количество товаров",
            type = "Integer"
    )
    private Integer quantity;

}
