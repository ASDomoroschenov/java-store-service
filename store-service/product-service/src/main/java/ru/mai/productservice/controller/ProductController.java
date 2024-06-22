package ru.mai.productservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import ru.mai.productservice.dto.request.ProductRequest;
import ru.mai.productservice.dto.response.ProductResponse;
import ru.mai.productservice.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product-service")
public class ProductController {

    private final ProductService productService;

    @Operation(
            summary = "Получение всех продуктов",
            description = "Метод возвращает список всех продуктов, определенных в базе данных",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешное выполнение метода",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ProductResponse.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка с БД или на стороне микросервиса",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class))
                                    )
                            }
                    )
            }
    )
    @GetMapping("/retrieveAll")
    public List<ProductResponse> retrieveAll() {
        return productService.retrieveAll();
    }


    @Operation(
            summary = "Получение всех продуктов по списку ids",
            description = "В метод передается список id, в качестве ответа - список ProductResponse",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешное выполнение метода",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ProductResponse.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка с БД или на стороне микросервиса",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class))
                                    )
                            }
                    )
            }
    )
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Список id",
            required = true,
            content = {
                    @Content(
                            array = @ArraySchema(schema = @Schema(implementation = ProductRequest.class))
                    )
            }
    )
    @GetMapping("/retrieveAllByIds")
    public List<ProductResponse> retrieveAllByIds(List<Long> ids) {
        return productService.retrieveAllByIds(ids);
    }


    @Operation(
            summary = "Сохранить/обновить продукты",
            description = "Сохранение или обновление (если объекты уже есть) по переданному списку запросов",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешное выполнение метода",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ProductResponse.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка с БД или на стороне микросервиса",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class))
                                    )
                            }
                    )
            }
    )
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Список объектов ProductRequest",
            required = true,
            content = {
                    @Content(
                            array = @ArraySchema(schema = @Schema(implementation = ProductRequest.class))
                    )
            }
    )
    @PostMapping("/save")
    public List<ProductResponse> save(@RequestBody List<ProductRequest> requests) {
        return productService.save(requests);
    }


    @Operation(
            summary = "Удалить продукты по ids",
            description = "Удаление объектов из базы данных по переданному списку id"
    )
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Список id",
            required = true,
            content = {
                    @Content(
                            array = @ArraySchema(schema = @Schema(implementation = ProductRequest.class))
                    )
            }
    )
    @DeleteMapping("/remove")
    public void remove(@RequestBody List<Long> ids) {
        productService.remove(ids);
    }

}
