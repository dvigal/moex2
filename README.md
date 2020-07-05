
# Обзор MOEX2

Первичное назначение библиотеки - функции взаимодействия с информационно-статистическим сервером [Московской Биржи](https://www.moex.com/a2193).




## Функции
### Реализованные
* Запросы к MOEX ISS
    * Синхронные запросы
    * Асинхронные запросы
    * Преобразование ответа от MOEX ISS в Pandas DataFrame
### В планах
TBD


## Начало работы

### Зависимости
* aiohttp
* pandas

### Установка
```
pip install moex2
```

## Примеры использования

### Получение глобальных справочников ISS
[/iss/index](https://iss.moex.com/iss/reference/28)
```python
moex = Moex()
iss_data = moex.iss().index().req().fetch()
iss_data.as_pandas()
```

### Получение списка рынков
[/iss/engines/[engine]/markets](https://iss.moex.com/iss/reference/42)
```python
moex = Moex()
iss_data = moex.iss().engines().engine('stock').markets().req().fetch()
iss_data.as_pandas()
```

### Получение истории по одной бумаге на рынке за интервал дат
[/iss/history/engines/[engine]/markets/[market]/securities/[security]](https://iss.moex.com/iss/reference/63)
```python
moex = Moex()
iss_data = moex.iss().history().engines().engine('stock').markets().market('shares').securities().security('SBER').req().fetch_all()
iss_data.as_pandas()
```

## Поддерживаемые запросы
- [x] [/iss/securities](https://iss.moex.com/iss/reference/5)
- [x] [/iss/securities/[security]](https://iss.moex.com/iss/reference/13)
- [x] [/iss/securities/[security]/indices](https://iss.moex.com/iss/reference/160)
- [x] [/iss/securities/[security]/aggregates](https://iss.moex.com/iss/reference/214)
- [x] [/iss/engines/[engine]/markets/[market]/secstats](https://iss.moex.com/iss/reference/823)
- [x] [/iss/turnovers](https://iss.moex.com/iss/reference/24)
- [x] [/iss/turnovers/columns](https://iss.moex.com/iss/reference/100)
- [x] [/iss/engines/[engine]/turnovers](https://iss.moex.com/iss/reference/95)
- [x] [/iss/engines/[engine]/markets/[market]/turnovers](https://iss.moex.com/iss/reference/96)
- [x] [/iss/engines/[engine]/markets/zcyc](https://iss.moex.com/iss/reference/89)
- [x] [/iss/engines/[engine]/zcyc](https://iss.moex.com/iss/reference/634)
- [x] [/iss/index](https://iss.moex.com/iss/reference/28)
- [x] [/iss/engines](https://iss.moex.com/iss/reference/40)
- [x] [/iss/history/engines/[engine]/markets/[market]/.*?listing/columns](https://iss.moex.com/iss/reference/117)
- [x] [/iss/history/engines/[engine]/markets/[market]/listing](https://iss.moex.com/iss/reference/118)
- [x] [/iss/history/engines/[engine]/markets/[market]/boards/[board]/listing](https://iss.moex.com/iss/reference/119)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/listing](https://iss.moex.com/iss/reference/120)
- [x] [/iss/engines/[engine]](https://iss.moex.com/iss/reference/41)
- [x] [/iss/history/engines/[engine]/markets/[market]/sessions](https://iss.moex.com/iss/reference/811)
- [x] [/iss/history/engines/[engine]/markets/[market]/sessions/[session]/securities](https://iss.moex.com/iss/reference/813)
- [x] [/iss/history/engines/[engine]/markets/[market]/sessions/[session]/securities/[security]](https://iss.moex.com/iss/reference/817)
- [x] [/iss/engines/[engine]/markets/[market]/.*?orderbook/columns](https://iss.moex.com/iss/reference/98)
- [x] [/iss/history/engines/[engine]/markets/[market]/session/[session]/boardgroups/[boardgroup]/securities](https://iss.moex.com/iss/reference/825)
- [x] [/iss/history/engines/[engine]/markets/[market]/sessions/[session]/boardgroups/[boardgroup]/securities/[security]](https://iss.moex.com/iss/reference/819)
- [x] [/iss/history/engines/[engine]/markets/[market]/sessions/[session]/boards/[board]/securities](https://iss.moex.com/iss/reference/821)
- [x] [/iss/history/engines/[engine]/markets/[market]/sessions/[session]/boards/[board]/securities/[security]](https://iss.moex.com/iss/reference/815)
- [x] [/iss/engines/[engine]/markets/[market]/.*?securities/columns](https://iss.moex.com/iss/reference/99)
- [x] [/iss/history/engines/[engine]/markets/[market]/.*?securities/columns](https://iss.moex.com/iss/reference/101)
- [x] [/iss/history/engines/[engine]/markets/[market]/.*?[securities]/columns](https://iss.moex.com/iss/reference/789)
- [x] [/iss/engines/[engine]/markets](https://iss.moex.com/iss/reference/42)
- [x] [/iss/engines/[engine]/markets/[market]/.*?trades/columns](https://iss.moex.com/iss/reference/97)
- [x] [/iss/engines/[engine]/markets/[market]](https://iss.moex.com/iss/reference/44)
- [x] [/iss/engines/[engine]/markets/[market]/securities](https://iss.moex.com/iss/reference/33)
- [x] [/iss/engines/[engine]/markets/[market]/securities/[security]](https://iss.moex.com/iss/reference/52)
- [x] [/iss/engines/[engine]/markets/[market]/securities/[security]/trades](https://iss.moex.com/iss/reference/55)
- [x] [/iss/engines/[engine]/markets/[market]/securities/[security]/orderbook](https://iss.moex.com/iss/reference/54)
- [x] [/iss/engines/[engine]/markets/[market]/trades](https://iss.moex.com/iss/reference/35)
- [x] [/iss/engines/[engine]/markets/[market]/orderbook](https://iss.moex.com/iss/reference/36)
- [x] [/iss/engines/[engine]/markets/[market]/boards](https://iss.moex.com/iss/reference/43)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]](https://iss.moex.com/iss/reference/49)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/securities](https://iss.moex.com/iss/reference/32)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/securities/[security]](https://iss.moex.com/iss/reference/53)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/securities/[security]/trades](https://iss.moex.com/iss/reference/56)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/securities/[security]/orderbook](https://iss.moex.com/iss/reference/57)
- [x] [/iss/engines/[engine]/markets/[market]/securities/[security]/candles](https://iss.moex.com/iss/reference/155)
- [x] [/iss/engines/[engine]/markets/[market]/securities/[security]/candleborders](https://iss.moex.com/iss/reference/156)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]/candleborders](https://iss.moex.com/iss/reference/158)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]/candles](https://iss.moex.com/iss/reference/157)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/securities/[security]/candles](https://iss.moex.com/iss/reference/46)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/securities/[security]/candleborders](https://iss.moex.com/iss/reference/48)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/trades](https://iss.moex.com/iss/reference/34)
- [x] [/iss/engines/[engine]/markets/[market]/boards/[board]/orderbook](https://iss.moex.com/iss/reference/39)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups](https://iss.moex.com/iss/reference/45)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]](https://iss.moex.com/iss/reference/50)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities](https://iss.moex.com/iss/reference/29)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]](https://iss.moex.com/iss/reference/58)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]/trades](https://iss.moex.com/iss/reference/60)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]/orderbook](https://iss.moex.com/iss/reference/59)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/trades](https://iss.moex.com/iss/reference/37)
- [x] [/iss/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/orderbook](https://iss.moex.com/iss/reference/38)
- [x] [/iss/history/engines/stock/markets/shares/securities/changeover](https://iss.moex.com/iss/reference/123)
- [x] [/iss/history/engines/stock/zcyc](https://iss.moex.com/iss/reference/783)
- [x] [/iss/history/engines/[engine]/markets/[market]/securities](https://iss.moex.com/iss/reference/62)
- [x] [/iss/history/engines/[engine]/markets/[market]/yields](https://iss.moex.com/iss/reference/791)
- [x] [/iss/history/engines/[engine]/markets/[market]/dates](https://iss.moex.com/iss/reference/83)
- [x] [/iss/history/engines/[engine]/markets/[market]/securities/[security]](https://iss.moex.com/iss/reference/63)
- [x] [/iss/history/engines/[engine]/markets/[market]/yields/[security]](https://iss.moex.com/iss/reference/793)
- [x] [/iss/history/engines/[engine]/markets/[market]/securities/[security]/dates](https://iss.moex.com/iss/reference/61)
- [x] [/iss/history/engines/[engine]/markets/[market]/boards/[board]/dates](https://iss.moex.com/iss/reference/26)
- [x] [/iss/history/engines/[engine]/markets/[market]/boards/[board]/securities](https://iss.moex.com/iss/reference/64)
- [x] [/iss/history/engines/[engine]/markets/[market]/boards/[board]/yields](https://iss.moex.com/iss/reference/795)
- [x] [/iss/history/engines/[engine]/markets/[market]/boards/[board]/securities/[security]](https://iss.moex.com/iss/reference/65)
- [x] [/iss/history/engines/[engine]/markets/[market]/boards/[board]/yields/[security]](https://iss.moex.com/iss/reference/797)
- [x] [/iss/history/engines/[engine]/markets/[market]/boards/[board]/securities/[security]/dates](https://iss.moex.com/iss/reference/66)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/dates](https://iss.moex.com/iss/reference/51)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities](https://iss.moex.com/iss/reference/152)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]](https://iss.moex.com/iss/reference/153)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities](https://iss.moex.com/iss/reference/67)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/yields](https://iss.moex.com/iss/reference/799)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]](https://iss.moex.com/iss/reference/68)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/yields/[security]](https://iss.moex.com/iss/reference/801)
- [x] [/iss/history/engines/[engine]/markets/[market]/boardgroups/[boardgroup]/securities/[security]/dates](https://iss.moex.com/iss/reference/69)
- [x] [/iss/archives/engines/[engine]/markets/[market]/[datatype]/years](https://iss.moex.com/iss/reference/114)
- [x] [/iss/archives/engines/[engine]/markets/[market]/[datatype]/[period]](https://iss.moex.com/iss/reference/116)
- [x] [/iss/archives/engines/[engine]/markets/[market]/[datatype]/years/[year]/months](https://iss.moex.com/iss/reference/115)
- [x] [/iss/securitygroups](https://iss.moex.com/iss/reference/127)
- [x] [/iss/securitygroups/[securitygroup]](https://iss.moex.com/iss/reference/128)
- [x] [/iss/securitygroups/[securitygroup]/collections](https://iss.moex.com/iss/reference/129)
- [x] [/iss/securitygroups/[securitygroup]/collections/[collection]](https://iss.moex.com/iss/reference/130)
- [x] [/iss/securitygroups/[securitygroup]/collections/[collection]/securities](https://iss.moex.com/iss/reference/131)
- [x] [/iss/securitytypes](https://iss.moex.com/iss/reference/132)
- [x] [/iss/securitytypes/[securitytype]](https://iss.moex.com/iss/reference/133)
- [x] [/iss/statistics/engines/stock/markets/shares/correlations](https://iss.moex.com/iss/reference/172)
- [x] [/iss/statistics/engines/currency/markets/selt/rates](https://iss.moex.com/iss/reference/168)
- [x] [/iss/statistics/engines/stock/splits](https://iss.moex.com/iss/reference/758)
- [x] [/iss/statistics/engines/stock/splits/[security]](https://iss.moex.com/iss/reference/759)
- [x] [/iss/statistics/engines/state/markets/repo/mirp](https://iss.moex.com/iss/reference/165)
- [x] [/iss/statistics/engines/state/markets/repo/dealers](https://iss.moex.com/iss/reference/166)
- [x] [/iss/statistics/engines/state/markets/repo/cboper](https://iss.moex.com/iss/reference/169)
- [x] [/iss/statistics/engines/stock/deviationcoeffs](https://iss.moex.com/iss/reference/134)
- [x] [/iss/statistics/engines/stock/quotedsecurities](https://iss.moex.com/iss/reference/171)
- [x] [/iss/statistics/engines/stock/currentprices](https://iss.moex.com/iss/reference/649)
- [x] [/iss/sitenews](https://iss.moex.com/iss/reference/191)
- [x] [/iss/sitenews/[news_id]](https://iss.moex.com/iss/reference/192)
- [x] [/iss/events](https://iss.moex.com/iss/reference/193)
- [x] [/iss/events/[event_id]](https://iss.moex.com/iss/reference/194)
- [x] [/iss/statistics/engines/stock/markets/bonds/aggregates](https://iss.moex.com/iss/reference/195)
- [x] [/iss/statistics/engines/stock/markets/bonds/aggregates/columns](https://iss.moex.com/iss/reference/196)
- [x] [/iss/statistics/engines/stock/markets/index/analytics](https://iss.moex.com/iss/reference/146)
- [x] [/iss/statistics/engines/stock/markets/index/analytics/columns](https://iss.moex.com/iss/reference/205)
- [x] [/iss/statistics/engines/stock/markets/index/analytics/[indexid]](https://iss.moex.com/iss/reference/147)
- [x] [/iss/statistics/engines/stock/markets/index/analytics/[indexid]/tickers](https://iss.moex.com/iss/reference/148)
- [x] [/iss/statistics/engines/stock/markets/index/analytics/[indexid]/tickers/[ticker]](https://iss.moex.com/iss/reference/149)
- [x] [/iss/statistics/engines/stock/markets/index/waitlists](https://iss.moex.com/iss/reference/150)
- [x] [/iss/statistics/engines/stock/markets/index/waitlists/[indexid]](https://iss.moex.com/iss/reference/151)
- [x] [/iss/statistics/engines/stock/capitalization](https://iss.moex.com/iss/reference/159)
- [x] [/iss/history/engines/stock/totals/boards](https://iss.moex.com/iss/reference/161)
- [x] [/iss/history/engines/stock/totals/securities](https://iss.moex.com/iss/reference/162)
- [x] [/iss/history/engines/stock/totals/boards/[board]/securities](https://iss.moex.com/iss/reference/163)
- [x] [/iss/history/engines/stock/totals/boards/[board]/securities/[security]](https://iss.moex.com/iss/reference/164)
- [x] [/iss/rms/engines/[engine]/objects/irr](https://iss.moex.com/iss/reference/764)
- [x] [/iss/rms/engines/[engine]/objects/irr/filters](https://iss.moex.com/iss/reference/766)
- [x] [/iss/statistics/engines/state/rates](https://iss.moex.com/iss/reference/178)
- [x] [/iss/statistics/engines/state/rates/columns](https://iss.moex.com/iss/reference/179)
- [x] [/iss/statistics/engines/[engine]/derivatives/[report_name]](https://iss.moex.com/iss/reference/219)
- [x] [/iss/statistics/engines/[engine]/monthly/[report_name]](https://iss.moex.com/iss/reference/220)
- [x] [/iss/statistics/engines/currency/markets/fixing/[security]](https://iss.moex.com/iss/reference/715)
- [x] [/iss/statistics/engines/futures/markets/indicativerates/securities](https://iss.moex.com/iss/reference/711)
- [x] [/iss/statistics/engines/futures/markets/indicativerates/securities/[security]](https://iss.moex.com/iss/reference/712)
- [x] [/iss/statistics/engines/currency/markets/fixing](https://iss.moex.com/iss/reference/716)
- [x] [/iss/statistics/engines/[engine]/markets/[market]](https://iss.moex.com/iss/reference/771)
- [x] [/iss/statistics/engines/[engine]/markets/[market]/securities](https://iss.moex.com/iss/reference/773)
- [x] [/iss/statistics/engines/[engine]/markets/[market]/securities/[security]](https://iss.moex.com/iss/reference/775)
- [x] [/iss/analyticalproducts/netflow2/securities](https://iss.moex.com/iss/reference/767)
- [x] [/iss/analyticalproducts/netflow2/securities/[security]](https://iss.moex.com/iss/reference/769)
- [x] [/iss/analyticalproducts/futoi/securities](https://iss.moex.com/iss/reference/807)
- [x] [/iss/analyticalproducts/futoi/securities/[security]](https://iss.moex.com/iss/reference/809)





## Обратная связь

Открыт для обратной связи. Буду рад ответить на вопросы, замечания и предложения. 
Связаться со мной можно написав на электронную почту [free.dvig@gmail.com](mailto:free.dvig@gmail.com) или [Telegram](https://t.me/dvig_al)


## Лицензия
Александр Литвинов (c). Все права защищены.
Распростроняется по лиценции [MIT](LICENSE).
