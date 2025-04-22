package com.informesaberpro.app.controller;

import com.informesaberpro.app.entity.Coordinacion;
import com.informesaberpro.app.repository.CoordinacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CoordinacionController {

    @Autowired
    private CoordinacionRepository coordinacionRepository;

    // Mostrar login de coordinadores
    @GetMapping("/logincoordinadores")
    public String mostrarLoginCoordinadores(Model model) {
        model.addAttribute("coordinador", new Coordinacion());
        return "logincoordinadores";
    }

    // Procesar login
    @PostMapping("/logincoordinadores")
    public String procesarLoginCoordinadores(@ModelAttribute("coordinador") Coordinacion loginData, Model model) {
        Coordinacion coordinador = coordinacionRepository.findByUsuario(loginData.getUsuario());

        if (coordinador != null && coordinador.getContrasena().equals(loginData.getContrasena())) {
            return "redirect:/dashboard";
        }

        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "logincoordinadores";
    }

    // Mostrar formulario de registro
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("coordinador", new Coordinacion());
        return "registro";
    }

    // Procesar registro
    @PostMapping("/registro")
    public String registrarCoordinador(@ModelAttribute("coordinador") Coordinacion coordinador) {
        coordinacionRepository.save(coordinador);
        return "redirect:/logincoordinadores";
    }

    // Página protegida
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
