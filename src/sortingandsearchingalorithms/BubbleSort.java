/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sortingandsearchingalorithms;

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
public class BubbleSort extends Source{
    
      public FlowPane mainpane;
    
      public int index = 1;
      
      public double num = 0;

      public VBox main = new VBox(10);
    
      public HBox h = new HBox(15);
    
      public double[] entries;
   
      public ButtonSource n = new ButtonSource("Next");
      public ButtonSource no = new ButtonSource("Next");
   
      public LabelSource[] box;
    
     
     public BubbleSort(Pane pane){
        
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
        LabelSource BubbleSort_titleLabel = new LabelSource("Bubble Sort",Color.WHITE);
         
        LabelSource promptEntries_label = new LabelSource("Enter numbers",Color.WHITE);
      
        //initialize TextFieldSource
        TextFieldSource entries_field = new TextFieldSource(30,15);
        
        //initialize ButtonSource
        ButtonSource next = new ButtonSource("Next");
        
        
        //set properties for nodes 
        contentPane.setPadding(new Insets(15,15,15,15));

        contentPane.getChildren().add(titlePane);

        titlePane.getChildren().add(BubbleSort_titleLabel); 
        
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
               startBubble();
               
           }
        });
            
     }

     public void startBubble(){
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
             
                BubbleSort(entries.length-1,1);
     
    
     
     });});}

                    
     
    public void BubbleSort(int i,int j) {
      /*for(int i = entries.length-1;i >=1;i--){
        for(int j = 1; j<=i ; j++){
            if(entries[j-1] > entries[j]){
                double temp = entries[j];
                entries[j] = entries[j-1];
                entries[j-1] = temp;
            }
        
        }
        
      
      }*/
        
        if(j <= i){
            if(entries[j-1] > entries[j]){
              double temp = entries[j];
              box[j].setText(String.valueOf(entries[j-1]));
              box[j-1].setText(String.valueOf(temp));
              entries[j] = entries[j-1];
              entries[j-1] = temp;}
           j++;
        }
        else{
          if(i < 1){
             main.getChildren().remove(no);
             main.getChildren().add(new LabelSource("BINGO the numbers are sorted: ",Color.YELLOW));
             return;
          }
          else{
            box[i].setTextFill(Color.AQUAMARINE);
            i--;
            j = 1;
          }
        }
        int a = i;
        int b = j;
        no.setOnMouseClicked(e -> BubbleSort(a,b));
        
        
        
        
        //34,21,4,67,5,1,9,3
        
    }
}
