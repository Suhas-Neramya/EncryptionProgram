package Elements;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;

public class RoundBorder extends AbstractBorder {

    private final int radius;
    private final String colour;

    public RoundBorder(int borderRadius, String colourInHex) {
        this.radius = borderRadius;
        this.colour = colourInHex;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.decode(colour));
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = this.radius + 1;
        insets.right = insets.bottom = this.radius + 2;
        return insets;
    }
}