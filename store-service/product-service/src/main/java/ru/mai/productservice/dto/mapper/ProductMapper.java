package ru.mai.productservice.dto.mapper;

import ru.mai.productservice.dto.request.ProductRequest;
import ru.mai.productservice.dto.response.ProductResponse;
import ru.mai.productservice.model.Product;

public class ProductMapper {

    private ProductMapper() {
    }

    /**
     * Преобразование сущности в ответ
     * @param model - сущность
     * @return ProductResponse - ответ
     */
    public static ProductResponse modelToResponse(Product model) {
        return ProductResponse.builder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .price(model.getPrice())
                .build();
    }

    /**
     * Преобразование запроса в сущность
     * @param request - запрос
     * @return Product - сущность
     */
    public static Product requestToModel(ProductRequest request) {
        return Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }

}
