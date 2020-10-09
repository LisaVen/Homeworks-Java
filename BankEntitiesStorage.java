package com.company;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BankEntitiesStorage {
    void save(Object entity);

    void saveAll(List entities);

    Object findByKey(Object key);

    List findAll();

    void deleteByKey(Object key);

    void deleteAll(List entities);
}


public class SimpleEntitiesStorage implements BankEntitiesStorage {
    private final Map storage = new HashMap();
    private final KeyExtractor keyExtractor;

    public SimpleEntitiesStorage(KeyExtractor keyExtractor) {
        this.keyExtractor = keyExtractor;
    }

    @Override
    public void save(Object entity) {
        //adding to Map this entity
        storage.put(keyExtractor, findByKey(keyExtractor));
    }

    @Override
    public void saveAll(List entities) {
        //adding to Map List of entities???
        for(Object entity : entities){
            save(entity);
        }
    }

    @Override
    public Object findByKey(Object key) { //я думала, здесь должен быть SimpleEntitiesStorage, но идея говорит иначе
        key = keyExtractor;
        return storage.get(key);
    }

    public List findAll() {
        Collection Val = storage.values();
        return (List) Val;
    } //I don't know what to do with this one, it is pretty tough;

    @Override
    public void deleteByKey(Object key) {
        key = keyExtractor;
        storage.remove(key);
        //storage.put(key, null); //если ключи остаются, а значения удаляются.
    }

    @Override
    public void deleteAll(List entities) {
        //перебор по значениям, применяя deleteByKey:
        for (Map.Entry<> item : storage.entrySet()) {
            Object key = item.getKey();
            deleteByKey(key);
        }
    }
}

//create class AnalyticsManager
