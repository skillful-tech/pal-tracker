package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();
    private long currentId = 1L;
    public InMemoryTimeEntryRepository()
    {
    }

    public TimeEntry create(TimeEntry timeEntry) {
        Long id = currentId++;

        TimeEntry newTimeEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        timeEntries.put(id, newTimeEntry);
        return newTimeEntry;

    }
    public TimeEntry find(long timeEntryId) {

        return timeEntries.get(timeEntryId);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    public TimeEntry update(long timeEntryId, TimeEntry expected) {

        if (find(timeEntryId) == null) return null;

        TimeEntry updatedEntry = new TimeEntry(
                timeEntryId,
                expected.getProjectId(),
                expected.getUserId(),
                expected.getDate(),
                expected.getHours()
        );

        timeEntries.replace(timeEntryId, updatedEntry);
        return updatedEntry;

    }

    public void delete(long timeEntryId) {
        timeEntries.remove(timeEntryId);
    }

}
