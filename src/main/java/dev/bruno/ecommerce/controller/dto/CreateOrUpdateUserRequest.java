package dev.bruno.ecommerce.controller.dto;

public record CreateOrUpdateUserRequest(
    String name,
    String address,
    Integer number,
    String complement
) {

}