package jscl;

import jscl.math.numeric.Numeric;
import jscl.math.numeric.Real;
import jscl.raw.RawNumber;
import org.jetbrains.annotations.NotNull;

/**
 * User: serso
 * Date: 11/19/11
 * Time: 8:55 PM
 */
public enum AngleUnit {

    deg {
        @Override
        protected double getCoefficientTo(@NotNull AngleUnit to) {
            switch (to) {
                case deg:
                    return 1d;
                case rad:
                    return FROM_DEG_TO_RAD;
                case grad:
                    return FROM_DEG_TO_GRAD;
                case turns:
                    return FROM_DEG_TO_TURNS;
                default:
                    throw new UnsupportedOperationException("Conversion from " + this + " to " + to + " is not supported!");
            }
        }
    },

    rad {
        @Override
        protected double getCoefficientTo(@NotNull AngleUnit to) {
            switch (to) {
                case deg:
                    return FROM_RAD_TO_DEG;
                case rad:
                    return 1d;
                case grad:
                    return FROM_RAD_TO_GRAD;
                case turns:
                    return FROM_RAD_TO_TURNS;
                default:
                    throw new UnsupportedOperationException("Conversion from " + this + " to " + to + " is not supported!");
            }
        }
    },

    grad {
        @Override
        protected double getCoefficientTo(@NotNull AngleUnit to) {
            switch (to) {
                case deg:
                    return FROM_GRAD_TO_DEG;
                case rad:
                    return FROM_GRAD_TO_RAD;
                case grad:
                    return 1d;
                case turns:
                    return FROM_GRAD_TO_TURNS;
                default:
                    throw new UnsupportedOperationException("Conversion from " + this + " to " + to + " is not supported!");
            }
        }
    },

    turns {
        @Override
        protected double getCoefficientTo(@NotNull AngleUnit to) {
            switch (to) {
                case deg:
                    return FROM_TURNS_TO_DEG;
                case rad:
                    return FROM_TURNS_TO_RAD;
                case grad:
                    return FROM_TURNS_TO_GRAD;
                case turns:
                    return 1d;
                default:
                    throw new UnsupportedOperationException("Conversion from " + this + " to " + to + " is not supported!");
            }
        }
    };


    private static final double FROM_RAD_TO_DEG = 180d / Math.PI;
    private static final double FROM_RAD_TO_GRAD = 200d / Math.PI;
    private static final double FROM_RAD_TO_TURNS = 0.5d / Math.PI;

    private static final double FROM_DEG_TO_RAD = Math.PI / 180d;
    private static final double FROM_DEG_TO_TURNS = 0.5d / 180d;
    private static final double FROM_DEG_TO_GRAD = 10d / 9d;

    private static final double FROM_GRAD_TO_RAD = Math.PI / 200d;
    private static final double FROM_GRAD_TO_TURNS = 0.5d / 200d;
    private static final double FROM_GRAD_TO_DEG = 9d / 10d;

    private static final double FROM_TURNS_TO_GRAD = 200d / 0.5d;
    private static final double FROM_TURNS_TO_RAD = Math.PI / 0.5d;
    private static final double FROM_TURNS_TO_DEG = 180d / 0.5d;

    @NotNull
    public final RawNumber transform(@NotNull JsclMathContext mathContext, @NotNull AngleUnit to, @NotNull RawNumber value) {
        return value.multiply(mathContext.fromDouble(getCoefficientTo(to)));
    }

    protected abstract double getCoefficientTo(@NotNull AngleUnit to);

    public final Numeric transform(@NotNull JsclMathContext mathContext, @NotNull AngleUnit to, @NotNull Numeric value) {
        return value.multiply(getRealCoefficientTo(mathContext, to));
    }

    private Real getRealCoefficientTo(@NotNull JsclMathContext mathContext, @NotNull AngleUnit to) {
        return Real.newInstance(mathContext, mathContext.fromDouble(getCoefficientTo(to)));
    }
}
