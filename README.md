# Юнит тесты для сайта stellarburgers.nomoreparties.site

## Описание
Проект содержит некоторые юнит тесты для приложения
"stellarburgers.nomoreparties.site".

# Как запустить автотесты
Запуск тестов реализован через maven.

### Запуск тестов
```bash
mvn clean test
```

# Отчет jacoco
Процент покрытия можно посмотреть в файле index.html, открыв его в браузере.
Путь: target/site/jacoco/index.html
### Собрать отчет jacoco
```bash
mvn verify
```