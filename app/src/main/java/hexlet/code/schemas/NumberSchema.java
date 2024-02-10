package hexlet.code;

public class NumberSchema extends BaseSchema<Integer> {
    private record Bound(int lower, int upper) { }

    private boolean isPositive;
    private Bound bounds;

    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        isPositive = true;
        return this;
    }

    public NumberSchema range(int lowerBound, int upperBound) {
        bounds = new Bound(lowerBound, upperBound);
        return this;
    }

    @Override
    public boolean isValid(Integer num) {
        boolean isValid = true;
        if (num == null) {
            return !isRequired();
        }

        isValid = isPositive ? 0 < num : isValid;
        isValid = bounds != null ? bounds.lower() <= num && num <= bounds.upper() : isValid;
        return isValid;
    }

}
