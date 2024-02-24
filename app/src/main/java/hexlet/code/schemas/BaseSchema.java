package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> validations = new LinkedHashMap<>();

    /** Checks that all validations are pass.
     * @param object Strongly parametrized object
     * @return true if all validations passed, false otherwise
     */
    public boolean isValid(T object) {
        return validations.values().stream().allMatch(v -> v.test(object));
    }

    /** Add non null validation.
     * @return This object type
     */
    public BaseSchema<T> required() {
        validations.put("required", Objects::nonNull);
        return this;
    }
}
