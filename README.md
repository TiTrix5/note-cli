Команды запуска
Все команды выполняются через:
java -cp src com.example.App --cmd=<команда> [аргументы]
Добавить заметку
java -cp src com.example.App --cmd=add --text="Купить хлеб"
Показать список заметок
java -cp src com.example.App --cmd=list
Удалить заметку по ID
java -cp src com.example.App --cmd=rm --id=1
Посчитать количество заметок
java -cp src com.example.App --cmd=count

Примеры заметок (файл data/notes.csv)
1;Купить молоко
2;Позвонить другу
3;Test
4;Test
История версий
v1.0.0 — Initial release
•    Основной функционал приложения
•    Добавление заметки (add)
•    Просмотр списка (list)
•    Конфигурирование CI с GitHub Actions
•    Dockerfile для запуска в контейнере
v1.1.0 — Add count command
•    Добавлена команда count
•    Теперь приложение может показывать количество заметок
•    Создан Pull Request из ветки feature
•    Выполнен merge → релиз опубликован
<img width="1915" height="1027" alt="Снимок экрана 2025-12-12 224546" src="https://github.com/user-attachments/assets/6c79a480-4552-4fd4-98b6-bcb11028430c" />
