package br.com.yago.mockito.services;

import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    private final OrderService service = new OrderService();
    private final UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
    private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2023, 10, 14, 15, 37);

    @DisplayName("Should Include Random Order Id When No Order Id Exists")
    @Test
    void test_ShouldIncludeRandomOrderIdWhen_NoOrderIdExists() {

        // Given / Arrange
        try (MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);
            // When / Act
            Order result = service.createOrder("MacBook Pro", 2L, null);
            assertEquals(defaultUuid.toString(), result.getId());
        }
        // Then / Assert
    }

    @DisplayName("Should Include Current Time When create A new Order")
    @Test
    void test_ShouldIncludeCurrentTimeWhen_CreateANewOrder() {

        // Given / Arrange
        try (MockedStatic<LocalDateTime> mockedUuid = mockStatic(LocalDateTime.class)) {
            mockedUuid.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

            // When / Act
            Order result = service.createOrder("MacBook Pro", 2L, null);
            assertEquals(defaultLocalDateTime, result.getCreationDate());
        }
        // Then / Assert

    }
}
