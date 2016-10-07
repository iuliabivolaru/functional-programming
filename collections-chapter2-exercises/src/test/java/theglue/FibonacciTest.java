package theglue;

import org.junit.Assert;
import org.junit.Test;
import theglue.Fibonacci;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciTest {

    @Test
    public void givenAFibonacci_when_then() {
        Fibonacci fibo = new Fibonacci();
        Stream<BigInteger> fib = fibo.fibonacci();
        List<Integer> fiboList = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597,
                2584, 4181, 6765).subList(0, 10);
        List<BigInteger> expectedFiboList = fiboList.stream().map(element -> new BigInteger(element.toString())).collect(Collectors.toList());
        List<BigInteger> trimmedList = fib.limit(10).collect(Collectors.toList());
        Assert.assertEquals(fiboList, trimmedList);
    }
}
