package ru.exdata.moex;

import ru.exdata.moex.response.ResponseMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.util.Collections;
import java.util.Map;

public final class Request<T> {
    private final ResponseMapper<T> responseMapper;
    private final HttpClient httpClient;
    private final URI uri;
    private final Query query;

    Request(
            final HttpClient httpClient,
            final ResponseMapper<T> responseMapper,
            final URI uri,
            final Query query
    ) {
        this.httpClient = httpClient;
        this.responseMapper = responseMapper;
        this.uri = uri;
        this.query = query;
    }

    public T get(final Map<String, String> parameters) {
        return IssRequestHelper.get(httpClient, responseMapper, uri, query.addParameters(parameters));
    }

    public T get() {
        return get(Collections.emptyMap());
    }
}
