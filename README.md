
# Обзор MOEX2

## Что это?
Реализация Java клиента к интерфейсу [Информационного-статистического сервера Московской Биржи](https://iss.moex.com/iss/reference) 

### Почему moex2?

Следующая генерация библиотеки [moex](https://github.com/dvigal/moex)

### Особенности реализации

* Большая часть кода (99%) сгенерирована с помощью библиотеки [Javapoet](https://github.com/square/javapoet)
* Запросы конструируются через цепочку вызовов методов ([Fluent API](https://en.wikipedia.org/wiki/Fluent_interface)), например:
```java
var history = client
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
        .format().json() // Выбираем формат JSON
        .get(Map.of("from", "2020-01-03", "till", "2020-10-03")); // Задаем параметры и выполняем запрос 
```

## Начало работы
### Создание экземпляра клиента

```java
import ru.exdata.moex.IssClientBuilder;

var client = IssClientBuilder.builder().build()
```

### Форматы ответов
Согласно официальной документации, формат в котором необходимо получить данные, указывается в конце основной части
URL через точку и поддерживаются XML, CSV, JSON, HTML.

Клиент, предоставляет способ выбрать нужный формат следующим образом:

```java
// str - объект класса String
var str = issClient.iss().index().format().asIs().get();

// json - объект класса Response
var json = issClient.iss().index().format().json().get();

// xml - объект класса String
var xml = issClient.iss().index().format().xml().get();

// csv - объект класса String
var csv = issClient.iss().index().format().csv().get();

// html - объект класса String
var html = issClient.iss().index().format().html().get();
```

### Конструирование запроса

Рассмотрим работу библиотеки на примере запроса получения истории по одной бумаге на фондовом рынке

#### Параметры запроса
Параметры передаются в метод ```get```, как экземпляр объекта класса, реализующего интерфейс ```java.lang.Map<K,V>``` 
```java
var request = client
        .iss()
        .history()
        .engines()
        .engine("stock")
        .markets()
        .market("shares")
        .securities()
        .security("MOEX")
        .format()
        .json();

// Экземпляр объекта класса Response
var response = request.get(Map.of("from", "2022-10-10", "till", "2022-10-14"));
```

#### Пагинация
Как следует из документации [MOEX ISS](https://www.moex.com/a2193)
> Для некоторых запросов также доступен специальный блок данных "cursor",
указывающий текущую позицию отдаваемый данных относительно всего объёма
данных, доступных по этому запросу.

Поэтому, для навигации по страницам, нужно использовать объект Qursor,
получить который можно с помощью метода ```qursor``` у объекта класса ```Response```.
```java
response
    .cursor()
    .filter(Cursor::hasNext)
    .map(cursor -> request.get(Map.of(
            "start", String.valueOf(cursor.nextIndex()),
            "from", "2020-01-03",
            "till", "2022-10-03"
    )));
```

## Поддерживаемые запросы
- [x] [/iss/analyticalproducts/curves/securities](https://iss.moex.com/iss/reference/859)
- [x] [/iss/analyticalproducts/curves/securities/[security]](https://iss.moex.com/iss/reference/861)
- [x] [/iss/analyticalproducts/futoi/securities](https://iss.moex.com/iss/reference/807)
- [x] [/iss/analyticalproducts/futoi/securities/[security]](https://iss.moex.com/iss/reference/809)
- [x] [/iss/analyticalproducts/netflow2/securities](https://iss.moex.com/iss/reference/767)
- [x] [/iss/analyticalproducts/netflow2/securities/[security]](https://iss.moex.com/iss/reference/769)
- [x] [/iss/archives/engines/[engine]/markets/[market]/[datatype]/[period]](https://iss.moex.com/iss/reference/116)
- [x] [/iss/archives/engines/[engine]/markets/[market]/[datatype]/years](https://iss.moex.com/iss/reference/114)
- [x] [/iss/archives/engines/[engine]/markets/[market]/[datatype]/years/[year]/months](https://iss.moex.com/iss/reference/115)
- [x] [/iss/engines](https://iss.moex.com/iss/reference/40)
- [x] [/iss/engines/[engine]](https://iss.moex.com/iss/reference/41)
- [x] [/iss/engines/[engine]/markets](https://iss.moex.com/iss/reference/42)
- [x] [/iss/engines/[engine]/markets/[market]](https://iss.moex.com/iss/reference/44)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups](https://iss.moex.com/iss/reference/45)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]](https://iss.moex.com/iss/reference/50)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/orderbook](https://iss.moex.com/iss/reference/38)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities](https://iss.moex.com/iss/reference/29)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]](https://iss.moex.com/iss/reference/58)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]/candleborders](https://iss.moex.com/iss/reference/158)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]/candles](https://iss.moex.com/iss/reference/157)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]/orderbook](https://iss.moex.com/iss/reference/59)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]/trades](https://iss.moex.com/iss/reference/60)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/trades](https://iss.moex.com/iss/reference/37)
- [x] [/iss/engines/[engine]/markets/[market]/boards](https://iss.moex.com/iss/reference/43)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]](https://iss.moex.com/iss/reference/49)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/orderbook](https://iss.moex.com/iss/reference/39)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/securities](https://iss.moex.com/iss/reference/32)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/securities/[security]](https://iss.moex.com/iss/reference/53)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/securities/[security]/candleborders](https://iss.moex.com/iss/reference/48)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/securities/[security]/candles](https://iss.moex.com/iss/reference/46)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/securities/[security]/orderbook](https://iss.moex.com/iss/reference/57)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/securities/[security]/trades](https://iss.moex.com/iss/reference/56)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/trades](https://iss.moex.com/iss/reference/34)
- [x] [/iss/engines/[engine]/markets/[market]/orderbook](https://iss.moex.com/iss/reference/36)
- [x] [/iss/engines/[engine]/markets/[market]/secstats](https://iss.moex.com/iss/reference/823)
- [x] [/iss/engines/[engine]/markets/[market]/securities](https://iss.moex.com/iss/reference/33)
- [x] [/iss/engines/[engine]/markets/[market]/securities/[security]](https://iss.moex.com/iss/reference/52)
- [x] [/iss/engines/[engine]/markets/[market]/securities/[security]/candleborders](https://iss.moex.com/iss/reference/156)
- [x] [/iss/engines/[engine]/markets/[market]/securities/[security]/candles](https://iss.moex.com/iss/reference/155)
- [x] [/iss/engines/[engine]/markets/[market]/securities/[security]/orderbook](https://iss.moex.com/iss/reference/54)
- [x] [/iss/engines/[engine]/markets/[market]/securities/[security]/trades](https://iss.moex.com/iss/reference/55)
- [x] [/iss/engines/[engine]/markets/[market]/trades](https://iss.moex.com/iss/reference/35)
- [x] [/iss/engines/[engine]/markets/[market]/turnovers](https://iss.moex.com/iss/reference/96)
- [x] [/iss/engines/[engine]/markets/zcyc](https://iss.moex.com/iss/reference/89)
- [x] [/iss/engines/[engine]/turnovers](https://iss.moex.com/iss/reference/95)
- [x] [/iss/engines/[engine]/zcyc](https://iss.moex.com/iss/reference/634)
- [x] [/iss/events](https://iss.moex.com/iss/reference/193)
- [x] [/iss/events/[event_id]](https://iss.moex.com/iss/reference/194)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/dates](https://iss.moex.com/iss/reference/51)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/listing](https://iss.moex.com/iss/reference/120)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities](https://iss.moex.com/iss/reference/67)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities](https://iss.moex.com/iss/reference/152)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]](https://iss.moex.com/iss/reference/68)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]](https://iss.moex.com/iss/reference/153)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]/dates](https://iss.moex.com/iss/reference/69)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/yields](https://iss.moex.com/iss/reference/799)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/yields/[security]](https://iss.moex.com/iss/reference/801)
- [x] [/iss/history/engines/[engine]/markets/[market]/boards/[board]/dates](https://iss.moex.com/iss/reference/26)
- [x] [/iss/history/engines/[engine]/markets/[market]/boards/[board]/listing](https://iss.moex.com/iss/reference/119)
- [x] [/iss/history/engines/[engine]/markets/[market]/boards/[board]/securities](https://iss.moex.com/iss/reference/64)
- [x] [/iss/history/engines/[engine]/markets/[market]/boards/[board]/securities/[security]](https://iss.moex.com/iss/reference/65)
- [x] [/iss/history/engines/[engine]/markets/[market]/boards/[board]/securities/[security]/dates](https://iss.moex.com/iss/reference/66)
- [x] [/iss/history/engines/[engine]/markets/[market]/boards/[board]/yields](https://iss.moex.com/iss/reference/795)
- [x] [/iss/history/engines/[engine]/markets/[market]/boards/[board]/yields/[security]](https://iss.moex.com/iss/reference/797)
- [x] [/iss/history/engines/[engine]/markets/[market]/dates](https://iss.moex.com/iss/reference/83)
- [x] [/iss/history/engines/[engine]/markets/[market]/listing](https://iss.moex.com/iss/reference/118)
- [x] [/iss/history/engines/[engine]/markets/[market]/securities](https://iss.moex.com/iss/reference/62)
- [x] [/iss/history/engines/[engine]/markets/[market]/securities/[security]](https://iss.moex.com/iss/reference/63)
- [x] [/iss/history/engines/[engine]/markets/[market]/securities/[security]/dates](https://iss.moex.com/iss/reference/61)
- [x] [/iss/history/engines/[engine]/markets/[market]/session/[session]/boardgroups/[boardgroup]/securities](https://iss.moex.com/iss/reference/825)
- [x] [/iss/history/engines/[engine]/markets/[market]/sessions](https://iss.moex.com/iss/reference/811)
- [x] [/iss/history/engines/[engine]/markets/[market]/sessions/[session]/boardgroups/[boardgroup]/securities/[security]](https://iss.moex.com/iss/reference/819)
- [x] [/iss/history/engines/[engine]/markets/[market]/sessions/[session]/boards/[board]/securities](https://iss.moex.com/iss/reference/821)
- [x] [/iss/history/engines/[engine]/markets/[market]/sessions/[session]/boards/[board]/securities/[security]](https://iss.moex.com/iss/reference/815)
- [x] [/iss/history/engines/[engine]/markets/[market]/sessions/[session]/securities](https://iss.moex.com/iss/reference/813)
- [x] [/iss/history/engines/[engine]/markets/[market]/sessions/[session]/securities/[security]](https://iss.moex.com/iss/reference/817)
- [x] [/iss/history/engines/[engine]/markets/[market]/yields](https://iss.moex.com/iss/reference/791)
- [x] [/iss/history/engines/[engine]/markets/[market]/yields/[security]](https://iss.moex.com/iss/reference/793)
- [x] [/iss/history/engines/stock/markets/shares/securities/changeover](https://iss.moex.com/iss/reference/123)
- [x] [/iss/history/engines/stock/totals/boards](https://iss.moex.com/iss/reference/161)
- [x] [/iss/history/engines/stock/totals/boards/[board]/securities](https://iss.moex.com/iss/reference/163)
- [x] [/iss/history/engines/stock/totals/boards/[board]/securities/[security]](https://iss.moex.com/iss/reference/164)
- [x] [/iss/history/engines/stock/totals/securities](https://iss.moex.com/iss/reference/162)
- [x] [/iss/history/engines/stock/zcyc](https://iss.moex.com/iss/reference/783)
- [x] [/iss/history/otc/providers/nsd/markets](https://iss.moex.com/iss/reference/833)
- [x] [/iss/history/otc/providers/nsd/markets/[market]/daily](https://iss.moex.com/iss/reference/835)
- [x] [/iss/history/otc/providers/nsd/markets/[market]/monthly](https://iss.moex.com/iss/reference/837)
- [x] [/iss/index](https://iss.moex.com/iss/reference/28)
- [x] [/iss/rms/engines/[engine]/objects/irr](https://iss.moex.com/iss/reference/764)
- [x] [/iss/rms/engines/[engine]/objects/irr/filters](https://iss.moex.com/iss/reference/766)
- [x] [/iss/securities](https://iss.moex.com/iss/reference/5)
- [x] [/iss/securities/[security]](https://iss.moex.com/iss/reference/13)
- [x] [/iss/securities/[security]/aggregates](https://iss.moex.com/iss/reference/214)
- [x] [/iss/securities/[security]/indices](https://iss.moex.com/iss/reference/160)
- [x] [/iss/securitygroups](https://iss.moex.com/iss/reference/127)
- [x] [/iss/securitygroups/[securitygroup]](https://iss.moex.com/iss/reference/128)
- [x] [/iss/securitygroups/[securitygroup]/collections](https://iss.moex.com/iss/reference/129)
- [x] [/iss/securitygroups/[securitygroup]/collections/[collection]](https://iss.moex.com/iss/reference/130)
- [x] [/iss/securitygroups/[securitygroup]/collections/[collection]/securities](https://iss.moex.com/iss/reference/131)
- [x] [/iss/securitytypes](https://iss.moex.com/iss/reference/132)
- [x] [/iss/securitytypes/[securitytype]](https://iss.moex.com/iss/reference/133)
- [x] [/iss/sitenews](https://iss.moex.com/iss/reference/191)
- [x] [/iss/sitenews/[news_id]](https://iss.moex.com/iss/reference/192)
- [x] [/iss/statistics/engines/[engine]/derivatives/[report_name]](https://iss.moex.com/iss/reference/219)
- [x] [/iss/statistics/engines/[engine]/markets/[market]](https://iss.moex.com/iss/reference/771)
- [x] [/iss/statistics/engines/[engine]/markets/[market]/securities](https://iss.moex.com/iss/reference/773)
- [x] [/iss/statistics/engines/[engine]/markets/[market]/securities/[security]](https://iss.moex.com/iss/reference/775)
- [x] [/iss/statistics/engines/[engine]/monthly/[report_name]](https://iss.moex.com/iss/reference/220)
- [x] [/iss/statistics/engines/currency/markets/fixing](https://iss.moex.com/iss/reference/716)
- [x] [/iss/statistics/engines/currency/markets/fixing/[security]](https://iss.moex.com/iss/reference/715)
- [x] [/iss/statistics/engines/currency/markets/selt/rates](https://iss.moex.com/iss/reference/168)
- [x] [/iss/statistics/engines/futures/markets/indicativerates/securities](https://iss.moex.com/iss/reference/711)
- [x] [/iss/statistics/engines/futures/markets/indicativerates/securities/[security]](https://iss.moex.com/iss/reference/712)
- [x] [/iss/statistics/engines/futures/markets/options/assets](https://iss.moex.com/iss/reference/873)
- [x] [/iss/statistics/engines/futures/markets/options/assets/[asset]](https://iss.moex.com/iss/reference/877)
- [x] [/iss/statistics/engines/futures/markets/options/assets/[asset]/openpositions](https://iss.moex.com/iss/reference/883)
- [x] [/iss/statistics/engines/futures/markets/options/assets/[asset]/optionboard](https://iss.moex.com/iss/reference/881)
- [x] [/iss/statistics/engines/futures/markets/options/assets/[asset]/turnovers](https://iss.moex.com/iss/reference/885)
- [x] [/iss/statistics/engines/futures/markets/options/assets/[asset]/volumes](https://iss.moex.com/iss/reference/879)
- [x] [/iss/statistics/engines/state/markets/repo/cboper](https://iss.moex.com/iss/reference/169)
- [x] [/iss/statistics/engines/state/markets/repo/dealers](https://iss.moex.com/iss/reference/166)
- [x] [/iss/statistics/engines/state/markets/repo/mirp](https://iss.moex.com/iss/reference/165)
- [x] [/iss/statistics/engines/state/rates](https://iss.moex.com/iss/reference/178)
- [x] [/iss/statistics/engines/state/rates/columns](https://iss.moex.com/iss/reference/179)
- [x] [/iss/statistics/engines/stock/capitalization](https://iss.moex.com/iss/reference/159)
- [x] [/iss/statistics/engines/stock/currentprices](https://iss.moex.com/iss/reference/649)
- [x] [/iss/statistics/engines/stock/deviationcoeffs](https://iss.moex.com/iss/reference/134)
- [x] [/iss/statistics/engines/stock/markets/bonds/aggregates](https://iss.moex.com/iss/reference/195)
- [x] [/iss/statistics/engines/stock/markets/bonds/aggregates/columns](https://iss.moex.com/iss/reference/196)
- [x] [/iss/statistics/engines/stock/markets/index/analytics](https://iss.moex.com/iss/reference/146)
- [x] [/iss/statistics/engines/stock/markets/index/analytics/[indexid]](https://iss.moex.com/iss/reference/147)
- [x] [/iss/statistics/engines/stock/markets/index/analytics/[indexid]/tickers](https://iss.moex.com/iss/reference/148)
- [x] [/iss/statistics/engines/stock/markets/index/analytics/[indexid]/tickers/[ticker]](https://iss.moex.com/iss/reference/149)
- [x] [/iss/statistics/engines/stock/markets/index/analytics/columns](https://iss.moex.com/iss/reference/205)
- [x] [/iss/statistics/engines/stock/markets/index/bulletins](https://iss.moex.com/iss/reference/839)
- [x] [/iss/statistics/engines/stock/markets/index/rusfar](https://iss.moex.com/iss/reference/843)
- [x] [/iss/statistics/engines/stock/markets/shares/correlations](https://iss.moex.com/iss/reference/172)
- [x] [/iss/statistics/engines/stock/quotedsecurities](https://iss.moex.com/iss/reference/171)
- [x] [/iss/statistics/engines/stock/securitieslisting](https://iss.moex.com/iss/reference/841)
- [x] [/iss/statistics/engines/stock/splits](https://iss.moex.com/iss/reference/758)
- [x] [/iss/statistics/engines/stock/splits/[security]](https://iss.moex.com/iss/reference/759)
- [x] [/iss/turnovers](https://iss.moex.com/iss/reference/24)
- [x] [/iss/turnovers/columns](https://iss.moex.com/iss/reference/100)

**Всего** 143 метода

## Подключение к проекту

##### Maven
```xml
<dependency>
  <groupId>ru.ex-data</groupId>
  <artifactId>moex2</artifactId>
  <version>1.0.0</version>
</dependency>
```

##### Gradle
```groovy
implementation  'ru.ex-data:moex2:1.0.0'
```

## Донат

Сказать "Спасибо" можно тут [donationalerts](https://www.donationalerts.com/r/dvigal)

![donationalerts](https://static.donationalerts.ru/uploads/qr/7888230/qr_0152b47da309620341cc9d14ca4aaa65.png)