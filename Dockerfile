FROM eclipse-temurin:17-jdk

WORKDIR /app

# Исходники
COPY src ./src

# Каталог данных (в репозитории лежит data/.gitkeep)
COPY data ./data

# Компиляция без Maven
RUN mkdir -p data && javac src/com/example/*.java

# Внешний том для сохранения notes.csv на хост
VOLUME ["/app/data"]

ENTRYPOINT ["java", "-cp", "src", "com.example.App"]
