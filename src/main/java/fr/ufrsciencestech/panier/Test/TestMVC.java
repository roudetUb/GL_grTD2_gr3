package fr.ufrsciencestech.panier.Test;



import fr.ufrsciencestech.panier.Model.*;
import fr.ufrsciencestech.panier.Controler.*;
import fr.ufrsciencestech.panier.View.*;


/**
 *
 * @author celine
 */
public class TestMVC {

    public static void main(String[] args){
        Panier p = new Panier(4);
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
        
        /* //La meme chose mais avec SpringIoC :
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TestMVC test = (TestMVC)context.getBean("MVC");  //SpringIoC
        Controleur cs = (Controleur)context.getBean("Controleur");  //SpringIoC
        p.addObserver(test.vueg);
        test.vueg.addControleur(cs);*/
    }
}
