package util;

import java.util.HashMap;
import java.util.Map;

public abstract class Distributor<T> {
    public Map<T, Integer> countMap = new HashMap<>();

    public abstract void initCountMap();

    public Integer getCount(T key) {
        Integer count = countMap.get(key);
        if (count == null) return 0;
        return count;
    }
}
