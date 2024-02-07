package LoadingBar;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JProgressBar;


public class LoadingBar extends JPanel {

        JProgressBar pbar;

        public long courseLength = 4680000; //1h30 minutes
        public long startTime;
        public long endTime;
        public static final int MY_MINIMUM = 0;
        public static final int MY_MAXIMUM = 100;

        public LoadingBar() {
            this.startTime = System.currentTimeMillis();
            // initialize Progress Bar
            this.endTime = startTime + courseLength;
            this.pbar = new JProgressBar();
            this.pbar.setMinimum(MY_MINIMUM);
            this.pbar.setMaximum(MY_MAXIMUM);
            // add to JPanel
            add(pbar);
        }

        public long timeElapsed(long currenTime, long starTime)
        {
            return(currenTime - starTime);
        }

        public void updateBar(int newValue) {
            pbar.setValue(newValue);
        }
            public int getProgress()
            {
                double currentTime = timeElapsed(System.currentTimeMillis(), this.startTime);
                double progressTime = currentTime / (this.courseLength);
                return (int) (progressTime * 100);
            }

    public static void main(String args[]) {

        final LoadingBar loadingBar = new LoadingBar();

        JFrame frame = new JFrame("Loading Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(loadingBar);
        frame.pack();
        frame.setVisible(true);

        // run a loop to demonstrate raising
        while (loadingBar.getProgress() < 100) {
            try
            {
                loadingBar.updateBar(loadingBar.getProgress());
                Thread.sleep(1000); //to ease the processor suffering
            }
            catch(InterruptedException e){
                ;
            }
        }
        loadingBar.updateBar(MY_MAXIMUM);
    }
}

