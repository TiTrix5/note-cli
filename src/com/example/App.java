package com.example;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Map<String, String> opts = parseArgs(args);

        String cmd = opts.get("cmd");
        if (cmd == null || cmd.isBlank()) {
            printUsage();
            System.exit(1);
        }

        NotesStore store = new NotesStore();

        try {
            switch (cmd) {
                case "add": {
                    String text = opts.get("text");
                    if (text == null || text.isBlank()) {
                        System.out.println("Missing --text");
                        System.exit(2);
                    }
                    int id = store.add(text);
                    System.out.println("Added #" + id);
                    break;
                }
                case "list": {
                    String out = store.listAsText();
                    System.out.print(out);
                    break;
                }
// Для альтернативной фичи "rm" см. заметку в README: можно реализовать в отдельной ветке.
                default:
                    System.out.println("Unknown cmd: " + cmd);
                    printUsage();
                    System.exit(3);
            }
        } catch (Exception e) {
            // Простой вывод для CLI-утилиты
            System.out.println("Error: " + e.getMessage());
            System.exit(10);
        }
    }

    private static Map<String, String> parseArgs(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (String a : args) {
            if (!a.startsWith("--")) continue;
            int eq = a.indexOf('=');
            if (eq <= 2) continue;
            String key = a.substring(2, eq).trim();
            String value = a.substring(eq + 1).trim();
            // значение уже приходит без кавычек от shell, если оно было "..."
            map.put(key, value);
        }
        return map;
    }

    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println("  --cmd=add --text=\"Купить хлеб\"");
        System.out.println("  --cmd=list");
    }
}
