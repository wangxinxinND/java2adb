package myframe;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/*
 * MainUI.java
 *
 * 图片循环播放
 *
 * @author monitor
 * Created on 2010-12-22, 16:49:47
 */
public class MainUI extends javax.swing.JFrame {
    private DisplayJPanel display=null;
    private DefaultListModel imageModel=new DefaultListModel();
    private List<BufferedImage> imageList=new ArrayList<BufferedImage>();
    /**
     * 构造一个MainUI对象
     */
    public MainUI() {
        initComponents();
        init();
    }
    /**
     * 界面初始化
     */
    private void init(){
        //居中显示
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth=(int)screenSize.getWidth();
        int screenHeight=(int)screenSize.getHeight();
        int width=this.getWidth();
        int height=this.getHeight();
        this.setBounds((screenWidth-width)/2,(screenHeight-height)/2,width ,height);
        display=new DisplayJPanel();
        imagePane.setViewportView(display);
        new Thread(display).start();
        //进度图不可视
        bar.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        msgLabel = new javax.swing.JLabel();
        bar = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        delaySpin = new javax.swing.JSpinner();
        jToolBar1 = new javax.swing.JToolBar();
        importButton = new javax.swing.JButton();
        playButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        goonButton = new javax.swing.JButton();
        imagePane = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        imageJList = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setFont(new java.awt.Font("宋体", 0, 36));
        jLabel1.setText("图片播放");
        jPanel1.add(jLabel1);
        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));
        jPanel2.add(msgLabel);
        jPanel2.add(bar);
        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setText("播放延时(ms)：");
        delaySpin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(50), Integer.valueOf(10), null, Integer.valueOf(1)));
        delaySpin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                delaySpinStateChanged(evt);
            }
        });
        jToolBar1.setRollover(true);
        importButton.setText("导入");
        importButton.setFocusable(false);
        importButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        importButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(importButton);
        playButton.setText("播放");
        playButton.setFocusable(false);
        playButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        playButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(playButton);
        stopButton.setText("暂停");
        stopButton.setFocusable(false);
        stopButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        stopButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(stopButton);
        goonButton.setText("继续");
        goonButton.setFocusable(false);
        goonButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        goonButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        goonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goonButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(goonButton);
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delaySpin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delaySpin, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );
        imageJList.setModel(imageModel);
        jScrollPane1.setViewportView(imageJList);
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagePane, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(imagePane, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap())
        );
        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);
        jMenu1.setText("文件");
        jMenuBar1.add(jMenu1);
        jMenu2.setText("编辑");
        jMenuBar1.add(jMenu2);
        jMenu3.setText("编辑");
        jMenuBar1.add(jMenu3);
        setJMenuBar(jMenuBar1);
        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * 用线程导入图片，并在界面显示信息
     * @param evt 触发事件
     */
    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        new Thread(new Runnable() {
            public void run() {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int flag=fileChooser.showOpenDialog(null);
                if(flag!=JFileChooser.APPROVE_OPTION){
                    return;
                }
                File importFile = fileChooser.getSelectedFile();
                if (importFile==null) {
                    return;
                }
                imageModel.removeAllElements();
                int i=1;
                bar.setVisible(true);
                bar.setIndeterminate(true);
                for(File file:importFile.listFiles()){
                    try {
                        msgLabel.setText("正在导入："+file.getName());
                        imageList.add(ImageIO.read(file));
                        imageModel.addElement(file.getName());
                        i++;
                    } catch (IOException ex) {
                        System.out.println("非图片文件");
                        //Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                bar.setVisible(false);
                msgLabel.setText("导入完毕！共"+i+"张图片，播放图片请点击“播放”按钮");
            }}).start();
    }//GEN-LAST:event_importButtonActionPerformed
    /**
     * 播放
     * @param evt
     */
    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        if(imageList==null || imageList.isEmpty()){
            String msg="请输入导入要播放的图片";
            JOptionPane.showMessageDialog(this, msg , "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        display.setImageList(imageList);
        
    }//GEN-LAST:event_playButtonActionPerformed
    /**
     * 修改帧延时
     * @param evt
     */
    private void delaySpinStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_delaySpinStateChanged
        int delay=(Integer)delaySpin.getValue();
        if(delay>=10){
            display.setDelay(delay);
        }
    }//GEN-LAST:event_delaySpinStateChanged
    /**
     * 暂停
     * @param evt
     */
    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        display.setStop(true);
    }//GEN-LAST:event_stopButtonActionPerformed
    /**
     * 继续
     * @param evt
     */
    private void goonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goonButtonActionPerformed
        display.setStop(false);
    }//GEN-LAST:event_goonButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar bar;
    private javax.swing.JSpinner delaySpin;
    private javax.swing.JButton goonButton;
    private javax.swing.JList imageJList;
    private javax.swing.JScrollPane imagePane;
    private javax.swing.JButton importButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel msgLabel;
    private javax.swing.JButton playButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}

