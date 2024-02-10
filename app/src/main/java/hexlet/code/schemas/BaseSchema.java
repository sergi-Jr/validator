package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    private boolean isRequired;

    protected BaseSchema<T> required() {
        isRequired = true;
        return this;
    }

    public abstract boolean isValid(T object);

    public final boolean isRequired() {
        return isRequired;
    }
}
