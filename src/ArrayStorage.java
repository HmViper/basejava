/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i=0;
        while(storage[i]!=null) {
            storage[i] = null;
            i++;
        }
    }

    void save(Resume r) {
        for(int i = 0; i < storage.length; i++) {
            if(storage[i] == null) {
                storage[i] = r;
                i = storage.length;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (uuid.equals(resume.uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {
        return 0;
    }
}
