package practice;

import java.math.BigInteger;
import java.util.stream.Stream;

import static practice.TailCalls.done;

public class Factorial {

    public static int factorialRec(int number) {
        if (number <= 1)
            return 1;
        return factorialRec(number - 1) * number;
    }

    public static TailCall factorialRecLambda(int number, BigInteger result) {
//        System.out.println(number);
//        System.out.println(result + "\n");
        if (number <= 1)
            return done(result);
        return () -> factorialRecLambda(number - 1, result.multiply(BigInteger.valueOf(number)));
    }

    public static void main(String[] args) {
        System.out.println(factorialRec(2000));
        TailCall factorialRecResult = factorialRecLambda(20000, BigInteger.ONE);
        System.out.println(Stream
                .iterate(factorialRecResult, TailCall::apply)
                .filter(TailCall::isComplete)
                .findFirst().get().getResult());
    }
}
