package com.TallerAutomotrizClientes;

import org.springframework.stereotype.Controller;

@Controller
public class AppController {
    public String verPaginaDeInicio(){
        return "index";
    }
}
