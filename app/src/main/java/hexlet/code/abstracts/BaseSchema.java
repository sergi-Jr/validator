package hexlet.code.abstracts;

public abstract class BaseSchema<T> {
    private boolean isRequired;

    public BaseSchema<T> required() {
        isRequired = true;
        return this;
    }

    public abstract boolean isValid(T object);

    public boolean isRequired() {
        return isRequired;
    }
}
