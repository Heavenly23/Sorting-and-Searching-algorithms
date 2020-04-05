/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sortingandsearchingalorithms;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

/**
 *
 * @author user
 */
public class QuickSort extends Source {
    
    FlowPane mainpane; 
    
    VBox contentPane = new VBox(40);
    
    ButtonSource next = new ButtonSource("Next");
 
    int pivot;
    
    int index = 0;
    
    

    ArrayList<Double> sortedList = new ArrayList<Double>();
    
    ArrayList<Double> givenList = new ArrayList<Double>();
    
    TextFieldSource sortedList_TextFieldSource = new TextFieldSource(30,15);
    
    LabelSource givenList_LabelSource= new LabelSource("",Color.YELLOW);
    
    StackPane result = new StackPane();
    
    public QuickSort(Pane pane){
      
       this.mainpane = (FlowPane)pane;
       
       mainpane.getChildren().clear();
       
       promptForEntries(); 
       
    
    }
    
    public void promptForEntries(){
        
        //initialize panes
       
        StackPane titlePane = new StackPane();
        
        HBox paneForEntriesInfo = new HBox(10);
        
        HBox paneForSearchInfo =new HBox(10);
        
        //initialize LabelSource
        LabelSource quickSort_titleLabel = new LabelSource("Quick Sort",Color.WHITE);
         
        LabelSource promptEntries_label = new LabelSource("Enter numbers",Color.WHITE);
        
        LabelSource pivot_label = new LabelSource("Pivot",Color.WHITE);
        
        
        //initialize TextFieldSource
        TextFieldSource entries_field = new TextFieldSource(30,15);
        
        TextFieldSource pivot_field = new TextFieldSource(3,15);
       
        //set properties for nodes 
        contentPane.setPadding(new Insets(15,15,15,15));

        contentPane.getChildren().add(titlePane);

        titlePane.getChildren().add(quickSort_titleLabel); 
        
        paneForEntriesInfo.getChildren().add( promptEntries_label );
        
        paneForEntriesInfo.getChildren().add(entries_field);
        
        contentPane.getChildren().add(paneForEntriesInfo);
        
        paneForSearchInfo.getChildren().add(pivot_label);
        
        paneForSearchInfo.getChildren().add(pivot_field);
        
        contentPane.getChildren().add(paneForSearchInfo);
        
        contentPane.setAlignment(Pos.BOTTOM_RIGHT);
        

        contentPane.getChildren().add(next);
        
        mainpane.getChildren().add(contentPane);
        
        
        //set event handlers
        entries_field.setOnKeyTyped(e -> {entries_field.setStyle("-fx-background-color:white");});

        pivot_field.setOnKeyTyped(e -> {pivot_field.setStyle("-fx-background-color:white");});
        
        next.setOnMouseClicked(e -> {
            
           double[] entries = CheckValidity_search(entries_field,pivot_field);
           
           if(entries != null){
               
               pivot = Integer.parseInt(pivot_field.getText().split(",")[0]);
               
               StringBuilder label =new StringBuilder("");
               for(double i: entries){
               
                   givenList.add(i);
                   
                   label.append(String.valueOf(i) + "  ");
               
               }
               givenList_LabelSource.setText(label.toString());
               
           }
               contentPane.getChildren().clear();
               mainpane.setAlignment(Pos.TOP_CENTER);
               
               contentPane.setStyle("-fx-background-color:pink");
               givenList_LabelSource.setStyle("-fx-background-color:green");
           quicksort(givenList,contentPane,30, 15);
           
        });
    }

    private void quicksort(ArrayList<Double> arrFull,VBox contentPane,double rowSize, double columnSize) {
       
        ArrayList<Double> left = new ArrayList<Double>();
        ArrayList<Double> right = new ArrayList<Double>();

        if(arrFull.size() <= 0){  
            return;                   
        }
        else if(arrFull.size() == 1){ 
            
            sortedList.add(arrFull.get(0));
            
            sortedList_TextFieldSource.appendText(String.valueOf(arrFull.get(0))+"  ");
            //field2.appendText(String.valueOf(arrFull.get(0))+" ");
        //12,3,14,57,4,7,6,8,19,40,43,10
        }
        else{
            
            TextFieldSource left_sourceField = new TextFieldSource(rowSize,columnSize);
            
            TextFieldSource right_sourceField = new TextFieldSource(rowSize,columnSize);
            
            left_sourceField .setStyle("-fx-border-color:black;-fx-border-style:solid;-fx-border-radius:15");;
            
            right_sourceField .setStyle("-fx-border-color:black;-fx-border-style:solid;-fx-border-radius:15");
            
            HBox row = new HBox(5);
            
            VBox v_left = new VBox(5);
            
            VBox v_right = new VBox(5);
            
            v_left.getChildren().add(left_sourceField);
            
            v_right.getChildren().add(right_sourceField);
            
            row.getChildren().add(v_left);
            
            row.getChildren().add(v_right);
            
            contentPane.getChildren().add(row);
            
            int index = arrFull.size()-1 < pivot?arrFull.size()-1:pivot;
            double pi = arrFull.get(index);   
            for(int i =0; i < arrFull.size();i++){
               double element = arrFull.get(i);
               if(element > pi){ 
                   right.add(element); 
                   right_sourceField.appendText(String.valueOf(element)+" ");
               }
               else if(element <= pi && (i != index)){
                   left.add(element);
                   left_sourceField.appendText(String.valueOf(element)+" ");
               
            }}
          
          // v_left.setStyle("-fx-border-color:blue");
           quicksort(left,v_left,rowSize/2,columnSize);
           
           sortedList.add(pi);
            
           sortedList_TextFieldSource.appendText(String.valueOf(pi)+"  ");
           //v_right.setStyle("-fx-border-color:green");
           quicksort(right,v_right,rowSize/2,columnSize);
           
           
        }
           if(sortedList.size() == givenList.size()){
               result.setStyle("-fx-background-color:green");
               result.getChildren().add(sortedList_TextFieldSource);
               result.setPadding(new Insets(15,15,15,15));
               mainpane.getChildren().add(result);
            
           }
    }

    }
