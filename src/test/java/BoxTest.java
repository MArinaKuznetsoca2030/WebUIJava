import lesson4.Box;
import org.junit.jupiter.api.*;

public class BoxTest {
    Box box;

    @Nested // вложенный
    class WhenEmpty {
        @BeforeEach
        void createBox() {
            box = new Box();
        }
        @Test
        void exceptionWhenTryToShuffleBoxTest() {
            Assertions.assertThrows(NullPointerException.class, () -> box.shuffleBalls());
        }

        @Test
        void addBallTest() {
            box.addBall();
            Assertions.assertEquals(box.getBallCount(), 1);

        }

        @Nested
        class WhenOnwBall {
            @BeforeEach
            void addBall() {
                box.addBall();
            }

            @Test
            void deleteBallTest() {
                Assertions.assertEquals(box.getBallCount(), 0);
            }

        }

    }

}
