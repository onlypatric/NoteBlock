package Comps;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * Text
 */
public class Text extends JLabel {

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

    public Text(String text) {
        super(text);
        f = new Font(this.getFont().getName(), Font.BOLD, 30);
        this.setFont(f);
    }
    public Text(String text, Type type) {
        super(text);
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

    public Text background(Color color) {
        this.setBackground(color);
        return this;
    }
    
    public Text foreground(Color color) {
        this.setForeground(color);
        return this;
    }

    public Text padding(int padding) {
        super.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        return this;
    }

    public Text title(String title) {
        super.setBorder(BorderFactory.createTitledBorder(super.getBorder(), title));
        return this;
    }

    public Text border(Border b) {
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

    public Text alignmentX(AlignmentGuide g) {
        this.setAlignmentX(
                parseAlignment(g));
        return this;
    }

    public Text alignmentY(AlignmentGuide g) {
        this.setAlignmentY(
                parseAlignment(g));
        return this;
    }

    public Text opaque(boolean b) {
        this.setOpaque(b);
        return this;
    }
}