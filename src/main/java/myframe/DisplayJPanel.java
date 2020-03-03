package myframe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
/**
 *
 * ѭ������ͼƬ
 *
 * @author monitor
 * Created on 2010-12-22, 16:38:02
 */
public class DisplayJPanel extends JPanel implements Runnable{
    /** ������ɫ */
    private final Color B_COLOR=Color.LIGHT_GRAY;
    /** ��ʼX���� */
    private final int WORK_X=10;
    /** ��ʼY���� */
    private final int WORK_Y=10;
    /** Ҫ���ŵ�ͼƬ */
    private List<BufferedImage> imageList=new ArrayList<BufferedImage>();
    /** ��ǰҪ����ͼƬ */
    private BufferedImage currentImage=null;
    /** ������ʱ */
    private int delay=50;
    /** �Ƿ񲥷� */
    private boolean work=true;
    /** �Ƿ���ͣ */
    private boolean stop=false;
    /**
     * ����һ�����û��ͼƬ��ʾ��DisplayJPanel����
     */
    public DisplayJPanel(){
    }
    /**
     * ����һ������Ҫ����ͼƬ�б��DisplayJPanel����
     * @param imageList Ҫ���ŵ�ͼƬ�б�
     */
    public DisplayJPanel(List<BufferedImage> imageList){
        this.imageList=imageList;
    }
    /**
     * ѭ������ͼƬ�б�
     */
    public void run(){
        while(work){
            if(stop || imageList==null || imageList.isEmpty()){
                sleep(1000);
                continue;
            }
            for(BufferedImage image:imageList){
                currentImage=image;
                repaint();
                sleep(delay);
            }
        }
    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(B_COLOR);
        g.fillRect(0, 0,this.getWidth(),this.getHeight());
        if(currentImage!=null){
            g.drawImage(currentImage,WORK_X,WORK_Y,null);
        }
    }
    /**
     * �߳�˯��
     * @param s ˯��ʱ�䣨ms��
     */
    private void sleep(int s){
        try{
            Thread.sleep(s);
        }catch(Exception e){
        }
    }
    /**
     * ���ò���֡��ʱ
     * @param delay ֡��ʱ��ms��
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }
    /**
     * ����Ҫ���ŵ�ͼƬ�б�
     * @param imageList Ҫ���ŵ�ͼƬ�б�
     */
    public void setImageList(List<BufferedImage> imageList) {
        this.imageList = imageList;
    }
    /**
     * �����Ƿ񲥷�
     * @param work ture ���ţ�false ������
     */
    public void setWork(boolean work) {
        this.work = work;
    }
    /**
     * �����Ƿ���ͣ
     * @param stop ture ��ͣ��false ����ͣ
     */
    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
