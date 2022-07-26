/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m2i.webservise;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elouf
 */
@XmlRootElement(name="personne")
public class Personne {
    
    protected int id;
    
    protected String nom;
    
    protected String prenon;

    public Personne(int id, String nom, String prenon) {
        this.id = id;
        this.nom = nom;
        this.prenon = prenon;
    }

    public Personne() {
        
   
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenon() {
        return prenon;
    }

    public void setPrenon(String prenon) {
        this.prenon = prenon;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", prenon=" + prenon + '}';
    }
    
    
    
}
