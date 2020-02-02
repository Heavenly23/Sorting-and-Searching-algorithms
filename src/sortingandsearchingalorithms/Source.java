/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sortingandsearchingalorithms;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author user
 */
public abstract class Source {
    
    public static class LabelSource extends Label{

        public LabelSource(String name,Color color) {
            super(name);
            setTextFill(color);
            setFont(Font.font("Times New Roman",30));
            
        }
    }

    public static class TextFieldSource extends TextField{
        public TextFieldSource(double prefColumnSize, double fontSize) {
            setPrefColumnCount((int)prefColumnSize);
            setFont(Font.font("Times", FontWeight.BOLD, fontSize));
            
        }
    }

    public static class ButtonSource extends Button{

        public ButtonSource (String name) {
            super(name);
            setFont(new Font("Times New Roman",25));
            setStyle("-fx-background-color:orange");
            
        }
    }
    
    
    
    public static double[] CheckValidity_search(TextFieldSource numbers,TextFieldSource searchBox){
        
            String[] input = numbers.getText().split(",");
            
            String[] searchN = searchBox.getText().split(",");
            
            double[] entries = new double[input.length];
            
            if(input.length != 0 && searchN.length == 1 && !numbers.getText().endsWith(",")){
            
                int i;
                
                for( i = 0; i < entries.length ; i++){
                
                    try {
                    
                        Double.parseDouble(input[i]);
                        
                        entries[i] = Double.parseDouble(input[i]);
                         
                        if(i == 0){
                        
                            try{ 
                                Double.parseDouble(searchN[i]);
                            }
                            catch(NumberFormatException f){
                                
                              searchBox.setStyle("-fx-background-color:red");
                              
                              return null;
   
                          }
                         } 
                     }
                    
                    catch(NumberFormatException f){
                         
                        numbers.setStyle("-fx-background-color:red");
                         
                        return null;
                     }
                  }
                
                  if(i == entries.length){
                  
                      return entries;
                  }

                  }
                
        numbers.setStyle("-fx-background-color:red");
        
        return null;
        
    }
     public double[] CheckValidity_sort(TextFieldSource numbers) {
            String[] input = numbers.getText().split(",");
 
            double[] entries = new double[input.length];
            
            if(input.length != 0 ){
            
                int i;
                
                for(i = 0; i < entries.length ; i++){
                
                    try {
                    
                        Double.parseDouble(input[i]);
                        
                        entries[i] = Double.parseDouble(input[i]);
                     }
                    
                    catch(NumberFormatException f){
                         
                        numbers.setStyle("-fx-background-color:red");
                         
                        return null;
                     }
                  }
                   if(i == entries.length){
                  
                      return entries;
                  }
                  }
                
        numbers.setStyle("-fx-background-color:red");
        
        return null;
    }
}
