package myframe;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

import utils.CmdUtils;


public class MainFrame extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JMenuBar menubar;
	JMenu menu1,menu2,menu3,menu4;
	JMenuItem item1,item2,item3,item4,item5;

	private ImageIcon colorIcon;
	private JLabel jLabColor; 
	private static final Logger logger = LogManager.getLogger(JFrame.class);
	
	private int[][] swipe = null;
	
	ExecutorService executorService = Executors.newFixedThreadPool(2);
	
	
	public MainFrame(String s) {
		super("边界布局管理器示例"); // 继承父类的构造方法
		setTitle(s);
		setBounds(0, 0, 525, 943); 
		getContentPane().setLayout(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
//		135,281
 
		final BorderLayout bb = new BorderLayout(); // 创建边界布局管理器对象
		bb.setHgap(10); // 设置组件的水平间距
		bb.setVgap(10); // 设置组件的垂直间距，默认两间距为0像素
		setLayout(bb); // 设置容器采用边界布局管理器
 
		final JButton aButton = new JButton("按钮 A");
		add(aButton, BorderLayout.NORTH); // 组件的显示位置为顶部
		
		JPanel westJpanel = new JPanel();
		JButton bButton = new JButton("按钮 B");
//		Dimension preferredSize = new Dimension(80, 50);//设置尺寸
//		bButton.setPreferredSize(preferredSize);
		  
		westJpanel.add(bButton);
		add(westJpanel, BorderLayout.WEST); // 左测
 
//		final JButton cButton = new JButton("按钮 C");
//		add(cButton, BorderLayout.CENTER);// 中间
		
		JPanel centerJpanel = new JPanel();
		colorIcon = new ImageIcon();
		jLabColor = new JLabel ();
		jLabColor.setIcon(colorIcon);
		Dimension jlabelBreferredSize = new Dimension(405, 843);//设置尺寸
//		jLabColor.setSize(324, 672);
		jLabColor.setPreferredSize(jlabelBreferredSize);
		jLabColor.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				logger.debug("mouse Pressed at :["+e.getX()+","+e.getY()+"]");
				swipe = new int[2][2];
				swipe[0][0] = e.getX()*8/3;
				swipe[0][1] = e.getY()*8/3;
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				logger.debug("mouse Released at :["+e.getX()+","+e.getY()+"]");
				swipe[1][0] = e.getX()*8/3;
				swipe[1][1] = e.getY()*8/3;
				
				if(Math.abs(swipe[1][1] - swipe[0][1]) > 27 || Math.abs(swipe[1][0] - swipe[0][0])  > 27) {
					logger.info(JSON.toJSON(swipe));
					CmdUtils.runCMD("adb -s 192.168.1.202:5558 shell input swipe "+swipe[0][0]+" "+swipe[0][1]+" "+swipe[1][0]+" "+swipe[1][1]+" ", null);
				}else {
					CmdUtils.runCMD("adb -s 192.168.1.202:5558 shell input tap "+e.getX()*8/3+" "+e.getY()*8/3+" ", null);
				}
				swipe = null;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
//				logger.debug("mouse Exited at :["+e.getX()+","+e.getY()+"]");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
//				logger.debug("mouse Entered at :["+e.getX()+","+e.getY()+"]");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
//				logger.debug("mouse Clicked at :["+e.getX()+","+e.getY()+"]");
//				CmdUtils.runCMD("adb -s 192.168.1.202:5558 shell input tap "+e.getX()*8/3+" "+e.getY()*8/3+" ", null);
			}
		});
		centerJpanel.add(jLabColor);
		add(centerJpanel, BorderLayout.CENTER);// 中间
 
//		final JButton dButton = new JButton("按钮 D");
//		add(dButton, BorderLayout.EAST); // 右侧
 
		final JButton eButton = new JButton("按钮 E");
		add(eButton, BorderLayout.SOUTH); // 底部
		
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				changeImage();
			}
		});
	}

	public void changeImage() {
		int i =0;
		Long useTime = 0L;
		while (true) {
			long startTime = System.currentTimeMillis();
			String path = "C:/Users/gdg/Desktop/11/sc"+i+".png";
			CmdUtils.runCMD("adb -s 192.168.1.202:5558 shell screencap -p /sdcard/sc.png ", null);
			//传输文件到电脑
			CmdUtils.runCMD("adb -s 192.168.1.202:5558 pull /sdcard/sc.png "+path, null);
			colorIcon = new ImageIcon(path);
//			logger.info("图片大小:"+colorIcon.getIconHeight()+","+colorIcon.getIconWidth());
			colorIcon.setImage(colorIcon.getImage().getScaledInstance(405, 843,Image.SCALE_DEFAULT));
			jLabColor.setIcon(colorIcon);
//			i = i==0?1:0;
			useTime = System.currentTimeMillis() - startTime;
			logger.info("use time :"+useTime);
		}
	}
	
	
//	class ClickAction implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("用于执行了单击操作");
//		}
//	}
	
	public static void main(String[] args) {
		MainFrame win = new MainFrame("浏览器");
		
	}
}
