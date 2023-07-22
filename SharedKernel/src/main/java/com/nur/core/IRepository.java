package com.nur.core;

public interface IRepository<T, UID> {
    T FindByIdAsyn(UID id);
    void CreateAsync(T obj);
}
