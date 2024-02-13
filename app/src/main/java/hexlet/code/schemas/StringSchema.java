package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

public final class StringSchema extends BaseSchema<String> {

    @Override
    public StringSchema required() {
        validations.add(s -> !StringUtils.isEmpty(s));
        return this;
    }

    public StringSchema minLength(int min) {
        validations.add(s -> {
            if (s != null) {
                return min <= s.length();
            }
            return true;
        });
        return this;
    }

    public StringSchema contains(String str) {
        validations.add(s -> {
            if (s != null) {
                return s.contains(str);
            }
            return true;
        });
        return this;
    }
}
