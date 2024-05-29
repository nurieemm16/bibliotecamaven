/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecamaven2;

import javax.persistence.Entity;
import java.util.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 *
 * @author nuria
 */

@Entity
@Table(name="libro")
//@IdClass(Libro.class)
public class Libro {
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_Libro")
    private Integer id_Libro;
   @Column(name="titulo")
    private String titulo;
    @Column(name="autor")
    private String autor;
   @Column(name="disponibilidad")
    private Integer disponibilidad;

    

   public Integer getId_Libro() {
        return id_Libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getDisponibilidad() {
        return disponibilidad;
    }

    public void setId_Libro(Integer id_Libro) {
        this.id_Libro = id_Libro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDisponibilidad(Integer disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}


