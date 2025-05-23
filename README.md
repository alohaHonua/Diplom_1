# 📘 Дипломный проект №1: Unit-тесты

🛠️ Используемые технологии:  
Java 11, JUnit 4, Maven, Jacoco, Mockito

📋 Описание проекта:  
Программа моделирует создание и состав бургера в Stellar Burgers.  
Цель — покрыть юнит-тестами основные классы модели: булку, ингредиенты, бургер.  
Используются моки, параметризация и отчёт о покрытии кода.

✅ Выполнено в рамках основного задания:
- Покрыты тестами классы `Bun`, `Ingredient`, `Burger`, `IngredientType`
- Использованы моки с Mockito (`Bun` и `Ingredient` в `BurgerTest`)
- Параметризация реализована в `BunTest` и `IngredientTest` с `@RunWith(Parameterized.class)`
- Создан отдельный тест на `IngredientType` для попадания в покрытие
- Покрытие Jacoco основной логики — 100%
- Проект собирается через Maven
- Все тесты находятся в `src/test/java`
- Отчёт Jacoco приложен

🚀 Для запуска тестов:
```bash
mvn clean test
```
📊 Для создания отчёта Jacoco:

```bash
mvn jacoco:report
```

Открыть отчёт можно по пути:
`target/site/jacoco/index.html`