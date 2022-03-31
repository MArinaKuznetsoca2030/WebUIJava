package lesson4;

import static java.lang.Math.sqrt;

public class AreaOfTheTriangle {

    public static float areaTringle(float a, float b, float c){
        float p = (a + b + c)/2;
        return (float) sqrt((p * (p - a) * (p - b) *(p - c)));


    }
}
