package dad.javafx.ventanaconmemoria.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Properties;

import dad.javafx.ventanaconmemoria.mvc.VentanaController;
import dad.javafx.ventanaconmemoria.mvc.VentanaModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class App extends Application {

	
	private VentanaController  controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		
		Scene scene= new Scene(controller.getView(),controller.getVentanaModel().getWidth(),controller.getVentanaModel().getHeight());
		primaryStage.setScene(scene);
		primaryStage.setX(controller.getVentanaModel().getCoordX());
		primaryStage.setY(controller.getVentanaModel().getCoordY());
		primaryStage.setTitle("Ventana con memoria");
		primaryStage.show();
		
	
		controller.onStageChanged(primaryStage);
		
		
	
	}
	
	
	
	
	@Override
	public void init() throws Exception {
		
		String rutaPerfil=System.getProperty("user.home");
		Properties properties= new Properties();
		
		File ficheroConfig= new File(rutaPerfil+ "\\.VentanaConMemoria\\ventana.config");
		
		
		
		
		if (!ficheroConfig.getParentFile().exists() && !ficheroConfig.getParentFile().mkdirs()) {
			System.err.println("Ha ocurrido un error");
			Alert alert= new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Ha ocurrido un error y no se puede ejecutar la aplicación ");
			alert.showAndWait();
			
			
		}
		
		
		if(ficheroConfig.createNewFile()) {
			FileWriter fw= new FileWriter(ficheroConfig);
			BufferedWriter bw= new BufferedWriter(fw);
			
			bw.write("background.red=150\n");
			bw.write("background.green=150\n");
			bw.write("background.blue=150\n");
			bw.write("size.width=320\n");
			bw.write("size.height=200\n");
			bw.write("location.x=500\n");
			bw.write("location.y=350");
			
			bw.close();
			
			
			
		}
		
		
		FileInputStream fis= new FileInputStream(ficheroConfig);
		properties.load(fis);
		controller= new VentanaController(properties);
		
		
	}
	
	@Override
	public void stop() throws Exception {
	
		String rutaPerfil= System.getProperty("user.home");
		Properties properties= new Properties();
		File ficheroConfig= new File(rutaPerfil+ "\\.VentanaConMemoria\\ventana.config");
		
		VentanaModel model= controller.getVentanaModel();
		
		if (!ficheroConfig.getParentFile().exists() && !ficheroConfig.getParentFile().mkdirs()) {
		System.err.println("Ha ocurrido un error creando el directorio");
		Alert alert= new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setContentText("Ha ocurrido un error al crear el directorio ");
		alert.showAndWait();
		}
		
		ficheroConfig.createNewFile();
		FileWriter fw= new FileWriter(ficheroConfig);
		
		properties.setProperty("background.red", String.valueOf(model.getRed()));
		properties.setProperty("background.green",String.valueOf(model.getGreen()));
		properties.setProperty("background.blue", String.valueOf(model.getBlue()));
		properties.setProperty("size.width", String.valueOf(model.getWidth()));
		properties.setProperty("size.height", String.valueOf(model.getHeight()));
		properties.setProperty("location.x", String.valueOf(model.getCoordX()));
		properties.setProperty("location.y", String.valueOf(model.getCoordY()));
		
		properties.store(fw,null);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
