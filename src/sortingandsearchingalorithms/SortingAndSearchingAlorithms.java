
package sortingandsearchingalorithms;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class SortingAndSearchingAlorithms extends Application {

    @Override
    public void start(Stage primaryStage) {

       //initialize buttons, labels,and pane
       MainPane mainpane = new MainPane();
       HBox horizontal = new HBox(10);
       VBox vertical  = new VBox (15);
       Scene scene = new Scene(mainpane,1100,500);
       //ImageView backgroundImage = new ImageView("\"C:\\Users\\user\\Desktop\\bg.png\"");

       customLabel introduction = new customLabel("Learn how to:",false);
       customLabel BinarySearch = new customLabel("BinarySearch",true);
       customLabel LinearSearch = new customLabel("LinearSearch",true);
       customLabel SelectionSort = new customLabel("SelectionSort",true);
       customLabel InsertionSort = new customLabel("InsertionSort",true);
       //customLabel MergeSort = new customLabel("Merge Sort",true);
       customLabel QuickSort = new customLabel("Quick Sort",true);
       customLabel BubbleSort = new customLabel("Bubble Sort",true);


       //set event-handlers for  the controls
       LinearSearch.setOnMouseClicked((e) -> {new LinearSearch(mainpane);});
       BinarySearch.setOnMouseClicked((e) -> {new BinarySearch_1(mainpane);});
       SelectionSort.setOnMouseClicked((e) -> {new SelectionSort (mainpane);});
       InsertionSort.setOnMouseClicked((e) -> {new InsertionSort (mainpane);});
       //MergeSort.setOnMouseClicked((e) -> {new BinarySearch(mainpane);});
       QuickSort.setOnMouseClicked((e) -> {new QuickSort(mainpane);});
       BubbleSort.setOnMouseClicked((e) -> {new BubbleSort(mainpane);});


       //place the controls on pane
       vertical.getChildren().add(LinearSearch);
       vertical.getChildren().add(BinarySearch);
       vertical.getChildren().add(SelectionSort);
       vertical.getChildren().add(InsertionSort);
       vertical.getChildren().add(BubbleSort);
       //vertical.getChildren().add(MergeSort);
       vertical.getChildren().add(QuickSort);



       horizontal.getChildren().add(introduction);
       horizontal.getChildren().add(vertical);


       mainpane.getChildren().add(horizontal);


       //create a scene and place the pane on stage

       primaryStage.setTitle("SortingAndSearchingAlorithms");
       primaryStage.setScene(scene);
       primaryStage.show();


    }
    class customLabel extends Label{
      public customLabel(String name,boolean value){
          super(name);
          setTextFill(Color.WHITE);
          if(value == true) {
               setStyle("-fx-border-color:yellow;-fx-background-color:white");
               setTextFill(Color.BLACK);
          }
          setFont(new Font("Times New Roman",40));
      }


    }

    public static class MainPane extends FlowPane{
      public MainPane(){
          super();
          setAlignment(Pos.CENTER);
          setVgap(15);
          setHgap(15);
          setStyle("-fx-background-color:black");

      }


    }

    public static void main(String[] args) {
        launch(args);
    }

}
