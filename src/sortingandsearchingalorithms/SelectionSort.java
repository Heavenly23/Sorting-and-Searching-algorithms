/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sortingandsearchingalorithms;

import javafx.event.EventType;
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
public class SelectionSort extends Source{
   public FlowPane mainpane;

   public int index = 0;

   public VBox main = new VBox(10);
    
   public HBox h = new HBox(15);
    
   public double[] entries;
   
   
   public LabelSource[] box;
    
    

  public SelectionSort(Pane pane){
        
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
        LabelSource selectionSort_titleLabel = new LabelSource("Selection Sort",Color.WHITE);
         
        LabelSource promptEntries_label = new LabelSource("Enter numbers",Color.WHITE);
      
        //initialize TextFieldSource
        TextFieldSource entries_field = new TextFieldSource(30,15);
        
        //initialize ButtonSource
        ButtonSource next = new ButtonSource("Next");
        
        
        //set properties for nodes 
        contentPane.setPadding(new Insets(15,15,15,15));

        contentPane.getChildren().add(titlePane);

        titlePane.getChildren().add(selectionSort_titleLabel); 
        
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
               
               startSelectionSort(entries);
           }
        });
            
    }

    private void startSelectionSort(double[] entries) {
         mainpane.getChildren().clear();
        
        LabelSource rule2 = new LabelSource("Find the largest number and place it ,painted in blue, at the end of the list"
        ,Color.WHITE);
        
        
        
        main.setAlignment(Pos.TOP_LEFT);
        
        main.getChildren().add(rule2);
        
        LabelSource indexlbl = new LabelSource("Index => ",Color.WHITE);
        
        LabelSource entrieslbl = new LabelSource("Numbers => ",Color.WHITE);
        
        
        box = new LabelSource[entries.length+2];
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
            
            LabelSource index_curent = new LabelSource("Largest-Number-index = ?", Color.PINK);
                    
            LabelSource number_current = new LabelSource("Largest-Number = ?" , Color.PINK);
 
            main.getChildren().add(index_curent);
            
            main.getChildren().add(number_current);
 
            main.getChildren().remove(next);
            
            box[entries.length] = index_curent;
            box[entries.length+1] = number_current;
            
            (h.getChildren().get(index+1)).setStyle("-fx-background-color:green");
            
            ButtonSource n = new ButtonSource("Next");
            
            main.getChildren().add(n);
            
            n.setOnMouseClicked(f -> {
                main.getChildren().remove(n);
                important(entries.length-1,0);
                
           });
    
        });}  
    
    
    
    public void selectionSortAlgorithm(int i,int j,ButtonSource n,int max){
        if(i == 0){
            (h.getChildren().get((i) +1)).setStyle("-fx-background-color:blue");
             main.getChildren().remove(n);
             main.getChildren().add(new LabelSource("BINGO the numbers are sorted: ",Color.YELLOW));
             return;
        }
        h.getChildren().get(j).setStyle("-fx-background-color:black");
        h.getChildren().get(j + 1).setStyle("-fx-background-color:violet");
        index = max;
        //(h.getChildren().get(initial+2)).setStyle("-fx-background-color:orange");
        if(entries[j] >= entries[max]){
               
               max = j;
               (h.getChildren().get(max+1)).setStyle("-fx-background-color:black");
               (h.getChildren().get(max +1)).setStyle("-fx-background-color:green");
           }
         
        int a = i;
        int b = j+1;
        int maxIdx = max;
        
          box[entries.length].setText("Largest-Number-index = "+ maxIdx);
          box[entries.length+1].setText("Largest-Number = "+ entries[maxIdx]);
        
          
        n.setOnMouseClicked(e -> {
          //box[entries.length].setText("Current-index = "+ maxIdx);
          //box[entries.length+1].setText("Current-MAX-index = "+ entries[maxIdx]);
          
          if(b <= (a)) { 
              
              //(h.getChildren().get(initial + 2)).setStyle("-fx-background-color:orange");
              
              //index++;
              selectionSortAlgorithm(a,b,n,maxIdx);
              
          }
        
          else{ 
                (h.getChildren().get(maxIdx+1)).setStyle("-fx-background-color:black");
                double temp = entries[a];
                entries[a] = entries[maxIdx];
                //entries[maxIdx] = temp;
                
                box[a].setText(String.valueOf(entries[maxIdx]));
                box[maxIdx].setText(String.valueOf(temp));
                entries[maxIdx] = temp;
                //box[entries.length+1].setText("Current-MAX-index = "+ entries[maxIdx]);
                (h.getChildren().get((a) +1)).setStyle("-fx-background-color:blue");
                index++;
               
                selectionSortAlgorithm(a-1,0,n,0);
                
                }
        });
        //3,21,14,5,6,13,5,7
    }

    public void important(int i,int j) {
        
       ButtonSource n = new ButtonSource("Next");
        
        main.getChildren().add(n);
        
        selectionSortAlgorithm(i,j,n,0);
  
    }
               
        
}   
        
        
