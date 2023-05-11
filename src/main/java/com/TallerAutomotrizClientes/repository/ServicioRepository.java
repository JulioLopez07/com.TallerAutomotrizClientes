package com.TallerAutomotrizClientes.repository;

import com.TallerAutomotrizClientes.entity.Automovil;
import com.TallerAutomotrizClientes.entity.Cliente;
import com.TallerAutomotrizClientes.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    List<Servicio> findByEmpleadosId(Integer idEmpleado);
    List<Servicio> findByCliente(Cliente cliente);
    List<Servicio> findByAutomovil(Automovil automovil);

    List<Servicio> findTop5ByOrderByIdDesc();

}
