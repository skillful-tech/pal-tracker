package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
     TimeEntry find(long timeEntryId);

    List<TimeEntry> list();

    TimeEntry update(long timeEntryId, TimeEntry expected);

    void delete(long timeEntryId);

    TimeEntry create(TimeEntry timeEntryToCreate);
}
