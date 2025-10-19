package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    String getObjectName();

    default String getStringRepresentation() {
        return getObjectName() + " - " + getContentType();
    }
}
