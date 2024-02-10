package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    private boolean isRequired;

    /** Instructs the schema to check the passed object for the presence of that object.
     * @return BaseSchema type
     */
    protected BaseSchema<T> required() {
        isRequired = true;
        return this;
    }

    public abstract boolean isValid(T object);

    public final boolean isRequired() {
        return isRequired;
    }
}
