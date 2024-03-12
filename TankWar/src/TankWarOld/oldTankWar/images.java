package TankWarOld.oldTankWar;

import java.net.URL;
import javax.swing.*;

//运用图片的工具类

public class images {

	//先把图片的地址封装为一个具体的对象
	static URL shellURL_tank1 = images.class.getResource("/TankWarOld/Images/坦克1.png");
	static URL shellURL_tank2 = images.class.getResource("/TankWarOld/Images/坦克2.png");  //要用的
	static URL shellURL_tank3 = images.class.getResource("/TankWarOld/Images/坦克3.png");
	static URL shellURL_tank4 = images.class.getResource("/TankWarOld/Images/坦克3.png");
	
	static URL shellURL_secelt = images.class.getResource("/TankWarOld/Images/tank2.jpg");//要用的
	
	static URL shellURL_backgrund = images.class.getResource("/TankWarOld/Images/背景.jpg");//要用的

	
	//把图片封装为一个对象
	static ImageIcon img_tank1 = new ImageIcon(shellURL_tank1);
	static ImageIcon img_tank2 = new ImageIcon(shellURL_tank2);
	static ImageIcon img_tank3 = new ImageIcon(shellURL_tank3);
	static ImageIcon img_tank4 = new ImageIcon(shellURL_tank4);
	
	static ImageIcon img_secelt = new ImageIcon(shellURL_secelt);
	
	static ImageIcon img_backgrund = new ImageIcon(shellURL_backgrund);
	
}

