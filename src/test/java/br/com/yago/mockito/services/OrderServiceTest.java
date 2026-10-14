package br.com.yago.mockito.services;

import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    private final OrderService service = new OrderService();
    private final UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");

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
}
