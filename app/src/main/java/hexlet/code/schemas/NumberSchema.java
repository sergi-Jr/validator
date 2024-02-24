package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        validations.put("positive", n -> n == null || n > 0);
        return this;
    }

    public NumberSchema range(int lowerBound, int upperBound) {
        validations.put("range", n -> n == null || (lowerBound <= n && n <= upperBound));
        return this;
    }
}
