package xidian;

import java.applet.Applet;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * 在java中有两种方式实现多线程，一种是继承 Thread类，一种是实现Runnable接口；
 * @author Administrator
 *
 *在实际的开发中可定是以Runnable接口为主
 *
 *1、画界面  2、绘制界面（显示静态时间） 3、调用线程刷新界面
 *
 *
 *1.applet是一种不能单独运行但可嵌入在其他应用程序中的小程序

2.该类直接继承于java.awt.Panel类，其直接子类为javax.swing.JApplet
 */



public class Animation extends Applet implements Runnable {
	Image igs[];  //用于装载组成GIF动画的JPG图片

	Thread th;   //声明了线程对象

	int MAX_hight = 200, MAX_width = 200;//定义了程序界面的大小

	Image image; //声明了一个图片  ；是一个抽象类，是表示图形图像的所有类的超类

	Graphics gh;//声明了一个Graphics对象  是所有图形上下文的抽象基类，允许应用程序可以在组件 以及图像上进行绘制

	MediaTracker mt;//声明了一个MediaTracker对象 ;是一个跟踪多种媒体对象状态的使用工具类，目前仅支持图像

	boolean flag = false;//其作用是标志图片是否加载成功

	int id = 0;//定义了一个图象索引

	public static void main(String[] args) {
		new Animation();
	}
  /**
   *    public void init()：由浏览器或applet viewer调用，通知当前applet它已经被加载到系统中，它经常在第一次调用start方法前调用;

                                 Applet的子类可以重写该方法，并在该方法中执行一些初始化操作
   */
	public void init() {
		igs = new Image[8];//对图像数组进行实例化，其长度为8
		mt = new MediaTracker(this);//对媒体跟踪器mt进行实例化
		image = this.createImage(MAX_width, MAX_hight);//创建一个用于双缓冲的、可在屏幕外绘制的图像image
		gh = image.getGraphics();//对图形对象gh进行实例化
		gh.setColor(Color.white);//将gh图形的当前颜色设置成白色
		gh.fillRect(0, 0, MAX_width, MAX_hight);//指定要绘制的矩形的位置和大小
		this.setSize(MAX_width, MAX_hight);//设置Applet的尺寸
		for (int i = 0; i < igs.length; i++) {//此循环的目的是获取每个JPG图片，并将其放入到mt中
			String file_name = (i + 1) + ".jpg";
			igs[i] = this.getImage(getCodeBase(), file_name);
			mt.addImage(igs[i], i);
		}
		try {
			mt.waitForAll();//开始加载由此媒体跟踪器跟踪的所有图像，也就是那些JPG图片
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flag = true;//将标识改成true，即加载完毕
	}

	public void paint(Graphics g) {
		if (flag) {//判断加载否完毕
			g.drawImage(image, 0, 0, this);//画出由上面定义好了的矩形
		}
	}

	/**
	 *   public void start()：由浏览器或applet viewer调用，通知当前applet它应该开始执行，它经常在init()方法调用后以及在Web页中

                                   每次重新访问applet时调用
	 */
	public void start() {
		if (mt.checkID(id)) {//判断处于id位置的图像是否加载完毕
			gh.drawImage(igs[id], 0, 0, this);//画出该图像
		}
		th = new Thread(this);//为线程th实例化
		th.start();//启动线程
	}

	public void run() {
		while ((th != null)) {
			if (mt.checkID(id)) {//判断处于id位置的图像是否加载完毕
				gh.fillRect(0, 0, MAX_width, MAX_hight);//指定要绘制的矩形的位置和大小
				gh.drawImage(igs[id], 0, 0, this);//画出于id位置的图像
				id++;//id加1
				if (id >= igs.length) { //如果图像绘制完毕
					id = 0;//id清零
				}
			}
			try {
				th.sleep(150);//线程休眠0.1秒
			} catch (InterruptedException e) {
			}
			this.repaint();//重新绘制
		}
	}
}
