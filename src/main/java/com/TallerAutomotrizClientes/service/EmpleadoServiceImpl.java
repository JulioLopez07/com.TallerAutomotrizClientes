package com.TallerAutomotrizClientes.service;

import com.TallerAutomotrizClientes.entity.Empleados;
import com.TallerAutomotrizClientes.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Empleados> findAll() {
        return (List<Empleados>) empleadoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Empleados> findAll(Pageable pageable) {
        return empleadoRepository.findAll(pageable);
    }

    @Override
    public void save(Empleados empleados) {
        empleadoRepository.save(empleados);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleados findOne(Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
