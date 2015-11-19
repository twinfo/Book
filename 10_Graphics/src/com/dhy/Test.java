/**
 * 
 */
package com.dhy;

/**
 * @ClassName: Test 
 * @Description: 测试类
 * @Author 何广军
 * @Date 2015年11月16日 上午10:08:40
 */
public class Test {
public static void main(String[] args) {
	MyGraghics graghics = new MyGraghics();
	graghics.setSize(600, 450);
	graghics.setResizable(false);  //不允许改变尺寸
	graghics.setVisible(true);
}
}
