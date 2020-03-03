package myframe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
/**
 *
 * 循环播放图片
 *
 * @author monitor
 * Created on 2010-12-22, 16:38:02
 */
public class DisplayJPanel extends JPanel implements Runnable{
    /** 背景颜色 */
    private final Color B_COLOR=Color.LIGHT_GRAY;
    /** 起始X坐标 */
    private final int WORK_X=10;
    /** 起始Y坐标 */
    private final int WORK_Y=10;
    /** 要播放的图片 */
    private List<BufferedImage> imageList=new ArrayList<BufferedImage>();
    /** 当前要画的图片 */
    private BufferedImage currentImage=null;
    /** 播放延时 */
    private int delay=50;
    /** 是否播放 */
    private boolean work=true;
    /** 是否暂停 */
    private boolean stop=false;
    /**
     * 构造一个最初没有图片显示的DisplayJPanel对象
     */
    public DisplayJPanel(){
    }
    /**
     * 构造一个带有要播放图片列表的DisplayJPanel对象
     * @param imageList 要播放的图片列表
     */
    public DisplayJPanel(List<BufferedImage> imageList){
        this.imageList=imageList;
    }
    /**
     * 循环播放图片列表
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
     * 线程睡眠
     * @param s 睡眠时间（ms）
     */
    private void sleep(int s){
        try{
            Thread.sleep(s);
        }catch(Exception e){
        }
    }
    /**
     * 设置播放帧延时
     * @param delay 帧延时（ms）
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }
    /**
     * 设置要播放的图片列表
     * @param imageList 要播放的图片列表
     */
    public void setImageList(List<BufferedImage> imageList) {
        this.imageList = imageList;
    }
    /**
     * 设置是否播放
     * @param work ture 播放，false 不播放
     */
    public void setWork(boolean work) {
        this.work = work;
    }
    /**
     * 设置是否暂停
     * @param stop ture 暂停，false 不暂停
     */
    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
