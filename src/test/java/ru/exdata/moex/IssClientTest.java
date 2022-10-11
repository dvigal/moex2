package ru.exdata.moex;

import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import ru.exdata.moex.response.Block;
import ru.exdata.moex.response.Cursor;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.stream.Collectors;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;


@WireMockTest
class IssClientTest {
    private IssClient issClient;

    @BeforeEach
    void setUp(WireMockRuntimeInfo info) throws URISyntaxException {
        issClient = IssClientBuilder.builder().uri(new URI("http://localhost:" + info.getHttpPort())).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Tag("Глобальные справочники ISS")
    @Test
    public void issIndex() {
        var json = readResource("/iss/index/get_index.json");
        stubFor(get("/iss/index.json").willReturn(ok(json)));

        var response = issClient.iss().index().format().json().get();

        assertThat(response).isNotNull();
        assertThat(response.findBlock("markets")).isPresent();
        assertThat(response.findBlock("boards")).isPresent();
        assertThat(response.findBlock("boardgroups")).isPresent();
        assertThat(response.findBlock("durations")).isPresent();
        assertThat(response.findBlock("securitytypes")).isPresent();
        assertThat(response.findBlock("securitygroups")).isPresent();
        assertThat(response.findBlock("securitycollections")).isPresent();
    }

    @Tag("Группы ценных бумаг")
    @Test
    public void issSecuritygroups() {
        var json = readResource("/iss/securitygroups/get_securitygroups.json");
        stubFor(get("/iss/securitygroups.json").willReturn(ok(json)));

        var response = issClient.iss().securitygroups().format().json().get();

        assertThat(response).isNotNull();
        assertThat(response.findBlock("securitygroups")).isPresent();
    }

    @Tag("Типы ценных бумаг")
    @Test
    public void issSecuritytypes() {
        var json = readResource("/iss/securitytypes/get_securitytypes.json");
        stubFor(get("/iss/securitytypes.json").willReturn(ok(json)));

        var response = issClient.iss().securitytypes().format().json().get();

        assertThat(response).isNotNull();
        assertThat(response.findBlock("securitytypes")).isPresent();
    }

    @Tag("Новости биржи")
    @Test
    public void issSitenews() {
        var json = readResource("/iss/sitenews/get_sitenews.json");
        stubFor(get("/iss/sitenews.json").willReturn(ok(json)));

        var response = issClient.iss().sitenews().format().json().get();

        assertThat(response).isNotNull();
        assertThat(response.findBlock("sitenews")).isPresent();
        assertThat(response.cursor()).isPresent();
        assertThat(response.cursor().map(Cursor::total)).isPresent();
    }

    @Tag("Мероприятия биржи")
    @Test
    public void issEvents() {
        var json = readResource("/iss/events/get_events.json");
        stubFor(get("/iss/events.json").willReturn(ok(json)));

        var response = issClient.iss().events().format().json().get();

        assertThat(response).isNotNull();
        assertThat(response.findBlock("events")).isNotNull();
        assertThat(response.cursor()).isNotNull();
    }

    @Tag("Торговые системы")
    @Test
    public void issEngines() {
        var json = readResource("/iss/engines/get_engines.json");
        stubFor(get("/iss/engines.json").willReturn(ok(json)));

        var response = issClient.iss().engines().format().json().get();

        assertThat(response.findBlock("engines")).isNotNull();
        assertThat(response.findBlock("engines").map(Block::getMetadata)).isNotNull();
        assertThat(response.findBlock("engines").map(Block::getColumns)).isNotNull();
        assertThat(response.findBlock("engines").map(Block::getData)).isNotNull();
    }

    @Tag("Бумаги")
    @Test
    public void issSecurities() {
        var json = readResource("/iss/securities/get_securities.json");
        stubFor(get("/iss/securities.json").willReturn(ok(json)));
        var response = issClient.iss().securities().format().json().get(Map.of());

        assertThat(response.findBlock("securities")).isPresent();
    }

    @Tag("Сводные обороты по рынкам")
    @Test
    public void issTurnovers() {
        var json = readResource("/iss/turnovers/get_turnovers.json");
        stubFor(get("/iss/turnovers.json").willReturn(ok(json)));

        var response = issClient.iss().turnovers().format().json().get();

        assertThat(response).isNotNull();
        assertThat(response.findBlock("turnovers")).isNotNull();
        assertThat(response.findBlock("turnoversprevdate")).isNotNull();
    }

    @Tag("История торгов для указанной бумаги на указанном режиме торгов за указанный интервал дат")
    @Test
    public void issHistoryEnginesEngineMarketsMarketBoardsBoardSecuritiesSecurity() {
        var json = readResource("/iss/engines/markets/securities/boards/get_sber.json");
        stubFor(get("/iss/history/engines/stock/markets/shares/boards/TQBR/securities/sber.json").willReturn(ok(json)));

        var request = issClient
                .iss()
                .history()
                .engines()
                .engine("stock")
                .markets()
                .market("shares")
                .boards()
                .board("TQBR")
                .securities()
                .security("sber")
                .format()
                .json();

        var response = request.get();

        assertThat(response).isNotNull();
        assertThat(response.findBlock("history")).isNotNull();
    }


    private String readResource(final String name) {
        var is = getClass().getResourceAsStream(name);
        if (is == null) {
            throw new RuntimeException("Resource not found by " + name);
        }
        try (var reader = new BufferedReader(new InputStreamReader(is))) {
            return reader.lines().collect(Collectors.joining());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}