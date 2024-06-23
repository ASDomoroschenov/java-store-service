package ru.mai.orderservice.controller.impl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import ru.mai.orderservice.controller.IOrderController;
import ru.mai.orderservice.dto.request.OrderItemRemoveRequest;
import ru.mai.orderservice.dto.request.OrderRequest;
import ru.mai.orderservice.dto.response.OrderResponse;
import ru.mai.orderservice.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order-service")
@RequiredArgsConstructor
public class OrderController implements IOrderController {

    private final OrderService orderService;

    @DeleteMapping("/remove")
    public void remove(@RequestBody List<Long> ids) {
        orderService.remove(ids);
    }

    @PostMapping("/addOrderItem")
    public OrderResponse addOrderItem(@RequestBody OrderRequest request) {
        return orderService.addOrderItem(request);
    }

    @DeleteMapping("/removeOrderItem")
    public OrderResponse removeOrderItem(@RequestBody OrderItemRemoveRequest request) {
        return orderService.removeOrderItem(request);
    }

}
