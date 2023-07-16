# Проект по автоматизации тестовых сценариев для сайта компании [Контур](https://kontur.ru/)
## :pushpin: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео пример запуска тестов](#-видео-пример-запуска-тестов)
## :computer: Используемый стек

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg">
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/logo/Java.svg">
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/logo/Selenide.svg">
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="media/logo/Selenoid.svg">
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg">
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/logo/AllureTestOps.svg">
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/logo/Gradle.svg">
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/logo/JUnit5.svg">
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/logo/GitHub.svg">
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/logo/Jenkins.svg">
<a href="https://web.telegram.org/"><img width="6%" title="Telegram" src="media/logo/Telegram.svg">
<a href="https://www.atlassian.com/ru/software/jira"><img width="5%" title="Jira" src="media/logo/Jira.svg">
</p>

- Тесты в данном проекте написаны на языке <code>Java</code> с использованием фреймворка для тестирования [Selenide](https://selenide.org/)
- В качестве сборщика был использован - <code>Gradle</code>
- <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/)
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота 
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>

## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала
```
gradle clean test
```
При выполнении команды тесты запустятся локально.

Также можно переопределить параметры запуска:
```
gradle clean test -DbaseUrl=${BASE_URL} -Dbrowser=${BROWSER} -DbrowserSize=${BROWSER_SIZE}
```
Примечание: для локального запуска тестов необходимо в папку src/test/resources/properties добавить файл credentials.properties с почтой, паролем, именем и фамилией тестового пользователя. Пример заполненного файла:
```
mailAccount = primer@mail.ru
passwordAccount = 123
name = Polina
surname = Rumak
```

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> [Сборка в Jenkins](https://jenkins.autotests.cloud/job/polina_rumak_kontur/)
### Параметры сборки
* <code>BASE_URL</code> – url, по которому будет открываться тестируемое приложение. По-умолчанию - <code>https://kontur.ru</code>.
* <code>BROWSER</code> – браузер и его версия. По-умолчанию - <code>chrome:100.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера. По-умолчанию - <code>1920x1080</code>.
  
<p align="center">
<img title="Jenkins Build" src="media/screens/jenkins.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> [Пример Allure-отчета](https://jenkins.autotests.cloud/job/polina_rumak_kontur/9/allure/)
<p align="center">
<img title="Allure Overview" src="media/screens/allure.png">
</p>

### Результат выполнения теста
Содержание:
* Шаги теста
* Скриншот страницы на последнем шаге
* Page Source
* Логи браузерной консоли
* Видео прогона каждого автотеста

<p align="center">
<img title="Test Results in Alure" src="media/screens/resultTest.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logo/AllureTestOps.svg"> [Интеграция с Allure TestOps](https://allure.autotests.cloud/project/2463/launches)
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

Результаты выполнения отдельных тестов:
* Шаги теста
* Скриншот страницы на последнем шаге
* Page Source
* Логи браузерной консоли
* Видео прогона автотестов

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/result_TestOps.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logo/Jira.svg"> [Интеграция с Jira](https://jira.autotests.cloud/browse/HOMEWORK-732)
Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>. В задаче отображаются прикреплённые к ней тест-кейсы, а также результаты запусков/прохождения тестов.
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/jira.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram
После завершения сборки, бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/telegram.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Видео пример запуска тестов
<p align="center">
  <img title="Selenoid Video" src="media/screens/video.gif">
</p>
