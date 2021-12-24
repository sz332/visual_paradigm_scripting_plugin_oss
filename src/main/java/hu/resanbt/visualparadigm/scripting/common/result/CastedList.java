package hu.resanbt.visualparadigm.scripting.common.result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CastedList {

    private final Object obj;

    private CastedList(Object obj) {
        this.obj = obj;
    }

    public static Optional<CastedList> of(Object obj) {
        if (obj != null && (isArray(obj) || isIterable(obj))) {
            return Optional.of(new CastedList(obj));
        }

        return Optional.empty();
    }

    private static boolean isArray(Object array) {
        return array != null && (array.getClass().isArray());
    }

    private static boolean isIterable(Object iterable) {
        return iterable instanceof Iterable;
    }

    public List<Object> asList() {

        if (obj instanceof Object[]) {
            return Arrays.asList((Object[]) obj);
        }

        if (obj instanceof boolean[]) {
            return Arrays.asList(obj);
        }

        if (obj instanceof byte[]) {
            return Arrays.asList(obj);
        }

        if (obj instanceof short[]) {
            return Arrays.asList(obj);
        }

        if (obj instanceof char[]) {
            return Arrays.asList(obj);
        }

        if (obj instanceof int[]) {
            return Arrays.asList(obj);
        }

        if (obj instanceof long[]) {
            return Arrays.asList(obj);
        }

        if (obj instanceof float[]) {
            return Arrays.asList(obj);
        }

        if (obj instanceof double[]) {
            return Arrays.asList(obj);
        }

        if (obj instanceof Iterable) {
            @SuppressWarnings("unchecked") var iterable = (Iterable<Object>) obj;
            var retValue = new ArrayList<>();
            iterable.forEach(retValue::add);
            return retValue;
        }

        return Arrays.asList("<<Array type not supported [" + obj.getClass().getComponentType().getName() + "]>>");
    }
}
