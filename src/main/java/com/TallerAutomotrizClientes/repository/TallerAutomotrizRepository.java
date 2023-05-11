package com.TallerAutomotrizClientes.repository;

import com.TallerAutomotrizClientes.entity.TallerAutomotriz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TallerAutomotrizRepository extends JpaRepository<TallerAutomotriz, Integer> {
}
