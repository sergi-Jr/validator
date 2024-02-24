package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema<T, R> extends BaseSchema<Map<T, R>> {
    private Map<T, BaseSchema<R>> schemas;

    @Override
    public MapSchema<T, R> required() {
        super.required();
        return this;
    }

    public MapSchema<T, R> sizeof(int count) {
        validations.put("sizeof", m -> m == null || m.size() == count);
        return this;
    }

    public MapSchema<T, R> shape(Map<T, BaseSchema<R>> sch) {
        schemas = sch;
        validations.put("shape", this::applySchema);
        return this;
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
