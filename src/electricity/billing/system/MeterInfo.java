
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MeterInfo extends JFrame implements ActionListener {
    JTextField tfname,tfaddress,tfcity,tfstate,tfemail,tfphone;
    JButton next;
    Choice meterLocation,meterType,phaseCode,billType;
    String meternumber;
    MeterInfo(String meternumber) {
        this.meternumber=meternumber;
        setSize(700,500);
        setLocation(300,100);
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        JLabel heading=new JLabel("Meter Information");
        heading.setBounds(180,10,200,25);
        heading.setFont(new Font("Tahona",Font.PLAIN,24));
        p.add(heading);
        
        JLabel lblname=new JLabel("Meter Number");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);
        
        JLabel lblmeternumber=new JLabel(meternumber);
        lblmeternumber.setBounds(240,80,100,20);
        p.add(lblmeternumber);
        
        JLabel lblmeterno=new JLabel("Meter Location");
        lblmeterno.setBounds(100,120,100,20);
        p.add(lblmeterno);
        
        meterLocation=new Choice();
        meterLocation.add("Outside");
        meterLocation.add("Inside");
        meterLocation.setBounds(240,120,200,20);
        p.add(meterLocation);

        JLabel lbladdress=new JLabel("Meter Type");
        lbladdress.setBounds(100,160,100,20);
        p.add(lbladdress);
        
        meterType=new Choice();
        meterType.add("Electric Meter");
        meterType.add("Solar Meter");
        meterType.add("Smart Meter ");
        meterType.setBounds(240,160,200,20);
        p.add(meterType);
        
        JLabel lblcity=new JLabel("Phase Code");
        lblcity.setBounds(100,200,100,20);
        p.add(lblcity);
        
        phaseCode=new Choice();
        phaseCode.add("011");
        phaseCode.add("022");
        phaseCode.add("033");
        phaseCode.add("044");
        phaseCode.add("055");
        phaseCode.add("066");
        phaseCode.add("077");
        phaseCode.add("088");
        phaseCode.add("099");
        phaseCode.setBounds(240,200,200,20);
        p.add(phaseCode);
        
        JLabel lblstate=new JLabel("Bill Type");
        lblstate.setBounds(100,240,100,20);
        p.add(lblstate);
        
        billType=new Choice();
        billType.add("Normal");
        billType.add("Commercial");
        billType.setBounds(240,240,200,20);
        p.add(billType);
        
        JLabel lblemail=new JLabel("Days");
        lblemail.setBounds(100,280,100,20);
        p.add(lblemail);
        
        JLabel lblemails=new JLabel("30 Days");
        lblemails.setBounds(240,280,100,20);
        p.add(lblemails);
        
        JLabel lblphone=new JLabel("Note");
        lblphone.setBounds(100,320,100,20);
        p.add(lblphone);
        
        JLabel lblphones=new JLabel("By default bill is calculated for 30 days");
        lblphones.setBounds(240,320,500,20);
        p.add(lblphones);
        
        next=new JButton("Submit");
        next.setBounds(220,370,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

        setLayout(new BorderLayout());
        add(p,"Center");
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource(("icon/hicon1.jpg")));
        Image i2=i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image,"West");
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next)
        {
            String meter=meternumber;
            String location=meterLocation.getSelectedItem();
            String type=meterType.getSelectedItem();
            String code=phaseCode.getSelectedItem();
            String typebill=billType.getSelectedItem();
            String days="30";
            
            String query="insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+code+"','"+typebill+"','"+days+"')";
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Meter Infomation Added succesfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new MeterInfo("");
    }
}
