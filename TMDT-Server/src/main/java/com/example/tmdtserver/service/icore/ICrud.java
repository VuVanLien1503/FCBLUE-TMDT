package com.example.tmdtserver.service.icore;

import org.springframework.data.domain.Page;

public interface ICrud <E>{
    Page<E>listAll(Page page);
    void save(E e);
    void delete(Long id);
}
