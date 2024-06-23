package ru.mai.orderservice.dto.mapper;

import ru.mai.orderservice.dto.request.OrderItemRequest;
import ru.mai.orderservice.dto.request.OrderRequest;
import ru.mai.orderservice.dto.response.OrderItemResponse;
import ru.mai.orderservice.dto.response.OrderResponse;
import ru.mai.orderservice.model.Order;
import ru.mai.orderservice.model.OrderItem;

public class OrderMapper {

    /**
     * Преобразование OrderItemRequest в OrderItem
     *
     * @param request объект для преобразования
     * @return преобразованный объект OrderItem
     */
    public static OrderItem orderItemRequestToModel(OrderItemRequest request) {
        return OrderItem.builder()
                .productId(request.getProductId())
                .quantity(request.getQuantity())
                .build();
    }


    /**
     * Преобразование OrderItem в OrderItemResponse
     *
     * @param orderItem объект для преобразования
     * @return преобразованный объект OrderItemResponse
     */
    public static OrderItemResponse orderItemModelToOrderItemResponse(OrderItem orderItem) {
        return OrderItemResponse.builder()
                .productId(orderItem.getProductId())
                .quantity(orderItem.getQuantity())
                .build();
    }


    /**
     * Преобразование Order в OrderResponse
     *
     * @param order объект для преобразования
     * @return преобразованный объект OrderResponse
     */
    public static OrderResponse modelToOrderResponse(Order order) {
        if (order == null) {
            return null;
        }

        return OrderResponse.builder()
                .idUser(order.getIdUser())
                .orderItemList(order.getOrderItemList().stream()
                        .map(OrderMapper::orderItemModelToOrderItemResponse)
                        .toList())
                .build();
    }


    /**
     * Преобразование OrderRequest в Order
     *
     * @param request объект для преобразования
     * @return преобразованный объект Order
     */
    public static Order orderRequestToModel(OrderRequest request) {
        return Order.builder()
                .idUser(request.getIdUser())
                .orderItemList(request.getOrderItemList().stream()
                        .map(OrderMapper::orderItemRequestToModel)
                        .toList())
                .build();
    }

}
