package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private List<Searchable> items = new ArrayList<>();

    public void add(Searchable item) {
        items.add(item);
        }

    public Map<String, Searchable> findAllMatching(String searchQuery) {
        Map<String, Searchable> results = new TreeMap<>();

        for (Searchable item : items) {
            if (item.getSearchTerm().contains(searchQuery)) {
                results.put(item.getObjectName(), item);
            }
        }

        return results;
    }
}

