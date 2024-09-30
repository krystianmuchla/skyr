package com.github.krystianmuchla.home.domain.note.removed;

import com.github.krystianmuchla.home.infrastructure.http.exception.NotFoundException;

public class RemovedNoteService {
    public static void update(RemovedNote removedNote) {
        var result = RemovedNotePersistence.update(removedNote);
        if (!result) {
            throw new NotFoundException();
        }
    }

    public static void delete(RemovedNote removedNote) {
        var result = RemovedNotePersistence.delete(removedNote);
        if (!result) {
            throw new NotFoundException();
        }
    }
}