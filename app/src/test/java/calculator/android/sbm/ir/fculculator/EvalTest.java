package calculator.android.sbm.ir.fculculator;

import org.junit.Test;

import java.math.BigDecimal;

import calculator.android.sbm.ir.fculculator.calculation.Calc;
import calculator.android.sbm.ir.fculculator.calculation.ICalc;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class EvalTest {
    @Test
    public void evalTest() {
        ICalc test = new Calc();
        BigDecimal evalResult= test.eval("1+3");
        BigDecimal expectedResult=new BigDecimal(4);
        assertEquals(expectedResult,evalResult);
    }
}