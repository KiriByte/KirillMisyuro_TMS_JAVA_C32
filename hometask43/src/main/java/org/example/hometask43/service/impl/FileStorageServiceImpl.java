package org.example.hometask43.service.impl;

import org.example.hometask43.service.FileStorageService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    @Override
    public void saveToFile(String filePath, String data) {
        try {
            Files.writeString(Paths.get(filePath), data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<String> readFromFile(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            return Optional.empty();
        }
        try {
            return Optional.of(Files.readString(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
