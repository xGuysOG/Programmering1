package Opgave2.Exercise12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;
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
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------
	private void drawCircle(GraphicsContext gc, int x, int y, int r) {
			gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
	}

	private void drawCross(GraphicsContext gc, int x, int y, int w) {
		gc.strokeLine(x - w / 2, y - w / 2, x + w / 2, y + w / 2);
		gc.strokeLine(x - w / 2, y + w / 2, x + w / 2, y - w / 2);
	}
	private void drawTriangle(GraphicsContext gc, int x, int y, int h) {
		//We want to go from xy + h then + h as x then + h again
		int math = x + h;
		gc.strokeLine(x, y, math, y);
		int math2 = y - h;
		gc.strokeLine(math, y, math, math2);
		gc.strokeLine(math, y, math + h, y);
//
//
//		// Set the stroke dash array to create the stripe effect
//
//		gc.strokeLine(math, math2, x, y);
//		gc.strokeLine(math, math2, math + h, y);


		// Draw a line from (50, 50) to (250, 50)
//		gc.strokeLine(math, y, math, math2);

	}

	private void drawInnerTriangles(GraphicsContext gc, int x, int y, int h) {
		int x2 = x + h +h;
		int h2 = h/3;
		x2 = x2 - h2 - h2;


		int x3 = x + h2 + h2;
		int y2 = y - h + h2;
		//We want to go from xy + h then + h as x then + h again
		drawTriangle(gc,x, y , h2);
		drawInnerInnerTriangles(gc, x ,y ,h2);
		drawTriangle(gc,x2, y , h2);
		drawInnerInnerTriangles(gc, x2 ,y ,h2);
		drawTriangle(gc,x3, y2 , h2);
		drawInnerInnerTriangles(gc, x3 ,y2 ,h2);

	}
	private void drawInnerInnerTriangles(GraphicsContext gc, int x, int y, int h) {
		int x2 = x + h +h;
		int h2 = h/3;
		x2 = x2 - h2 - h2;


		int x3 = x + h2 + h2;
		int y2 = y - h + h2;
		//We want to go from xy + h then + h as x then + h again
		drawTriangle(gc,x, y , h2);
		drawTriangle(gc,x2, y , h2);
		drawTriangle(gc,x3, y2 , h2);
	}
	private void drawShapes(GraphicsContext gc) {
		int x = 20; // center: (x,y)
		int y = 100;
		int h = 81; // radius: r
		drawTriangle(gc,x,y,h);
//		drawInnerTriangles(gc, x ,y ,h);
	}

//	private void drawShapes(GraphicsContext gc)
//	{
//		int x = 50; // center: (x,y)
//		int y = 100;
//		int r = 40; // radius: r
//		while (x <= 150) {
//			gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
//			x = x + 25;
//		}
//	}
}
