/**
 * 
 */
package com.dhy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

/**
 * @ClassName: MyGraghics 
 * @Description: ͼ���� 
 * @Author �ι��
 * @Date 2015��11��16�� ����10:02:44
 */
public class MyGraghics extends JFrame 
    implements ActionListener,ItemListener,KeyListener{
	private static final long serialVersionUID = 1L;
	JMenuBar jmb;  // �˵���
	JMenu fileMenu,optMenu,colorMenu;  // �˵�
	JMenuItem jmiClear,jmiEraser,jmiExit,jmiReapet;
	JCheckBoxMenuItem jcmi;
	JRadioButtonMenuItem rbmiBlue,rbmiYellow,rbmiRed;
	ButtonGroup bg; // �����ѡť
	Color c = new Color(0,0,255);  // ������ɫĬ��ֵ
	MyPanel myPanel; // ʹ���ڲ��ඨ��һ������
	int x = 100, y = 100; // ͼ�γ�ʼλ��
	
	public MyGraghics() {
		createMenu();  // ��ʼ���˵�,ģ�黯
		myPanel = new MyPanel();
		getContentPane().add(myPanel, BorderLayout.CENTER); // �ڲ��������������

		// ע�������
		this.addKeyListener(this);
	}
	
	private void createMenu() {
		jmb = new JMenuBar(); 
		setJMenuBar(jmb);  // �˵�������JFrame���
		
		fileMenu = new JMenu("�����ʽ",false);
		optMenu = new JMenu("ѡ��",true);
		// �˵���Ҫ���뵽�˵�����
		jmb.add(fileMenu);
		jmb.add(optMenu);
		
		jmiReapet = new JMenuItem("�ػ�");
		jmiClear = new JMenuItem("���");
		jmiEraser = new JMenuItem("��Ƥ");
		jmiExit = new JMenuItem("�˳�");
		// �˵�����Ҫ���뵽��Ӧ�Ĳ˵���
		fileMenu.add(jmiEraser);
		fileMenu.add(jmiClear);
		fileMenu.add(jmiReapet);
		fileMenu.addSeparator();  // �ָ���
		fileMenu.add(jmiExit);
		
		jcmi = new JCheckBoxMenuItem("�Զ�����");  // ��ѡ�˵���
		optMenu.add(jcmi);
		
		colorMenu = new JMenu("��ɫ");
		optMenu.add(colorMenu);
		rbmiBlue = new JRadioButtonMenuItem("��ɫ",true);
		rbmiYellow = new JRadioButtonMenuItem("��ɫ");
		rbmiRed = new JRadioButtonMenuItem("��ɫ");
		bg = new ButtonGroup();   // ����ѡ��ť�����һ����
		bg.add(rbmiBlue);
		bg.add(rbmiYellow);
		bg.add(rbmiRed);
		colorMenu.add(rbmiBlue);  // ����ѡ��ť�˵�������Ӳ˵���
		colorMenu.add(rbmiYellow);
		colorMenu.add(rbmiRed);
		
		// �Բ˵�����м���
		jmiClear.addActionListener(this);
		jmiEraser.addActionListener(this);
		jmiExit.addActionListener(this);
		jmiReapet.addActionListener(this);
		// �Ը�ѡ����ѡ�˵�����м���
		jcmi.addItemListener(this);
		rbmiBlue.addItemListener(this);
		rbmiYellow.addItemListener(this);
		rbmiRed.addItemListener(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setImage(g);   // ������
		/*// �޸ĵ�ɫ
		g.setColor(Color.WHITE);
		g.fillRect(0, 55, getWidth(), getHeight()-55);
		
		// 1.ȡ���ʣ����û��ʵ���ɫ
		g.setColor(Color.BLUE);
		// 2.����
		g.drawLine(100, 100, 200, 200); // ����
		
		g.setColor(new Color(56, 130, 38));
		g.fillRect(150, 120, 100, 120);
		
		g.setColor(Color.RED);
		g.fillOval(160, 140, 100, 70);*/
	}

	// ����һֻ����
	private void setImage(Graphics g) {
		// ����
		g.setColor(Color.WHITE);
		g.fillRect(0, 50, this.getSize().width, this.getSize().height-50);

		// Ϊ���ʵ�ɫ
		Color color = new Color(80, 233, 22);
		g.setColor(color);
		// ��������������
		// ��ͼ˳���Ȼ�һ��ͼ���ٻ�һ��ͼ��
		// ͷ��
		g.fillOval(x, y, 50, 70);

		g.setColor(Color.white);

		g.fillOval(x + 5, y + 10, 10, 10);
		g.fillOval(x + 35, y + 10, 10, 10);

		g.setColor(Color.black);
		g.fillOval(x + 3, y + 8, 10, 10);
		g.fillOval(x + 33, y + 8, 10, 10);

		// β��
		color = new Color(80, 233, 22);
		g.setColor(color);
		g.fillOval(x + 15, y + 160, 70, 90);
		g.setColor(Color.WHITE);
		g.fillOval(x + 25, y + 160, 70, 90);

		color = new Color(80, 233, 22);
		g.setColor(color);
		g.fillOval(x + 20, y + 200, 30, 30);
		g.setColor(Color.white);
		g.fillOval(x + 28, y + 208, 14, 14);

		// ��ֻ��
		color = new Color(80, 233, 22);
		g.setColor(color);
		g.fillOval(x - 70, y + 45, 50, 60);
		g.fillOval(x + 70, y + 45, 50, 60);
		g.fillOval(x + 70, y + 140, 50, 60);
		g.fillOval(x - 70, y + 140, 50, 60);

		// ������԰
		color = new Color(65, 188, 18);
		g.setColor(color);
		g.fillOval(x - 50, y + 40, 150, 150);
		// ������԰
		g.setColor(Color.green);
		g.fillOval(x - 40, y + 50, 130, 130);
		// ���ϵ���
		color = new Color(65, 188, 18);
		g.setColor(color);

		// g.drawLine(155, 245, 175, 265);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// ��ѡ��ѡ�˵���
		if (e.getSource() instanceof JRadioButtonMenuItem){
			if (rbmiBlue.isSelected()){ //��ɫ�ı�ѡ��
				c = Color.BLUE;
			} else if (rbmiYellow.isSelected()){
				c = Color.YELLOW;
			} else {
				c = Color.RED;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Graphics g = getGraphics(); // ��ȡ����
		// �˵���
		if (e.getSource() == jmiClear){ // ���
			g.setColor(Color.WHITE);
			g.fillRect(0, 55, getWidth(), getHeight()-55);
		} else if (e.getSource() == jmiEraser){ // ȡ����ɫ
			c = Color.WHITE;  // ��Ƥ�������õ�ɫΪ��ɫ��
		} else if (e.getSource() == jmiExit){ // �˳�ϵͳ
			System.exit(0);
		} else {
			repaint();  // �Զ�����paint�����������»���
		}
	}
	
	

	// �ڲ���
	class MyPanel extends JPanel implements MouseMotionListener{
		public MyPanel() {
			this.addMouseMotionListener(this);  // ע�������
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// ��ȡ����
			Graphics g = getGraphics();
			g.setColor(c);
			if (c == Color.WHITE){  // ʹ����Ƥ��	
				g.fillOval(e.getX() - 10, e.getY() - 10, 20, 20);
			} else{
				g.fillOval(e.getX(), e.getY(), 5, 5);
			}
			g.dispose();  // �ͷ���Դ
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) { // ���̰���
		int key = e.getKeyCode();  // ��ü�����
		if (key == KeyEvent.VK_UP){ // ����
			y--;
		} else if (key == KeyEvent.VK_DOWN){ // ����
			y++;
		} else if (key == KeyEvent.VK_LEFT){ // ����
			x--;
		} else if (key == KeyEvent.VK_RIGHT){ //����
			x++;
		}
		repaint(); 
	}

	@Override
	public void keyReleased(KeyEvent e) { // ����̧��
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {  // �����û�������+̧��
		// TODO Auto-generated method stub
		
	}


}
