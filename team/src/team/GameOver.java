package team;

import javax.swing.*;           // ���� ��Ű�� ����
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class GameOver extends JDialog     // ������ JDialog ���
  implements ActionListener, WindowListener
{
  // ���� ������Ʈ ����
  JPanel aboutPanel;  
  JButton newgame, retry, exit;
  JLabel showOver;
  Nemonemo parent;
  
  public GameOver(Nemonemo parent)
  {
	  
    super(parent, "GameOver", true);  // ���̾�α�(��ȭ����)�� Ÿ��Ʋ(����) ����
    this.parent=parent;
    this.setSize(240,190);                            // ���̾�α��� ũ�� ����
    this.addWindowListener(this);
    this.setLayout(new BorderLayout(15,15));
    this.setFont(new Font("SansSerif", Font.BOLD, 14));

    createAboutPanel();
  }  

  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==newgame){
    	parent.showOpenDialog();
    	parent.heart.re=true;
    	parent.heart.repaint();
    	this.dispose();
    }else if(e.getSource()==retry){
    	parent.heart.re=true;
    	parent.heart.repaint();
    	parent.board.clearBoard();
    	parent.board.over=false;
    	parent.board.repaint();
    	this.dispose();
    }else if(e.getSource()==exit){
    	System.exit(0);    	
    }    
  }  
  
  public void createAboutPanel()
  {
    aboutPanel= new JPanel();
    aboutPanel.setLayout(null);
    
    showOver = new JLabel("Game Over");
    aboutPanel.add(showOver);
    showOver.setBounds(88, 20, 240, 30);
    
    newgame= new JButton("New Game");
    newgame.addActionListener(this);
    aboutPanel.add(newgame);
    newgame.setBounds(80,50,80,25);

    retry= new JButton("Retry");
    retry.addActionListener(this);
    aboutPanel.add(retry);
    retry.setBounds(80,80,80,25);
    
    exit= new JButton("Exit");
    exit.addActionListener(this);
    aboutPanel.add(exit);
    exit.setBounds(80,110,80,25);
    
    
    
    this.add("Center", aboutPanel);
  }
        
  // the methods of the WindowListener object
  public void windowClosing(WindowEvent e){ this.dispose(); }
  public void windowOpened(WindowEvent e){}
  public void windowClosed(WindowEvent e){}
  public void windowIconified(WindowEvent e){}
  public void windowDeiconified(WindowEvent e){}
  public void windowActivated(WindowEvent e){}
  public void windowDeactivated(WindowEvent e){}  
}

