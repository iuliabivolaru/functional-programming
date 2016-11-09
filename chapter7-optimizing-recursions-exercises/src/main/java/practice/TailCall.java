package practice;

import java.math.BigInteger;

@FunctionalInterface
interface TailCall {

    TailCall apply();

    default boolean isComplete() {
        return false;
    }

    default BigInteger getResult(){
        throw new RuntimeException("Factorial is still running");
    }
}
