package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> items = new HashSet<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public Set<Searchable> findAllMatching(String searchQuery) {
        return items.stream()
                .filter(item -> item.getSearchTerm().contains(searchQuery))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new CustomComparator())));
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

