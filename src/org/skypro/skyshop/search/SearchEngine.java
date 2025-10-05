package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] items;
    private int size = 0;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (size <= items.length) {
            throw new IllegalStateException("Array is full.");
        }
            items[size++] = item;
        }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultIndex = 0;

        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().contains(query)) {
                results[resultIndex++] = item;
                if (resultIndex >= 5) break;
            }
        }
        return results;
    }
}
