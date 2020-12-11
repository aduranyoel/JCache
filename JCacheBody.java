package yt.example.cache;

import java.time.LocalDateTime;

class JCacheBody<T> {

    private static final long DEFAULT_REFRESH = 3600;

    private long refresh;
    private LocalDateTime loadTime;
    private T data;
    private JCacheAction<T> action;

    public JCacheBody() {
    }

    public JCacheBody(JCacheAction<T> action) {
        setRefresh(DEFAULT_REFRESH);
        setAction(action);
    }

    public JCacheBody(long refresh, JCacheAction<T> action) {
        setRefresh(refresh);
        setAction(action);
    }

    public long getRefresh() {
        return refresh;
    }

    public void setRefresh(long refresh) {
        this.refresh = refresh;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
        this.setLoadTime(LocalDateTime.now());
    }

    public JCacheAction<T> getAction() {
        return action;
    }

    public void setAction(JCacheAction<T> action) {
        this.action = action;
    }

    public LocalDateTime getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(LocalDateTime loadTime) {
        this.loadTime = loadTime;
    }
}