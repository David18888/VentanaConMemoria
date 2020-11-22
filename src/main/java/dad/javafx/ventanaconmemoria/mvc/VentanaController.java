package dad.javafx.ventanaconmemoria.mvc;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VentanaController implements Initializable {
	
	
	
	@FXML
	private BorderPane view;
	
	@FXML
	private Slider redSlider,greenSlider,blueSlider;
	
	
	private VentanaModel model = new VentanaModel();
	private Stage stage;
	
	public VentanaController(Properties properties) throws IOException {
		
		
		model.setRed(Integer.valueOf((String) properties.get("background.red")));
		model.setGreen(Integer.valueOf((String) properties.get("background.green")));
		model.setBlue(Integer.valueOf((String) properties.get("background.blue")));
		model.setWidth(Double.valueOf((String) properties.get("size.width")));
		model.setHeight(Double.valueOf((String) properties.get("size.height")));
		model.setCoordX(Double.valueOf((String) properties.get("location.x")));
		model.setCoordY(Double.valueOf((String) properties.get("location.y")));
		
		
		
		
		FXMLLoader loader= new FXMLLoader(getClass().getResource("/fxml/VentanaView.fxml"));
		loader.setController(this);
		loader.load();
		
	}
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Bindings.bindBidirectional(redSlider.valueProperty(), model.redProperty());
		Bindings.bindBidirectional(greenSlider.valueProperty(), model.greenProperty());
		Bindings.bindBidirectional(blueSlider.valueProperty(), model.blueProperty());
		
		redSlider.valueProperty().addListener(e-> onSliderValueChanged());
		greenSlider.valueProperty().addListener(e-> onSliderValueChanged());
		blueSlider.valueProperty().addListener(e-> onSliderValueChanged());
		
		view.setStyle("-fx-background-color:rgb("+model.getRed()+","+model.getGreen()+","+model.getBlue()+")");
		
	}





	private void onSliderValueChanged() {
		view.setStyle("-fx-background-color:rgb("+model.getRed()+","+model.getGreen()+","+model.getBlue()+")");
		
	}

	
	
	public void onStageChanged(Stage primaryStage) {
		stage=primaryStage;
		
		stage.widthProperty().addListener(e->onStageSizeChanged());
		stage.heightProperty().addListener(e->onStageSizeChanged());
		stage.xProperty().addListener(e->onStagePositionChanged());
		stage.yProperty().addListener(e->onStagePositionChanged());
	}
	
	
	
	
	
	
	
	
	
	
	private void onStageSizeChanged() {
		model.setWidth(stage.getWidth());
		model.setHeight(stage.getHeight());
	}





	private void onStagePositionChanged() {
		model.setCoordX(stage.getX());
		model.setCoordY(stage.getY());
		
	}





	public BorderPane getView() {
		return view;
	}





	public VentanaModel getVentanaModel() {
		return model;
	}

}
