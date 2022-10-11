package ru.exdata.moex.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResponseMapper implements ResponseMapper<Response> {
    public static final JsonResponseMapper JSON_RESPONSE_MAPPER = new JsonResponseMapper();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Response map(final String content) {
        try {
            return objectMapper.readValue(content, Response.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
