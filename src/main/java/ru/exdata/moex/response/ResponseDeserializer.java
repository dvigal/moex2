package ru.exdata.moex.response;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class ResponseDeserializer extends StdDeserializer<Response> {
    private static final String CURSOR_FIELD_SUFFIX = ".cursor";

    public ResponseDeserializer() {
        this(null);
    }

    protected ResponseDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Response deserialize(
            final JsonParser jsonParser,
            final DeserializationContext deserializationContext) throws IOException
    {
        final var responseBuilder = Response.builder();
        final var rootNode = jsonParser.getCodec().readTree(jsonParser);
        final var names = rootNode.fieldNames();
        while (names.hasNext()) {
            var name = names.next();
            if (name == null || name.isBlank()) {
                continue;
            }
            if (name.contains(CURSOR_FIELD_SUFFIX)) {
                responseBuilder.cursor(rootNode.get(name).traverse(jsonParser.getCodec()).readValueAs(Cursor.class));
            } else {
                responseBuilder.addBlock(name, rootNode.get(name).traverse(jsonParser.getCodec()).readValueAs(Block.class));
            }
        }
        return responseBuilder.build();
    }
}
