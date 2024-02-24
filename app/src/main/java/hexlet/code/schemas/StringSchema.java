package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

public final class StringSchema extends BaseSchema<String> {

    @Override
    public StringSchema required() {
        validations.put("required", s -> !StringUtils.isEmpty(s));
        return this;
    }

    public StringSchema minLength(int min) {
        validations.put("minLength", s -> s == null || min <= s.length());
        return this;
    }

    public StringSchema contains(String str) {
        validations.put("contains", s -> s == null || s.contains(str));
        return this;
    }
}
