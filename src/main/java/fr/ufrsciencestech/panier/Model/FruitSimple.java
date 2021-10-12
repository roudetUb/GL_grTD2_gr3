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
public abstract class FruitSimple implements Fruit{
    
    private double prix;
    private String origine;
    
    @Override
    public abstract boolean isSeedless();
    public abstract String toString();
    
    @Override
    public double getPrix() {
        return this.prix;
    }

    @Override
    public String getOrigine() {
        return this.origine;
    }
    
    public boolean equals(Object o){
        return (o == this);
    }
    
}
