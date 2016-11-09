package practice;

import java.math.BigInteger;

public class TailCalls {

    static TailCall done(BigInteger result){
        return new TailCall() {
            @Override
            public TailCall apply() {
                return null;
            }

            @Override
            public boolean isComplete() {
                return true;
            }

            @Override
            public BigInteger getResult(){
                return result;
            }
        };
    }

    static TailCall call(TailCall tailCall) {
        return tailCall;
    }
}
