package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @Test
    public void isValidTestStringSchema() {
        StringSchema schema = new Validator().string();
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("some string"));
        assertTrue(schema.isValid("hexlet"));

        schema.minLength(8);
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("some string"));
        assertFalse(schema.isValid("hexlet"));

        assertTrue(schema.contains("wh").isValid("what does the"));
        assertTrue(schema.contains("what").isValid("what does the"));
        assertFalse(schema.contains("whatthe").isValid("what does the"));
    }

    @Test
    public void isValidTestNumberSchema() {
        NumberSchema schema = new Validator().number();

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));

        assertTrue(schema.positive().isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(5));

        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));

        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }

    @Test
    public void isValidTestMapSchema() {
        MapSchema<String, String> schema = new Validator().map();

        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("k1", "v1");
        assertTrue(schema.isValid(data));

        schema.sizeOf(2);
        assertFalse(schema.isValid(data));
        data.put("k2", "v2");
        assertTrue(schema.isValid(data));
    }

    @Test
    public void isValidTestMapSchemaShape() {
        Validator validator = new Validator();
        MapSchema<String, String> schema = validator.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));

        schema.shape(schemas);
        Map<String, String> h1 = new HashMap<>();
        h1.put("firstName", "John");
        h1.put("lastName", "Smith");
        assertTrue(schema.isValid(h1));

        Map<String, String> h2 = new HashMap<>();
        h1.put("firstName", "John");
        h1.put("lastName", null);
        assertFalse(schema.isValid(h2));

        Map<String, String> h3 = new HashMap<>();
        h1.put("firstName", "John");
        h1.put("lastName", "B");
        assertFalse(schema.isValid(h3));
    }
}
