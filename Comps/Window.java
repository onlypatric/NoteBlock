package Comps;

import java.awt.*;
import javax.swing.*;

/**
 * Represents a custom window with specified components.
 */
public class Window extends JFrame {

    public static enum AlignmentGuide {
        TOP,
        CENTER,
        BOTTOM,
        LEFT,
        RIGHT
    }

    /**
     * Constructs a new Window with the specified components.
     * 
     * @param items The components to be added to the window.
     */
    public Window(Component... items) {
        super();
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.adds(items);
    }

    public Window adds(Component... items) {
        for (Component component : items)
            if (component != null)
                this.getContentPane().add(component);
        return this;
    }
    public Window background(Color color) {
        this.setBackground(color);
        return this;
    }
    public Window size(Dimension size) {
        this.setSize(size);
        return this;
    }
    public Window size(int width, int height) {
        this.setSize(width, height);
        return this;
    }
    public Window pos(int x,int y){
        this.setLocation(x, y);
        return this;
    }
}