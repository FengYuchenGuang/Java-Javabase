package TankWarOld.oldTankWar;

import java.net.URL;
import javax.swing.*;

//����ͼƬ�Ĺ�����

public class images {

	//�Ȱ�ͼƬ�ĵ�ַ��װΪһ������Ķ���
	static URL shellURL_tank1 = images.class.getResource("/TankWarOld/Images/̹��1.png");
	static URL shellURL_tank2 = images.class.getResource("/TankWarOld/Images/̹��2.png");  //Ҫ�õ�
	static URL shellURL_tank3 = images.class.getResource("/TankWarOld/Images/̹��3.png");
	static URL shellURL_tank4 = images.class.getResource("/TankWarOld/Images/̹��3.png");
	
	static URL shellURL_secelt = images.class.getResource("/TankWarOld/Images/tank2.jpg");//Ҫ�õ�
	
	static URL shellURL_backgrund = images.class.getResource("/TankWarOld/Images/����.jpg");//Ҫ�õ�

	
	//��ͼƬ��װΪһ������
	static ImageIcon img_tank1 = new ImageIcon(shellURL_tank1);
	static ImageIcon img_tank2 = new ImageIcon(shellURL_tank2);
	static ImageIcon img_tank3 = new ImageIcon(shellURL_tank3);
	static ImageIcon img_tank4 = new ImageIcon(shellURL_tank4);
	
	static ImageIcon img_secelt = new ImageIcon(shellURL_secelt);
	
	static ImageIcon img_backgrund = new ImageIcon(shellURL_backgrund);
	
}

