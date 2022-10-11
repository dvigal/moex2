package ru.exdata.moex;

import java.util.*;

final class Query {
    private final List<String> path;
    private final Map<String, String> parameters;

    public Query() {
        this.path = new ArrayList<>();
        this.parameters = new HashMap<>();
    }

    Query(final List<String> path, final Map<String, String> parameters) {
        this.path = path;
        this.parameters = parameters;
    }

    public Query addPath(final String path) {
        final var list = new ArrayList<>(this.path);
        list.add(path);
        return new Query(
                list,
                this.parameters
        );
    }

    public List<String> path() {
        return Collections.unmodifiableList(this.path);
    }

    public Query addParameter(final String key, final String value) {
        final var map = new HashMap<>(this.parameters);
        map.put(key, value);
        return new Query(
                this.path,
                map
        );
    }

    public Query addParameters(final Map<String, String> parameters) {
        return new Query(this.path, Map.copyOf(parameters));
    }

    public Map<String, String> parameters() {
        return Collections.unmodifiableMap(this.parameters);
    }
}
