/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Gestion_Echange;

import Utils.Database;
import Services.ArticleService;
import Entities.Article;
import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Riadh
 */
public class ArticleTest {
    public static void main(String[] args) {
        Database m = Database.getInstance();
        

 ArticleService AS = new ArticleService();
 java.util.Date date = Calendar.getInstance().getTime();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    Article a1= new Article(1,5,true,false,true,sqlDate, "neuf","desc","titre");
    AS.ajouterArticle(a1);
        //System.out.println(AS.afficherArticle());
    }
    
  }
