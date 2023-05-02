package com.TallerAutomotrizClientes.service;

import com.TallerAutomotrizClientes.entity.Empleados;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpleadoService {
    List<Empleados> findAll();

    Page<Empleados> findAll(Pageable pageable);

    public void save(Empleados empleados);

    public Empleados findOne(Integer id);

    public void delete(Integer id);
}
