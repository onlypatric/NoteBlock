package Comps;
import javax.swing.*;
import java.awt.*;
public class ScrollArea extends JScrollPane {

    public ScrollArea(Component view) {
        super(view);
        setPreferredSize(new Dimension(200, 200)); // Set preferred size to ensure scrollbar appears if needed
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    // Add a component to the scroll area
    public void addComponent(Component component) {
        getViewport().add(component);
    }

}