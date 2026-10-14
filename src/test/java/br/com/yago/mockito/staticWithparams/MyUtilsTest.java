package br.com.yago.mockito.staticWithparams;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mockStatic;

public class MyUtilsTest {

    @Test
    void shouldMockStaticMethodWithParams() {

        try (MockedStatic<MyUtils> mockedStatic = mockStatic(MyUtils.class)) {
            mockedStatic.when(
                    () -> MyUtils.getWelcomeMessage(
                            eq("Yago"),
                            anyBoolean())).thenReturn("Howdy Yago!");

            String result = MyUtils.getWelcomeMessage("Yago", false);

            assertEquals("Howdy Yago!" , result);
        }
    }
}
