package uy.gub.fgn.sippau2.common.utils.cache;

import java.time.LocalDateTime;

class SippauCacheBody<T> {

    private static final long DEFAULT_REFRESH = 3600;

    private long refresh;
    private LocalDateTime loadTime;
    private T data;
    private SippauCacheAction<T> action;

    public SippauCacheBody() {
    }

    public SippauCacheBody(SippauCacheAction<T> action) {
        setRefresh(DEFAULT_REFRESH);
        setAction(action);
    }

    public SippauCacheBody(long refresh, SippauCacheAction<T> action) {
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

    public SippauCacheAction<T> getAction() {
        return action;
    }

    public void setAction(SippauCacheAction<T> action) {
        this.action = action;
    }

    public LocalDateTime getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(LocalDateTime loadTime) {
        this.loadTime = loadTime;
    }
}