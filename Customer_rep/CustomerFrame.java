import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSlider;
public class CustomerFrame extends JPanel {
    JLabel cNo, cName, cState, creditLimit, repNo;
    JTextField cNoTF, cNameTF, cStateTF, creditLimitTF, repNoTF;
    JButton submit,creditLimitButton;

    public CustomerFrame() {
//cNo=new JLabel("Customer Frame");
//add(cNo);
        cNo = new JLabel("Cust No:");
        cName = new JLabel("Cust Name:");
        cState = new JLabel("State:");
        creditLimit = new JLabel("Credit Limit:");
        repNo = new JLabel("Rep No:");
        cNoTF = new JTextField(10);
        cNameTF = new JTextField(10);
        cStateTF = new JTextField(10);
        creditLimitTF = new JTextField(10);
        repNoTF = new JTextField(10);

        submit = new JButton("Insert");
        //JSlider slider= new JSlider(1000,5000,1000);
        //slider.setMajorTickSpacing(5000);
        //slider.setMinorTickSpacing(1000);
        //slider.setPaintTicks(true);
        //slider.setPaintLabels(true);
        //slider.getGraphics();
        creditLimitButton = new JButton("> Credit Limit");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(cNo);
        add(cNoTF);
        add(cName);
        add(cNameTF);
        add(cState);
        add(cStateTF);
        add(creditLimit);
        //add(slider);
        add(creditLimitTF);
        add(repNo);
        add(repNoTF);
        add(submit);
        add(creditLimitButton);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Home48", "root", "2314");
                    Statement st = con.createStatement();
                    int cno = Integer.parseInt(cNoTF.getText());
                    String cuName = cNameTF.getText();
                    String cuState = cStateTF.getText();
                    int credLimit = Integer.parseInt(creditLimitTF.getText());
                    int repre = Integer.parseInt(repNoTF.getText());

                    String query = String.format("insert into customer values(%d,'%s','%s',%d,%d)", cno, cuName, cuState, credLimit, repre);
                    st.executeUpdate(query);
                } catch (SQLException se) {
                    System.out.println("error in connecting to database");

                }
                JOptionPane.showMessageDialog(CustomerFrame.this, "Record Inserted Succesfully");
                clearform();


            }
        });
        creditLimitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                HigherCreditLimitFrame myFrame = new HigherCreditLimitFrame();
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Home48", "root", "2314");
                    Statement st = con.createStatement();
                    String query = "select RepNo,RepName from representative where RepNo in (select RepNo from customer where Credit_limit>15000)";
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        myFrame.addText(rs.getInt(1) + "\t" + rs.getString(2) + "\n");
                    }
                } catch (SQLException se) {
                    System.out.println(se);
                }

            }

        });
    }

    private void clearform() {
        cNoTF.setText("");
        cNameTF.setText("");
        cStateTF.setText("");
        creditLimitTF.setText("");
        repNoTF.setText("");
    }
}