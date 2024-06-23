package ru.mai.orderservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.mai.orderservice.dto.request.OrderItemRemoveRequest;
import ru.mai.orderservice.dto.request.OrderRequest;
import ru.mai.orderservice.dto.response.OrderResponse;

import java.util.List;

public interface IOrderController {

    @Operation(
            summary = "Удаление корзин пользователей",
            description = "Метод удаляет корзины пользователей, чей идентификатор был передан в списке",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешное выполнение метода"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка с БД или на стороне микросервиса"
                    )
            }
    )
    @DeleteMapping("/remove")
    void remove(@RequestBody List<Long> ids);


    @Operation(
            summary = "Добавление продуктов в корзину пользователя",
            description = "Метод добавляет список переданных продуктов в корзину определенного пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешное выполнение метода",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = OrderResponse.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка с БД или на стороне микросервиса",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = OrderResponse.class)
                                    )
                            }
                    )
            }
    )
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Объект OrderRequest",
            required = true,
            content = {
                    @Content(
                            schema = @Schema(implementation = OrderRequest.class)
                    )
            }
    )
    @PostMapping("/addOrderItem")
    OrderResponse addOrderItem(@RequestBody OrderRequest request);


    @Operation(
            summary = "Удаление продуктов из корзины пользователя",
            description = "Метод удаляет список переданных продуктов из корзины определенного пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешное выполнение метода",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = OrderResponse.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка с БД или на стороне микросервиса",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = OrderResponse.class)
                                    )
                            }
                    )
            }
    )
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Объект OrderItemRemoveRequest",
            required = true,
            content = {
                    @Content(
                            schema = @Schema(implementation = OrderItemRemoveRequest.class)
                    )
            }
    )
    @DeleteMapping("/removeOrderItem")
    OrderResponse removeOrderItem(@RequestBody OrderItemRemoveRequest request);

}
