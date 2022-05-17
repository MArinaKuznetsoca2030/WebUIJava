package lesson4;

public class Box {
    private Integer ballCount;

    public Box() {
        this.ballCount = 0;
    }

    public Integer getBallCount() {
        return ballCount;
    }

    public void addBall() {
        ballCount++;
    }

    public void deleteBall()  throws  BoxIsAlreadyEmptyException
    {
        if (ballCount ==0) {
            throw new BoxIsAlreadyEmptyException();
        }
        ballCount--;
    }

    public void shuffleBalls() {
        if (ballCount == 0) {
            throw new NullPointerException();
        }
        System.out.println("Помешали мячи");
    }
}
