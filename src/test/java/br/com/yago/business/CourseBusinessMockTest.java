package br.com.yago.business;

import br.com.yago.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class CourseBusinessMockTest {

    CourseService mockService;
    CourseBusiness business;

    @BeforeEach
    void setup() {
        // Given / Arrange
        mockService = mock(CourseService.class);
        business = new CourseBusiness(mockService);
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAMock() {

        // When / Act
        var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");

        // Then / Assert
        assertEquals(4, filteredCourses.size());

    }
}