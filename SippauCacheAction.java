package uy.gub.fgn.sippau2.common.utils.cache;

@FunctionalInterface
public interface SippauCacheAction<T> {
    T getData();
}
