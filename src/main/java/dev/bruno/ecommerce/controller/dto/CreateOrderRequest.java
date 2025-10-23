package dev.bruno.ecommerce.controller.dto;

import java.util.List;

public record CreateOrderRequest(
    Long userId,
    List<OrderProductDto> products
) {

}
