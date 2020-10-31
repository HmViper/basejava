package ru.topjava.basejava.webapp.exception;

public class NotExistStorageException extends StorageException {

    public NotExistStorageException(String uuid) {
        super("Resume "+ uuid + " not exist", uuid);
    }
}
