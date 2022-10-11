package ru.exdata.moex;

import ru.exdata.moex.response.ResponseMapper;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class IssRequestHelper {

    protected static <T> T get(
            final HttpClient httpClient,
            final ResponseMapper<T> responseMapper,
            final URI uri,
            final Query query
    ) {
        try {
            final var uriBuilder = new URIBuilder(uri).setPathSegments(query.path());
            query.parameters().forEach(uriBuilder::addParameter);

            final var req = HttpRequest
                    .newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .uri(uriBuilder.build())
                    .GET()
                    .build();
            final var httpResponse = httpClient.send(req, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            final var body = httpResponse.body();
            return responseMapper.map(body);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
