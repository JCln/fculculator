package calculator.android.sbm.ir.fculculator.calculation;

import com.udojava.evalex.Expression;
import java.math.BigDecimal;

/**
 * Created by babak on 8/2/2017.
 */

public class Calc implements ICalc {
    public BigDecimal eval(String s) {
        Expression expression1 = new Expression(s);
        BigDecimal bigdecimal = expression1.eval();
        return bigdecimal;
    }
}
