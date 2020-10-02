/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i = 0;
        while(storage[i] != null && i < storage.length) {
            storage[i] = null;
            i++;
        }
    }

    void save(Resume r) {
        for(int i = 0; i < storage.length; i++) {
            if(storage[i] == null) {
                storage[i] = r;
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
        for (int i = 0; i < storage.length; i++) {
            if (uuid.equals(storage[i].uuid)) {
                int k = i;
                storage[i] = null;


                while(storage[k + 1] != null && k + 1 < storage.length) {
                    storage[k] = storage[k + 1];
                    k++;
                }
                i = storage.length;
            }
        }
    }
        /**
         * @return array, contains only Resumes in storage (without null)
         */
        Resume[] getAll () {
            return new Resume[0];
        }

        int size () {
            int i = 0;
            while(storage[i]!=null) {
                i++;
            }
            return i+1;
        }
}
