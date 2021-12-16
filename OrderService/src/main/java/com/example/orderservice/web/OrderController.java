package com.example.orderservice.web;

import com.example.orderservice.domain.Order;
import com.example.orderservice.domain.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/order-service")
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{userId}/orders")
    public ResponseEntity<OrderResponseDto> createOrder(@PathVariable Long userId, @RequestBody OrderRequestDto orderRequestDto) {
        orderRequestDto.setUserId(userId);
        Order order = orderRequestDto.toEntity();

        return ResponseEntity.created(URI.create("/order-service/" + userId + "/orders")).body(orderService.createOrder(order));
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable Long id) {
        OrderResponseDto orderResponseDto = OrderResponseDto.from(orderService.getOrderByOrderId(id));
        return ResponseEntity.ok(orderResponseDto);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<OrderResponseDtos> getOrder(@PathVariable Long userId) {
        List<OrderResponseDto> orderResponseDtos = orderService.findOrdersByUserId(userId).stream()
                .map(OrderResponseDto::from)
                .collect(Collectors.toList());

        OrderResponseDtos responseDtos = new OrderResponseDtos(orderResponseDtos);
        return ResponseEntity.ok(responseDtos);
    }
}
