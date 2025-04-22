package com.informesaberpro.app.controller;

import com.informesaberpro.app.entity.Estudiante;
import com.informesaberpro.app.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping("/login")
    public String mostrarLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam("correo") String correo,
                                @RequestParam("contrasena") String contrasena,
                                Model model) {
        Estudiante estudiante = estudianteRepository.findByCorreoElectronicoAndNumeroDocumento(correo, contrasena);
        if (estudiante != null) {
            model.addAttribute("estudiante", estudiante);
            return "estudiantes/panel"; // asegúrate de que panel.html existe
        } else {
            model.addAttribute("error", "Credenciales inválidas");
            return "login";
        }
    }
}
