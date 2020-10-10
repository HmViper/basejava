package topjava.basejava.storage;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void update(Resume resume) {
        int index = searchResume(resume.uuid);
        if (index > -1) {
            storage[index] = resume;
        } else {
            System.out.println("ERROR: Resume " + resume + " is not present");
        }
    }

    void save(Resume resume) {
        if (searchResume(resume.uuid) > -1) {
            System.out.println("ERROR: Resume " + resume + " is already exist");
        } else if (size == storage.length) {
            System.out.println("ERROR: Storage overflow");
        } else {
            storage[size++] = resume;
        }
    }

    Resume get(String uuid) {
        int index = searchResume(uuid);
        if(index > -1) {
            return storage[index];
        } else {
            System.out.println("ERROR: Resume with uuid " + uuid + " not present");
        }
        return null;
    }

    void delete(String uuid) {
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
    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        System.arraycopy(storage, 0, resumes, 0, size);
        return resumes;
    }

    int size() {
        return size;
    }

    private int searchResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
