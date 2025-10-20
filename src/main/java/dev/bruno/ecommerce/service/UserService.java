package dev.bruno.ecommerce.service;

import org.springframework.stereotype.Service;

import dev.bruno.ecommerce.controller.dto.CreateOrUpdateUserRequest;
import dev.bruno.ecommerce.entity.BillingAddressEntity;
import dev.bruno.ecommerce.entity.UserEntity;
import dev.bruno.ecommerce.repository.BillingAddressRepository;
import dev.bruno.ecommerce.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository, BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public Long createUser(
            CreateOrUpdateUserRequest createOrUpdateUserRequest) {

        var billingAddressEntity = billingAddressRepository.save(
                new BillingAddressEntity(
                        null,
                        createOrUpdateUserRequest.address(),
                        createOrUpdateUserRequest.number(),
                        createOrUpdateUserRequest.complement(),
                        null));

        var userEntity = userRepository.save(
                new UserEntity(
                        null,
                        createOrUpdateUserRequest.name(),
                        billingAddressEntity));

        return userEntity.getId();
    }
}
