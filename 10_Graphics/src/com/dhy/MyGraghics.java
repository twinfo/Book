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
 * @Description: 图形类 
 * @Author 何广军
 * @Date 2015年11月16日 上午10:02:44
 */
public class MyGraghics extends JFrame 
    implements ActionListener,ItemListener,KeyListener{
	private static final long serialVersionUID = 1L;
	JMenuBar jmb;  // 菜单条
	JMenu fileMenu,optMenu,colorMenu;  // 菜单
	JMenuItem jmiClear,jmiEraser,jmiExit,jmiReapet;
	JCheckBoxMenuItem jcmi;
	JRadioButtonMenuItem rbmiBlue,rbmiYellow,rbmiRed;
	ButtonGroup bg; // 打包单选钮
	Color c = new Color(0,0,255);  // 设置蓝色默认值
	MyPanel myPanel; // 使用内部类定义一个对象
	int x = 100, y = 100; // 图形初始位置
	
	public MyGraghics() {
		createMenu();  // 初始化菜单,模块化
		myPanel = new MyPanel();
		getContentPane().add(myPanel, BorderLayout.CENTER); // 内部类加入主容器中

		// 注册监听器
		this.addKeyListener(this);
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
		setImage(g);   // 画王八
		/*// 修改底色
		g.setColor(Color.WHITE);
		g.fillRect(0, 55, getWidth(), getHeight()-55);
		
		// 1.取画笔，设置画笔的颜色
		g.setColor(Color.BLUE);
		// 2.绘制
		g.drawLine(100, 100, 200, 200); // 画线
		
		g.setColor(new Color(56, 130, 38));
		g.fillRect(150, 120, 100, 120);
		
		g.setColor(Color.RED);
		g.fillOval(160, 140, 100, 70);*/
	}

	// 画的一只王八
	private void setImage(Graphics g) {
		// 清屏
		g.setColor(Color.WHITE);
		g.fillRect(0, 50, this.getSize().width, this.getSize().height-50);

		// 为画笔调色
		Color color = new Color(80, 233, 22);
		g.setColor(color);
		// 决定所画的内容
		// 贴图顺序：先画一个图像，再画一个图像
		// 头部
		g.fillOval(x, y, 50, 70);

		g.setColor(Color.white);

		g.fillOval(x + 5, y + 10, 10, 10);
		g.fillOval(x + 35, y + 10, 10, 10);

		g.setColor(Color.black);
		g.fillOval(x + 3, y + 8, 10, 10);
		g.fillOval(x + 33, y + 8, 10, 10);

		// 尾巴
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

		// 四只脚
		color = new Color(80, 233, 22);
		g.setColor(color);
		g.fillOval(x - 70, y + 45, 50, 60);
		g.fillOval(x + 70, y + 45, 50, 60);
		g.fillOval(x + 70, y + 140, 50, 60);
		g.fillOval(x - 70, y + 140, 50, 60);

		// 中心外园
		color = new Color(65, 188, 18);
		g.setColor(color);
		g.fillOval(x - 50, y + 40, 150, 150);
		// 中心内园
		g.setColor(Color.green);
		g.fillOval(x - 40, y + 50, 130, 130);
		// 背上的线
		color = new Color(65, 188, 18);
		g.setColor(color);

		// g.drawLine(155, 245, 175, 265);
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

	@Override
	public void keyPressed(KeyEvent e) { // 键盘按下
		int key = e.getKeyCode();  // 获得键盘码
		if (key == KeyEvent.VK_UP){ // 向上
			y--;
		} else if (key == KeyEvent.VK_DOWN){ // 向下
			y++;
		} else if (key == KeyEvent.VK_LEFT){ // 向左
			x--;
		} else if (key == KeyEvent.VK_RIGHT){ //向右
			x++;
		}
		repaint(); 
	}

	@Override
	public void keyReleased(KeyEvent e) { // 键盘抬起
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {  // 键盘敲击（按下+抬起）
		// TODO Auto-generated method stub
		
	}


}
