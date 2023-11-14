/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package connect4;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */
public class Main extends Application {
    
    private Controller controller;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane=loader.load();
        
        controller=loader.getController();
        controller.createPlayground();
        
        
        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        
        Pane menuPane=(Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);
        
        Scene scene=new Scene(rootGridPane);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }

    
    private MenuBar createMenu(){
        Menu fileMenu=new Menu("File");
        
        MenuItem newGame=new MenuItem("New Game");
        
        newGame.setOnAction((ActionEvent event) -> {
            controller.resetGame();
        });
        
        MenuItem resetGame=new MenuItem("Reset Game");
        
        resetGame.setOnAction((ActionEvent event) -> {
            controller.resetGame();
        });
        
        SeparatorMenuItem separator=new SeparatorMenuItem();
        
        
        MenuItem exitGame=new MenuItem("Exit Game");
        
        exitGame.setOnAction((ActionEvent event) -> {
            exitGame();
        });
        
        
        fileMenu.getItems().addAll(newGame,resetGame,separator,exitGame);
        
        Menu helpMenu=new Menu("Help");
        
        MenuItem aboutGame=new MenuItem("About Connect4");
        
        aboutGame.setOnAction(event -> {
        
            aboutConnect4();
            
        });
        
        SeparatorMenuItem separatorNew=new SeparatorMenuItem();
       
        
        MenuItem aboutMe=new MenuItem("About Me");
        
        aboutMe.setOnAction(event -> {
            aboutMe();
        });
        
        helpMenu.getItems().addAll(aboutGame,separatorNew,aboutMe);
        
        
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
    
        
        return menuBar;
    }
    
    
    
    private void exitGame(){
        Platform.exit();
        System.exit(0);
    }
    
    private void aboutConnect4(){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How to Play?");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
//        alert.setResizable(true);
        alert.setContentText("Connect Four is a two-player connection game in which the players first "
                + "choose a color and then take turns dropping colored discs from the top into a seven-column,"
                + " six-row vertically suspended grid. The pieces fall straight down, occupying the next available"
                + " space within the column. The objective of the game is to be the first to form a horizontal, "
                + "vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first"
                + " player can always win by playing the right moves.");
        
        alert.show();
    }
    
    private void aboutMe(){
         Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Kedar Kailas Sanglikar");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
//        alert.setResizable(true);
        alert.setContentText("First of all, I love to code in Java. This is my first game developed using "
                + "Java Language. I had developed UI based desktop applications in Java and also in other languages"
                + " like VB.Net. In my free time I prefer coding.");
        
        alert.show();
    }
    
   
    public static void main(String[] args) {
        launch(args);
    }
    
}
