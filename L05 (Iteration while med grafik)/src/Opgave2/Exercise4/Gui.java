package Opgave2.Exercise4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(200, 200);
		pane.add(canvas, 0, 0);
		this.drawShapes3(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes1(GraphicsContext gc)
	{
		int x = 100; // center: (x,y)
		int y = 100;
		int r = 40; // radius: r
		while (r <= 100) {
			gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
			r = r + 20;
		}
	}

	private void drawShapes2(GraphicsContext gc)
	{
		int x = 20; // center: (x,y)
		int y = 100;
		int r = 10; // radius: r
		while (r <= 80 && x <= 90) {
			gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
			r = r + 10;
			x = x + 10;
		}
	}

	private void drawShapes3(GraphicsContext gc)
	{
		int x = 20;
		int y = 100;
		int circles = 5;

		double radius = 10;

		while (circles > 0) {

			gc.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
			x += 10;
			radius += 10;

			circles--;
		}
	}
}
