# notes-cli

**Автор:** <ВАШ_GITHUB_NICK> — https://github.com/<ВАШ_GITHUB_NICK>

Консольная утилита для хранения текстовых заметок в файле `data/notes.csv`.

## Команды

### Добавить заметку
```bash
java -cp src com.example.App --cmd=add --text="Купить хлеб"
```

### Показать список
```bash
java -cp src com.example.App --cmd=list
```

Если заметок нет — выводится:
```
(empty)
```


## Формат хранения

Каждая строка файла `data/notes.csv`:
```
ID;ТЕКСТ
```

Пример:
```
1;Купить молоко
2;Позвонить другу
```

## Локальный запуск (без Maven)

1) Компиляция:
```bash
javac src/com/example/*.java
```

2) Запуск:
```bash
java -cp src com.example.App --cmd=add --text="Купить хлеб"
java -cp src com.example.App --cmd=list
```

## Docker

Сборка:
```bash
docker build -t notes-cli:dev .
```

Запуск с volume (данные сохраняются на хосте):
```bash
mkdir -p data
docker run --rm -v "$PWD/data:/app/data" notes-cli:dev --cmd=add --text="Test"
docker run --rm -v "$PWD/data:/app/data" notes-cli:dev --cmd=list
```

### PowerShell (Windows)
```powershell
mkdir data -Force | Out-Null
docker run --rm -v "${PWD}\data:/app/data" notes-cli:dev --cmd=add --text="Test"
docker run --rm -v "${PWD}\data:/app/data" notes-cli:dev --cmd=list
```

## Версии (SemVer)

- **v1.0.0** — команды `add` и `list`.

## Заметка про альтернативную фичу `rm`
По ТЗ допускается вместо `count` реализовать `rm` (удаление по `--id`). Делайте это в отдельной ветке `feature/...` и через PR в `main`.
