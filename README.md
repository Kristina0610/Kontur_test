# Проект по автоматизации тестовых сценариев для сайта компании [Контур](https://kontur.ru/)
## :pushpin: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео пример запуска тестов](#-видео-пример-запуска-тестов)
## :computer: Используемый стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="media/logo/Java.svg">
<img width="6%" title="Selenide" src="media/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="media/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg">
<img width="5%" title="Allure TestOps" src="media/logo/AllureTestOps.svg">
<img width="6%" title="Gradle" src="media/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="media/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="media/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="media/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="media/logo/Telegram.svg">
<img width="5%" title="Jira" src="media/logo/Jira.svg">
</p>

- Тесты в данном проекте написаны на языке <code>Java</code> с использованием фреймворка для тестирования [Selenide](https://selenide.org/)
- В качестве сборщика был использован - <code>Gradle</code>
- <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/)
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота 
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>
 
Содержание Allure-отчета:
* Шаги теста
* Скриншот страницы на последнем шаге
* Page Source
* Логи браузерной консоли
* Видео прогона автотестов

## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала
```
gradle clean running_tests -DbaseUrl="https://kontur.ru" -Dbrowser="chrome:100.0" -DbrowserSize="1920x1080"
```
При выполнении команды тесты запустятся удаленно в <code>Selenoid</code>.

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> Сборка в Jenkins
<p align="center">
<img title="Jenkins Build" src="media/screens/jenkins.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> Пример Allure-отчета
<p align="center">
<img title="Allure Overview" src="media/screens/allure.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="media/screens/resultTest.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logo/AllureTestOps.svg"> Интеграция с Allure TestOps
На вкладке Dashboards отображается:
- Количество тест-кейсов и их статус
- Соотношение ручных/автоматизированных тестов
- Результаты запусков/прохождения тестов в графике по датам
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/Dashboards_TestOps.png">
</p>

На вкладке Launches можно увидеть:
- Результаты запусков автоматизированных тестов
- Результаты прохождения ручных тест-кейсов
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/Launches_TestOps.png">
</p>

Результаты прохождения отдельных тестов:
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/result_TestOps.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logo/Jira.svg"> Интеграция с Jira
Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>. В задаче отображаются прикреплённые к ней тест-кейсы, а также результаты запусков/прохождения тестов.
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/jira.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота
После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/telegram.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Видео пример запуска тестов
<p align="center">
  <img title="Selenoid Video" src="media/screens/video.gif">
</p>
