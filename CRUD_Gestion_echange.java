/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.gestion_echange;

/**
 *
 * @author Riadh
 */
public class CRUD_Gestion_echange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnexionBD m = ConnexionBD.getInstance();
        
        Membre m1= new Membre("aziz","hamadi");
        System.out.print(m1);
        Membre m2= new Membre("mahdi","rjeb");
        System.out.print(m2);
        
        
        MembreService mb=new MembreService();
   
       /* mb.ajouterMembre(m2);
        /*System.out.println(mb.afficherMembre());*/
        Article a1= new Article("aziz","hamadi");
        System.out.println(a1);
        ArticleService art=new ArticleService();
        art.ajouterArticle(a1);
        
        Echange e= new Echange(110,5,78,11,10);
        System.out.println(a1);
        EchangeService ech=new EchangeService();
        ech.ajouterEchange(e);
    }
    
}
