package lesson4;

public class Functions {
    public static boolean isPrime(Integer number) {
        //простое 1,2,3,5
        if (number <= 0) return false;
        if (number <= 3) return true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    //123321 -polindrom
    //1235321
    //12
    public static boolean isPolindrome(String word) {
        if (word.length() < 2) {
            return true;
        }
        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }
        return isPolindrome(word.substring(1, word.length() - 1));

        //1235321 isPolindrome
        //235321  isPolindrome
        //353     isPolindrome
        //5       isPolindrome - true
    }


}
