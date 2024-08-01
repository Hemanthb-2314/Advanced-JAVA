import javax.swing.*;
public class MainFrame extends JFrame {
    JTabbedPane tabbedPane = new JTabbedPane();
    public MainFrame() {
        super("Customer Representative Form");
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100,100);
        //tabbedPane=new JTabbedPane();
        tabbedPane.add("Customer",new CustomerFrame());
        tabbedPane.add("Representative",new RepresentativeFrame());
        add(tabbedPane);
        pack();
    }
}
