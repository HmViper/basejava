package ru.topjava.basejava.webapp.storage;

import ru.topjava.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = searchResume(uuid);
        if (index > -1) {
            return storage[index];
        }
        System.out.println("ERROR: Resume with uuid " + uuid + " not present");
        return null;
    }

    protected abstract int searchResume(String uuid);

}
