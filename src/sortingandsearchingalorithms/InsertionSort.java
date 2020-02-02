/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sortingandsearchingalorithms;

import java.awt.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author user
 */
public class InsertionSort extends Source {
     
      public FlowPane mainpane;

      public int index = 1;
      
      public double num = 0;

      public VBox main = new VBox(10);
    
      public HBox h = new HBox(15);
    
      public double[] entries;
   
      public ButtonSource n = new ButtonSource("Next");
      public ButtonSource no = new ButtonSource("Next");
   
   public LabelSource[] box;
    
     
     public InsertionSort(Pane pane){
        
       this.mainpane = (FlowPane)pane;
       
       mainpane.getChildren().clear();
       
        promptForEntries(); 
    
  }

     public void promptForEntries(){
        
        //initialize panes
        VBox contentPane = new VBox(50);
        
        StackPane titlePane = new StackPane();
        
        HBox paneForEntriesInfo = new HBox(10);
        
        
        //initialize LabelSource
        LabelSource insertionSort_titleLabel = new LabelSource("Insertion Sort",Color.WHITE);
         
        LabelSource promptEntries_label = new LabelSource("Enter numbers",Color.WHITE);
      
        //initialize TextFieldSource
        TextFieldSource entries_field = new TextFieldSource(30,15);
        
        //initialize ButtonSource
        ButtonSource next = new ButtonSource("Next");
        
        
        //set properties for nodes 
        contentPane.setPadding(new Insets(15,15,15,15));

        contentPane.getChildren().add(titlePane);

        titlePane.getChildren().add(insertionSort_titleLabel); 
        
        paneForEntriesInfo.getChildren().add(promptEntries_label );
        
        paneForEntriesInfo.getChildren().add(entries_field);
        
        contentPane.getChildren().add(paneForEntriesInfo);
          
        contentPane.setAlignment(Pos.BOTTOM_RIGHT);
        
        contentPane.getChildren().add(next);
        
        mainpane.getChildren().add(contentPane);
        
        
        //set event handlers
        entries_field.setOnKeyTyped(e -> {entries_field.setStyle("-fx-background-color:white");});

        next.setOnMouseClicked(e -> {
            
           entries = CheckValidity_sort(entries_field);
           
           if(entries != null){
               insertion();
               
           }
        });
            
     }

    public void insertion(){
        mainpane.getChildren().clear();
        
        LabelSource rule2 = new LabelSource("1, Compare each number in the list with the searched number"
        ,Color.WHITE);
    
        main.setAlignment(Pos.TOP_LEFT);
        
        main.getChildren().add(rule2);
        
        LabelSource indexlbl = new LabelSource("Index => ",Color.WHITE);
        
        LabelSource entrieslbl = new LabelSource("Numbers => ",Color.WHITE);
        
        
        box = new LabelSource[entries.length+1];
        mainpane.setPadding(new Insets(15,15,15,15));
       
        for(int i = 0 ; i < entries.length;i++){
            
           if(i == 0){
               
             VBox b = new VBox(22);
             
             b.getChildren().add(indexlbl);
             
             b.getChildren().add(entrieslbl);
             
             h.getChildren().add(b);
           }
           
           LabelSource ind = new LabelSource(String.valueOf(i),Color.BLANCHEDALMOND);
           
           LabelSource in = new LabelSource(String.valueOf(entries[i]),Color.BISQUE);
           
           Rectangle rec = new Rectangle(8,18);
           
           rec.setFill(Color.BURLYWOOD);
        
           VBox v = new VBox(2); 
           
           v.getChildren().add(ind);
          
           v.getChildren().add(rec);
         
           v.getChildren().add(in);
           
           box[i] = in;
           
           h.getChildren().add(v);
           
        }
        main.getChildren().add(h);
        
        ButtonSource next = new ButtonSource("Next");
        
        main.setAlignment(Pos.TOP_RIGHT);
        
        mainpane.getChildren().add(main);
        
        main.getChildren().add(next);
        
        next.setOnMouseClicked(e -> {
            
            //LabelSource index_curent = new LabelSource("Next-number-index = ?", Color.PINK);
                    
            LabelSource number_current = new LabelSource("Next-number = ?" , Color.PINK);
 
            //main.getChildren().add(index_curent);
            
            main.getChildren().add(number_current);
 
            main.getChildren().remove(next);
            
         
            box[entries.length] = number_current;
            
            //(h.getChildren().get(index+1)).setStyle("-fx-background-color:green");
            
           
            
            main.getChildren().add(n);
            
            n.setOnMouseClicked(f -> {
                //main.getChildren().remove(n);
                main.getChildren().remove(n);
                main.getChildren().add(no);
                
                num = entries[index];
                startInsertionSort(entries,1,0);
                //important(entries.length-1,0);
           
               /* main.getChildren().remove(n);
                (h.getChildren().get(index)).setStyle("-fx-background-color:black");
             if( entries.length != index) {
             
              index_curent.setText("Current-index = "+ (index));
              number_current.setText("Current-number = "+ entries[index]);
              main.getChildren().remove(n);
              (h.getChildren().get(index+1)).setStyle("-fx-background-color:green");
             }*/
           });
    
        });}  
    
    public void startInsertionSort(double[] entries,int i,int j) {
       /* for(int i = 1; i < entries.length; i++){
          double next = entries[i];
          int j;
           for( j = i; entries[j] > next && j >= 0 ; j--){
              entries[j+1] = entries[j];
           }   
           entries[j+1] = next;
        }
        
       */
        
        if((index) < entries.length){
           (h.getChildren().get(index)).setStyle("-fx-background-color:black");
           //(h.getChildren().get(j)).setStyle("-fx-background-color:red");
           (h.getChildren().get(index+1)).setStyle("-fx-background-color:green");
           box[entries.length].setText("Next number: "+String.valueOf(num));
           
             no.setOnMouseClicked(e -> {
               
                  if( j >= 0 && entries[j] > num){
                          box[j+1].setText(String.valueOf(entries[j]));
                          //(h.getChildren().get(j+1)).setStyle("-fx-background-color:red");
                          entries[j+1] = entries[j];
                          startInsertionSort(entries,i,j-1);
                  }
                  else{  
                      
                      box[j+1].setText(String.valueOf(num));
                      //box[j+1].setTextFill(Color.RED);
                      entries[j+1] = num;
                      
                      //(h.getChildren().get(i+1)).setStyle("-fx-background-color:green");
                      index++;
                      if(index == entries.length){
                         main.getChildren().remove(no);
                         main.getChildren().add(new LabelSource("BINGO the numbers are sorted: ",Color.YELLOW));
                         return;
                      }
                      else{
                          num = entries[index];
                          startInsertionSort(entries,i+1,i);
           
        }
        }
       });}}}
    
   /* public void process(double[] entries,double next,int i,int j){
        System.out.println("stop");
         if(entries[i] > next && i >= 0 ){
                box[i+1].setText(String.valueOf(entries[i]));
                entries[i+1] = entries[i];}
        else{  startInsertionSort(entries,j+1);
                        }
        no.setOnMouseClicked(e -> {
          
                process(entries,next,i-1,j);
               
        }
            
            );
    
    }
}

//13,2,5,4,8,6,9,12,3 */