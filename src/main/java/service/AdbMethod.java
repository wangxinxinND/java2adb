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
//		taskkill /pid 进程号 -t -f
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
		
//		"adb shell screencap -p /sdcard/sc.png"; //截屏
		
//			CmdUtils.runCMD("adb -s 192.168.1.202:5558 shell screencap -p /sdcard/sc.png", null);
//			
//			//传输文件到电脑
//			CmdUtils.runCMD("adb -s 192.168.1.202:5558 pull /sdcard/sc.png  C:/Users/gdg/Desktop/快手面对面码/11/sc"+i+".png", null);
		for (int i = 0;i<1;i++) {
//			CmdUtils.runCMD("adb -s 192.168.1.202:5558 exec-out screencap > C:\\Users\\gdg\\Desktop\\sc.png", null);
//			CmdUtils.runCMD("adb -s 192.168.1.202:5558 exec-out screencap -p > C:/Users/gdg/Desktop/快手面对面码/11/sc1.png", null);
			//截屏
			CmdUtils.runCMD("adb -s 192.168.1.202:5558 shell screencap -p /sdcard/sc.png", null);
			//压缩
			CmdUtils.runCMD("adb -s 192.168.1.202:5558 shell tar -czvf sc.tar.gz sc.png", null);
//			//传输文件到电脑
			CmdUtils.runCMD("adb -s 192.168.1.202:5558 pull /sdcard/sc.tar.gz  C:/Users/gdg/Desktop/11/sc.tar.gz", null);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
//		"adb shell input keyevent 82"; //按键
		
//		"adb shell input swipe 300 1000 300 500"; //滑屏 //参数 300 1000 300 500 分别表示起始点x坐标 起始点y坐标 结束点x坐标 结束点y坐标。
		
		
		
		
	}

}
