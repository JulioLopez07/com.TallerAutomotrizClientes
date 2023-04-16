package com.TallerAutomotrizClientes.repository;

import com.TallerAutomotrizClientes.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    // otros métodos si los hay
}
