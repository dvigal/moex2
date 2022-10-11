package ru.exdata.moex.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@JsonDeserialize(using = ResponseDeserializer.class)
public class Response {
    private final Map<String, Block> blocks;
    private final Cursor cursor;

    private Response(Map<String, Block> blocks, Cursor cursor) {
        this.blocks = blocks;
        this.cursor = cursor;
    }

    public Optional<Block> findBlock(final String block) {
        return Optional
                .ofNullable(blocks)
                .map(blocks -> blocks.getOrDefault(block, null));
    }

    public Optional<Cursor> cursor() {
        return Optional.ofNullable(cursor);
    }

    @Override
    public String toString() {
        return "Response{" +
                "blocks=" + blocks +
                ", cursor=" + cursor +
                '}';
    }

    public static ResponseBuilder builder() {
        return new ResponseBuilder();
    }

    public static class ResponseBuilder {
        private Cursor cursor;
        private Map<String, Block> blocks;

        public ResponseBuilder cursor(Cursor cursor) {
            this.cursor = cursor;
            return this;
        }

        public ResponseBuilder blocks(Map<String, Block> blocks) {
            this.blocks = blocks;
            return this;
        }

        public ResponseBuilder addBlock(String name, Block block) {
            if (name == null || name.isBlank()) {
                return this;
            }
            if (blocks == null) {
                blocks = new HashMap<>();
            }
            blocks.put(name, block);
            return this;
        }

        public Response build() {
            return new Response(blocks, cursor);
        }
    }
}
