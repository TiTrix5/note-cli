package com.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class NotesStore {

    private final Path dataDir;
    private final Path file;

    public NotesStore() {
        this(Paths.get("data"), Paths.get("data", "notes.csv"));
    }

    public NotesStore(Path dataDir, Path file) {
        this.dataDir = dataDir;
        this.file = file;
    }

    public int add(String text) throws IOException {
        ensureStorage();

        String clean = text.replace("\r", " ").replace("\n", " ").trim();

        int nextId = nextId();
        try (BufferedWriter w = Files.newBufferedWriter(
                file,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        )) {
            w.write(nextId + ";" + clean);
            w.newLine();
        }
        return nextId;
    }

    public String listAsText() throws IOException {
        ensureStorage();
        List<String> lines = readAllRawLines();
        if (lines.isEmpty()) {
            return "(empty)\n";
        }
        StringBuilder sb = new StringBuilder();
        for (String l : lines) {
            sb.append(l).append("\n");
        }
        return sb.toString();
    }

    public int count() throws IOException {
        ensureStorage();
        return readAllRawLines().size();
    }

    private void ensureStorage() throws IOException {
        if (!Files.exists(dataDir)) {
            Files.createDirectories(dataDir);
        }
        if (!Files.exists(file)) {
            Files.createFile(file);
        }
    }

    private List<String> readAllRawLines() throws IOException {
        if (!Files.exists(file)) return new ArrayList<>();
        List<String> raw = Files.readAllLines(file, StandardCharsets.UTF_8);
        List<String> out = new ArrayList<>();
        for (String l : raw) {
            String t = l.trim();
            if (!t.isEmpty()) out.add(t);
        }
        return out;
    }

    private int nextId() throws IOException {
        int max = 0;
        for (String line : readAllRawLines()) {
            int semi = line.indexOf(';');
            if (semi <= 0) continue;
            String idStr = line.substring(0, semi).trim();
            try {
                int id = Integer.parseInt(idStr);
                if (id > max) max = id;
            } catch (NumberFormatException ignored) {
            }
        }
        return max + 1;
    }
}
