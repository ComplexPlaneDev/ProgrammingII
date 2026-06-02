package com.github.prog2.ui;

import com.github.prog2.Drawable;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Disc implements Drawable {
    private final static Color[] colors = {
        Color.RED,
        Color.ORANGE,
        Color.BLUE,
        Color.PURPLE,
        Color.GREEN,
        Color.LIGHTCYAN,
        Color.CORAL,
        Color.LIGHTBLUE,
        Color.MAGENTA,
        Color.LIGHTGREEN
     };

    private final int index;

    public Disc(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public void render(Rectangle2D bounds, Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Disc.colors[this.getIndex() % colors.length]);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);

        final Point2D middle = new Point2D(
            bounds.getMinX() + bounds.getWidth() / 2,
            bounds.getMinY() + bounds.getHeight() / 2
        );

        final double discWidth = bounds.getWidth() * (this.getIndex() + 1) / 10;

        gc.fillRoundRect(
            middle.getX() - discWidth / 2,
            bounds.getMinY(),
            discWidth,
            bounds.getHeight(),
            10.0,
            10.0
        );
        gc.strokeRoundRect(middle.getX() - discWidth / 2,
            bounds.getMinY(),
            discWidth,
            bounds.getHeight(),
            10.0,
            10.0
        );

        final Text label = new Text(String.valueOf(this.getIndex()));
        label.setFont(gc.getFont());

        gc.setStroke(Color.BLACK);
        gc.strokeText(
            String.valueOf(this.getIndex()),
            middle.getX() - label.getLayoutBounds().getWidth() / 2,
            middle.getY() + label.getLayoutBounds().getHeight() / 2
        );
    }
}
