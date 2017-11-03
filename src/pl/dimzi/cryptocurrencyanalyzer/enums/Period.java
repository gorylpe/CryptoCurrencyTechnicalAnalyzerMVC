package pl.dimzi.cryptocurrencyanalyzer.enums;

import java.util.function.BiFunction;
import java.util.function.Function;

public enum Period {
    DAILY(  (period, size) -> period + size * 24 * 3600,
            (period) -> (period / (24 * 3600)) * 24 * 3600);

    private String name;
    private BiFunction<Long, Long, Long> addFunction;
    Function<Long, Long> floorFunction;

    Period(BiFunction<Long, Long, Long> addFunction,
           Function<Long, Long> floorFunction){
        name = name();
        this.addFunction = addFunction;
        this.floorFunction = floorFunction;
    }

    public String getName(){
        return name;
    }

    public long addPeriod(long timeToAddTo, long size){
        return addFunction.apply(timeToAddTo, size);
    }

    public long floorToPeriodType(long time){
        return floorFunction.apply(time);
    }
}