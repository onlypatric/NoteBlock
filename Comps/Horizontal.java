package Comps;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * Horizontal box layout, will display elements in the Y axis
 */
public class Horizontal extends JPanel {

    public static enum AlignmentGuide {
        TOP,
        CENTER,
        BOTTOM,
        LEFT,
        RIGHT
    }

    /**
     * Constructs a new Horizontal layout panel with the specified components.
     * 
     * @param items The components to be added to the panel.
     */
    public Horizontal(Component... items) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        for (Component component : items)
            if (component != null)
                super.add(component);
    }

    public Horizontal add(Component... items) {
        for (Component component : items)
            if (component != null)
                super.add(component);
        return this;
    }

    public Horizontal background(Color color) {
        this.setBackground(color);
        return this;
    }

    public Horizontal padding(int padding) {
        super.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        return this;
    }

    public Horizontal title(String title) {
        super.setBorder(BorderFactory.createTitledBorder(super.getBorder(), title));
        return this;
    }

    public Horizontal border(Border b) {
        super.setBorder(b);
        return this;
    }

    private float parseAlignment(AlignmentGuide g) {
        return switch (g) {
            case TOP -> Component.TOP_ALIGNMENT;
            case CENTER -> Component.CENTER_ALIGNMENT;
            case BOTTOM -> Component.BOTTOM_ALIGNMENT;
            case LEFT -> Component.LEFT_ALIGNMENT;
            case RIGHT -> Component.RIGHT_ALIGNMENT;
        };
    }

    public Horizontal alignmentX(AlignmentGuide g) {
        this.setAlignmentX(
                parseAlignment(g));
        return this;
    }

    public Horizontal alignmentY(AlignmentGuide g) {
        this.setAlignmentY(
                parseAlignment(g));
        return this;
    }
}