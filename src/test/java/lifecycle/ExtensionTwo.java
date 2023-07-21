package lifecycle;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * @author Bingqi Xia
 * @version 1.0
 * @date 21/07/2023 16:04
 */
public class ExtensionTwo implements BeforeEachCallback, AfterEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        System.out.println("Before each from lifecycle.ExtensionTwo");
    }

    @Override
    public void afterEach(ExtensionContext context) {
        System.out.println("After each from lifecycle.ExtensionTwo");
    }
}
