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
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if(storage[i] != null) {
                if (uuid.equals(storage[i].uuid)) {
                    return storage[i];
                }
            }
            else {
                return null;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (uuid.equals(storage[i].uuid)) {
                  for(int k = i; k < storage.length; k++) {
                      if(k == storage.length-1) {
                          storage[k] = null;
                      } else {
                          storage[k] = storage[k+1];
                      }
                }
                i = storage.length;
            }
        }
    }
        /**
         * @return array, contains only Resumes in storage (without null)
         */
        Resume[] getAll () {
            if(storage.length > 0) {
                for (int i = 0; i < storage.length; i++) {
                    if (storage[i] == null) {
                        Resume[] realStorage = new Resume[i];
                        System.arraycopy(storage, 0, realStorage, 0, i);
                        return realStorage;
                    }
                }
            }
            return new Resume[0];
        }

        int size () {
            int i = 0;
            while(storage[i]!=null) {
                i++;
            }
            return i;
        }
}
