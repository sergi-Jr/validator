package hexlet.code;

import org.apache.commons.lang3.StringUtils;

public class StringSchema extends BaseSchema<String> {
    private int minLength;
    private String sequence;

    public StringSchema required() {
        super.required();
        return this;
    }

    public StringSchema minLength(int min) {
        minLength = min;
        return this;
    }


    public StringSchema contains(String str) {
        sequence = str;
        return this;
    }

    @Override
    public boolean isValid(String str) {
        boolean isValid;
        if (StringUtils.isEmpty(str)) {
            return !isRequired();
        }

        isValid = minLength <= str.length();
        isValid = sequence != null ? str.contains(sequence) : isValid;

        return isValid;
    }
}
