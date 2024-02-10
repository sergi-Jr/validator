package hexlet.code.schemas;

import hexlet.code.abstracts.BaseSchema;

import java.util.Map;

public final class MapSchema<T, R> extends BaseSchema<Map<T, R>> {
    private int size;
    private Map<T, BaseSchema<R>> schemas;

    public MapSchema<T, R> required() {
        super.required();
        return this;
    }

    public MapSchema<T, R> sizeOf(int count) {
        size = count;
        return this;
    }

    public MapSchema<T, R> shape(Map<T, BaseSchema<R>> sch) {
        schemas = sch;
        return this;
    }

    @Override
    public boolean isValid(Map<T, R> map) {
        boolean isValid = true;
        if (map == null) {
            return !isRequired();
        }

        isValid = size != 0 ? map.size() == size : isValid;
        isValid = schemas != null ? applySchema(map) : isValid;

        return isValid;
    }

    private boolean applySchema(Map<T, R> map) {
        for (Map.Entry<T, BaseSchema<R>> entry : schemas.entrySet()) {
            T key = entry.getKey();
            BaseSchema<R> sch = entry.getValue();
            if (!sch.isValid(map.get(key))) {
                return false;
            }
        }
        return true;
    }
}
