package nested;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * @author Bingqi Xia
 * @version 1.0
 * @date 21/07/2023 16:13
 */

class NestedTest {
    @Nested
    @DisplayName("Creating a product")
    class Post {
        @Nested
        @DisplayName("when fields are missing")
        class WhenFieldsAreMissing {
            @Test
            @DisplayName("return HTTP status Bad Request")
            void returnHttpStatusBadRequest() throws Exception { }

            @Test
            @DisplayName("do not create a product")
            void doNotCreateProduct() throws Exception { }
        }

        @Nested
        @DisplayName("when fields are valid")
        class WhenFieldsAreValid {
            @Test
            @DisplayName("return HTTP status Created")
            void returnHttpStatusCreated() throws Exception { }
        }
    }

    @Nested
    @DisplayName("Finding a product")
    class GetById {
        @Nested
        @DisplayName("when product is not found")
        class WhenProductIsNotFound {
            @Test
            @DisplayName("return HTTP status Not Found")
            void returnHttpStatusNotFound() throws Exception { }
        }

        @Nested
        @DisplayName("when product is found")
        class WhenProductIsFound {
            @Test
            @DisplayName("return HTTP status OK")
            void returnHttpStatusOk() throws Exception { }

            @Test
            @DisplayName("return found product as JSON")
            void returnFoundProductAsJson() throws Exception { }
        }
    }

    @Nested
    @DisplayName("Deleting a product")
    class Delete {
        @Nested
        @DisplayName("when product is not found")
        class WhenProductIsNotFound {
            @Test
            @DisplayName("return HTTP status Not Found")
            void returnHttpStatusNotFound() throws Exception { }
        }

        @Nested
        @DisplayName("when product is found")
        class WhenProductIsFound {
            @Test
            @DisplayName("return HTTP status No Content")
            void returnHttpStatusNoContent() throws Exception { }
        }
    }
}

