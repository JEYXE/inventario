package com.fontebo.inventario.Controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ejemplo")
public class ControladorEjemplo {

    @GetMapping
    public String ejemplo() {
        return "Esto es un ejemplo";
    }

}
