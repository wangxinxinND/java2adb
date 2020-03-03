package service;

import java.util.ArrayList;
import java.util.List;

import entity.ReplaceDto;
import utils.CmdUtils;

public class AdbMethod {
	
	
	public static List<String> getDevices(){
		List<ReplaceDto> list = new ArrayList<ReplaceDto>();
		ReplaceDto temp1 = new ReplaceDto("List of devices attached", "");
		ReplaceDto temp2 = new ReplaceDto("device", "");
		list.add(temp1);
		list.add(temp2);
		List<String> res = CmdUtils.runCMD("adb devices", list );
		return res;
	}
	
	
	public static void kill(){
		List<ReplaceDto> list = new ArrayList<ReplaceDto>();
		ReplaceDto temp1 = new ReplaceDto("adb.exe", "");
		ReplaceDto temp2 = new ReplaceDto("Console", "");
		list.add(temp1);
		list.add(temp2);
		
		CmdUtils.runCMD("adb kill-server", null);
//		tasklist |findstr adb
//		taskkill /pid ���̺� -t -f
	}
	
	public static void connect() {
//		CmdUtils.runCMD("adb connect 192.168.1.200:5556", null);
//		CmdUtils.runCMD("adb connect 192.168.1.201:5557", null);
		CmdUtils.runCMD("adb connect 192.168.1.202:5558", null);
	}
	
	public static void main(String[] args) {
//		AdbMethod.kill();
//		AdbMethod.connect();
//		AdbMethod.getDevices();
		
//		CmdUtils.runCMD("adb -s 192.168.1.202:5558 shell wm size", null);
		
//		"adb shell screencap -p /sdcard/sc.png"; //����
		
//			CmdUtils.runCMD("adb -s 192.168.1.202:5558 shell screencap -p /sdcard/sc.png", null);
//			
//			//�����ļ�������
//			CmdUtils.runCMD("adb -s 192.168.1.202:5558 pull /sdcard/sc.png  C:/Users/gdg/Desktop/�����������/11/sc"+i+".png", null);
		for (int i = 0;i<1;i++) {
//			CmdUtils.runCMD("adb -s 192.168.1.202:5558 exec-out screencap > C:\\Users\\gdg\\Desktop\\sc.png", null);
//			CmdUtils.runCMD("adb -s 192.168.1.202:5558 exec-out screencap -p > C:/Users/gdg/Desktop/�����������/11/sc1.png", null);
			//����
			CmdUtils.runCMD("adb -s 192.168.1.202:5558 shell screencap -p /sdcard/sc.png", null);
			//ѹ��
			CmdUtils.runCMD("adb -s 192.168.1.202:5558 shell tar -czvf sc.tar.gz sc.png", null);
//			//�����ļ�������
			CmdUtils.runCMD("adb -s 192.168.1.202:5558 pull /sdcard/sc.tar.gz  C:/Users/gdg/Desktop/11/sc.tar.gz", null);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
//		"adb shell input keyevent 82"; //����
		
//		"adb shell input swipe 300 1000 300 500"; //���� //���� 300 1000 300 500 �ֱ��ʾ��ʼ��x���� ��ʼ��y���� ������x���� ������y���ꡣ
		
		
		
		
	}

}
