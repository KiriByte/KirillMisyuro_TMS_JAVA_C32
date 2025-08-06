package org.example.hometask43.service;

import java.util.List;

public interface SerializationService<T> {

    String serialize(List<T> list);

    List<T> deserialize(String data, Class<T> type);
}
