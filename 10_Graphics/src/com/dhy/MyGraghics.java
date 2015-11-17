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
 * @Description: 图形类 
 * @Author 何广军
 * @Date 2015年11月16日 上午10:02:44
 */
public class MyGraghics extends JFrame 
    implements ActionListener,ItemListener{
	private static final long serialVersionUID = 1L;
	JMenuBar jmb;  // 菜单条
	JMenu fileMenu,optMenu,colorMenu;  // 菜单
	JMenuItem jmiClear,jmiEraser,jmiExit,jmiReapet;
	JCheckBoxMenuItem jcmi;
	JRadioButtonMenuItem rbmiBlue,rbmiYellow,rbmiRed;
	ButtonGroup bg; // 打包单选钮
	Color c = new Color(0,0,255);  // 设置蓝色默认值
	MyPanel myPanel; // 使用内部类定义一个对象
	
	public MyGraghics() {
		createMenu();  // 初始化菜单,模块化
		myPanel = new MyPanel();
		getContentPane().add(myPanel, BorderLayout.CENTER); // 内部类加入主容器中
	}
	
	private void createMenu() {
		jmb = new JMenuBar(); 
		setJMenuBar(jmb);  // 菜单条加入JFrame框架
		
		fileMenu = new JMenu("清除方式",false);
		optMenu = new JMenu("选项",true);
		// 菜单需要加入到菜单条中
		jmb.add(fileMenu);
		jmb.add(optMenu);
		
		jmiReapet = new JMenuItem("重绘");
		jmiClear = new JMenuItem("清除");
		jmiEraser = new JMenuItem("橡皮");
		jmiExit = new JMenuItem("退出");
		// 菜单项需要加入到对应的菜单中
		fileMenu.add(jmiEraser);
		fileMenu.add(jmiClear);
		fileMenu.add(jmiReapet);
		fileMenu.addSeparator();  // 分隔条
		fileMenu.add(jmiExit);
		
		jcmi = new JCheckBoxMenuItem("自动换行");  // 复选菜单项
		optMenu.add(jcmi);
		
		colorMenu = new JMenu("颜色");
		optMenu.add(colorMenu);
		rbmiBlue = new JRadioButtonMenuItem("蓝色",true);
		rbmiYellow = new JRadioButtonMenuItem("黄色");
		rbmiRed = new JRadioButtonMenuItem("红色");
		bg = new ButtonGroup();   // 将单选按钮打包到一个组
		bg.add(rbmiBlue);
		bg.add(rbmiYellow);
		bg.add(rbmiRed);
		colorMenu.add(rbmiBlue);  // 将单选按钮菜单项加入子菜单中
		colorMenu.add(rbmiYellow);
		colorMenu.add(rbmiRed);
		
		// 对菜单项进行监听
		jmiClear.addActionListener(this);
		jmiEraser.addActionListener(this);
		jmiExit.addActionListener(this);
		jmiReapet.addActionListener(this);
		// 对复选及单选菜单项进行监听
		jcmi.addItemListener(this);
		rbmiBlue.addItemListener(this);
		rbmiYellow.addItemListener(this);
		rbmiRed.addItemListener(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 修改底色
		g.setColor(Color.WHITE);
		g.fillRect(0, 55, getWidth(), getHeight()-55);
		
		// 1.取画笔，设置画笔的颜色
		g.setColor(Color.BLUE);
		// 2.绘制
		g.drawLine(100, 100, 200, 200); // 画线
		
		g.setColor(new Color(56, 130, 38));
		g.fillRect(150, 120, 100, 120);
		
		g.setColor(Color.RED);
		g.fillOval(160, 140, 100, 70);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// 复选或单选菜单项
		if (e.getSource() instanceof JRadioButtonMenuItem){
			if (rbmiBlue.isSelected()){ //蓝色的被选中
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
		Graphics g = getGraphics(); // 获取画板
		// 菜单项
		if (e.getSource() == jmiClear){ // 清除
			g.setColor(Color.WHITE);
			g.fillRect(0, 55, getWidth(), getHeight()-55);
		} else if (e.getSource() == jmiEraser){ // 取背景色
			c = Color.WHITE;  // 橡皮擦，设置底色为白色。
		} else if (e.getSource() == jmiExit){ // 退出系统
			System.exit(0);
		} else {
			repaint();  // 自动调用paint方法进行重新绘制
		}
	}

	// 内部类
	class MyPanel extends JPanel implements MouseMotionListener{
		public MyPanel() {
			this.addMouseMotionListener(this);  // 注册监听器
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// 获取画板
			Graphics g = getGraphics();
			g.setColor(c);
			if (c == Color.WHITE){  // 使用橡皮擦	
				g.fillOval(e.getX() - 10, e.getY() - 10, 20, 20);
			} else{
				g.fillOval(e.getX(), e.getY(), 5, 5);
			}
			g.dispose();  // 释放资源
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
