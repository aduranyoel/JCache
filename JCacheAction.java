package yt.example.cache;

@FunctionalInterface
public interface JCacheAction<T> {
    T getData();
}
