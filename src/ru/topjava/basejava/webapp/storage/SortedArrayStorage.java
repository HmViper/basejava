package ru.topjava.basejava.webapp.storage;

import ru.topjava.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insertElement(Resume resume, int index) {
        int indexToInsert = -index - 1;
        System.arraycopy(storage, indexToInsert, storage, indexToInsert + 1, size - indexToInsert);
        storage[indexToInsert] = resume;
    }

    @Override
    protected void deleteElement(int index) {
        int indDeleted = size - index - 1;
        if (indDeleted > 0) {
            System.arraycopy(storage, index + 1, storage, index, indDeleted);
        }
    }
}
