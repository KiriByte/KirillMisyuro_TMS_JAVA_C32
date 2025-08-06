package org.example.hometask43.service;

import java.util.Optional;

public interface FileStorageService {
    void saveToFile(String filePath, String data);

    Optional<String> readFromFile(String filePath);
}
