package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected List<Predicate<T>> validations = new LinkedList<>();

    /** Checks that all validations are pass
     * @param object Strongly parametrized object
     * @return true if all validations passed, false otherwise
     */
    public boolean isValid(T object) {
        return validations.stream().allMatch(validation -> validation.test(object));
    }

    /** Add non null validation
     * @return This object type
     */
    public BaseSchema<T> required() {
        validations.add(Objects::nonNull);
        return this;
    }
}
