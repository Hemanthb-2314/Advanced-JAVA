import javax.swing.JFrame;
import javax.swing.JTextArea;

public class HigherCreditLimitFrame extends JFrame {
    JTextArea reArea;

    HigherCreditLimitFrame() {
        setVisible(true);
        setSize(200, 300);
        reArea = new JTextArea();
        add(reArea);
    }

    public void addText(String msg) {
        // TODO Auto-generated method stub
        reArea.append(msg);

    }
}