Notes CLI

Автор

GitHub:https://github.com/TiTrix5

Возможности приложения

Добавление заметок

Просмотр списка заметок

Подсчёт количества заметок

Хранение данных в файле data/notes.csv

Запуск как локально, так и в Docker

CI через GitHub Actions

Работа с ветками, Pull Request и релизами

Формат хранения заметок

Файл: data/notes.csv

id;текст

Пример:

1;Купить хлеб 2;Позвонить другу

▶ Запуск локально (без Docker) Компиляция javac src/com/example/*.java

Добавить заметку java -cp . com.example.App --cmd=add --text="Купить хлеб"

Показать список java -cp . com.example.App --cmd=list

Посчитать количество java -cp . com.example.App --cmd=count

Запуск через Docker Сборка Docker-образа

В корне проекта:

docker build -t notes-cli:dev .

▶ Запуск контейнера

Важно: команда монтирует папку data/ с хоста, чтобы заметки сохранялись после остановки контейнера.

Добавить заметку docker run --rm -v "${PWD}/data:/app/data" notes-cli:dev --cmd=add --text="Купить хлеб"

Показать список заметок docker run --rm -v "${PWD}/data:/app/data" notes-cli:dev --cmd=list

Посчитать количество заметок docker run --rm -v "${PWD}/data:/app/data" notes-cli:dev --cmd=count

История версий v1.0.0 — Initial release

Реализованы команды:

add

list

Настроен CI (GitHub Actions)

Добавлен Dockerfile

Выпущен первый релиз

v1.1.0 — Add count command

Добавлена новая команда:

count

Реализация выполнена в отдельной ветке

Создан Pull Request и выполнен merge

Выпущен релиз v1.1.0\
<img width="1915" height="1027" alt="Снимок экрана 2025-12-12 224546" src="https://github.com/user-attachments/assets/6c79a480-4552-4fd4-98b6-bcb11028430c" />
