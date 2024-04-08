package Comps;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * Heading
 */
public class Heading extends JLabel {

    public static enum AlignmentGuide {
        TOP,
        CENTER,
        BOTTOM,
        LEFT,
        RIGHT
    }
    public static enum Type{
        H1, H2, H3, H4, H5, H6;
    }

    private Font f;

    public Heading(String text) {
        super(text);
        f = new Font(this.getFont().getName(), Font.BOLD, 30);
        this.setFont(f);
    }
    public Heading(String text, Type type) {
        super(text);
        switch (type) {
            case H1:
                f = new Font(this.getFont().getName(), Font.BOLD, 30);
                break;
            case H2:
                f = new Font(this.getFont().getName(), Font.BOLD, 28);
                break;
            case H3:
                f = new Font(this.getFont().getName(), Font.BOLD, 26);
                break;
            case H4:
                f = new Font(this.getFont().getName(), Font.BOLD, 24);
                break;
            case H5:
                f = new Font(this.getFont().getName(), Font.BOLD, 22);
                break;
            case H6:
                f = new Font(this.getFont().getName(), Font.BOLD, 20);
                break;
            default:
                f = new Font(this.getFont().getName(), Font.BOLD, 30);
                break;
        }
        this.setFont(f);
    }

    public Heading background(Color color) {
        this.setBackground(color);
        return this;
    }

    public Heading padding(int padding) {
        super.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        return this;
    }

    public Heading title(String title) {
        super.setBorder(BorderFactory.createTitledBorder(super.getBorder(), title));
        return this;
    }

    public Heading border(Border b) {
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

    public Heading alignmentX(AlignmentGuide g) {
        this.setAlignmentX(
                parseAlignment(g));
        return this;
    }

    public Heading alignmentY(AlignmentGuide g) {
        this.setAlignmentY(
                parseAlignment(g));
        return this;
    }
}