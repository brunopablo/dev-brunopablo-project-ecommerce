/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dev.bruno.ecommerce.controller.dto;

import java.math.BigDecimal;

public record OrderItemDto(
        Integer quantity,
        Long productId) {

}
