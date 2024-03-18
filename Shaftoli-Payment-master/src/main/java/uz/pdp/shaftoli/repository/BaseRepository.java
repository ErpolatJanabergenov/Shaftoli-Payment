package uz.pdp.shaftoli.repository;

import uz.pdp.shaftoli.entity.UserEntity;

import java.util.List;

public interface BaseRepository<T> {
    T save(T t);
    T findByEmail(String email);
    List<T> getAll();
}
