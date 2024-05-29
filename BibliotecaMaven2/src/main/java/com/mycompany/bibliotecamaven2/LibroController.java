/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecamaven2;

/**
 *
 * @author nuria
 */
// Importa las anotaciones y clases necesarias de Spring Framework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Marca la clase como un controlador REST, lo que significa que manejará las solicitudes HTTP
@RestController
// Define la ruta base para las solicitudes HTTP manejadas por este controlador
@RequestMapping("/libros")
public class LibroController {

    // Inyecta una instancia de PersonRepository, que proporciona métodos para interactuar con la base de datos
    @Autowired
    private LibroRepository libroRepository;

    // Manage GET request on /libros and return a list of all books
    /* 
  
    GET http://localhost:8080/libros
    */
    @GetMapping
    public List<Libro> getAllLibros() {
        // Llama al método findAll() del repositorio para obtener todas las personas
        return libroRepository.findAll();
    }
    
    
     // Maneja las solicitudes GET a /productos/{id} para obtener un producto específico por su ID
    /* 
    
    GET http://localhost:8080/libros/1
    */
    @GetMapping("{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable int id) {
        // Busca un libro por su ID
        Optional<Libro> result=libroRepository.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    // Añade libro
    /* 
    
    POST http://localhost:8080/libros
    Body / raw / JSON
    {
        "titulo": "Libro 9",
        "autor": "Postmethod",
        "disponibilidad": 1
    }
    */
    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        // Guarda la nueva persona en la base de datos y la devuelve en la respuesta
        return libroRepository.save(libro);
    }
    
    
    // Cambia la disponibilidad del libro
    /* 
    Ruta:
    PUT http://localhost:8080/libros/updateDispo/1
    */
    @PutMapping ("updateDispo/{id}")
    public ResponseEntity<Libro> updateDispoLibro (@PathVariable int id)
    {
        // Busca un libro por su ID
        Optional<Libro>  result=libroRepository.findById(id);
        if (result.isPresent()) {
            Libro libroToUpdate = result.get();
            Integer disponibilidad=libroToUpdate.getDisponibilidad(); // Coje valor actual
            if (disponibilidad==0){
                libroToUpdate.setDisponibilidad(1); 
            }else{
                libroToUpdate.setDisponibilidad(0);
            }
            libroRepository.save(libroToUpdate); // guarda el objeto updateado en la base de datos
            return ResponseEntity.ok(libroToUpdate);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    // http://localhost:8080/libros/1
    /* {
    "titulo": "Nuevo Titulo",
    "autor": "Nuevo Autor"
    }     */

      @PutMapping("{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable int id, @RequestBody Libro libroDetails) {
        Optional<Libro> result = libroRepository.findById(id);
        if (result.isPresent()) {
            Libro libroToUpdate = result.get();
            libroToUpdate.setTitulo(libroDetails.getTitulo());
            libroToUpdate.setAutor(libroDetails.getAutor());
            libroRepository.save(libroToUpdate);
            return ResponseEntity.ok(libroToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 
    
    // Devuelve cuantos libros hay
    /* 
    Ruta Postman:
    GET http://localhost:8080/libros/countlibros
    */
    @GetMapping ("countlibros")
    public ResponseEntity<Integer>countLibros() {
        // Llama al método findAll() del repositorio para obtener todas las personas
        Integer count=libroRepository.countLibros();
        System.out.println(count);
        
        if (count != null) {
            return ResponseEntity.ok(count);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
     // Borra Libros
    
     @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable int id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

