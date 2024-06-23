package ru.mai.orderservice.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    @Schema(
            name = "idUser",
            description = "Уникальный идентификатор пользователя",
            type = "Long"
    )
    private Long idUser;

    @Schema(
            name = "orderItemList",
            description = "Список товаров",
            type = "List<OrderItemResponse>"
    )
    private List<OrderItemResponse> orderItemList;

}
