# Дипломная работа «Облачное хранилище»
## Описание проекта
REST-сервис. Сервис предоставляет REST-интерфейс для загрузки файлов и вывода списка уже загруженных файлов пользователя.

Все запросы к сервису должны быть авторизованы. Веб-приложение (FRONT) подключается к разработанному сервису, а также использует функционал FRONT для авторизации, загрузки и вывода списка файлов пользователя.

Сервис реализовывает все методы, описанные в [yaml-файле](https://github.com/netology-code/jd-homeworks/blob/master/diploma/CloudServiceSpecification.yaml):  
✓ Авторизация;  
✓ Добавление файла;  
✓ Удаление файла;  
✓ Скачивание файла;  
✓ Переименование файла;  
✓ Вывод списка файлов.

Информация о пользователe сервиса (логин для авторизации) и данные, хранится в базе данных PostgreSQL.

## Реализация
✓ Приложение разработано с использованием Spring Boot.  
✓ Использован сборщик пакетов maven.  
✓ Для запуска используется docker, docker-compose.  
✓ Класс [TokenScheduler](https://github.com/VioK0709/Cloudservice/blob/main/src/main/java/com/example/cloudservice/token_scheduler/TokenScheduler.java) гененирует новый токен авторизации каждый чаc.  
✓ Код покрыт unit-тестами с использованием mockito.  
✓ Для запуска приложения нужно открыть в браузере страницу по адресу http://localhost:8080/.
