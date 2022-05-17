import lesson4.Functions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class AssertJExamplesTest {

    @Test
    void assertJExample() {
        assertThat(Functions.isPrime(5)).isTrue();
        List<String> strings = new ArrayList<>(Arrays.asList("test1", "test2","test"));
        assertThat(strings).containsAnyOf("testZ", "test2");

    }
}
