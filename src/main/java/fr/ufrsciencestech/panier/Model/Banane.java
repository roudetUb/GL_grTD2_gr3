/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

/**
 *
 * @author ct434953
 */
public class Banane extends FruitSimple{
    private String origine;
    private double prix;
    
    public Banane(double prix, String origine){
        super(prix, origine);
    }
    @Override
    public boolean isSeedless() {
        return true;
    }

    @Override
    public String toString() {
        return "Banane de " + super.getOrigine() + " coutant " + super.getPrix() + " euros";    
    }
    
}
