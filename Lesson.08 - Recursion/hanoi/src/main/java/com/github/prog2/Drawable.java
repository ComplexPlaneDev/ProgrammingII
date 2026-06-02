package com.github.prog2;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;

public interface Drawable {
    void render(Rectangle2D bounds, Canvas canvas);
}
