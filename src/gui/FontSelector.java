//@@author A0130717M
package gui;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class FontSelector {

	private GridPane fonts;
	private final int GAP = 30;
	
	public FontSelector(){
		fonts = new GridPane();
		fonts.setHgap(GAP);
		fonts.setVgap(GAP);
	
		Label consolas = new Label("Consolas");
		consolas.setId("consolas");
		GridPane.setConstraints(consolas, 0, 0);
		fonts.getChildren().addAll(consolas);
	
		Label segoe = new Label("Segoe");
		segoe.setId("segoe");
		GridPane.setConstraints(segoe, 1, 0);
		fonts.getChildren().addAll(segoe);
	}
	
	public GridPane getFont(){
		return fonts;
	}
	
}
