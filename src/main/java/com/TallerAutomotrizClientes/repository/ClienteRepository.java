package com.TallerAutomotrizClientes.repository;

import com.TallerAutomotrizClientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
