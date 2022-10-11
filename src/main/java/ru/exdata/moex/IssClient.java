package ru.exdata.moex;

import java.io.Closeable;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.net.URI;
import java.net.http.HttpClient;

public final class IssClient implements Closeable {
  private final HttpClient httpClient;

  private final URI uri;

  IssClient(final HttpClient httpClient, final URI uri) {
    this.httpClient = httpClient;
    this.uri = uri;
  }

  public Iss iss() {
    return new Iss(new Query().addPath("iss"));
  }

  @Override
  public void close() throws IOException {

  }

  public final class Iss {
    private final Query query;

    Iss(final Query query) {
      this.query = query;
    }

    public Securitygroups securitygroups() {
      return new Securitygroups(this.query.addPath("securitygroups"));
    }

    public Sitenews sitenews() {
      return new Sitenews(this.query.addPath("sitenews"));
    }

    public Index index() {
      return new Index(this.query.addPath("index"));
    }

    public Statistics statistics() {
      return new Statistics(this.query.addPath("statistics"));
    }

    public Turnovers turnovers() {
      return new Turnovers(this.query.addPath("turnovers"));
    }

    public Engines engines() {
      return new Engines(this.query.addPath("engines"));
    }

    public History history() {
      return new History(this.query.addPath("history"));
    }

    public Rms rms() {
      return new Rms(this.query.addPath("rms"));
    }

    public Events events() {
      return new Events(this.query.addPath("events"));
    }

    public Analyticalproducts analyticalproducts() {
      return new Analyticalproducts(this.query.addPath("analyticalproducts"));
    }

    public Securities securities() {
      return new Securities(this.query.addPath("securities"));
    }

    public Archives archives() {
      return new Archives(this.query.addPath("archives"));
    }

    public Securitytypes securitytypes() {
      return new Securitytypes(this.query.addPath("securitytypes"));
    }

    public final class Securitygroups {
      private final Query query;

      Securitygroups(final Query query) {
        this.query = query;
      }

      /**
       * <a href="https://iss.moex.com/iss/reference/127">Группы ценных бумаг</a>
       */
      public Format format() {
        return new Format(httpClient, uri, this.query);
      }

      public Securitygroup securitygroup(final String securitygroup) {
        if (securitygroup == null || securitygroup.isBlank()) {
          throw new IllegalArgumentException(securitygroup);
        }
        return new Securitygroup(this.query.addPath(securitygroup));
      }

      public final class Securitygroup {
        private final Query query;

        Securitygroup(final Query query) {
          this.query = query;
        }

        /**
         * <a href="https://iss.moex.com/iss/reference/128">Группа ценных бумаг</a>
         */
        public Format format() {
          return new Format(httpClient, uri, this.query);
        }

        public Collections collections() {
          return new Collections(this.query.addPath("collections"));
        }

        public final class Collections {
          private final Query query;

          Collections(final Query query) {
            this.query = query;
          }

          public Collection collection(final String collection) {
            if (collection == null || collection.isBlank()) {
              throw new IllegalArgumentException(collection);
            }
            return new Collection(this.query.addPath(collection));
          }

          /**
           * <a href="https://iss.moex.com/iss/reference/129">Коллекции ценных бумаг входящие в группу</a>
           */
          public Format format() {
            return new Format(httpClient, uri, this.query);
          }

          public final class Collection {
            private final Query query;

            Collection(final Query query) {
              this.query = query;
            }

            /**
             * <a href="https://iss.moex.com/iss/reference/130">Коллекция ценных бумаг входящие в группу</a>
             */
            public Format format() {
              return new Format(httpClient, uri, this.query);
            }

            public Securities securities() {
              return new Securities(this.query.addPath("securities"));
            }

            public final class Securities {
              private final Query query;

              Securities(final Query query) {
                this.query = query;
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/131">Описание инструментов</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }
            }
          }
        }
      }
    }

    public final class Sitenews {
      private final Query query;

      Sitenews(final Query query) {
        this.query = query;
      }

      public News_id news_id(final String news_id) {
        if (news_id == null || news_id.isBlank()) {
          throw new IllegalArgumentException(news_id);
        }
        return new News_id(this.query.addPath(news_id));
      }

      /**
       * <a href="https://iss.moex.com/iss/reference/191">Новости биржи</a>
       */
      public Format format() {
        return new Format(httpClient, uri, this.query);
      }

      public final class News_id {
        private final Query query;

        News_id(final Query query) {
          this.query = query;
        }

        /**
         * <a href="https://iss.moex.com/iss/reference/192">Новость сайта</a>
         */
        public Format format() {
          return new Format(httpClient, uri, this.query);
        }
      }
    }

    public final class Index {
      private final Query query;

      Index(final Query query) {
        this.query = query;
      }

      /**
       * <a href="https://iss.moex.com/iss/reference/28">Получить глобальные справочники iss. например: https://iss.moex.com/iss/index.xml</a>
       */
      public Format format() {
        return new Format(httpClient, uri, this.query);
      }
    }

    public final class Statistics {
      private final Query query;

      Statistics(final Query query) {
        this.query = query;
      }

      public Engines engines() {
        return new Engines(this.query.addPath("engines"));
      }

      public final class Engines {
        private final Query query;

        Engines(final Query query) {
          this.query = query;
        }

        public Currency currency() {
          return new Currency(this.query.addPath("currency"));
        }

        public Futures futures() {
          return new Futures(this.query.addPath("futures"));
        }

        public Engine engine(final String engine) {
          if (engine == null || engine.isBlank()) {
            throw new IllegalArgumentException(engine);
          }
          return new Engine(this.query.addPath(engine));
        }

        public Stock stock() {
          return new Stock(this.query.addPath("stock"));
        }

        public State state() {
          return new State(this.query.addPath("state"));
        }

        public final class Currency {
          private final Query query;

          Currency(final Query query) {
            this.query = query;
          }

          public Markets markets() {
            return new Markets(this.query.addPath("markets"));
          }

          public final class Markets {
            private final Query query;

            Markets(final Query query) {
              this.query = query;
            }

            public Selt selt() {
              return new Selt(this.query.addPath("selt"));
            }

            public Fixing fixing() {
              return new Fixing(this.query.addPath("fixing"));
            }

            public final class Selt {
              private final Query query;

              Selt(final Query query) {
                this.query = query;
              }

              public Rates rates() {
                return new Rates(this.query.addPath("rates"));
              }

              public final class Rates {
                private final Query query;

                Rates(final Query query) {
                  this.query = query;
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/168">Курсы цбрф</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }
              }
            }

            public final class Fixing {
              private final Query query;

              Fixing(final Query query) {
                this.query = query;
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/716">Фиксинги московской биржи</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }

              public Security security(final String security) {
                if (security == null || security.isBlank()) {
                  throw new IllegalArgumentException(security);
                }
                return new Security(this.query.addPath(security));
              }

              public final class Security {
                private final Query query;

                Security(final Query query) {
                  this.query = query;
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/715">Фиксинги московской биржи</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }
              }
            }
          }
        }

        public final class Futures {
          private final Query query;

          Futures(final Query query) {
            this.query = query;
          }

          public Markets markets() {
            return new Markets(this.query.addPath("markets"));
          }

          public final class Markets {
            private final Query query;

            Markets(final Query query) {
              this.query = query;
            }

            public Options options() {
              return new Options(this.query.addPath("options"));
            }

            public Indicativerates indicativerates() {
              return new Indicativerates(this.query.addPath("indicativerates"));
            }

            public final class Options {
              private final Query query;

              Options(final Query query) {
                this.query = query;
              }

              public Assets assets() {
                return new Assets(this.query.addPath("assets"));
              }

              public final class Assets {
                private final Query query;

                Assets(final Query query) {
                  this.query = query;
                }

                public Asset asset(final String asset) {
                  if (asset == null || asset.isBlank()) {
                    throw new IllegalArgumentException(asset);
                  }
                  return new Asset(this.query.addPath(asset));
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/873">Опционные серии</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }

                public final class Asset {
                  private final Query query;

                  Asset(final Query query) {
                    this.query = query;
                  }

                  public Optionboard optionboard() {
                    return new Optionboard(this.query.addPath("optionboard"));
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/877">Опционные серии</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }

                  public Volumes volumes() {
                    return new Volumes(this.query.addPath("volumes"));
                  }

                  public Turnovers turnovers() {
                    return new Turnovers(this.query.addPath("turnovers"));
                  }

                  public Openpositions openpositions() {
                    return new Openpositions(this.query.addPath("openpositions"));
                  }

                  public final class Optionboard {
                    private final Query query;

                    Optionboard(final Query query) {
                      this.query = query;
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/881">Доска опционов</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }
                  }

                  public final class Volumes {
                    private final Query query;

                    Volumes(final Query query) {
                      this.query = query;
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/879">Объем торгов для опционной серии</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }
                  }

                  public final class Turnovers {
                    private final Query query;

                    Turnovers(final Query query) {
                      this.query = query;
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/885">Объем торгов для опционной серии</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }
                  }

                  public final class Openpositions {
                    private final Query query;

                    Openpositions(final Query query) {
                      this.query = query;
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/883">Открытые позиции по опционной серии</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }
                  }
                }
              }
            }

            public final class Indicativerates {
              private final Query query;

              Indicativerates(final Query query) {
                this.query = query;
              }

              public Securities securities() {
                return new Securities(this.query.addPath("securities"));
              }

              public final class Securities {
                private final Query query;

                Securities(final Query query) {
                  this.query = query;
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/711">Индикативные курсы валют срочного рынка</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }

                public Security security(final String security) {
                  if (security == null || security.isBlank()) {
                    throw new IllegalArgumentException(security);
                  }
                  return new Security(this.query.addPath(security));
                }

                public final class Security {
                  private final Query query;

                  Security(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/712">Индикативный курс валют срочного рынка</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }
              }
            }
          }
        }

        public final class Engine {
          private final Query query;

          Engine(final Query query) {
            this.query = query;
          }

          public Monthly monthly() {
            return new Monthly(this.query.addPath("monthly"));
          }

          public Markets markets() {
            return new Markets(this.query.addPath("markets"));
          }

          public Derivatives derivatives() {
            return new Derivatives(this.query.addPath("derivatives"));
          }

          public final class Monthly {
            private final Query query;

            Monthly(final Query query) {
              this.query = query;
            }

            public Report_name report_name(final String report_name) {
              if (report_name == null || report_name.isBlank()) {
                throw new IllegalArgumentException(report_name);
              }
              return new Report_name(this.query.addPath(report_name));
            }

            public final class Report_name {
              private final Query query;

              Report_name(final Query query) {
                this.query = query;
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/220"></a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }
            }
          }

          public final class Markets {
            private final Query query;

            Markets(final Query query) {
              this.query = query;
            }

            public Market market(final String market) {
              if (market == null || market.isBlank()) {
                throw new IllegalArgumentException(market);
              }
              return new Market(this.query.addPath(market));
            }

            public final class Market {
              private final Query query;

              Market(final Query query) {
                this.query = query;
              }

              public Securities securities() {
                return new Securities(this.query.addPath("securities"));
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/771">Курсы переоценки коллатеральных инструментов</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }

              public final class Securities {
                private final Query query;

                Securities(final Query query) {
                  this.query = query;
                }

                public Security security(final String security) {
                  if (security == null || security.isBlank()) {
                    throw new IllegalArgumentException(security);
                  }
                  return new Security(this.query.addPath(security));
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/773">Курсы переоценки коллатеральных инструментов</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }

                public final class Security {
                  private final Query query;

                  Security(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/775">Курсы переоценки коллатеральных инструментов. инструмент за интервал дат.</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }
              }
            }
          }

          public final class Derivatives {
            private final Query query;

            Derivatives(final Query query) {
              this.query = query;
            }

            public Report_name report_name(final String report_name) {
              if (report_name == null || report_name.isBlank()) {
                throw new IllegalArgumentException(report_name);
              }
              return new Report_name(this.query.addPath(report_name));
            }

            public final class Report_name {
              private final Query query;

              Report_name(final Query query) {
                this.query = query;
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/219">Еженедельные отчеты по валютным деривативам: numtrades - информация о количестве договоров по инструментам, являющимся производными финансовыми инструментами (по валютным парам) participants - информация о количестве лиц, имеющих открытые позиции по инструментам, являющимся производными финансовыми инструментами (по валютным парам) openpositions - информация об открытых позициях по инструментам, являющимся производными финансовыми инструментами (по валютным парам) expirationparticipants - информация о количестве лиц, имеющих открытые позиции по договорам, являющимся производными финансовыми инструментами (по срокам экспирации) expirationopenpositions - информация об объеме открытых позиций по договорам, являющимся производными финансовыми инструментами (по срокам экспирации)</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }
            }
          }
        }

        public final class Stock {
          private final Query query;

          Stock(final Query query) {
            this.query = query;
          }

          public Deviationcoeffs deviationcoeffs() {
            return new Deviationcoeffs(this.query.addPath("deviationcoeffs"));
          }

          public Currentprices currentprices() {
            return new Currentprices(this.query.addPath("currentprices"));
          }

          public Markets markets() {
            return new Markets(this.query.addPath("markets"));
          }

          public Capitalization capitalization() {
            return new Capitalization(this.query.addPath("capitalization"));
          }

          public Quotedsecurities quotedsecurities() {
            return new Quotedsecurities(this.query.addPath("quotedsecurities"));
          }

          public Splits splits() {
            return new Splits(this.query.addPath("splits"));
          }

          public Securitieslisting securitieslisting() {
            return new Securitieslisting(this.query.addPath("securitieslisting"));
          }

          public final class Deviationcoeffs {
            private final Query query;

            Deviationcoeffs(final Query query) {
              this.query = query;
            }

            /**
             * <a href="https://iss.moex.com/iss/reference/134">Показатели для определения критериев существенного отклонения</a>
             */
            public Format format() {
              return new Format(httpClient, uri, this.query);
            }
          }

          public final class Currentprices {
            private final Query query;

            Currentprices(final Query query) {
              this.query = query;
            }

            /**
             * <a href="https://iss.moex.com/iss/reference/649">Текущие цены бумаг</a>
             */
            public Format format() {
              return new Format(httpClient, uri, this.query);
            }
          }

          public final class Markets {
            private final Query query;

            Markets(final Query query) {
              this.query = query;
            }

            public Shares shares() {
              return new Shares(this.query.addPath("shares"));
            }

            public Bonds bonds() {
              return new Bonds(this.query.addPath("bonds"));
            }

            public Index index() {
              return new Index(this.query.addPath("index"));
            }

            public final class Shares {
              private final Query query;

              Shares(final Query query) {
                this.query = query;
              }

              public Correlations correlations() {
                return new Correlations(this.query.addPath("correlations"));
              }

              public final class Correlations {
                private final Query query;

                Correlations(final Query query) {
                  this.query = query;
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/172">Коэффициенты корелляции фондового рынка</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }
              }
            }

            public final class Bonds {
              private final Query query;

              Bonds(final Query query) {
                this.query = query;
              }

              public Aggregates aggregates() {
                return new Aggregates(this.query.addPath("aggregates"));
              }

              public final class Aggregates {
                private final Query query;

                Aggregates(final Query query) {
                  this.query = query;
                }

                public Columns columns() {
                  return new Columns(this.query.addPath("columns"));
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/195">Агрегированные показатели рынка облигаций</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }

                public final class Columns {
                  private final Query query;

                  Columns(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/196"></a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }
              }
            }

            public final class Index {
              private final Query query;

              Index(final Query query) {
                this.query = query;
              }

              public Rusfar rusfar() {
                return new Rusfar(this.query.addPath("rusfar"));
              }

              public Bulletins bulletins() {
                return new Bulletins(this.query.addPath("bulletins"));
              }

              public Analytics analytics() {
                return new Analytics(this.query.addPath("analytics"));
              }

              public final class Rusfar {
                private final Query query;

                Rusfar(final Query query) {
                  this.query = query;
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/843">Rusfar расшифровка показателей</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }
              }

              public final class Bulletins {
                private final Query query;

                Bulletins(final Query query) {
                  this.query = query;
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/839">Бюллетени для индексов</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }
              }

              public final class Analytics {
                private final Query query;

                Analytics(final Query query) {
                  this.query = query;
                }

                public Indexid indexid(final String indexid) {
                  if (indexid == null || indexid.isBlank()) {
                    throw new IllegalArgumentException(indexid);
                  }
                  return new Indexid(this.query.addPath(indexid));
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/146">Индексы фондового рынка</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }

                public Columns columns() {
                  return new Columns(this.query.addPath("columns"));
                }

                public final class Indexid {
                  private final Query query;

                  Indexid(final Query query) {
                    this.query = query;
                  }

                  public Tickers tickers() {
                    return new Tickers(this.query.addPath("tickers"));
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/147">Аналитические показатели за дату</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }

                  public final class Tickers {
                    private final Query query;

                    Tickers(final Query query) {
                      this.query = query;
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/148">Список тикеров за все время торгов</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }

                    public Ticker ticker(final String ticker) {
                      if (ticker == null || ticker.isBlank()) {
                        throw new IllegalArgumentException(ticker);
                      }
                      return new Ticker(this.query.addPath(ticker));
                    }

                    public final class Ticker {
                      private final Query query;

                      Ticker(final Query query) {
                        this.query = query;
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/149">Информация по тикеру</a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }
                    }
                  }
                }

                public final class Columns {
                  private final Query query;

                  Columns(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/205"></a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }
              }
            }
          }

          public final class Capitalization {
            private final Query query;

            Capitalization(final Query query) {
              this.query = query;
            }

            /**
             * <a href="https://iss.moex.com/iss/reference/159">Капитализация фондового рынка</a>
             */
            public Format format() {
              return new Format(httpClient, uri, this.query);
            }
          }

          public final class Quotedsecurities {
            private final Query query;

            Quotedsecurities(final Query query) {
              this.query = query;
            }

            /**
             * <a href="https://iss.moex.com/iss/reference/171">Cписок акций, по которым рассчитывается рыночная котировка</a>
             */
            public Format format() {
              return new Format(httpClient, uri, this.query);
            }
          }

          public final class Splits {
            private final Query query;

            Splits(final Query query) {
              this.query = query;
            }

            /**
             * <a href="https://iss.moex.com/iss/reference/758">Справочник дроблений и консолидаций бумаг фондового рынка</a>
             */
            public Format format() {
              return new Format(httpClient, uri, this.query);
            }

            public Security security(final String security) {
              if (security == null || security.isBlank()) {
                throw new IllegalArgumentException(security);
              }
              return new Security(this.query.addPath(security));
            }

            public final class Security {
              private final Query query;

              Security(final Query query) {
                this.query = query;
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/759"></a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }
            }
          }

          public final class Securitieslisting {
            private final Query query;

            Securitieslisting(final Query query) {
              this.query = query;
            }

            /**
             * <a href="https://iss.moex.com/iss/reference/841">Таблица соответствия торгуемых ценных бумаг по режимам торгов</a>
             */
            public Format format() {
              return new Format(httpClient, uri, this.query);
            }
          }
        }

        public final class State {
          private final Query query;

          State(final Query query) {
            this.query = query;
          }

          public Rates rates() {
            return new Rates(this.query.addPath("rates"));
          }

          public Markets markets() {
            return new Markets(this.query.addPath("markets"));
          }

          public final class Rates {
            private final Query query;

            Rates(final Query query) {
              this.query = query;
            }

            /**
             * <a href="https://iss.moex.com/iss/reference/178"></a>
             */
            public Format format() {
              return new Format(httpClient, uri, this.query);
            }

            public Columns columns() {
              return new Columns(this.query.addPath("columns"));
            }

            public final class Columns {
              private final Query query;

              Columns(final Query query) {
                this.query = query;
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/179"></a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }
            }
          }

          public final class Markets {
            private final Query query;

            Markets(final Query query) {
              this.query = query;
            }

            public Repo repo() {
              return new Repo(this.query.addPath("repo"));
            }

            public final class Repo {
              private final Query query;

              Repo(final Query query) {
                this.query = query;
              }

              public Cboper cboper() {
                return new Cboper(this.query.addPath("cboper"));
              }

              public Dealers dealers() {
                return new Dealers(this.query.addPath("dealers"));
              }

              public Mirp mirp() {
                return new Mirp(this.query.addPath("mirp"));
              }

              public final class Cboper {
                private final Query query;

                Cboper(final Query query) {
                  this.query = query;
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/169">Средневзвешенные ставки по операциям центрального банка</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }
              }

              public final class Dealers {
                private final Query query;

                Dealers(final Query query) {
                  this.query = query;
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/166"></a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }
              }

              public final class Mirp {
                private final Query query;

                Mirp(final Query query) {
                  this.query = query;
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/165"></a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }
              }
            }
          }
        }
      }
    }

    public final class Turnovers {
      private final Query query;

      Turnovers(final Query query) {
        this.query = query;
      }

      public Columns columns() {
        return new Columns(this.query.addPath("columns"));
      }

      /**
       * <a href="https://iss.moex.com/iss/reference/24">Получить сводные обороты по рынкам. например: https://iss.moex.com/iss/turnovers.xml</a>
       */
      public Format format() {
        return new Format(httpClient, uri, this.query);
      }

      public final class Columns {
        private final Query query;

        Columns(final Query query) {
          this.query = query;
        }

        /**
         * <a href="https://iss.moex.com/iss/reference/100">Получить описание полей для запросов оборотов по рынку/торговой системе. например: https://iss.moex.com/iss/engines/stock/turnovers/columns.xml</a>
         */
        public Format format() {
          return new Format(httpClient, uri, this.query);
        }
      }
    }

    public final class Engines {
      private final Query query;

      Engines(final Query query) {
        this.query = query;
      }

      public Engine engine(final String engine) {
        if (engine == null || engine.isBlank()) {
          throw new IllegalArgumentException(engine);
        }
        return new Engine(this.query.addPath(engine));
      }

      /**
       * <a href="https://iss.moex.com/iss/reference/40">Получить доступные торговые системы. например: https://iss.moex.com/iss/engines.xml</a>
       */
      public Format format() {
        return new Format(httpClient, uri, this.query);
      }

      public final class Engine {
        private final Query query;

        Engine(final Query query) {
          this.query = query;
        }

        public Turnovers turnovers() {
          return new Turnovers(this.query.addPath("turnovers"));
        }

        public Zcyc zcyc() {
          return new Zcyc(this.query.addPath("zcyc"));
        }

        /**
         * <a href="https://iss.moex.com/iss/reference/41">Получить описание и режим работы торговой системы. например: https://iss.moex.com/iss/engines/stock.xml</a>
         */
        public Format format() {
          return new Format(httpClient, uri, this.query);
        }

        public Markets markets() {
          return new Markets(this.query.addPath("markets"));
        }

        public final class Turnovers {
          private final Query query;

          Turnovers(final Query query) {
            this.query = query;
          }

          /**
           * <a href="https://iss.moex.com/iss/reference/95">Получить текущее значение оборотов торговой сессии по рынкам торговой системы</a>
           */
          public Format format() {
            return new Format(httpClient, uri, this.query);
          }
        }

        public final class Zcyc {
          private final Query query;

          Zcyc(final Query query) {
            this.query = query;
          }

          /**
           * <a href="https://iss.moex.com/iss/reference/634"></a>
           */
          public Format format() {
            return new Format(httpClient, uri, this.query);
          }
        }

        public final class Markets {
          private final Query query;

          Markets(final Query query) {
            this.query = query;
          }

          /**
           * <a href="https://iss.moex.com/iss/reference/42">Получить список рынков торговой системы. например: https://iss.moex.com/iss/engines/stock/markets.xml</a>
           */
          public Format format() {
            return new Format(httpClient, uri, this.query);
          }

          public Zcyc zcyc() {
            return new Zcyc(this.query.addPath("zcyc"));
          }

          public Market market(final String market) {
            if (market == null || market.isBlank()) {
              throw new IllegalArgumentException(market);
            }
            return new Market(this.query.addPath(market));
          }

          public final class Zcyc {
            private final Query query;

            Zcyc(final Query query) {
              this.query = query;
            }

            /**
             * <a href="https://iss.moex.com/iss/reference/89">Получить данные по кривой бескупонной доходности (прекращены расчеты с 2018-01-03)</a>
             */
            public Format format() {
              return new Format(httpClient, uri, this.query);
            }
          }

          public final class Market {
            private final Query query;

            Market(final Query query) {
              this.query = query;
            }

            public Trades trades() {
              return new Trades(this.query.addPath("trades"));
            }

            public Boards boards() {
              return new Boards(this.query.addPath("boards"));
            }

            /**
             * <a href="https://iss.moex.com/iss/reference/44">Получить описание: словарь доступных режимов торгов, описание полей публикуемых таблиц данных и т.д. например: https://iss.moex.com/iss/engines/stock/markets/shares.xml</a>
             */
            public Format format() {
              return new Format(httpClient, uri, this.query);
            }

            public Boardgroups boardgroups() {
              return new Boardgroups(this.query.addPath("boardgroups"));
            }

            public Securities securities() {
              return new Securities(this.query.addPath("securities"));
            }

            public Secstats secstats() {
              return new Secstats(this.query.addPath("secstats"));
            }

            public Turnovers turnovers() {
              return new Turnovers(this.query.addPath("turnovers"));
            }

            public Orderbook orderbook() {
              return new Orderbook(this.query.addPath("orderbook"));
            }

            public final class Trades {
              private final Query query;

              Trades(final Query query) {
                this.query = query;
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/35">Получить все сделки рынка. например: https://iss.moex.com/iss/engines/stock/markets/shares/trades.xml</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }
            }

            public final class Boards {
              private final Query query;

              Boards(final Query query) {
                this.query = query;
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/43">Получить справочник режимов торгов рынка. например: https://iss.moex.com/iss/engines/stock/markets/shares/boards.xml</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }

              public Board board(final String board) {
                if (board == null || board.isBlank()) {
                  throw new IllegalArgumentException(board);
                }
                return new Board(this.query.addPath(board));
              }

              public final class Board {
                private final Query query;

                Board(final Query query) {
                  this.query = query;
                }

                public Orderbook orderbook() {
                  return new Orderbook(this.query.addPath("orderbook"));
                }

                public Trades trades() {
                  return new Trades(this.query.addPath("trades"));
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/49">Получить описание режима торгов. например: https://iss.moex.com/iss/engines/stock/markets/shares/boards/tqbr.xml</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }

                public Securities securities() {
                  return new Securities(this.query.addPath("securities"));
                }

                public final class Orderbook {
                  private final Query query;

                  Orderbook(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/39">Получить все лучшие котировки по выбранному режиму торгов.</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }

                public final class Trades {
                  private final Query query;

                  Trades(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/34">Получить все сделки по выбранному режиму торгов.</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }

                public final class Securities {
                  private final Query query;

                  Securities(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/32">Получить таблицу инструментов по режиму торгов. например: https://iss.moex.com/iss/engines/stock/markets/shares/boards/tqbr/securities.xml</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }

                  public Security security(final String security) {
                    if (security == null || security.isBlank()) {
                      throw new IllegalArgumentException(security);
                    }
                    return new Security(this.query.addPath(security));
                  }

                  public final class Security {
                    private final Query query;

                    Security(final Query query) {
                      this.query = query;
                    }

                    public Orderbook orderbook() {
                      return new Orderbook(this.query.addPath("orderbook"));
                    }

                    public Candleborders candleborders() {
                      return new Candleborders(this.query.addPath("candleborders"));
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/53">Получить данные по указанному инструменту на выбранном режиме торгов.</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }

                    public Candles candles() {
                      return new Candles(this.query.addPath("candles"));
                    }

                    public Trades trades() {
                      return new Trades(this.query.addPath("trades"));
                    }

                    public final class Orderbook {
                      private final Query query;

                      Orderbook(final Query query) {
                        this.query = query;
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/57">Получить стакан котировок указанного инструмента по выбранному режиму торгов.</a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }
                    }

                    public final class Candleborders {
                      private final Query query;

                      Candleborders(final Query query) {
                        this.query = query;
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/48">Получить период дат рассчитанных свечей.</a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }
                    }

                    public final class Candles {
                      private final Query query;

                      Candles(final Query query) {
                        this.query = query;
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/46">Получить свечи указанного инструмента по выбранному режиму торгов.</a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }
                    }

                    public final class Trades {
                      private final Query query;

                      Trades(final Query query) {
                        this.query = query;
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/56">Получить все сделки указанного инструмента по выбранному режиму торгов.</a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }
                    }
                  }
                }
              }
            }

            public final class Boardgroups {
              private final Query query;

              Boardgroups(final Query query) {
                this.query = query;
              }

              public Boardgroup boardgroup(final String boardgroup) {
                if (boardgroup == null || boardgroup.isBlank()) {
                  throw new IllegalArgumentException(boardgroup);
                }
                return new Boardgroup(this.query.addPath(boardgroup));
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/45">Получить справочник групп режимов торгов.</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }

              public final class Boardgroup {
                private final Query query;

                Boardgroup(final Query query) {
                  this.query = query;
                }

                public Trades trades() {
                  return new Trades(this.query.addPath("trades"));
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/50">Получить описание группы режимов торгов.</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }

                public Securities securities() {
                  return new Securities(this.query.addPath("securities"));
                }

                public Orderbook orderbook() {
                  return new Orderbook(this.query.addPath("orderbook"));
                }

                public final class Trades {
                  private final Query query;

                  Trades(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/37">Получить сделки инструментов, торгуемых на выбранной группе режимов торгов.</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }

                public final class Securities {
                  private final Query query;

                  Securities(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/29">Получить список всех инструментов, торгуемых на выбранной группе режимов торгов.</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }

                  public Security security(final String security) {
                    if (security == null || security.isBlank()) {
                      throw new IllegalArgumentException(security);
                    }
                    return new Security(this.query.addPath(security));
                  }

                  public final class Security {
                    private final Query query;

                    Security(final Query query) {
                      this.query = query;
                    }

                    public Candleborders candleborders() {
                      return new Candleborders(this.query.addPath("candleborders"));
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/58">Получить данные по указанному инструменту, торгуемому на выбранной группе режимов торгов.</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }

                    public Trades trades() {
                      return new Trades(this.query.addPath("trades"));
                    }

                    public Candles candles() {
                      return new Candles(this.query.addPath("candles"));
                    }

                    public Orderbook orderbook() {
                      return new Orderbook(this.query.addPath("orderbook"));
                    }

                    public final class Candleborders {
                      private final Query query;

                      Candleborders(final Query query) {
                        this.query = query;
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/158"></a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }
                    }

                    public final class Trades {
                      private final Query query;

                      Trades(final Query query) {
                        this.query = query;
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/60">Получить сделки выбранного инструмента, торгуемого на выбранной группе режимов торгов.</a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }
                    }

                    public final class Candles {
                      private final Query query;

                      Candles(final Query query) {
                        this.query = query;
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/157">Получить свечи указанного инструмента по выбранной группе режимов торгов.</a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }
                    }

                    public final class Orderbook {
                      private final Query query;

                      Orderbook(final Query query) {
                        this.query = query;
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/59">Получить лучшие заявки выбранного инструмента, торгуемого на выбранной группе режимов торгов.</a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }
                    }
                  }
                }

                public final class Orderbook {
                  private final Query query;

                  Orderbook(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/38">Получить лучшие заявки всех инструментов, торгуемых на выбранной группе режимов торгов.</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }
              }
            }

            public final class Securities {
              private final Query query;

              Securities(final Query query) {
                this.query = query;
              }

              public Security security(final String security) {
                if (security == null || security.isBlank()) {
                  throw new IllegalArgumentException(security);
                }
                return new Security(this.query.addPath(security));
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/33">Получить таблицу инструментов торговой сессии по рынку в целом. например: https://iss.moex.com/iss/engines/stock/markets/shares/securities.xml</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }

              public final class Security {
                private final Query query;

                Security(final Query query) {
                  this.query = query;
                }

                public Orderbook orderbook() {
                  return new Orderbook(this.query.addPath("orderbook"));
                }

                public Candles candles() {
                  return new Candles(this.query.addPath("candles"));
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/52">Получить данные по конкретному инструменту рынка. например: https://iss.moex.com/iss/engines/stock/markets/shares/securities/aflt.xml</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }

                public Trades trades() {
                  return new Trades(this.query.addPath("trades"));
                }

                public Candleborders candleborders() {
                  return new Candleborders(this.query.addPath("candleborders"));
                }

                public final class Orderbook {
                  private final Query query;

                  Orderbook(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/54">Получить стакан заявок по инструменту. например: https://iss.moex.com/iss/engines/stock/markets/shares/securities/aflt/orderbook.xml</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }

                public final class Candles {
                  private final Query query;

                  Candles(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/155">Получить свечи указанного инструмента по дефолтной группе режимов.</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }

                public final class Trades {
                  private final Query query;

                  Trades(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/55">Получить сделки по инструменту. например: https://iss.moex.com/iss/engines/stock/markets/shares/securities/aflt/trades.xml</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }

                public final class Candleborders {
                  private final Query query;

                  Candleborders(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/156"></a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }
              }
            }

            public final class Secstats {
              private final Query query;

              Secstats(final Query query) {
                this.query = query;
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/823">Промежуточные "итоги дня". только для фондового рынка</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }
            }

            public final class Turnovers {
              private final Query query;

              Turnovers(final Query query) {
                this.query = query;
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/96">Получить текущее значение оборота по рынку</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }
            }

            public final class Orderbook {
              private final Query query;

              Orderbook(final Query query) {
                this.query = query;
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/36">Получить стаканы заявок всех инструментов рынка. например: https://iss.moex.com/iss/engines/stock/markets/shares/orderbook.xml</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }
            }
          }
        }
      }
    }

    public final class History {
      private final Query query;

      History(final Query query) {
        this.query = query;
      }

      public Otc otc() {
        return new Otc(this.query.addPath("otc"));
      }

      public Engines engines() {
        return new Engines(this.query.addPath("engines"));
      }

      public final class Otc {
        private final Query query;

        Otc(final Query query) {
          this.query = query;
        }

        public Providers providers() {
          return new Providers(this.query.addPath("providers"));
        }

        public final class Providers {
          private final Query query;

          Providers(final Query query) {
            this.query = query;
          }

          public Nsd nsd() {
            return new Nsd(this.query.addPath("nsd"));
          }

          public final class Nsd {
            private final Query query;

            Nsd(final Query query) {
              this.query = query;
            }

            public Markets markets() {
              return new Markets(this.query.addPath("markets"));
            }

            public final class Markets {
              private final Query query;

              Markets(final Query query) {
                this.query = query;
              }

              public Market market(final String market) {
                if (market == null || market.isBlank()) {
                  throw new IllegalArgumentException(market);
                }
                return new Market(this.query.addPath(market));
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/833">Обобщенные данные отс пфи и репо - список рынков.</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }

              public final class Market {
                private final Query query;

                Market(final Query query) {
                  this.query = query;
                }

                public Daily daily() {
                  return new Daily(this.query.addPath("daily"));
                }

                public Monthly monthly() {
                  return new Monthly(this.query.addPath("monthly"));
                }

                public final class Daily {
                  private final Query query;

                  Daily(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/835">Ежедневные обобщенные данные отс пфи и репо.</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }

                public final class Monthly {
                  private final Query query;

                  Monthly(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/837">Ежедневные обобщенные данные отс пфи и репо.</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }
              }
            }
          }
        }
      }

      public final class Engines {
        private final Query query;

        Engines(final Query query) {
          this.query = query;
        }

        public Engine engine(final String engine) {
          if (engine == null || engine.isBlank()) {
            throw new IllegalArgumentException(engine);
          }
          return new Engine(this.query.addPath(engine));
        }

        public Stock stock() {
          return new Stock(this.query.addPath("stock"));
        }

        public final class Engine {
          private final Query query;

          Engine(final Query query) {
            this.query = query;
          }

          public Markets markets() {
            return new Markets(this.query.addPath("markets"));
          }

          public final class Markets {
            private final Query query;

            Markets(final Query query) {
              this.query = query;
            }

            public Market market(final String market) {
              if (market == null || market.isBlank()) {
                throw new IllegalArgumentException(market);
              }
              return new Market(this.query.addPath(market));
            }

            public final class Market {
              private final Query query;

              Market(final Query query) {
                this.query = query;
              }

              public Securities securities() {
                return new Securities(this.query.addPath("securities"));
              }

              public Listing listing() {
                return new Listing(this.query.addPath("listing"));
              }

              public Boards boards() {
                return new Boards(this.query.addPath("boards"));
              }

              public Yields yields() {
                return new Yields(this.query.addPath("yields"));
              }

              public Dates dates() {
                return new Dates(this.query.addPath("dates"));
              }

              public Sessions sessions() {
                return new Sessions(this.query.addPath("sessions"));
              }

              public Session session() {
                return new Session(this.query.addPath("session"));
              }

              public Boardgroups boardgroups() {
                return new Boardgroups(this.query.addPath("boardgroups"));
              }

              public final class Securities {
                private final Query query;

                Securities(final Query query) {
                  this.query = query;
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/62">Получить историю по всем бумагам на рынке за одну дату. например: https://iss.moex.com/iss/history/engines/stock/markets/index/securities.xml?date=2010-11-22</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }

                public Security security(final String security) {
                  if (security == null || security.isBlank()) {
                    throw new IllegalArgumentException(security);
                  }
                  return new Security(this.query.addPath(security));
                }

                public final class Security {
                  private final Query query;

                  Security(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/63">Получить историю по одной бумаге на рынке за интервал дат.</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }

                  public Dates dates() {
                    return new Dates(this.query.addPath("dates"));
                  }

                  public final class Dates {
                    private final Query query;

                    Dates(final Query query) {
                      this.query = query;
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/61">Получить интервал дат в истории для указанного рынка и бумаги.</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }
                  }
                }
              }

              public final class Listing {
                private final Query query;

                Listing(final Query query) {
                  this.query = query;
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/118">Список неторгуемых инструментов с указанием интервалов торгуемости по режимам</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }
              }

              public final class Boards {
                private final Query query;

                Boards(final Query query) {
                  this.query = query;
                }

                public Board board(final String board) {
                  if (board == null || board.isBlank()) {
                    throw new IllegalArgumentException(board);
                  }
                  return new Board(this.query.addPath(board));
                }

                public final class Board {
                  private final Query query;

                  Board(final Query query) {
                    this.query = query;
                  }

                  public Securities securities() {
                    return new Securities(this.query.addPath("securities"));
                  }

                  public Dates dates() {
                    return new Dates(this.query.addPath("dates"));
                  }

                  public Listing listing() {
                    return new Listing(this.query.addPath("listing"));
                  }

                  public Yields yields() {
                    return new Yields(this.query.addPath("yields"));
                  }

                  public final class Securities {
                    private final Query query;

                    Securities(final Query query) {
                      this.query = query;
                    }

                    public Security security(final String security) {
                      if (security == null || security.isBlank()) {
                        throw new IllegalArgumentException(security);
                      }
                      return new Security(this.query.addPath(security));
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/64">Получить историю торгов для всех бумаг на указанном режиме торгов отфильтрованных по дате.</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }

                    public final class Security {
                      private final Query query;

                      Security(final Query query) {
                        this.query = query;
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/65">Получить историю торгов для указанной бумаги на указанном режиме торгов за указанный интервал дат.</a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }

                      public Dates dates() {
                        return new Dates(this.query.addPath("dates"));
                      }

                      public final class Dates {
                        private final Query query;

                        Dates(final Query query) {
                          this.query = query;
                        }

                        /**
                         * <a href="https://iss.moex.com/iss/reference/66">Получить интервал дат в истории, за которые доступна указанная бумага на рынке на указанном режиме торгов.</a>
                         */
                        public Format format() {
                          return new Format(httpClient, uri, this.query);
                        }
                      }
                    }
                  }

                  public final class Dates {
                    private final Query query;

                    Dates(final Query query) {
                      this.query = query;
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/26">Получить интервал дат, доступных в истории для рынка по заданному режиму торгов.</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }
                  }

                  public final class Listing {
                    private final Query query;

                    Listing(final Query query) {
                      this.query = query;
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/119">Получить данные по листингу бумаг в историческом разрезе по указанному режиму</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }
                  }

                  public final class Yields {
                    private final Query query;

                    Yields(final Query query) {
                      this.query = query;
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/795">Получить историю доходностей для всех бумаг на указанном режиме торгов отфильтрованных по дате.</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }

                    public Security security(final String security) {
                      if (security == null || security.isBlank()) {
                        throw new IllegalArgumentException(security);
                      }
                      return new Security(this.query.addPath(security));
                    }

                    public final class Security {
                      private final Query query;

                      Security(final Query query) {
                        this.query = query;
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/797">Получить историю доходностей для указанной бумаги на указанном режиме торгов за указанный интервал дат.</a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }
                    }
                  }
                }
              }

              public final class Yields {
                private final Query query;

                Yields(final Query query) {
                  this.query = query;
                }

                public Security security(final String security) {
                  if (security == null || security.isBlank()) {
                    throw new IllegalArgumentException(security);
                  }
                  return new Security(this.query.addPath(security));
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/791">Получить историю рассчитанных доходностей для всех бумаг на указанном режиме торгов отфильтрованных по дате.</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }

                public final class Security {
                  private final Query query;

                  Security(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/793">Получить историю доходностей по одной бумаге на рынке за интервал дат.</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }
              }

              public final class Dates {
                private final Query query;

                Dates(final Query query) {
                  this.query = query;
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/83">Получить даты, за которые доступны данные на указанных рынке и торговой системе.</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }
              }

              public final class Sessions {
                private final Query query;

                Sessions(final Query query) {
                  this.query = query;
                }

                public Session session(final String session) {
                  if (session == null || session.isBlank()) {
                    throw new IllegalArgumentException(session);
                  }
                  return new Session(this.query.addPath(session));
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/811">Список сессий доступных в итогах торгов. только для фондового рынка!</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }

                public final class Session {
                  private final Query query;

                  Session(final Query query) {
                    this.query = query;
                  }

                  public Securities securities() {
                    return new Securities(this.query.addPath("securities"));
                  }

                  public Boards boards() {
                    return new Boards(this.query.addPath("boards"));
                  }

                  public Boardgroups boardgroups() {
                    return new Boardgroups(this.query.addPath("boardgroups"));
                  }

                  public final class Securities {
                    private final Query query;

                    Securities(final Query query) {
                      this.query = query;
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/813">Получить историю по всем бумагам на рынке за одну дату. например: https://iss.moex.com/iss/history/engines/stock/markets/index/securities.xml?date=2010-11-22</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }

                    public Security security(final String security) {
                      if (security == null || security.isBlank()) {
                        throw new IllegalArgumentException(security);
                      }
                      return new Security(this.query.addPath(security));
                    }

                    public final class Security {
                      private final Query query;

                      Security(final Query query) {
                        this.query = query;
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/817">Получить историю по одной бумаге на рынке за интервал дат.</a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }
                    }
                  }

                  public final class Boards {
                    private final Query query;

                    Boards(final Query query) {
                      this.query = query;
                    }

                    public Board board(final String board) {
                      if (board == null || board.isBlank()) {
                        throw new IllegalArgumentException(board);
                      }
                      return new Board(this.query.addPath(board));
                    }

                    public final class Board {
                      private final Query query;

                      Board(final Query query) {
                        this.query = query;
                      }

                      public Securities securities() {
                        return new Securities(this.query.addPath("securities"));
                      }

                      public final class Securities {
                        private final Query query;

                        Securities(final Query query) {
                          this.query = query;
                        }

                        /**
                         * <a href="https://iss.moex.com/iss/reference/821">Получить историю торгов для всех бумаг на указанном режиме торгов отфильтрованных по дате.</a>
                         */
                        public Format format() {
                          return new Format(httpClient, uri, this.query);
                        }

                        public Security security(final String security) {
                          if (security == null || security.isBlank()) {
                            throw new IllegalArgumentException(security);
                          }
                          return new Security(this.query.addPath(security));
                        }

                        public final class Security {
                          private final Query query;

                          Security(final Query query) {
                            this.query = query;
                          }

                          /**
                           * <a href="https://iss.moex.com/iss/reference/815">Получить историю торгов для указанной бумаги на указанном режиме торгов за указанный интервал дат.</a>
                           */
                          public Format format() {
                            return new Format(httpClient, uri, this.query);
                          }
                        }
                      }
                    }
                  }

                  public final class Boardgroups {
                    private final Query query;

                    Boardgroups(final Query query) {
                      this.query = query;
                    }

                    public Boardgroup boardgroup(final String boardgroup) {
                      if (boardgroup == null || boardgroup.isBlank()) {
                        throw new IllegalArgumentException(boardgroup);
                      }
                      return new Boardgroup(this.query.addPath(boardgroup));
                    }

                    public final class Boardgroup {
                      private final Query query;

                      Boardgroup(final Query query) {
                        this.query = query;
                      }

                      public Securities securities() {
                        return new Securities(this.query.addPath("securities"));
                      }

                      public final class Securities {
                        private final Query query;

                        Securities(final Query query) {
                          this.query = query;
                        }

                        public Security security(final String security) {
                          if (security == null || security.isBlank()) {
                            throw new IllegalArgumentException(security);
                          }
                          return new Security(this.query.addPath(security));
                        }

                        public final class Security {
                          private final Query query;

                          Security(final Query query) {
                            this.query = query;
                          }

                          /**
                           * <a href="https://iss.moex.com/iss/reference/819">Получить историю торгов для указанной бумаги на выбранной группе режимов торгов за указанный интервал дат.</a>
                           */
                          public Format format() {
                            return new Format(httpClient, uri, this.query);
                          }
                        }
                      }
                    }
                  }
                }
              }

              public final class Session {
                private final Query query;

                Session(final Query query) {
                  this.query = query;
                }

                public Session_ session(final String session_) {
                  if (session_ == null || session_.isBlank()) {
                    throw new IllegalArgumentException(session_);
                  }
                  return new Session_(this.query.addPath(session_));
                }

                public final class Session_ {
                  private final Query query;

                  Session_(final Query query) {
                    this.query = query;
                  }

                  public Boardgroups boardgroups() {
                    return new Boardgroups(this.query.addPath("boardgroups"));
                  }

                  public final class Boardgroups {
                    private final Query query;

                    Boardgroups(final Query query) {
                      this.query = query;
                    }

                    public Boardgroup boardgroup(final String boardgroup) {
                      if (boardgroup == null || boardgroup.isBlank()) {
                        throw new IllegalArgumentException(boardgroup);
                      }
                      return new Boardgroup(this.query.addPath(boardgroup));
                    }

                    public final class Boardgroup {
                      private final Query query;

                      Boardgroup(final Query query) {
                        this.query = query;
                      }

                      public Securities securities() {
                        return new Securities(this.query.addPath("securities"));
                      }

                      public final class Securities {
                        private final Query query;

                        Securities(final Query query) {
                          this.query = query;
                        }

                        /**
                         * <a href="https://iss.moex.com/iss/reference/825">Получить историю торгов для всех бумаг на указанной группе режимов торгов за указанную дату.</a>
                         */
                        public Format format() {
                          return new Format(httpClient, uri, this.query);
                        }
                      }
                    }
                  }
                }
              }

              public final class Boardgroups {
                private final Query query;

                Boardgroups(final Query query) {
                  this.query = query;
                }

                public Boardgroup boardgroup(final String boardgroup) {
                  if (boardgroup == null || boardgroup.isBlank()) {
                    throw new IllegalArgumentException(boardgroup);
                  }
                  return new Boardgroup(this.query.addPath(boardgroup));
                }

                public final class Boardgroup {
                  private final Query query;

                  Boardgroup(final Query query) {
                    this.query = query;
                  }

                  public Yields yields() {
                    return new Yields(this.query.addPath("yields"));
                  }

                  public Dates dates() {
                    return new Dates(this.query.addPath("dates"));
                  }

                  public Listing listing() {
                    return new Listing(this.query.addPath("listing"));
                  }

                  public Securities securities() {
                    return new Securities(this.query.addPath("securities"));
                  }

                  public final class Yields {
                    private final Query query;

                    Yields(final Query query) {
                      this.query = query;
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/799">Получить доходности торгов для всех бумаг на указанной группе режимов торгов за указанную дату.</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }

                    public Security security(final String security) {
                      if (security == null || security.isBlank()) {
                        throw new IllegalArgumentException(security);
                      }
                      return new Security(this.query.addPath(security));
                    }

                    public final class Security {
                      private final Query query;

                      Security(final Query query) {
                        this.query = query;
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/801">Получить историю доходностей для указанной бумаги на выбранной группе режимов торгов за указанный интервал дат.</a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }
                    }
                  }

                  public final class Dates {
                    private final Query query;

                    Dates(final Query query) {
                      this.query = query;
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/51">Получить интервал дат для указанной группы режимов торгов.</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }
                  }

                  public final class Listing {
                    private final Query query;

                    Listing(final Query query) {
                      this.query = query;
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/120">Получить данные по листингу бумаг в историческом разрезе по указанной группе режимов</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }
                  }

                  public final class Securities {
                    private final Query query;

                    Securities(final Query query) {
                      this.query = query;
                    }

                    public Security security(final String security) {
                      if (security == null || security.isBlank()) {
                        throw new IllegalArgumentException(security);
                      }
                      return new Security(this.query.addPath(security));
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/67">Получить историю торгов для всех бумаг на указанной группе режимов торгов за указанную дату.</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }

                    public final class Security {
                      private final Query query;

                      Security(final Query query) {
                        this.query = query;
                      }

                      public Dates dates() {
                        return new Dates(this.query.addPath("dates"));
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/68">Получить историю торгов для указанной бумаги на выбранной группе режимов торгов за указанный интервал дат.</a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }

                      public final class Dates {
                        private final Query query;

                        Dates(final Query query) {
                          this.query = query;
                        }

                        /**
                         * <a href="https://iss.moex.com/iss/reference/69">Получить интервал дат для указанной бумаги на заданной группе режимов торгов.</a>
                         */
                        public Format format() {
                          return new Format(httpClient, uri, this.query);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }

        public final class Stock {
          private final Query query;

          Stock(final Query query) {
            this.query = query;
          }

          public Totals totals() {
            return new Totals(this.query.addPath("totals"));
          }

          public Markets markets() {
            return new Markets(this.query.addPath("markets"));
          }

          public Zcyc zcyc() {
            return new Zcyc(this.query.addPath("zcyc"));
          }

          public final class Totals {
            private final Query query;

            Totals(final Query query) {
              this.query = query;
            }

            public Boards boards() {
              return new Boards(this.query.addPath("boards"));
            }

            public Securities securities() {
              return new Securities(this.query.addPath("securities"));
            }

            public final class Boards {
              private final Query query;

              Boards(final Query query) {
                this.query = query;
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/161">Список режимов обобщенной информации по фондовому рынку</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }

              public Board board(final String board) {
                if (board == null || board.isBlank()) {
                  throw new IllegalArgumentException(board);
                }
                return new Board(this.query.addPath(board));
              }

              public final class Board {
                private final Query query;

                Board(final Query query) {
                  this.query = query;
                }

                public Securities securities() {
                  return new Securities(this.query.addPath("securities"));
                }

                public final class Securities {
                  private final Query query;

                  Securities(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/163">Обобщенная информация по фондовому рынку по выбранному режиму</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }

                  public Security security(final String security) {
                    if (security == null || security.isBlank()) {
                      throw new IllegalArgumentException(security);
                    }
                    return new Security(this.query.addPath(security));
                  }

                  public final class Security {
                    private final Query query;

                    Security(final Query query) {
                      this.query = query;
                    }

                    /**
                     * <a href="https://iss.moex.com/iss/reference/164">Обобщенная информация по фондовому рынку по выбранному режиму и инструменту</a>
                     */
                    public Format format() {
                      return new Format(httpClient, uri, this.query);
                    }
                  }
                }
              }
            }

            public final class Securities {
              private final Query query;

              Securities(final Query query) {
                this.query = query;
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/162">Обобщенная информация по фондовому рынку</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }
            }
          }

          public final class Markets {
            private final Query query;

            Markets(final Query query) {
              this.query = query;
            }

            public Shares shares() {
              return new Shares(this.query.addPath("shares"));
            }

            public final class Shares {
              private final Query query;

              Shares(final Query query) {
                this.query = query;
              }

              public Securities securities() {
                return new Securities(this.query.addPath("securities"));
              }

              public final class Securities {
                private final Query query;

                Securities(final Query query) {
                  this.query = query;
                }

                public Changeover changeover() {
                  return new Changeover(this.query.addPath("changeover"));
                }

                public final class Changeover {
                  private final Query query;

                  Changeover(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/123">Информация по техническому изменению торговых кодов</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }
              }
            }
          }

          public final class Zcyc {
            private final Query query;

            Zcyc(final Query query) {
              this.query = query;
            }

            /**
             * <a href="https://iss.moex.com/iss/reference/783">История изменения параметров кбд (кривая бескупоной доходности).</a>
             */
            public Format format() {
              return new Format(httpClient, uri, this.query);
            }
          }
        }
      }
    }

    public final class Rms {
      private final Query query;

      Rms(final Query query) {
        this.query = query;
      }

      public Engines engines() {
        return new Engines(this.query.addPath("engines"));
      }

      public final class Engines {
        private final Query query;

        Engines(final Query query) {
          this.query = query;
        }

        public Engine engine(final String engine) {
          if (engine == null || engine.isBlank()) {
            throw new IllegalArgumentException(engine);
          }
          return new Engine(this.query.addPath(engine));
        }

        public final class Engine {
          private final Query query;

          Engine(final Query query) {
            this.query = query;
          }

          public Objects objects() {
            return new Objects(this.query.addPath("objects"));
          }

          public final class Objects {
            private final Query query;

            Objects(final Query query) {
              this.query = query;
            }

            public Irr irr() {
              return new Irr(this.query.addPath("irr"));
            }

            public final class Irr {
              private final Query query;

              Irr(final Query query) {
                this.query = query;
              }

              /**
               * <a href="https://iss.moex.com/iss/reference/764">Индикаторы риска</a>
               */
              public Format format() {
                return new Format(httpClient, uri, this.query);
              }

              public Filters filters() {
                return new Filters(this.query.addPath("filters"));
              }

              public final class Filters {
                private final Query query;

                Filters(final Query query) {
                  this.query = query;
                }

                /**
                 * <a href="https://iss.moex.com/iss/reference/766">Доступные параметры фильтрации для индикаторов рисков</a>
                 */
                public Format format() {
                  return new Format(httpClient, uri, this.query);
                }
              }
            }
          }
        }
      }
    }

    public final class Events {
      private final Query query;

      Events(final Query query) {
        this.query = query;
      }

      public Event_id event_id(final String event_id) {
        if (event_id == null || event_id.isBlank()) {
          throw new IllegalArgumentException(event_id);
        }
        return new Event_id(this.query.addPath(event_id));
      }

      /**
       * <a href="https://iss.moex.com/iss/reference/193">Мероприятия биржи</a>
       */
      public Format format() {
        return new Format(httpClient, uri, this.query);
      }

      public final class Event_id {
        private final Query query;

        Event_id(final Query query) {
          this.query = query;
        }

        /**
         * <a href="https://iss.moex.com/iss/reference/194">Контент мероприятия биржи</a>
         */
        public Format format() {
          return new Format(httpClient, uri, this.query);
        }
      }
    }

    public final class Analyticalproducts {
      private final Query query;

      Analyticalproducts(final Query query) {
        this.query = query;
      }

      public Netflow2 netflow2() {
        return new Netflow2(this.query.addPath("netflow2"));
      }

      public Futoi futoi() {
        return new Futoi(this.query.addPath("futoi"));
      }

      public Curves curves() {
        return new Curves(this.query.addPath("curves"));
      }

      public final class Netflow2 {
        private final Query query;

        Netflow2(final Query query) {
          this.query = query;
        }

        public Securities securities() {
          return new Securities(this.query.addPath("securities"));
        }

        public final class Securities {
          private final Query query;

          Securities(final Query query) {
            this.query = query;
          }

          public Security security(final String security) {
            if (security == null || security.isBlank()) {
              throw new IllegalArgumentException(security);
            }
            return new Security(this.query.addPath(security));
          }

          /**
           * <a href="https://iss.moex.com/iss/reference/767"></a>
           */
          public Format format() {
            return new Format(httpClient, uri, this.query);
          }

          public final class Security {
            private final Query query;

            Security(final Query query) {
              this.query = query;
            }

            /**
             * <a href="https://iss.moex.com/iss/reference/769"></a>
             */
            public Format format() {
              return new Format(httpClient, uri, this.query);
            }
          }
        }
      }

      public final class Futoi {
        private final Query query;

        Futoi(final Query query) {
          this.query = query;
        }

        public Securities securities() {
          return new Securities(this.query.addPath("securities"));
        }

        public final class Securities {
          private final Query query;

          Securities(final Query query) {
            this.query = query;
          }

          public Security security(final String security) {
            if (security == null || security.isBlank()) {
              throw new IllegalArgumentException(security);
            }
            return new Security(this.query.addPath(security));
          }

          /**
           * <a href="https://iss.moex.com/iss/reference/807"></a>
           */
          public Format format() {
            return new Format(httpClient, uri, this.query);
          }

          public final class Security {
            private final Query query;

            Security(final Query query) {
              this.query = query;
            }

            /**
             * <a href="https://iss.moex.com/iss/reference/809"></a>
             */
            public Format format() {
              return new Format(httpClient, uri, this.query);
            }
          }
        }
      }

      public final class Curves {
        private final Query query;

        Curves(final Query query) {
          this.query = query;
        }

        public Securities securities() {
          return new Securities(this.query.addPath("securities"));
        }

        public final class Securities {
          private final Query query;

          Securities(final Query query) {
            this.query = query;
          }

          /**
           * <a href="https://iss.moex.com/iss/reference/859">Будущие ставки для ценообразования нестандартных инструментов (деривативов)</a>
           */
          public Format format() {
            return new Format(httpClient, uri, this.query);
          }

          public Security security(final String security) {
            if (security == null || security.isBlank()) {
              throw new IllegalArgumentException(security);
            }
            return new Security(this.query.addPath(security));
          }

          public final class Security {
            private final Query query;

            Security(final Query query) {
              this.query = query;
            }

            /**
             * <a href="https://iss.moex.com/iss/reference/861">Будущие ставки для ценообразования нестандартных инструментов (деривативов)</a>
             */
            public Format format() {
              return new Format(httpClient, uri, this.query);
            }
          }
        }
      }
    }

    public final class Securities {
      private final Query query;

      Securities(final Query query) {
        this.query = query;
      }

      public Security security(final String security) {
        if (security == null || security.isBlank()) {
          throw new IllegalArgumentException(security);
        }
        return new Security(this.query.addPath(security));
      }

      /**
       * <a href="https://iss.moex.com/iss/reference/5">Список бумаг торгуемых на московской бирже.</a>
       */
      public Format format() {
        return new Format(httpClient, uri, this.query);
      }

      public final class Security {
        private final Query query;

        Security(final Query query) {
          this.query = query;
        }

        public Aggregates aggregates() {
          return new Aggregates(this.query.addPath("aggregates"));
        }

        /**
         * <a href="https://iss.moex.com/iss/reference/13">Получить спецификацию инструмента. например: https://iss.moex.com/iss/securities/imoex.xml</a>
         */
        public Format format() {
          return new Format(httpClient, uri, this.query);
        }

        public Indices indices() {
          return new Indices(this.query.addPath("indices"));
        }

        public final class Aggregates {
          private final Query query;

          Aggregates(final Query query) {
            this.query = query;
          }

          /**
           * <a href="https://iss.moex.com/iss/reference/214">Агрегированные итоги торгов за дату по рынкам</a>
           */
          public Format format() {
            return new Format(httpClient, uri, this.query);
          }
        }

        public final class Indices {
          private final Query query;

          Indices(final Query query) {
            this.query = query;
          }

          /**
           * <a href="https://iss.moex.com/iss/reference/160">Список индексов в которые входит бумага</a>
           */
          public Format format() {
            return new Format(httpClient, uri, this.query);
          }
        }
      }
    }

    public final class Archives {
      private final Query query;

      Archives(final Query query) {
        this.query = query;
      }

      public Engines engines() {
        return new Engines(this.query.addPath("engines"));
      }

      public final class Engines {
        private final Query query;

        Engines(final Query query) {
          this.query = query;
        }

        public Engine engine(final String engine) {
          if (engine == null || engine.isBlank()) {
            throw new IllegalArgumentException(engine);
          }
          return new Engine(this.query.addPath(engine));
        }

        public final class Engine {
          private final Query query;

          Engine(final Query query) {
            this.query = query;
          }

          public Markets markets() {
            return new Markets(this.query.addPath("markets"));
          }

          public final class Markets {
            private final Query query;

            Markets(final Query query) {
              this.query = query;
            }

            public Market market(final String market) {
              if (market == null || market.isBlank()) {
                throw new IllegalArgumentException(market);
              }
              return new Market(this.query.addPath(market));
            }

            public final class Market {
              private final Query query;

              Market(final Query query) {
                this.query = query;
              }

              public Datatype datatype(final String datatype) {
                if (datatype == null || datatype.isBlank()) {
                  throw new IllegalArgumentException(datatype);
                }
                return new Datatype(this.query.addPath(datatype));
              }

              public final class Datatype {
                private final Query query;

                Datatype(final Query query) {
                  this.query = query;
                }

                public Period period(final String period) {
                  if (period == null || period.isBlank()) {
                    throw new IllegalArgumentException(period);
                  }
                  return new Period(this.query.addPath(period));
                }

                public Years years() {
                  return new Years(this.query.addPath("years"));
                }

                public final class Period {
                  private final Query query;

                  Period(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/116">Получить список ccылок на годовые/месячные/дневные файлы с архивом сделок и исторической биржевой информацией. datatype может принимать значения securities или trades. period может принимать значения yearly, monthly или daily. помесячные данные доступны только за последние 30 дней.</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }
                }

                public final class Years {
                  private final Query query;

                  Years(final Query query) {
                    this.query = query;
                  }

                  /**
                   * <a href="https://iss.moex.com/iss/reference/114">Список годов, за которые существуют ссылки на файлы с архивом сделок и исторической биржевой информацией. datatype может принимать значения securities или trades.</a>
                   */
                  public Format format() {
                    return new Format(httpClient, uri, this.query);
                  }

                  public Year year(final String year) {
                    if (year == null || year.isBlank()) {
                      throw new IllegalArgumentException(year);
                    }
                    return new Year(this.query.addPath(year));
                  }

                  public final class Year {
                    private final Query query;

                    Year(final Query query) {
                      this.query = query;
                    }

                    public Months months() {
                      return new Months(this.query.addPath("months"));
                    }

                    public final class Months {
                      private final Query query;

                      Months(final Query query) {
                        this.query = query;
                      }

                      /**
                       * <a href="https://iss.moex.com/iss/reference/115">Список месяцев в году, за которые существуют ссылки на файлы с архивом сделок и исторической биржевой информацией. datatype может принимать значения securities или trades.</a>
                       */
                      public Format format() {
                        return new Format(httpClient, uri, this.query);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    public final class Securitytypes {
      private final Query query;

      Securitytypes(final Query query) {
        this.query = query;
      }

      public Securitytype securitytype(final String securitytype) {
        if (securitytype == null || securitytype.isBlank()) {
          throw new IllegalArgumentException(securitytype);
        }
        return new Securitytype(this.query.addPath(securitytype));
      }

      /**
       * <a href="https://iss.moex.com/iss/reference/132">Типы ценных бумаг</a>
       */
      public Format format() {
        return new Format(httpClient, uri, this.query);
      }

      public final class Securitytype {
        private final Query query;

        Securitytype(final Query query) {
          this.query = query;
        }

        /**
         * <a href="https://iss.moex.com/iss/reference/133">Справочник: тип ценной бумаги</a>
         */
        public Format format() {
          return new Format(httpClient, uri, this.query);
        }
      }
    }
  }
}
