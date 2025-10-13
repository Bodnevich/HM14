package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] items;
    private int size = 0;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (size >= items.length) {
            throw new IllegalStateException("Array is full.");
        }
            items[size++] = item;
        }

    private int countSubstrings (String source, String target) {
        int count = 0;
        int index = 0;
        while ((index = source.indexOf(target, index)) != -1) {
            count++;
            index += target.length();
        }
        return count;
    }

    public Searchable findMostRelevant (String searchQuery) throws BestResultNotFound {
        int maxScore = -1;
        Searchable bestMatch = null;

        if (size == 0) {
            throw new BestResultNotFound("Нет объектов для поиска");
        }

        for (int i =0; i < size; i++) {
            Searchable item = items[i];
                int score = countSubstrings(item.getSearchTerm(), searchQuery);

                if (score > maxScore) {
                    maxScore = score;
                    bestMatch = item;
                }
            }

        if (bestMatch == null) {
            throw new BestResultNotFound("Для запроса " + searchQuery + " не найден подходящий объект");
        }

        return bestMatch;
    }
}
