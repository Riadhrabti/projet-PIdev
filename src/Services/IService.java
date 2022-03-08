/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public interface IService<T> {
    
     
    boolean add (T t) ;
    ObservableList<T> read();
    boolean update(T t);
    boolean delete(T t);
    
}
