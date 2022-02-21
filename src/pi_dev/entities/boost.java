/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_dev.entities;
/**
 *
 * @author Msi
 */
public class boost {
  private int  Id_boost;
  private String Type_boost;
  private float Prix_boost	;
    public boost() {
    }

    public boost(String Type_boost, float Prix_boost) {
        this.Type_boost = Type_boost;
        this.Prix_boost = Prix_boost;
    }

    public int getId_boost() {
        return Id_boost;
    }

    public void setId_boost(int Id_boost) {
        this.Id_boost = Id_boost;
    }

    public String getType_boost() {
        return Type_boost;
    }


    public void setType_boost(String Type_boost) {
        this.Type_boost = Type_boost;
    }

    public float getPrix_boost() {
        return Prix_boost;
    }

    public void setPrix_boost(float Prix_boost) {
        this.Prix_boost = Prix_boost;
    }

    @Override
    public String toString() {
        return "boost{" + "Id_boost=" + Id_boost + ", Type_boost=" + Type_boost + ", Prix_boost=" + Prix_boost + '}';
    }
    
}
