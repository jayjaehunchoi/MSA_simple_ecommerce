package com.example.orderservice.domain;

import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.web.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderResponseDto createOrder(Order order) {
        Order saveOrder = orderRepository.save(order);
        return OrderResponseDto.from(saveOrder);
    }

    public Order getOrderByOrderId(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("Order Not Found");
        });
    }

    @Transactional(readOnly = true)
    public List<Order> findOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
