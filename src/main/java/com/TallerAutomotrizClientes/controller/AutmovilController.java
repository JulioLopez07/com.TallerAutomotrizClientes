package com.TallerAutomotrizClientes.controller;

import com.TallerAutomotrizClientes.entity.Automovil;
import com.TallerAutomotrizClientes.entity.Cliente;
import com.TallerAutomotrizClientes.repository.AutomovilRepository;
import com.TallerAutomotrizClientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class AutmovilController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AutomovilRepository automovilRepository;

}
