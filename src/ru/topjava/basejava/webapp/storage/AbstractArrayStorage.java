package ru.topjava.basejava.webapp.storage;

import ru.topjava.basejava.webapp.model.Resume;

import java.util.Arrays;

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
        int index = getIndex(uuid);
        if (index > -1) {
            return storage[index];
        }
        System.out.println("ERROR: Resume with uuid " + uuid + " not present");
        return null;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index > -1) {
            storage[index] = resume;
        } else {
            System.out.println("ERROR: Resume " + resume + " is not present");
        }
    }

    public void save(Resume resume) {
        int ind = getIndex(resume.getUuid());
        if (ind  > -1) {
            System.out.println("ERROR: Resume " + resume + " is already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            insertElement(resume, ind);
            size++;
        }
    }


    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            deleteElement(index);
            size--;
        } else {
            System.out.println("ERROR: Resume with uuid " + uuid + " in not present");
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }


    protected abstract int getIndex(String uuid);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void deleteElement(int index);

}
