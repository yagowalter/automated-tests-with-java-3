package br.com.yago.business;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;


public class ListWithBDDTest {

    @DisplayName("")
    @Test
    void test_MockingList_When_SizeIsCalled_ShouldReturn10() {

        // Given / Arrange
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10);

        // When / Act & Then / Assert
        assertThat(list.size(), is(10));

    }

    @DisplayName("")
    @Test
    void test_MockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {

        // Given / Arrange
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10).willReturn(20);

        // When / Act & Then / Assert
        assertThat(list.size(), is(10));

    }

    @DisplayName("")
    @Test
    void test_MockingList_When_GetIsCalled_ShouldReturnYago() {

        // Given / Arrange
        var list = mock(List.class);
        given(list.get(0)).willReturn("Yago");

        // When / Act & Then / Assert
        assertThat(list.get(0), is("Yago"));
        assertNull(list.get(1));

    }

    @DisplayName("")
    @Test
    void test_MockingList_When_ThrowsAnException() {

        // Given / Arrange
        var list = mock(List.class);
        given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar!"));

        // When / Act & Then / Assert
        assertThrows(RuntimeException.class,
                () -> {
                    // When / Act
                    list.get(anyInt());
                },
                () -> "Should have throw an RunTimeException");
    }
}
