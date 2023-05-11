package com.TallerAutomotrizClientes.repository;

import com.TallerAutomotrizClientes.entity.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleados, Integer> {

    Empleados findByNombre(String nombreEmpleado);
}
