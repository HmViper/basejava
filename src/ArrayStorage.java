/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        int i = 0;
        while (storage[i] != null && i < storage.length) {
            storage[i] = null;
            i++;
        }
        size = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                size++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (uuid.equals(storage[i].uuid)) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (uuid.equals(storage[i].uuid)) {
                for (int k = i; k < storage.length; k++) {
                    if (k == storage.length - 1) {
                        storage[k] = null;
                    } else {
                        storage[k] = storage[k + 1];
                    }
                }
                i = storage.length;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (storage.length > 0) {
            Resume[] realStorage = new Resume[size];
            System.arraycopy(storage, 0, realStorage, 0, size);
            return realStorage;

        }
        return new Resume[0];
    }

    int size() {
        return size;
    }
}
