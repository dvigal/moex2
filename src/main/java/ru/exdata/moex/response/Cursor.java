package ru.exdata.moex.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Cursor {
    private final Map<String, Object> metadata;
    private final List<String> columns;
    private final List<List<Integer>> data;

    @JsonCreator
    public Cursor(
            @JsonProperty("metadata")
            final Map<String, Object> metadata,
            @JsonProperty("columns")
            final List<String> columns,
            @JsonProperty("data")
            final List<List<Integer>> data
    ) {
        this.metadata = metadata;
        this.columns = columns;
        this.data = data;
    }

    public int index() {
        return fieldOrZero("INDEX");
    }

    public int total() {
        return fieldOrZero("TOTAL");
    }

    public int pageSize() {
        return fieldOrZero("PAGESIZE");
    }

    public boolean hasNext() {
        return index() + pageSize() < total();
    }

    public int nextIndex() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return index() + pageSize();
    }

    private int fieldOrZero(final String name) {
        var index = columns.indexOf(name);
        if (index == -1 || data.isEmpty()) {
            return 0;
        }
        return data.get(0).get(index);
    }

    @Override
    public String toString() {
        return "Cursor{" +
                "metadata=" + metadata +
                ", columns=" + columns +
                ", data=" + data +
                '}';
    }
}
