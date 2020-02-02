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


public class LinearSearch extends Source{

  FlowPane mainpane;

  int index = 0;

  ButtonSource next = new ButtonSource("Next");

  VBox contentPane = new VBox(40);

 
  public LinearSearch(Pane pane){
        
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
        LabelSource binarySearch_titleLabel = new LabelSource("Linear Search",Color.WHITE);
         
        LabelSource promptEntries_label = new LabelSource("Enter numbers",Color.WHITE);
        
        LabelSource search = new LabelSource("Search",Color.WHITE);
        
        
        //initialize TextFieldSource
        TextFieldSource entries_field = new TextFieldSource(30,15);
        
        TextFieldSource search_field = new TextFieldSource(3,15);
        
        
        //set properties for nodes 
        contentPane.setPadding(new Insets(15,15,15,15));

        contentPane.getChildren().add(titlePane);

        titlePane.getChildren().add(binarySearch_titleLabel); 
        
        paneForEntriesInfo.getChildren().add( promptEntries_label );
        
        paneForEntriesInfo.getChildren().add(entries_field);
        
        contentPane.getChildren().add(paneForEntriesInfo);
        
        paneForSearchInfo.getChildren().add(search);
        
        paneForSearchInfo.getChildren().add(search_field);
        
        contentPane.getChildren().add(paneForSearchInfo);
        
        contentPane.setAlignment(Pos.BOTTOM_RIGHT);
        
        contentPane.getChildren().add(next);
        
        mainpane.getChildren().add(contentPane);
        
        
        //set event handlers
        entries_field.setOnKeyTyped(e -> {entries_field.setStyle("-fx-background-color:white");});

        search_field.setOnKeyTyped(e -> {search_field.setStyle("-fx-background-color:white");});
  
        next.setOnMouseClicked(e -> {
            
           double[] entries = CheckValidity_search(entries_field,search_field);
           
           if(entries != null){
               
               startLinearSearch(entries, Double.parseDouble(search_field.getText().split(",")[0]));
           }
        });
            
    }
         

    private void startLinearSearch(double[] entries, double searched){
        contentPane.getChildren().clear();
        
        //initialize nodes
        LabelSource rule_2 = new LabelSource("1, Find the middle indexed number and compare it with the searched number"
        ,Color.WHITE);
        
        LabelSource index_label = new LabelSource("Index => ",Color.WHITE);
        
        LabelSource entries_label = new LabelSource("Numbers => ",Color.WHITE);
        
        VBox paneForDescribitiveLabels = new VBox(22);
        
        HBox rowForIndicesAndEntries = new HBox(15);    
  
        //set properties for nodes
        contentPane.setAlignment(Pos.TOP_LEFT);
        
        contentPane.getChildren().add(rule_2);
        
        contentPane.setPadding(new Insets(15,15,15,15));
        
        paneForDescribitiveLabels.getChildren().add(index_label);
             
        paneForDescribitiveLabels.getChildren().add(entries_label);
        
        rowForIndicesAndEntries.getChildren().add(paneForDescribitiveLabels);
        
        contentPane.getChildren().add(rowForIndicesAndEntries);
        
        
        //display the numbers that are indexed from low_index to high_index
        for(int i = 0 ; i < entries.length ;i++){
        
           VBox indexAndLabelPair = new VBox(2); 
           
           LabelSource index = new LabelSource(String.valueOf(i),Color.YELLOW);
               
           indexAndLabelPair.getChildren().add(index);
             
           LabelSource valueAtCurrentIndex = new LabelSource(String.valueOf(entries[i]),Color.YELLOW);
           
           Rectangle pointers = new Rectangle(8,18);
           
           pointers.setFill(Color.DARKBLUE);

           indexAndLabelPair.getChildren().add(pointers);
         
           indexAndLabelPair.getChildren().add(valueAtCurrentIndex);
           
           rowForIndicesAndEntries.getChildren().add(indexAndLabelPair);
           
        }
        
        contentPane.setAlignment(Pos.BASELINE_RIGHT);
        
        contentPane.getChildren().add(next);
        
        LabelSource index_current = new LabelSource("Current-index = "+ index, Color.PINK);
                    
        LabelSource number_current = new LabelSource("Current-number = "+ entries[index], Color.PINK);
                    
        LabelSource searched_number = new LabelSource("Searched-number = "+ searched, Color.PINK);
        
        contentPane.getChildren().add(index_current);
        
        contentPane.getChildren().add(number_current);
        
        contentPane.getChildren().add(searched_number);
       
        
        next.setOnMouseClicked(e -> {
            
            //contentPane.getChildren().remove(next);
            
             if(index == entries.length){
              
               contentPane.getChildren().remove(next);
               
               mainpane.getChildren().add(new LabelSource("The searched number is not found" ,Color.RED));
               
               return;
               
            }
            
               (rowForIndicesAndEntries.getChildren().get(index)).setStyle("-fx-background-color:black");
            
               (rowForIndicesAndEntries.getChildren().get(index+1)).setStyle("-fx-background-color:green");
            
               index_current.setText("Current-index = "+ index);
            
               number_current.setText("Current-number = "+ entries[index]);
            
               searched_number.setText("Searched-number = "+ searched);
            
             
             if(entries[index] == searched){
              
              contentPane.getChildren().remove(next);
        
              contentPane.getChildren().add(new LabelSource("BINGO the number is found at INDEX : "+ index ,Color.YELLOW));
              
              return;
            
            }
            index++;
        
        });}
}