package com.github.prog2.ui;

import java.util.Stack;

import com.github.prog2.Drawable;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Rod implements Drawable {
    private final int index;
    private Stack<Disc> discs = new Stack<>();

    public Rod(int index, int initialDiscCount) {
        this.index = index;
        for (int i = initialDiscCount; i > 0; i--) {
            discs.push(new Disc(i));
        }
    }

    public Rod(int index) {
        this(index, 0);
    }

    public int getIndex() {
        return index;
    }

    public Disc popDisc() {
        return discs.pop();
    }

    public void pushDisc(Disc d) {
        discs.push(d);
    }

    @Override
    public void render(Rectangle2D bounds, Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.DARKGRAY);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1.0);

        final Point2D middle = new Point2D(
            bounds.getMinX() + bounds.getWidth() / 2,
            bounds.getMinY() + bounds.getHeight() / 2
        );

        final double totalWidth = bounds.getWidth() * 9 / 10;
        final double totalHeight = bounds.getHeight() * 9 / 10;
        final double totalRodWidth = totalWidth / 10;
        final double totalRodHeight = totalHeight * 95 / 100;
        final double rodLabelHeight = totalHeight / 20;

        final Rectangle2D rodRect = new Rectangle2D(
            middle.getX() - totalRodWidth / 2,
            middle.getY() - totalHeight / 2,
            totalRodWidth,
            totalRodHeight
        );
        final Point2D rodMiddle = new Point2D(
            rodRect.getMinX() + rodRect.getWidth() / 2,
            rodRect.getMinY() + rodRect.getHeight() / 2
        );
        gc.fillRoundRect(
            rodRect.getMinX(),
            rodRect.getMinY(),
            rodRect.getWidth(),
            rodRect.getHeight(),
            10.0,
            10.0
        );
        gc.strokeRoundRect(rodRect.getMinX(),
            rodRect.getMinY(),
            rodRect.getWidth(),
            rodRect.getHeight(),
            10.0,
            10.0
        );

        final Rectangle2D labelRect = new Rectangle2D(
            rodRect.getMinX(),
            rodRect.getMaxY(),
            rodRect.getWidth(),
            rodLabelHeight
        );
        final Point2D labelMiddle = new Point2D(
            labelRect.getMinX() + labelRect.getWidth() / 2,
            labelRect.getMinY() + labelRect.getHeight() / 2
        );

        final Text label = new Text(String.valueOf(this.getIndex() + 1));
        label.setFont(gc.getFont());

        gc.setStroke(Color.BLACK);
        gc.strokeText(String.valueOf(this.getIndex() + 1),
            labelMiddle.getX() - label.getLayoutBounds().getWidth() / 2,
            labelMiddle.getY() + label.getLayoutBounds().getHeight() / 2
        );

        double discHeight = (totalRodHeight * 0.75) / 10;
        int discCount = 0;
        for (final Disc disc : discs) {
            disc.render(
                new Rectangle2D(
                    rodMiddle.getX() - totalWidth / 2,
                    rodRect.getMaxY() - ++discCount * discHeight,
                    totalWidth,
                    discHeight
                ),
                canvas
            );
        }
    }
}
