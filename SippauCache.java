package uy.gub.fgn.sippau2.common.utils.cache;

import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SippauCache {

    private final Map<String, SippauCacheBody<?>> cache = new HashMap<>();

    public void add(String name, long refresh, SippauCacheAction<?> action) {
        this.cache.put(name, new SippauCacheBody<>(refresh, action));
    }

    public void add(String name, SippauCacheAction<?> action) {
        this.cache.put(name, new SippauCacheBody<>(action));
    }

    @Nullable
    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        SippauCacheBody<T> current = (SippauCacheBody<T>) this.cache.get(name);
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
