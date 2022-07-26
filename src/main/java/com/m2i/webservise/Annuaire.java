/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m2i.webservise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Annuaire {

    private static List<Personne> listePersone = new ArrayList<>();

    public Annuaire() {
           listePersone = new ArrayList<>(Arrays.asList(
            new Personne(1,"John", "Mating"),
             new Personne(2,"John2", "Maa"),
              new Personne(3,"John3", "Maa3")
    ));

    }

    public static List<Personne> getAnnuaire() {
        return listePersone;
    }

    public static void setAnnuaire(List<Personne> annuaire) {
        Annuaire.listePersone = annuaire;
    }

    public void addPersone(Personne persone) {
        listePersone.add(persone);
    }

    public void removePersone(int id) {
         int idd=0;
        for( Personne perrr: listePersone){
            idd++;
            if(perrr.getId()== id) {idd--; listePersone.remove(idd); }
         }

    }

    public void modifiePersone(int id, Personne pers) {
        int idd=0;
        for( Personne perrr: listePersone){
            idd++;
             if(perrr.getId()== id) {idd--; listePersone.set(idd, pers); }
         }
        
    }
    
    
    
     public Personne personeByID(int id) {
         for( Personne pers: listePersone){
             if(pers.getId()== id) return pers;
         }
        // throw new Exception("Exception not found");
        return null;
        
    }

}
