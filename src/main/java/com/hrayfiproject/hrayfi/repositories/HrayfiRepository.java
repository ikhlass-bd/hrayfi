package com.hrayfiproject.hrayfi.repositories;

import com.hrayfiproject.hrayfi.entities.Hrayfi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HrayfiRepository extends JpaRepository<Hrayfi, Long> {

}
