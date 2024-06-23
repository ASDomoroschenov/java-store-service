package ru.mai.inventoryservice.controller;

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
import ru.mai.inventoryservice.dto.request.InventoryRequest;
import ru.mai.inventoryservice.dto.response.InventoryResponse;

import java.util.List;

public interface IInventoryController {

    @Operation(
            summary = "Получение всех продуктов склада",
            description = "Метод возвращает список всех продуктов склада, определенных в базе данных",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешное выполнение метода",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = InventoryResponse.class))
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
    List<InventoryResponse> retrieveAll();


    @Operation(
            summary = "Получение всех продуктов склада по списку ids",
            description = "В метод передается список id, в качестве ответа - список InventoryResponse",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешное выполнение метода",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = InventoryResponse.class))
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
                            array = @ArraySchema(schema = @Schema(implementation = InventoryRequest.class))
                    )
            }
    )
    @GetMapping("/retrieveAllByIds")
    List<InventoryResponse> retrieveAllByIds(List<Long> ids);


    @Operation(
            summary = "Сохранить/обновить продукты на складе",
            description = "Сохранение или обновление (если объекты уже есть) по переданному списку запросов",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешное выполнение метода",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = InventoryResponse.class))
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
            description = "Список объектов InventoryRequest",
            required = true,
            content = {
                    @Content(
                            array = @ArraySchema(schema = @Schema(implementation = InventoryRequest.class))
                    )
            }
    )
    @PostMapping("/save")
    List<InventoryResponse> save(@RequestBody List<InventoryRequest> requests);


    @Operation(
            summary = "Удалить продукты на складе по ids",
            description = "Удаление объектов из базы данных по переданному списку id"
    )
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Список id",
            required = true,
            content = {
                    @Content(
                            array = @ArraySchema(schema = @Schema(implementation = InventoryRequest.class))
                    )
            }
    )
    @DeleteMapping("/remove")
    void remove(@RequestBody List<Long> ids);

}
