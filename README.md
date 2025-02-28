# qa_java

QA Java Project

## Используемая технология

junit- 4.13.2
selenium-java 4.27.0
java- 11
jacoco- 0.8.7
mockito- 3.12.4
maven-4.0.0

## Документация к тестируемому API

https://qa-scooter.praktikum-services.ru/docs/#api-Courier-Login

## Команды

### Запуск всех тестов

Для генерации англядного отчёта необходимо последовательно выполнить команды ниже

``` 1. компилирует код (через терминал)
mvn compiler:compile
``` 

``` 2. 2 раза нажать кнопку ctrl и выбрать mvn verify
mvn verify
```

## Найти в папке target/site/jacoco/ файл index.html,
## нажать на него правой кнопкой мыши и выбрать Open In — Browser — твой браузер.