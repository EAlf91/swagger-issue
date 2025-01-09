package org.example;

import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.models.media.JsonSchema;
import org.junit.jupiter.api.Test;


class MainTest {

    record TestDto (@Schema(example = "notANumber") String name, int age) {}
    record TestDtoClone (@Schema(example = "1234") String name, int age) {}

    record TestDtoCloneTyping (@Schema(example = "1234", type = "string") String name, int age) {}
    @Test
    void shouldReturnStringProperty(){
        var converter = ModelConverters.getInstance(true);
        var actual = converter.read(TestDto.class);
        JsonSchema schema = (JsonSchema) actual.get("TestDto").getProperties().get("name");
        assert schema.getExample() instanceof String;
    }

    @Test
    void shouldReturnStringPropertyForNumbers(){
        var converter = ModelConverters.getInstance(true);
        var actual = converter.read(TestDtoClone.class);
        JsonSchema schema = (JsonSchema) actual.get("TestDtoClone").getProperties().get("name");
        assert schema.getExample() instanceof String;
    }


    @Test
    void shouldReturnStringPropertyForNumbersWithExplicitTyping(){
        var converter = ModelConverters.getInstance(true);
        var actual = converter.read(TestDtoCloneTyping.class);
        JsonSchema schema = (JsonSchema) actual.get("TestDtoCloneTyping").getProperties().get("name");
        assert schema.getExample() instanceof String;
    }



}