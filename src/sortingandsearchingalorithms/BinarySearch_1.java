package sortingandsearchingalorithms;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sortingandsearchingalorithms.SortingAndSearchingAlorithms.MainPane;


public class BinarySearch_1 extends Source {
    
    FlowPane mainpane;
    
    VBox contentPane = new VBox(40);
    
    ButtonSource next = new ButtonSource("Next");
    
  
    
    public BinarySearch_1(Pane pane){
       
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
        LabelSource binarySearch_titleLabel = new LabelSource("Binary Search",Color.WHITE);
         
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
               
               sortAscendingOrder(entries, Double.parseDouble(search_field.getText().split(",")[0]));
           }
        });
    }
    
    

    private void sortAscendingOrder(double[] entries, double searchN) {
        
        contentPane.getChildren().clear();
        //initialize LabelSource
        LabelSource rule_1 = new LabelSource("1, Sort the numbers in ascending order",Color.WHITE);
        
        LabelSource rule_1_explained = new LabelSource(" ==> Whenever Binary search takes place,"
                + "make sure the numbers are ordered ",Color.WHITE);
        
        //set properties for nodes
        TextFieldSource sortedEntries_textField = new TextFieldSource(30,15);
        
        sortedEntries_textField .editableProperty().set(false);
        
        contentPane.setAlignment(Pos.TOP_LEFT);
        
        contentPane.setPadding(new Insets(15,15,15,15));
        
        contentPane.getChildren().add(rule_1);
        
        contentPane.getChildren().add(rule_1_explained);
        
        contentPane.setAlignment(Pos.TOP_RIGHT); 
        
        contentPane.getChildren().add(next);
       
        //set event handlers
        next.setOnMouseClicked(e -> {
        
            Arrays.sort(entries);
          
            for(int i = 0; i < entries.length; i++){
              
                sortedEntries_textField .appendText( entries[i] + "   ");
          }
          contentPane.getChildren().remove(next);
          
          contentPane.getChildren().add(sortedEntries_textField );

          contentPane.getChildren().add(next);
          
   
          next.setOnMouseClicked(f -> indexComparison(entries,searchN,0,entries.length-1));
        });

     //12,53,78,45,90,16,89,36   

    }
 
    public void indexComparison(double[] entries,double searched,int low_index,int high_index){
        //pass to the next stage
        contentPane.getChildren().clear();
        
        //initialize nodes
        LabelSource rule_2 = new LabelSource("2, Find the middle indexed number and compare it with the searched number"
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
        for(int i = low_index ; i <= high_index ;i++){
        
           VBox indexAndLabelPair = new VBox(2); 
           
           LabelSource index = new LabelSource(String.valueOf(i),Color.YELLOW);
               
           indexAndLabelPair.getChildren().add(index);
             
           LabelSource valueAtCurrentIndex = new LabelSource(String.valueOf(entries[i]),Color.YELLOW);
           
           Rectangle pointers = new Rectangle(8,18);
           
           pointers.setFill(Color.ANTIQUEWHITE);

           indexAndLabelPair.getChildren().add(pointers);
         
           indexAndLabelPair.getChildren().add(valueAtCurrentIndex);
           
           rowForIndicesAndEntries.getChildren().add(indexAndLabelPair);
           
        }
        
        
        contentPane.setAlignment(Pos.TOP_RIGHT);
        

        contentPane.getChildren().add(next);
        
        //set event handlers
        next.setOnMouseClicked(e -> {
               
            int middleIndex = (high_index-low_index)/2 + 1 ;
            
            int middle  = (low_index + high_index)/2;
            
            (rowForIndicesAndEntries.getChildren().get(middleIndex)).setStyle("-fx-background-color:green");
            
            contentPane.getChildren().add(new LabelSource("Middle-index = "+ (middle), Color.PINK));
            
            contentPane.getChildren().add(new LabelSource("Middle-number = "+ entries[middle], Color.PINK));
            
            contentPane.getChildren().add(new LabelSource("Searched-number = "+ searched, Color.PINK));
            
            next.setOnMouseClicked(f -> {
                
                contentPane.getChildren().clear();
                
                rulesBinarySearch(entries,searched,low_index,high_index);

            });
            
                });
        
    }

    private void rulesBinarySearch(double[] entries,double searched,int low,int high) {
  
        contentPane.setAlignment(Pos.CENTER);
        
        contentPane.getChildren().add(new LabelSource("If middle index number > searched number:",Color.WHITE));
        
        contentPane.getChildren().add(new LabelSource("Look for searched number from the numbers that are lower than middle index number",Color.YELLOW));
        
        contentPane.getChildren().add(new LabelSource("Else if middle index number = searched number:",Color.WHITE));
        
        contentPane.getChildren().add(new LabelSource("BINGO the number is found",Color.YELLOW));
        
        contentPane.getChildren().add(new LabelSource("Else:",Color.WHITE));
        
        contentPane.getChildren().add(new LabelSource("Look for searched number from the numbers that are greater than middle index number",Color.YELLOW));
        

        contentPane.getChildren().add(next);
        
        
        next.setOnMouseClicked(e -> {
            
            search(entries,searched,low,high);
        });
    }
    

    private  void search(double[] list, double searchk,int a ,int b) {
       
       int low = a;
       
       int high = b;
       
       int middle= (low + high)/2;
       
       if(list[middle] > searchk && (middle != list.length-1 && middle != 0)){
           
              high = middle-1;

              indexComparison(list,searchk,low,high);
        
       }
       else if (list[middle] < searchk && (middle != list.length-1 && middle != 0)){
           
              low = middle+1;
        
              indexComparison(list,searchk,low,high);
        
       }
        else if((list[middle] == searchk)){
         
              contentPane.getChildren().clear();
          
              mainpane.setStyle("-fx-background-color:green;");
          
              contentPane.getChildren().add(new LabelSource("BINGO the NUMBER is found at INDEX: "+ middle,Color.WHITE));
         
        
       }
       else if(list[middle] > searchk || list[middle] < searchk ) {
          
              contentPane.getChildren().clear();
           
              mainpane.setStyle("-fx-background-color:red;");
           
              contentPane.getChildren().add(new LabelSource("The NUMBER is Not found! ",Color.WHITE));
       
       }
      

   
       
    }}

