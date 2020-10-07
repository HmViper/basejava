/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    int searchResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                return i;
            }
        }
        return -1;
    }

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void update(Resume r) {
        int index;
        if ((index = searchResume(r.uuid)) > -1) {
            storage[index] = r;
        } else {
            System.out.println("ERROR: Resume is not present");
        }
    }

    void save(Resume r) {
        if (searchResume(r.uuid) > -1) {
            System.out.println("ERROR: Resume is already saved");
        } else if (size == storage.length) {
            System.out.println("ERROR: Storage overload");
        } else {
            storage[size++] = r;
        }
    }

    Resume get(String uuid) {
        return searchResume(uuid) > -1 ? storage[searchResume(uuid)] : null;
    }

    void delete(String uuid) {
        int index;
        if ((index = searchResume(uuid)) > -1) {
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
    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        System.arraycopy(storage, 0, resumes, 0, size);
        return resumes;
    }

    int size() {
        return size;
    }
}
