package ru.exdata.moex.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class Block {
    private final Map<String, Object> metadata;
    private final List<String> columns;
    private final List<List<Object>> data;

    @JsonCreator
    public Block(
            @JsonProperty("metadata")
            final Map<String, Object> metadata,
            @JsonProperty("column")
            final List<String> columns,
            @JsonProperty("data")
            final List<List<Object>> data
    ) {
        this.metadata = metadata;
        this.columns = columns;
        this.data = data;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public List<String> getColumns() {
        return columns;
    }

    public List<List<Object>> getData() {
        return data;
    }

    public boolean isEmpty() {
        return getData() == null || getData().isEmpty();
    }

    @Override
    public String toString() {
        return "Block{" +
                "metadata=" + metadata +
                ", columns=" + columns +
                ", data=" + data +
                '}';
    }
}
