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
		super("�߽粼�ֹ�����ʾ��"); // �̳и���Ĺ��췽��
		setTitle(s);
		setBounds(0, 0, 525, 943); 
		getContentPane().setLayout(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
//		135,281
 
		final BorderLayout bb = new BorderLayout(); // �����߽粼�ֹ���������
		bb.setHgap(10); // ���������ˮƽ���
		bb.setVgap(10); // ��������Ĵ�ֱ��࣬Ĭ�������Ϊ0����
		setLayout(bb); // �����������ñ߽粼�ֹ�����
 
		final JButton aButton = new JButton("��ť A");
		add(aButton, BorderLayout.NORTH); // �������ʾλ��Ϊ����
		
		JPanel westJpanel = new JPanel();
		JButton bButton = new JButton("��ť B");
//		Dimension preferredSize = new Dimension(80, 50);//���óߴ�
//		bButton.setPreferredSize(preferredSize);
		  
		westJpanel.add(bButton);
		add(westJpanel, BorderLayout.WEST); // ���
 
//		final JButton cButton = new JButton("��ť C");
//		add(cButton, BorderLayout.CENTER);// �м�
		
		JPanel centerJpanel = new JPanel();
		colorIcon = new ImageIcon();
		jLabColor = new JLabel ();
		jLabColor.setIcon(colorIcon);
		Dimension jlabelBreferredSize = new Dimension(405, 843);//���óߴ�
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
		add(centerJpanel, BorderLayout.CENTER);// �м�
 
//		final JButton dButton = new JButton("��ť D");
//		add(dButton, BorderLayout.EAST); // �Ҳ�
 
		final JButton eButton = new JButton("��ť E");
		add(eButton, BorderLayout.SOUTH); // �ײ�
		
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
			//�����ļ�������
			CmdUtils.runCMD("adb -s 192.168.1.202:5558 pull /sdcard/sc.png "+path, null);
			colorIcon = new ImageIcon(path);
//			logger.info("ͼƬ��С:"+colorIcon.getIconHeight()+","+colorIcon.getIconWidth());
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
//			System.out.println("����ִ���˵�������");
//		}
//	}
	
	public static void main(String[] args) {
		MainFrame win = new MainFrame("�����");
		
	}
}
