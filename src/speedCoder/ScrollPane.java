package speedCoder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ScrollPane extends JScrollPane{
	
	public ScrollPane(Component view) {
        setViewportView(view);
        setBorder(null);

        getVerticalScrollBar().setUnitIncrement(20);
        getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(0, 0));
                btn.setMinimumSize(new Dimension(0, 0));
                btn.setMaximumSize(new Dimension(0, 0));

                return btn;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(0, 0));
                btn.setMinimumSize(new Dimension(0, 0));
                btn.setMaximumSize(new Dimension(0, 0));
                return btn;
            }

            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.LIGHT_GRAY;
                this.trackColor = Color.white;
            }
        });
    }
}
