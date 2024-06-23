package ru.mai.orderservice.dto.request;

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
public class OrderItemRemoveRequest {

    @Schema(
            name = "idUser",
            description = "Уникальный идентификатор пользователя",
            type = "Long"
    )
    private Long idUser;

    @Schema(
            name = "productIds",
            description = "Список продуктов для удаления",
            type = "List<Long>"
    )
    private List<Long> productIds;

}
