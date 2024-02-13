package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        validations.add(n -> {
            if (n != null) {
                return 0 < n;
            }
            return true;
        });
        return this;
    }

    public NumberSchema range(int lowerBound, int upperBound) {
        validations.add(n -> {
            if (n != null){
                return lowerBound <= n && n <= upperBound;
            }
            return true;
        });
        return this;
    }
}
