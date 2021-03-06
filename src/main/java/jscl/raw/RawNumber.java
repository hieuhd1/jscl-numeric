package jscl.raw;

import jscl.math.Arithmetic;
import org.jetbrains.annotations.NotNull;

/**
 * User: serso
 * Date: 1/30/12
 * Time: 1:41 PM
 */
public interface RawNumber extends Arithmetic<RawNumber>, Comparable<RawNumber> {

    @NotNull
    RawNumber negate();

    int signum();

    @NotNull
    RawNumber sqrt();

    @NotNull
    RawNumber atan2(@NotNull RawNumber that);

    @NotNull
    RawNumber log();

    @NotNull
    RawNumber log10();

    @NotNull
    RawNumber sin();

    @NotNull
    RawNumber cos();

    @NotNull
    RawNumber exp();

    boolean isZero();

    boolean isOne();

    boolean positive();

    boolean negative();

    @NotNull
    RawNumber pow(@NotNull RawNumber that);

    @NotNull
    RawNumber acos();

    boolean isNaN();

    @NotNull
    RawNumber asin();

    @NotNull
    RawNumber atan();

    @NotNull
    RawNumber tan();

    @NotNull
    DoubleRawNumber asDoubleRawNumber();

    double asDouble();

    @NotNull
    BigDecimalRawNumber asBigDecimalRawNumber();

    boolean equals(Object o);

    boolean mathEquals(@NotNull RawNumber that);
}
