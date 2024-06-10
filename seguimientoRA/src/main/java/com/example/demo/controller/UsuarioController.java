package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="*")
public class UsuarioController {
	
		@Autowired
		private UsuarioService emailService;
		
	    @Autowired
	    private UsuarioRepository usuarioRepository;

	    @GetMapping
	    public List<Usuario> getAllUsuarios() {
	        return usuarioRepository.findAll();
	    }

	    @PostMapping("/registro/estudiante")
	    public Usuario createUsuarioE(@RequestBody Usuario usuario) { //para registrar un estudiante para presentar la prueba
	    	 	String to = usuario.getCorreo();
		        String subject = "Seguimiento de aprendizaje UFPS";
		        String text = "Estimado " + usuario.getNombre() + ",\n\n" +
		                      "Ha sido elegido para participar en nuestra prueba para el seguimiento\n\n" +
		                      "de los resultados de aprendizaje,\n" +
		                      "Saludos,\n" +
		                      "Programa de Ingeniería en Sistemas, universidad Francisco de Paula Santander";
		        emailService.sendEmail(to, subject, text);
	    	return usuarioRepository.save(usuario);
	        
	    }
	    
	    @PostMapping("/registro/jurado")
	    public Usuario createUsuarioJ(@RequestBody Usuario usuario) { //para registrar un jurado y calificar la prueba
	    	 	String to = usuario.getCorreo();
		        String subject = "Jurado prueba seguimiento de aprendizaje";
		        String text = "Estimado " + usuario.getNombre() + ",\n\n" +
		                      "Ha sido designado correctamente como jurado en las pruebas\n\n" +
		                      "de los resultados de aprendizaje,\n" +
		                      "Saludos,\n" +
		                      "Programa de Ingeniería en Sistemas, universidad Francisco de Paula Santander";
		        emailService.sendEmail(to, subject, text);
	    	return usuarioRepository.save(usuario);
	        
	    }	  

	    @GetMapping("/{id}")
	    public Usuario getUsuarioById(@PathVariable Long id) {
	        return usuarioRepository.findById(id).orElse(null);
	    }

	    @PutMapping("/{id}")
	    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
	        Usuario usuario = usuarioRepository.findById(id).orElse(null);
	        if (usuario != null) {
	            usuario.setNombre(usuarioDetails.getNombre());
	            usuario.setCorreo(usuarioDetails.getCorreo());
	            usuario.setContraseña(usuarioDetails.getContraseña());
	            usuario.setRol(usuarioDetails.getRol());
	            return usuarioRepository.save(usuario);
	        } else {
	            return null;
	        }
	    }

	    @DeleteMapping("/{id}")
	    public void deleteUsuario(@PathVariable Long id) {
	        usuarioRepository.deleteById(id);
	    }
	}

