package com.github.brandontm.veterinarity.veterinarity.consultas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.brandontm.veterinarity.veterinarity.entity.Consulta;

@Controller
public class ConsultasController {
    @Autowired
    ServletContext servletContext;

    @GetMapping("/consulta")
    public String consultas(Model model) {
        List<Consulta> consultas = (List<Consulta>) servletContext.getAttribute("consultas");
        if (consultas == null)
            consultas = new ArrayList<Consulta>();

        servletContext.setAttribute("consultas", consultas);

        return "consultas";
    }

    @GetMapping("/consulta/agregar/{petId}")
    public String agregarConsultaForm(@PathVariable("petId") int petId, Model model) {
        model.addAttribute("consulta", new Consulta());
        return "agregar_consulta";
    }

    @PostMapping("/consulta/agregar/{petId}")
    public String agregarConsulta(@PathVariable("petId") int petId,
            @ModelAttribute(value = "consulta") Consulta consulta) {

        List<Consulta> consultas = (List<Consulta>) servletContext.getAttribute("consultas");
        if (consultas == null)
            consultas = new ArrayList<Consulta>();

        int id = consultas.stream().flatMapToInt(c -> IntStream.of(c.getId())).max().orElse(0) + 1; // get next id
        consulta.setId(id);
        consulta.setFecConsulta(LocalDate.now());
        consulta.setIdPaciente(petId);
        consultas.add(consulta);
        servletContext.setAttribute("consultas", consultas);
        return "agregar_consulta";
    }
}
