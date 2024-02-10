package hexlet.code;

public class Validator {
    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }

    public <T, R> MapSchema<T, R> map() {
        return new MapSchema<>();
    }
}
