package win.hgfdodo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;

class CrcCalculatorTest {

    private final String data = "123456789";
    private final long crc8Result = 244;
    private CrcCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new CrcCalculator(Crc8.Crc8);
    }

    @Test
    void calc() {
        long result = calculator.calc(data.getBytes(), 0, data.length());
        Assertions.assertEquals(crc8Result, result);
    }

    @Test
    void test() {
        Check(Crc8.Params);

        Check(Crc16.Params);

        Check(Crc32.Params);

        Check(Crc64.Params);
    }

    private static void Check(AlgoParams[] params) {
        for (int i = 0; i < params.length; i++) {
            CrcCalculator calculator = new CrcCalculator(params[i]);
            long result = calculator.calc(CrcCalculator.TestBytes, 0, CrcCalculator.TestBytes.length);
            if (result != calculator.Parameters.Check)
                out.println(calculator.Parameters.Name + " - BAD ALGO!!! " + Long.toHexString(result).toUpperCase());
        }
    }
}