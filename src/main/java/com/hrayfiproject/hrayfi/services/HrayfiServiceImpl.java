package com.hrayfiproject.hrayfi.services;

import com.hrayfiproject.hrayfi.entities.Hrayfi;
import com.hrayfiproject.hrayfi.repositories.HrayfiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrayfiServiceImpl implements HrayfiService {
    @Autowired
    HrayfiRepository hrayfiRepository;
    //MultipartFile file//
    @Override
    public Hrayfi saveHrayfi(Hrayfi hrayfi) {


        return hrayfiRepository.save(hrayfi);
    }

    @Override
    public Hrayfi updateHrayfi(Hrayfi hrayfi) {
        return hrayfiRepository.save(hrayfi);
    }

    @Override
    public Hrayfi getHrayfi(Long id) {
        return hrayfiRepository.findById(id).get();
    }

    @Override
    public List<Hrayfi> getAllHrayfis() {
        return hrayfiRepository.findAll();
    }

    @Override
    public void deleteHrayfi(Hrayfi hrayfi) {
hrayfiRepository.delete(hrayfi);
    }

    @Override
    public void deleteHrayfiById(Long id) {
hrayfiRepository.deleteById(id);
    }

    @Override
    public void deleteAllHrayfis() {
hrayfiRepository.deleteAll();
    }

    @Override
    public Page<Hrayfi> getAllHrayfiByPage(int page, int size) {
        return hrayfiRepository.findAll(PageRequest.of(page,size));
    }
}
