package yt.example.cache;

import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JCache {

    private final Map<String, JCacheBody<?>> cache = new HashMap<>();

    public void add(String name, long refresh, JCacheAction<?> action) {
        this.cache.put(name, new JCacheBody<>(refresh, action));
    }

    public void add(String name, JCacheAction<?> action) {
        this.cache.put(name, new JCacheBody<>(action));
    }

    @Nullable
    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        JCacheBody<T> current = (JCacheBody<T>) this.cache.get(name);
        if (Objects.isNull(current)) return null;
        if (Objects.isNull(current.getData()) || Objects.isNull(current.getLoadTime()) || current.getLoadTime().plusSeconds(current.getRefresh()).isBefore(LocalDateTime.now())) {
            try {
                current.setData(current.getAction().getData());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return current.getData();
    }
}
