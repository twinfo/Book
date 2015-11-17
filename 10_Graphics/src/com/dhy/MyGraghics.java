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
    implements ActionListener,ItemListener{
	private static final long serialVersionUID = 1L;
	JMenuBar jmb;  // �˵���
	JMenu fileMenu,optMenu,colorMenu;  // �˵�
	JMenuItem jmiClear,jmiEraser,jmiExit,jmiReapet;
	JCheckBoxMenuItem jcmi;
	JRadioButtonMenuItem rbmiBlue,rbmiYellow,rbmiRed;
	ButtonGroup bg; // �����ѡť
	Color c = new Color(0,0,255);  // ������ɫĬ��ֵ
	MyPanel myPanel; // ʹ���ڲ��ඨ��һ������
	
	public MyGraghics() {
		createMenu();  // ��ʼ���˵�,ģ�黯
		myPanel = new MyPanel();
		getContentPane().add(myPanel, BorderLayout.CENTER); // �ڲ��������������
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
		// �޸ĵ�ɫ
		g.setColor(Color.WHITE);
		g.fillRect(0, 55, getWidth(), getHeight()-55);
		
		// 1.ȡ���ʣ����û��ʵ���ɫ
		g.setColor(Color.BLUE);
		// 2.����
		g.drawLine(100, 100, 200, 200); // ����
		
		g.setColor(new Color(56, 130, 38));
		g.fillRect(150, 120, 100, 120);
		
		g.setColor(Color.RED);
		g.fillOval(160, 140, 100, 70);
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

}
