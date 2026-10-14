package br.com.yago.business;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @DisplayName("")
    @Test
    void test_MockingList_When_SizeIsCalled_ShouldReturn10() {

        // Given / Arrange
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10);

        // When / Act & Then / Assert
        assertEquals(10, list.size());

    }

    @DisplayName("")
    @Test
    void test_MockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {

        // Given / Arrange
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);

        // When / Act & Then / Assert
        assertEquals(10, list.size());

    }

    @DisplayName("")
    @Test
    void test_MockingList_When_GetIsCalled_ShouldReturnYago() {

        // Given / Arrange
        var list = mock(List.class);
        when(list.get(0)).thenReturn("Yago");

        // When / Act & Then / Assert
        assertEquals("Yago", list.get(0));
        assertNull(list.get(1));

    }

    @DisplayName("")
    @Test
    void test_MockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnYago() {

        // Given / Arrange
        var list = mock(List.class);
        when(list.get(anyInt())).thenReturn("Yago");

        // When / Act & Then / Assert
        assertEquals("Yago", list.get(anyInt()));
        assertEquals("Yago", list.get(anyInt()));

    }
}
