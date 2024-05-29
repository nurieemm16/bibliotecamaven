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
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Autor")
    private Integer id_Autor;

    @Column(name = "nombre_Autor")
    private String nombre_Autor;

    @Column(name = "anoNacimiento")
    private Integer anoNacimiento;

    @Column(name = "anoMuerte")
    private Integer anoMuerte;

  
 
    public Integer getId_Autor() {
        return id_Autor;
    }

    public String getNombre_Autor() {
        return nombre_Autor;
    }

    public void setNombre_Autor(String nombre_Autor) {
        this.nombre_Autor = nombre_Autor;
    }

    public Integer getAnoNacimiento() {
        return anoNacimiento;
    }

    public void setAnoNacimiento(Integer anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public Integer getAnoMuerte() {
        return anoMuerte;
    }

    public void setAnoMuerte(Integer anoMuerte) {
        this.anoMuerte = anoMuerte;
    }


    
}
