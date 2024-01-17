package com.hrsoft.utils.seleniumfy;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS;
import static com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import java.io.File;
import java.io.InputStream;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * @author Annameni Srinivas
 *         <a href="mailto:sannameni@gmail.com">sannameni@gmail.com</a>
 */
public class TestObjectMapper extends JsonMapper {

    private static final long serialVersionUID = 2L;

    public synchronized static TestObjectMapper setMapper () {
        TestObjectMapper mapper = (TestObjectMapper) TestObjectMapper.builder ()
                                                                     .enable (ALLOW_NON_NUMERIC_NUMBERS)
                                                                     .enable (ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
                                                                     .disable (WRITE_DATES_AS_TIMESTAMPS)
                                                                     .disable (FAIL_ON_UNKNOWN_PROPERTIES)
                                                                     .build ();
        mapper.registerModule (new JavaTimeModule ());
        mapper.registerModule (new JodaModule ());
        mapper.setSerializationInclusion (NON_NULL);
        return mapper;
    }

    @Override
    public <T> T readValue (String content, Class <T> valueType) {
        try {
            return super.readValue (content, valueType);
        } catch (Exception e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    public <T> T readValue (byte[] content, Class <T> valueType) {
        try {
            return super.readValue (content, valueType);
        } catch (Exception e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    public <T> T readValue (String content, TypeReference <T> valueTypeRef) {
        try {
            return super.readValue (content, valueTypeRef);
        } catch (Exception e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    public <T> T readValue (File src, Class <T> valueType) {
        try {
            return super.readValue (src, valueType);
        } catch (Exception e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    public <T> T readValue (InputStream src, Class <T> valueType) {
        try {
            return super.readValue (src, valueType);
        } catch (Exception e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    public String writeValueAsString (Object value) {
        try {
            return super.writeValueAsString (value);
        } catch (Exception e) {
            throw new RuntimeException (e);
        }
    }

    public static TestObjectMapper.TestBuilder builder () {
        return new TestBuilder (new TestObjectMapper ());
    }

    public static class TestBuilder extends Builder {
        public TestBuilder (TestObjectMapper m) {
            super (m);
        }
    }

}
