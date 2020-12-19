package ru.evteev.extmap;

import ru.evteev.extmap.enums.ReturnType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public interface ExtMap<K, V> extends Map<K, V> {

    default List<K> getKeysByValue(V value, int maxKeysCount) {
        return getKeysByValue(value, maxKeysCount, ReturnType.NO_EXCEPTION);
    }

    default List<K> getKeysByValue(V value, int maxKeysCount, ReturnType returnType) {
        List<K> list = new ArrayList<>();
        for (Entry<K, V> entry : this.entrySet()) {
            if (entry.getValue().equals(value)) {
                list.add(entry.getKey());
            }
            if (list.size() == maxKeysCount) {
                break;
            }
        }
        if (list.isEmpty() && returnType == ReturnType.EXCEPTION) {
            throw new NoSuchElementException(
                    "'No keys for value: " + value.toString() + "'");
        } else {
            return list;
        }
    }

    default K getFirstKeyByValue(V value) {
        return getFirstKeyByValue(value, ReturnType.NO_EXCEPTION);
    }

    default K getFirstKeyByValue(V value, ReturnType returnType) {
        List<K> keys = getKeysByValue(value, 1, returnType);
        if (keys.isEmpty() && returnType == ReturnType.EXCEPTION) {
            throw new NoSuchElementException(
                    "'No keys for value: " + value.toString() + "'");
        } else {
            return keys.isEmpty() ? null : keys.get(0);
        }
    }

    default List<K> getAllKeysByValue(V value) {
        return getAllKeysByValue(value, ReturnType.NO_EXCEPTION);
    }

    // All keys: maxKeysCount = Integer.MAX_VALUE
    default List<K> getAllKeysByValue(V value, ReturnType returnType) {
        return getKeysByValue(value, Integer.MAX_VALUE, returnType);
    }

}
