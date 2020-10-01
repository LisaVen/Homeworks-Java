package com.company;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection of entries for the account. Use it to save and get history of payments
 */
public class Entries {
    public Collection history;

    void addEntry(Entry entry) {
        history.add(entry);
    }

    Collection<Entry> from(LocalDate date) {
        if (Entry.contains(date)){
            from().add(entry);
        }
        return from(date);
    }

    Collection<Entry> betweenDates(LocalDate from, LocalDate to) {
        betweenDates.toArray();
        betweenDates.subList(from, to);
        return betweenDates(from, to);
    }

    Entry last() {
        final Iterator itr = history.iterator();
        Object lastElement = itr.next();
        while (itr.hasNext()) {
            lastElement = itr.next();
        }
        return last();
    }
}
