package ru.mai.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;
import ru.mai.orderservice.dto.mapper.OrderMapper;
import ru.mai.orderservice.dto.request.OrderItemRemoveRequest;
import ru.mai.orderservice.dto.request.OrderRequest;
import ru.mai.orderservice.dto.response.OrderResponse;
import ru.mai.orderservice.model.Order;
import ru.mai.orderservice.model.OrderItem;
import ru.mai.orderservice.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    /**
     * Метод для получения всех продуктов в каждой корзине каждого пользователя
     *
     * @return список объектов OrderResponse
     */
    public List<OrderResponse> retrieveAll() {
        return IteratorUtils.toList(orderRepository.findAll().iterator()).stream()
                .map(OrderMapper::modelToOrderResponse)
                .toList();
    }


    /**
     * Получение продуктов в каждой корзине по каждому пользователю,
     * уникальный идентификатор которого передали в списке
     *
     * @param ids список уникальных идентификаторов
     * @return список объектов OrderResponse
     */
    public List<OrderResponse> retrieveAllByIds(List<Long> ids) {
        return IteratorUtils.toList(orderRepository.findAllById(ids).iterator()).stream()
                .map(OrderMapper::modelToOrderResponse)
                .toList();
    }


    /**
     * Создание корзины для каждого пользователя
     *
     * @param requests список запросов
     * @return список объектов OrderResponse
     */
    public List<OrderResponse> save(List<OrderRequest> requests) {
        return IteratorUtils.toList(orderRepository.saveAll(requests.stream()
                        .map(OrderMapper::orderRequestToModel)
                        .toList()).iterator()).stream()
                .map(OrderMapper::modelToOrderResponse)
                .toList();
    }


    /**
     * Удаление корзины каждого пользователя, чей
     * уникальный идентификатор оказался в списке
     *
     * @param ids список уникальных идентификаторов
     */
    public void remove(List<Long> ids) {
        orderRepository.deleteAllById(ids);
    }


    /**
     * Добавление продукта в корзину определенному пользователю.
     * В объекте передается уникальный идентификатор пользователя и
     * список продуктов, которые нужно добавить в корзину
     *
     * @param request объект запроса
     * @return объект OrderResponse вместе с добавленными продуктами
     */
    public OrderResponse addOrderItem(OrderRequest request) {
        Order order = orderRepository.findById(request.getIdUser()).orElse(null);

        if (order != null) {
            List<OrderItem> orderItemList = request.getOrderItemList().stream()
                    .map(OrderMapper::orderItemRequestToModel)
                    .toList();
            List<OrderItem> list = order.getOrderItemList();
            list.addAll(orderItemList);
            order.setOrderItemList(list);
            orderRepository.save(order);

            return OrderMapper.modelToOrderResponse(order);
        }

        return null;
    }


    /**
     * Удаление из корзины продуктов для определенного пользователя
     *
     * @param request объект OrderItemRemoveRequest, который содержит информацию
     *                о продуктах для удаления для определенного пользователя
     * @return объект OrderResponse
     */
    public OrderResponse removeOrderItem(OrderItemRemoveRequest request) {
        Order order = orderRepository.findById(request.getIdUser()).orElse(null);

        if (order != null) {
            List<OrderItem> newOrderItemList = new ArrayList<>();

            order.getOrderItemList().forEach(item -> {
                if (!request.getProductIds().contains(item.getProductId())) {
                    newOrderItemList.add(item);
                }
            });

            order.setOrderItemList(newOrderItemList);

            return OrderMapper.modelToOrderResponse(order);
        }

        return null;
    }

}
