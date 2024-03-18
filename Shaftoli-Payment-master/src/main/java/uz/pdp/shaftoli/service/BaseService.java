package uz.pdp.shaftoli.service;

import java.util.ArrayList;
import java.util.List;

public interface BaseService <T>{
    T add(T t);
    List<T> getAll();
    T getById();

}
