package ru.mai.orderservice.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponse {

    @Schema(
            name = "productId",
            description = "Уникальный идентификатор продукта",
            type = "Long"
    )
    private Long productId;

    @Schema(
            name = "quantity",
            description = "Количество товара",
            type = "Integer"
    )
    private Integer quantity;

}
