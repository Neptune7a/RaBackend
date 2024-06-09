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

	    @PostMapping("/registro")
	    public Usuario createUsuario(@RequestBody Usuario usuario) {
	    	 	String to = usuario.getCorreo();
		        String subject = "Confirmación de Registro";
		        String text = "Estimado " + usuario.getNombre() + ",\n\n" +
		                      "Gracias por registrarse. Su cuenta ha sido creada exitosamente.\n\n" +
		                      "Saludos,\n" +
		                      "El equipo de soporte.";
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

