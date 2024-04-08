package Comps;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class Button extends JButton {

    public static enum AlignmentGuide {
        TOP,
        CENTER,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public Button(String Button) {
        super(Button);
        this.setOpaque(true);
        this.setBorderPainted(true);
        this.setFocusPainted(true);
        this.setContentAreaFilled(true);
    }
    public Button font(Font f){
        this.setFont(f);
        return this;
    }
    public Button opaque(boolean b){
        this.setOpaque(b);
        return this;
    }
    public Button borderPainted(boolean b){
        this.setBorderPainted(b);
        return this;
    }
    public Button focusPainted(boolean b){
        this.setFocusPainted(b);
        return this;
    }
    public Button contentAreaFilled(boolean b){
        this.setContentAreaFilled(b);
        return this;
    }

    public Button background(Color color) {
        this.setBackground(color);
        return this;
    }

    public Button padding(int padding) {
        super.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        return this;
    }

    public Button title(String title) {
        super.setBorder(BorderFactory.createTitledBorder(super.getBorder(), title));
        return this;
    }

    public Button border(Border b) {
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

    public Button alignmentX(AlignmentGuide g) {
        this.setAlignmentX(
                parseAlignment(g));
        return this;
    }

    public Button alignmentY(AlignmentGuide g) {
        this.setAlignmentY(
                parseAlignment(g));
        return this;
    }
    public Button action(ActionListener r){
        this.addActionListener(r);
        return this;
    }
}
