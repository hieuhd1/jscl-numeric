package jscl;

import jscl.math.numeric.Complex;
import jscl.math.numeric.Real;
import jscl.raw.RawNumber;
import jscl.raw.RawNumberCreator;
import jscl.raw.RawNumberType;
import org.jetbrains.annotations.NotNull;

/**
 * User: serso
 * Date: 1/31/12
 * Time: 11:14 AM
 */
public class JsclMathContextImpl implements JsclMathContext {

    @NotNull
    private final AngleUnit angleUnit;

    @NotNull
    private final NumeralBase numeralBase;

    @NotNull
    private final RawNumberCreator rawNumberType;

    private JsclMathContextImpl(@NotNull AngleUnit angleUnit,
                                @NotNull NumeralBase numeralBase,
                                @NotNull RawNumberCreator rawNumberType) {
        this.angleUnit = angleUnit;
        this.numeralBase = numeralBase;
        this.rawNumberType = rawNumberType;
    }

    public static JsclMathContext defaultInstance() {
        return new JsclMathContextImpl(AngleUnit.deg, NumeralBase.dec, RawNumberType.DOUBLE);
    }

    public static JsclMathContext newInstance(@NotNull final AngleUnit au,
                                              @NotNull final NumeralBase nb,
                                              @NotNull final RawNumberCreator rnt) {
        return new JsclMathContextImpl(au, nb, rnt);
    }

    @NotNull
    @Override
    public AngleUnit getAngleUnits() {
        return angleUnit;
    }

    @NotNull
    @Override
    public NumeralBase getNumeralBase() {
        return numeralBase;
    }

    @NotNull
    @Override
    public String format(@NotNull RawNumber value) throws NumeralBaseException {
        return String.valueOf(value.asDouble());
    }

    @NotNull
    @Override
    public String format(@NotNull RawNumber value, @NotNull NumeralBase nb) throws NumeralBaseException {
        return String.valueOf(value.asDouble());
    }

    @NotNull
    @Override
    public Real newReal(long value) {
        return Real.newInstance(this, rawNumberType.fromLong(value));
    }

    @NotNull
    @Override
    public RawNumber getPI() {
        return this.rawNumberType.getPI();
    }

    @NotNull
    @Override
    public RawNumber fromDouble(double value) {
        return this.rawNumberType.fromDouble(value);
    }

    @NotNull
    @Override
    public RawNumber fromLong(long value) {
        return this.rawNumberType.fromLong(value);
    }

    @NotNull
    @Override
    public RawNumber ZERO() {
        return rawNumberType.ZERO();
    }

    @NotNull
    @Override
    public RawNumber ONE() {
        return rawNumberType.ONE();
    }

    @NotNull
    @Override
    public RawNumber random() {
        return rawNumberType.random();
    }

    @NotNull
    @Override
    public Real newReal(double value) {
        return Real.newInstance(this, rawNumberType.fromDouble(value));
    }

    @NotNull
    @Override
    public Complex newComplex(long real, long imaginary) {
        return Complex.newInstance(this, rawNumberType.fromLong(real), rawNumberType.fromLong(imaginary));
    }

    @NotNull
    @Override
    public Complex newComplex(double real, double imaginary) {
        return Complex.newInstance(this, rawNumberType.fromDouble(real), rawNumberType.fromDouble(imaginary));
    }

    @NotNull
    @Override
    public Real randomReal() {
        return Real.newInstance(this, random());
    }
}
