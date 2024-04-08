package Comps;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.border.Border;
import javax.swing.event.ChangeListener;

import java.awt.Font;

public class CheckBox extends JCheckBox {

    public static enum AlignmentGuide {
        TOP,
        CENTER,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public CheckBox(String t) {
        super(t);
        this.setOpaque(true);
        this.setBorderPainted(true);
        this.setFocusPainted(true);
        this.setContentAreaFilled(true);
    }
    public CheckBox font(Font f){
        this.setFont(f);
        return this;
    }
    public CheckBox opaque(boolean b){
        this.setOpaque(b);
        return this;
    }
    public CheckBox borderPainted(boolean b){
        this.setBorderPainted(b);
        return this;
    }
    public CheckBox focusPainted(boolean b){
        this.setFocusPainted(b);
        return this;
    }
    public CheckBox contentAreaFilled(boolean b){
        this.setContentAreaFilled(b);
        return this;
    }

    public CheckBox background(Color color) {
        this.setBackground(color);
        return this;
    }

    public CheckBox padding(int padding) {
        super.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        return this;
    }

    public CheckBox title(String title) {
        super.setBorder(BorderFactory.createTitledBorder(super.getBorder(), title));
        return this;
    }

    public CheckBox border(Border b) {
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

    public CheckBox alignmentX(AlignmentGuide g) {
        this.setAlignmentX(
                parseAlignment(g));
        return this;
    }

    public CheckBox alignmentY(AlignmentGuide g) {
        this.setAlignmentY(
                parseAlignment(g));
        return this;
    }
    public CheckBox action(ActionListener r){
        this.addActionListener(r);
        return this;
    }
    public CheckBox change(ChangeListener c){
        this.addChangeListener(c);
        return this;
    }
}
