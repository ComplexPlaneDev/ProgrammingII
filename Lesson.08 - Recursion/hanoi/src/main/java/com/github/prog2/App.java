package com.github.prog2;

import java.util.ArrayList;
import java.util.List;

import com.github.prog2.ui.Disc;
import com.github.prog2.ui.Rod;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

public class App extends Application {
    private static final int DISCS = 10;
    private static int tabs = 0;
    private final Canvas canvas = new Canvas(1200, 600);
    private final List<Rod> rods = List.of(
        new Rod(0, App.DISCS),
        new Rod(1),
        new Rod(2)
    );
    private final List<Pair<Integer, Integer>> moves = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hanoi");

        hanoi(App.DISCS, 1, 3);

        this.renderRods();
        Timeline timeline = new Timeline();

        int second = 0;
        for (final Pair<Integer, Integer> move : moves) {
            KeyFrame frame = new KeyFrame(
                Duration.seconds(++second),
                e -> {
                    Disc d = this.rods.get(move.getKey() - 1).popDisc();
                    this.rods.get(move.getValue() - 1).pushDisc(d);
                    this.renderRods();
                }
            );

            timeline.getKeyFrames().add(frame);
        }

        timeline.setRate(10);
        timeline.play();

        var vbox = new VBox(canvas);
        var scene = new Scene(vbox, 1200, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void renderRods() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());

        double start = canvas.getWidth() / (rods.size() + 1);
        double rectWidth = canvas.getWidth() / (rods.size() + 1);
        for (Rod rod : rods) {
            rod.render(
                new Rectangle2D(
                    start - rectWidth / 2,
                    canvas.getHeight() / 20,
                    rectWidth,
                    canvas.getHeight() * 18 / 20
                ),
                canvas
            );
            start += rectWidth;
        }
    }

    private void moveDiscTo(int start, int end) {
        /* IGNORE THIS BLOCK vvvv */
        for (int i = 0; i <= App.tabs; ++i) {
            System.out.printf("|\t");
        }
        System.out.printf("Moving disc from %d to %d\n", start, end);
        /* IGNORE THIS BLOCK ^^^^ */

        moves.add(new Pair<Integer, Integer>(start, end));
    }

    private void hanoi(int discs, int start, int end) {
        /* IGNORE THIS BLOCK vvvv */
        for (int i = 0; i < App.tabs; ++i) {
            System.out.printf("|\t");
        }
        System.out.printf("Moving %d discs from %d to %d\n", discs, start, end);
        /* IGNORE THIS BLOCK ^^^^ */

        final int other = 6 - (start + end);

        if (discs > 1) {
            ++App.tabs; // IGNORE THIS LINE
            hanoi(discs - 1, start, other);
            --App.tabs; // IGNORE THIS LINE
        }

        moveDiscTo(start, end);

        if (discs > 1) {
            ++App.tabs; // IGNORE THIS LINE
            hanoi(discs - 1, other, end);
            --App.tabs; // IGNORE THIS LINE
        }
    }
}