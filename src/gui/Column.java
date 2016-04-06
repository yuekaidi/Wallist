package gui;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Column {
	private Color color;
	private StackPane column;
	private Rectangle rectangle;
	private Text text;

	public StackPane column(String content, int colNumber) {
		column = new StackPane();
		rectangle = new Rectangle();
		text = new Text(content);
		text.setFill(color);
		column.getChildren().addAll(rectangle, text);
		GridPane.setConstraints(column, colNumber, 0);
		return column;
	}
	
	public void setWidth(int width){
		rectangle.setWidth(width);		
	}
	
	public void setColor(Color color){
		text.setFill(color);
	}
	
	public void setAlignRight(){
		column.setAlignment(Pos.TOP_RIGHT);
	}
}
