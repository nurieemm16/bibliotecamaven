/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecamaven2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Usuario")
    private Integer id_Usuario;

    @Column(name = "nombre_Usuario", nullable = false)
    private String nombre_Usuario;

    @Column(name = "rol", nullable = false)
    private String rol;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Libro> listaLibrosPrestados = new ArrayList<>();

    public Usuario() {}

    public Usuario(String nombre_Usuario, String rol) {
        this.nombre_Usuario = nombre_Usuario;
        this.rol = rol;
    }

    public Integer getId_Usuario() {
        return id_Usuario;
    }

    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
       public List<Libro> getListaLibrosPrestados() {
        return listaLibrosPrestados;
    }

    public void setListaLibrosPrestados(List<Libro> listaLibrosPrestados) {
        this.listaLibrosPrestados = listaLibrosPrestados;
    }

 }