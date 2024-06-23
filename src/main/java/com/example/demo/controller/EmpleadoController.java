package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Repository.AreaRepository;
import com.example.demo.Repository.EmpleadoRepository;
import com.example.demo.entity.AreaEntity;
import com.example.demo.entity.EmpleadoEntity;

@Controller
public class EmpleadoController {
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@GetMapping("/")
	public String listarEmpleado(Model model) {
	    List<EmpleadoEntity>listaEmpleado = empleadoRepository.findAll();
	    model.addAttribute("listaEmpleado", listaEmpleado);
	    return "listado";
	} 
	
	@GetMapping("/registrar_empleado")
    public String showRegistrarProducto(Model model) {
        List<AreaEntity>listaAreas = areaRepository.findAll();
        model.addAttribute("listaAreas", listaAreas);
        model.addAttribute("empleado", new EmpleadoEntity());
        return "registrar_empleado";
        }
	
	@PostMapping("/registrar_empleado")
	public String registarEmpleado(Model model, @ModelAttribute EmpleadoEntity empleado) {
		empleadoRepository.save(empleado);
		return "redirect:/";
	}
	
	
	@GetMapping("/editar_empleado/{dni}")
    public String showEditarEmpleado(@PathVariable("dni") String dniEmpleado, Model model) {
        Optional<EmpleadoEntity> empleado = empleadoRepository.findById(dniEmpleado);
        if (empleado.isPresent()) {
            model.addAttribute("empleado", empleado.get());
            List<AreaEntity> listaAreas = areaRepository.findAll();
            model.addAttribute("listaAreas", listaAreas);
            return "editar_empleado";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/actualizar_empleado")
    public String actualizarEmpleado(@ModelAttribute EmpleadoEntity empleado) {
        empleadoRepository.save(empleado);
        return "redirect:/";
    }
    
    
    @GetMapping("/eliminar_empleado/{dni}")
    public String eliminarEmpleado(@PathVariable("dni") String dniEmpleado) {
        empleadoRepository.deleteById(dniEmpleado);
        return "redirect:/";
    }
	
	

}
