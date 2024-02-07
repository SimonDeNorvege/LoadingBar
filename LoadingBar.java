package LoadingBar;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;


public class LoadingBar extends JPanel {

        JProgressBar pbar;

        static final int MY_MINIMUM = 0;
        static final int MY_MAXIMUM = 100;

        public LoadingBar() {
            // initialize Progress Bar
            pbar = new JProgressBar();
            pbar.setMinimum(MY_MINIMUM);
            pbar.setMaximum(MY_MAXIMUM);
            // add to JPanel
            add(pbar);
        }

        public void updateBar(int newValue) {
            pbar.setValue(newValue);
        }

        public static void main(String args[]) {

            final LoadingBar it = new LoadingBar();

            JFrame frame = new JFrame("Loading Bar Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(it);
            frame.pack();
            frame.setVisible(true);

            // run a loop to demonstrate raising
            for (int i = MY_MINIMUM; i <= MY_MAXIMUM; i++) {
                final int percent = i;
                try {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            it.updateBar(percent);
                        }
                    });
                    java.lang.Thread.sleep(100);
                } catch (InterruptedException e) {
                    ;
                }
            }
        }
    }
