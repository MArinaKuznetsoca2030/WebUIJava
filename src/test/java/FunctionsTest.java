import lesson4.Cat;
import lesson4.Functions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static lesson4.Functions.*;
import static lesson4.Functions.isPrime;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunctionsTest {
    private static Logger logger = LoggerFactory.getLogger(FunctionsTest.class);
    // или строку private static Logger logger = LoggerFactory.getLogger("свой текст");

    @BeforeAll
    static void beforeAll() {
        System.out.println("метод выполнится 1 раз перед всеми тестами");
        logger.info("info log");
        logger.warn("warn log");
        //уровни логирования
        // TRACE, DEBUG, INFO, WARN, ERROR
        //если в logback.xml указан debug, то запишутся эти оба лога, таккак все что правее, то и записывется

        // mvn test -Dtest=FunctionsTest - запустить тест из консоли
        // export LOG_LEVEL=ERROR - установить уровень логирования через консоль - LOG_LEVEL переменная из xml

    }

    @BeforeEach
    void beforeEach() {
        System.out.println("метод выполнится перед каждым тестом");
    }

    @Test
    @DisplayName("Проверка простого числа")
            // именование названия тестов что нам дано  что мы хотим сделать то что мы ожидаем получить
    void givenPrimeNumberWhenCallsPrimeThenTrue(){
        boolean result = isPrime(7);
       // Assertions.assertEquals(4, 4);
        assertTrue(result);

   }

//   @Test
//   @DisplayName("Подробное описание цели теста")
//   void  isPalindromPositiveTest() {
//        assertTrue(isPolindrome("1235321"));
//
//   }
//
//    @Test
//    @DisplayName("Подробное описание цели теста")
//    void  isPalindromPositiveTest2() {
//        assertTrue(isPolindrome("1235321"));
//    }
        @ParameterizedTest
        @ValueSource(strings = {"1235321", "1235321"})
        void  isPalindromPositiveTest(String word) {
            assertTrue(isPolindrome(word));
        }

        @Test
        void isNoPolindrome(){
            assertFalse(isPolindrome("12"));
        }

        @ParameterizedTest
        @DisplayName("Подробное описание цели теста")
        @CsvSource({"true, 12321", "false, 12"})
        void commonPalindromeTest(boolean expectedResult, String word){
            assertEquals(expectedResult, isPolindrome( word));

        }

        @ParameterizedTest
        @MethodSource("catAndAgeDataProvider")
        void catTest (Cat cat, Integer age) {
        assertEquals(age, cat.getAge());
        }
        private static Stream<Arguments> catAndAgeDataProvider() {
            return Stream.of(
                    Arguments.of(new Cat("Barsik", 10), 10),
                    Arguments.of(new Cat("Myrzik", 10), 11)
            );
        }

    @AfterEach
    void afterEach() {
        System.out.println("метод выполнится 1 раз после каждого теста");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("метод выполнится 1 раз после всех тестов");
    }
}
