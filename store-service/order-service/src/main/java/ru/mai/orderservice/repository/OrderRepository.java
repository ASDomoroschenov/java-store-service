package ru.mai.orderservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mai.orderservice.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
