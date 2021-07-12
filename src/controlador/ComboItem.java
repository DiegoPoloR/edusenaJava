/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author polod
 */
public class ComboItem {
    
    private String key;
    private int value;

    public ComboItem(String key, int value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString(){
        return key;
    }
    public String getKey(){
        return key;
    }

    public int getValue(){
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
}
