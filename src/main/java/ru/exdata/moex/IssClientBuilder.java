package ru.exdata.moex;

import java.net.URI;
import java.net.http.HttpClient;

public class IssClientBuilder {
    private static final String MOEX_ISS_URI = "https://iss.moex.com";
    private URI uri;
    private HttpClient httpClient;

    private IssClientBuilder() {}

    public static IssClientBuilder builder() {
        return new IssClientBuilder();
    }

    public IssClient build() {
        try {
            var httpClient = this.httpClient != null ? this.httpClient : HttpClient.newBuilder().build();
            var uri = this.uri != null ? this.uri : new URI(MOEX_ISS_URI);
            return new IssClient(httpClient, uri);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public IssClientBuilder uri(final URI uri) {
        if (uri == null) {
            throw new IllegalArgumentException("uri must not be null");
        }
        this.uri = uri;
        return this;
    }

    public IssClientBuilder httpClient(final HttpClient httpClient) {
        if (httpClient == null) {
            throw new IllegalArgumentException("http client must not be null");
        }
        this.httpClient = httpClient;
        return this;
    }
}
