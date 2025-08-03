package org.example.hometask43.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.hometask43.service.SerializationService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class GsonSerializationService<T> implements SerializationService<T> {

    private final Gson gson;

    public GsonSerializationService() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public String serialize(List<T> list) {
        return gson.toJson(list);
    }

    @Override
    public List<T> deserialize(String data, Class<T> type) {
        Type collectionType = TypeToken.getParameterized(List.class, type).getType();
        return gson.fromJson(data, collectionType);
    }
}
