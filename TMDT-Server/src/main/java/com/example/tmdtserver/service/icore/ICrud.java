package com.example.tmdtserver.service.icore;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICrud<E> {
    Page<E> listAll(Pageable pageable);

    boolean save(String inputCode, E e);

    void delete(Long id);

    String randomCode(E e);
}
