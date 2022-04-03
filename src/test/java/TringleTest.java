import lesson4.AreaOfTheTriangle;
import lesson4.Cat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TringleTest {
    private static Logger logger = LoggerFactory.getLogger(FunctionsTest.class);
    @ParameterizedTest
    @MethodSource("giveAreaTringleWhenDifferentABC")
    @DisplayName("Проверка площади треугольника с разным набором данных")

    void AreaTring(Integer a, Integer b, Integer c, float result){
        Assertions.assertEquals(AreaOfTheTriangle.areaTringle(a,b,c), result);
        logger.info("info log");
        logger.warn("warn log");
    }
    private static Stream<Arguments> giveAreaTringleWhenDifferentABC() {
        return Stream.of(
                Arguments.of(3, 4, 5, 6),
                Arguments.of(30,40,50,600)
        );
    }



}
