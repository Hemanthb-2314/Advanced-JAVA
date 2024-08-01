import javax.swing.*;

public class RepresentativeFrame extends JPanel
{
    JLabel rNo,rName,rState,rCommision;
    JTextField rNoTF,rNameTF,rStateTF,rCommTF;
    public RepresentativeFrame()
    {
        rNo=new JLabel("Representative No.");
        rName=new JLabel("Representative Name");
        rState=new JLabel("Representative State");
        rCommision=new JLabel("Commission Rate");
        rNoTF=new JTextField(10);
        rNameTF=new JTextField(10);
        rStateTF=new JTextField(10);
        rCommTF=new JTextField(10);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(rNo);
        add(rNoTF);
        add(rName);
        add(rNameTF);
        add(rState);
        add(rStateTF);
        add(rCommision);
        add(rCommTF);



    }
}