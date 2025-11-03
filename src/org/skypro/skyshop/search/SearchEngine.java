package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> items = new HashSet<>();

    public void add(Searchable item) {
        items.add(item);
        }

    public Set<Searchable> findAllMatching(String searchQuery) {
        Set<Searchable> results = new TreeSet<>(new CustomComparator());

        for (Searchable item : items) {
            if (item.getSearchTerm().contains(searchQuery)) {
                results.add(item);
            }
        }

        return results;
    }
}

class CustomComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        String s1 = o1.getStringRepresentation();
        String s2 = o2.getStringRepresentation();

        int lenCompare = Integer.compare(s2.length(), s1.length());

        if (lenCompare == 0) {
            return s1.compareTo(s2);
        }
        return lenCompare;
    }
}

