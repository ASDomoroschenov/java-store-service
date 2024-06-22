package ru.mai.productservice.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    @Schema(
            name = "id",
            description = "Уникальный идентификатор",
            type = "Long"
    )
    private Long id;

    @Schema(
            name = "name",
            description = "Имя продукта",
            type = "String"
    )
    private String name;

    @Schema(
            name = "description",
            description = "Описание продукта",
            type = "String"
    )
    private String description;

    @Schema(
            name = "price",
            description = "Цена продукта",
            type = "Double"
    )
    private Double price;
}