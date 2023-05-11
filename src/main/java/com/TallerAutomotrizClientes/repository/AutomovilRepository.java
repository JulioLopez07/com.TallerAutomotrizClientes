package com.TallerAutomotrizClientes.repository;

import com.TallerAutomotrizClientes.entity.Automovil;
import com.TallerAutomotrizClientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutomovilRepository extends JpaRepository<Automovil, Integer> {
    List<Automovil> findByCliente(Cliente cliente);
}
