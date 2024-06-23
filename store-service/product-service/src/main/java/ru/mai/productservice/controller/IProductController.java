package ru.mai.productservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.mai.productservice.dto.request.ProductRequest;
import ru.mai.productservice.dto.response.ProductResponse;

import java.util.List;

public interface IProductController {

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
    List<ProductResponse> retrieveAll();


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
    List<ProductResponse> retrieveAllByIds(List<Long> ids);


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
    List<ProductResponse> save(@RequestBody List<ProductRequest> requests);


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
    void remove(@RequestBody List<Long> ids);

}
