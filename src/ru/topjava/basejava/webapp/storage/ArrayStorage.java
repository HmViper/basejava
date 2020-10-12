package ru.topjava.basejava.webapp.storage;

import ru.topjava.basejava.webapp.model.Resume;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = searchResume(resume.getUuid());
        if (index > -1) {
            storage[index] = resume;
        } else {
            System.out.println("ERROR: Resume " + resume + " is not present");
        }
    }

    public void save(Resume resume) {
        if (searchResume(resume.getUuid()) > -1) {
            System.out.println("ERROR: Resume " + resume + " is already exist");
        } else if (size == storage.length) {
            System.out.println("ERROR: Storage overflow");
        } else {
            storage[size++] = resume;
        }
    }

    public Resume get(String uuid) {
        int index = searchResume(uuid);
        if(index > -1) {
            return storage[index];
        }
        System.out.println("ERROR: Resume with uuid " + uuid + " not present");
        return null;
    }

    public void delete(String uuid) {
        int index = searchResume(uuid);
        if (index > -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("ERROR: Resume in not present");
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        System.arraycopy(storage, 0, resumes, 0, size);
        return resumes;
    }

    public int size() {
        return size;
    }

    private int searchResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
