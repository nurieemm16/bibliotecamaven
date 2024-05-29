/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bibliotecamaven2;

/**
 *
 * @author nuria
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.*;
import java.util.*;


public interface LibroRepository extends JpaRepository<Libro, Integer> {
    
    
  /* Aquí añadimos nuevos métodos y peticiones asociadas que no existen en JPA*/
    
    @Query ("SELECT COUNT(*) AS countlibros FROM Libro")
    Integer countLibros();
    
    
}