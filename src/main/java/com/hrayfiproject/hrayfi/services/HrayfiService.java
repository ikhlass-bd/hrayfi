package com.hrayfiproject.hrayfi.services;


import com.hrayfiproject.hrayfi.entities.Hrayfi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HrayfiService {
@Autowired
Hrayfi saveHrayfi(Hrayfi hrayfi);

Hrayfi updateHrayfi(Hrayfi hrayfi);
Hrayfi getHrayfi(Long id);
List<Hrayfi> getAllHrayfis();
void deleteHrayfi(Hrayfi hrayfi);
void deleteHrayfiById(Long id);
void deleteAllHrayfis();
Page<Hrayfi> getAllHrayfiByPage(int page, int size);
}
