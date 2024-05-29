/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecamaven2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;
//URL: http://localhost:8080/autores
    // GET all authors
    @GetMapping
 public List<Autor> getAllAutores() {
    return autorRepository.findAll();
}
//http://localhost:8080/autores/{id}
    // GET author by ID
    @GetMapping("{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable int id) {
        Optional<Autor> result = autorRepository.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    //http://localhost:8080/autores
    // POST create a new author
    @PostMapping
    public Autor createAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    
    //http://localhost:8080/autores/{id}
    // PUT update an author
    @PutMapping("{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable int id, @RequestBody Autor autorDetails) {
        Optional<Autor> result = autorRepository.findById(id);
        if (result.isPresent()) {
            Autor autorToUpdate = result.get();
            autorToUpdate.setNombre_Autor(autorDetails.getNombre_Autor());
            autorToUpdate.setAnoNacimiento(autorDetails.getAnoNacimiento());
            autorToUpdate.setAnoMuerte(autorDetails.getAnoMuerte());
            autorRepository.save(autorToUpdate);
            return ResponseEntity.ok(autorToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    //http://localhost:8080/autores/{id}
    // DELETE an author
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable int id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

