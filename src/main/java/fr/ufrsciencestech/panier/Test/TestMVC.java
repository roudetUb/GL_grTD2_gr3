package fr.ufrsciencestech.panier.Test;

import fr.ufrsciencestech.panier.Model.*;
import fr.ufrsciencestech.panier.Controler.*;
import fr.ufrsciencestech.panier.View.*;

//utilise pour springIoC :
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author celine
 */
public class TestMVC {
    private VueGraphique vueg;      //pour pouvoir changer de vue si on le souhaite
    private Controleur controleur;  //pour pouvoir changer de controleur si on le souhaite
    
    /**
     * @return the vueg
     */
    public VueGraphique getVueg() {
        return vueg;
    }

    /**
     * @param vueg the vueg to set
     */
    public void setVueg(VueGraphique vueg) {
        this.vueg = vueg;
    }

    /**
     * @return the controleur
     */
    public Controleur getControleur() {
        return controleur;
    }

    /**
     * @param controleur the controleur to set
     */
    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    public static void main(String[] args) throws PanierPleinException{
        Panier p = new Panier(4);
        p.ajoute(new Banane(3.5,"france"));
        p.ajoute(new Cerise(5,"Espagne"));
        System.out.println(p.getFruits(0).toString());
        System.out.println(p.getFruits(1).toString());
        //une vue console abonnee au panier :
        VueConsole vuec = new VueConsole();
        p.addObserver(vuec);
        
        //une vue graphique simple abonnee au panier :
        VueGraphiqueSimple vueg = new VueGraphiqueSimple();
        //VueGraphiqueSimpleAWT vueg = new VueGraphiqueSimpleAWT();
        Controleur cs = new ControleurSimple();
        cs.setPanier(p);
        p.addObserver(vueg);
        vueg.addControleur(cs);
        
        //La meme chose que ci-dessus mais avec SpringIoC :
        /*ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TestMVC test = (TestMVC)context.getBean("MVC");  //SpringIoC
        test.setControleur( (Controleur)context.getBean("Controleur") );  //SpringIoC
        test.setVueg( (VueGraphique)context.getBean("Vue") );   //SpringIoC
        test.getControleur().setPanier(p);  
        p.addObserver(test.getVueg());
        test.getVueg().addControleur(test.getControleur());*/
    }
}
