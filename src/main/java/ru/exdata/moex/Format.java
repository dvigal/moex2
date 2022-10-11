package ru.exdata.moex;

import ru.exdata.moex.response.Response;
import ru.exdata.moex.response.JsonResponseMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.util.ArrayList;

public final class Format {
    private final HttpClient httpClient;
    private final URI uri;
    private final Query query;

    Format(final HttpClient httpClient, final URI uri, final Query query) {
        this.httpClient = httpClient;
        this.uri = uri;
        this.query = query;
    }

    public Request<String> asIs() {
        return new Request<>(httpClient, content -> content, uri, query);
    }

    public Request<Response> json() {
        return new Request<>(httpClient, JsonResponseMapper.JSON_RESPONSE_MAPPER, uri, addFormat(query, ".json"));
    }

    public Request<String> xml() {
        return new Request<>(httpClient, content -> content, uri, addFormat(query, ".xml"));
    }

    public Request<String> csv() {
        return new Request<>(httpClient, content -> content, uri, addFormat(query, ".csv"));
    }

    public Request<String> html() {
        return new Request<>(httpClient, content -> content, uri, addFormat(query, ".html"));
    }

    private Query addFormat(final Query query, final String format) {
        final var path = new ArrayList<>(query.path());
        if (!path.isEmpty()) {
            var lastIndex = path.size() - 1;
            path.set(lastIndex, path.get(lastIndex) + format);
        }
        return new Query(path, query.parameters());
    }

}
