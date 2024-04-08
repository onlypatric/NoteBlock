package Comps;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * Panel
 */
public class Listed<T> extends JList<T> {
    
    private DefaultListModel<T> model;

    public static enum AlignmentGuide {
        TOP,
        CENTER,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public Listed(T[] items) {
        super();
        model = new DefaultListModel<>();
        setModel(model);
        add(items);
    }

    public Listed() {
        super();
        model = new DefaultListModel<>();
        setModel(model);
    }
    public Listed<T> clear() {
        model.clear();
        return this;
    }

    // Add a string to the list
    public Listed<T> add(@SuppressWarnings("unchecked") T... items) {
        for(T item:items)
            model.addElement(item);
        return this;
    }

    public Listed<T> opaque(boolean b){
        this.setOpaque(b);
        return this;
    }

    public Listed<T> background(Color color) {
        this.setBackground(color);
        return this;
    }

    public Listed<T> padding(int padding) {
        super.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        return this;
    }

    public Listed<T> title(String title) {
        super.setBorder(BorderFactory.createTitledBorder(super.getBorder(), title));
        return this;
    }

    public Listed<T> border(Border b) {
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

    public Listed<T> alignmentX(AlignmentGuide g) {
        this.setAlignmentX(
            parseAlignment(g));
        return this;
    }

    public Listed<T> alignmentY(AlignmentGuide g) {
        this.setAlignmentY(
                parseAlignment(g));
        return this;
    }
}