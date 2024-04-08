package Comps;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * Text
 */
public class Area extends JTextArea {

    public static enum AlignmentGuide {
        TOP,
        CENTER,
        BOTTOM,
        LEFT,
        RIGHT
    }
    public enum Type{
        P1,P2,P3;
    }

    private Font f;

    public Area() {
        super();
        f = new Font(this.getFont().getName(), Font.BOLD, 30);
        this.setFont(f);
    }
    public Area(Type type) {
        super();
        switch (type) {
            case P1:
                f = new Font(this.getFont().getName(), Font.PLAIN, 18);
                break;
            case P2:
                f = new Font(this.getFont().getName(), Font.PLAIN, 16);
                break;
            case P3:
                f = new Font(this.getFont().getName(), Font.PLAIN, 14);
                break;
            default:
                f = new Font(this.getFont().getName(), Font.PLAIN, 16);
                break;
        }
        this.setFont(f);
    }

    public Area background(Color color) {
        this.setBackground(color);
        return this;
    }
    
    public Area foreground(Color color) {
        this.setForeground(color);
        return this;
    }

    public Area padding(int padding) {
        super.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        return this;
    }

    public Area title(String title) {
        super.setBorder(BorderFactory.createTitledBorder(super.getBorder(), title));
        return this;
    }

    public Area border(Border b) {
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

    public Area alignmentX(AlignmentGuide g) {
        this.setAlignmentX(
                parseAlignment(g));
        return this;
    }

    public Area alignmentY(AlignmentGuide g) {
        this.setAlignmentY(
                parseAlignment(g));
        return this;
    }

    public Area opaque(boolean b) {
        this.setOpaque(b);
        return this;
    }
    public String get(){
        return this.getText();
    }
}