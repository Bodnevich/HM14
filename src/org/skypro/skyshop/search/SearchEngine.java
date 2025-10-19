package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> items = new ArrayList<>();

    public void add(Searchable item) {
            items.add(item);
        }

    public List<Searchable> findAllMatching(String searchQuery) {
        List<Searchable> results = new ArrayList<>();

        for (Searchable item : items) {
            if (item.getSearchTerm().contains(searchQuery)) {
                results.add(item);
            }
        }

        return results;
    }
}

