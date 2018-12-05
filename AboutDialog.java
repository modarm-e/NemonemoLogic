package team;

import javax.swing.*;           // ���� ��Ű�� ����
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AboutDialog extends JDialog     // ������ JDialog ���
  implements ActionListener, WindowListener
{
  // ���� ������Ʈ ����
  JPanel aboutPanel;  
  JButton ok;
  JLabel titleLabel, nameLabel;
  Nemonemo parent;
  
  public AboutDialog(Nemonemo parent)
  {
    super(parent, "Nemonemo Logic", true);  // ���̾�α�(��ȭ����)�� Ÿ��Ʋ(����) ����
    this.parent=parent;
    parent.timer.stop=true;
    this.setSize(240,190);                            // ���̾�α��� ũ�� ����
    this.addWindowListener(this);
    this.setLayout(new BorderLayout(15,15));
    this.setFont(new Font("SansSerif", Font.BOLD, 14));

    createAboutPanel();
  }  

  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==ok){
      parent.timer.stop=false;
      this.dispose();
    }
  }  
  
  public void createAboutPanel()
  {
    aboutPanel= new JPanel();
    aboutPanel.setLayout(null);
    
    // About Game ���� ���
    titleLabel= new JLabel("�ͫ�ͫ���ë� 2018/12/06");
    aboutPanel.add(titleLabel);
    titleLabel.setBounds(40,30,200,25);
    
    nameLabel= new JLabel(" by ������ ���̵�");
    aboutPanel.add(nameLabel);
    nameLabel.setBounds(60,60,200,25);

    // ���̾�α� ���� ��ư
    ok= new JButton("Okay");
    ok.addActionListener(this);
    aboutPanel.add(ok);
    ok.setBounds(80,110,80,25);

    this.add("Center", aboutPanel);
  }
        
  // the methods of the WindowListener object
  public void windowClosing(WindowEvent e){ 
	  parent.timer.stop=false;
	  this.dispose(); }
  public void windowOpened(WindowEvent e){}
  public void windowClosed(WindowEvent e){}
  public void windowIconified(WindowEvent e){}
  public void windowDeiconified(WindowEvent e){}
  public void windowActivated(WindowEvent e){}
  public void windowDeactivated(WindowEvent e){}  
}

