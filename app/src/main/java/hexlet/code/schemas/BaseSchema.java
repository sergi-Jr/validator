package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected List<Predicate<T>> validations = new LinkedList<>();

    public boolean isValid(T object) {
        return validations.stream().allMatch(validation -> validation.test(object));
    }

    public BaseSchema<T> required() {
        validations.add(Objects::nonNull);
        return this;
    }
}
