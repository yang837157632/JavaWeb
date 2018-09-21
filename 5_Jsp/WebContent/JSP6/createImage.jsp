<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.Random,java.awt.*,javax.imageio.*,java.awt.image.BufferedImage"%>

<%

	//输入验证码

	final char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z' };

	int width = 100, height = 60;

	BufferedImage bi = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);

	Graphics g = bi.getGraphics();

	g.setColor(new Color(200, 200, 200));

	g.fillRect(0, 0, width, height);

	Random rnd = new Random();

	StringBuffer sb = new StringBuffer("");

	//产生四位数的字母数字验证码，各个数字的颜色也随即
	for (int i = 0; i < 4; i++) {

		int num = rnd.nextInt(str.length);

		Color c = new Color(rnd.nextInt(256), rnd.nextInt(256),
				rnd.nextInt(256));

		g.setColor(c);

		g.setFont(new Font("", Font.BOLD + Font.ITALIC, 20));

		g.drawString(str[num] + "", (i + 1) * 18, (i + 1) * 15);

		sb.append(str[num]);

	}

	//划干扰线
	for (int i = 0; i < 10; i++) {

		Color c = new Color(rnd.nextInt(256), rnd.nextInt(256),
				rnd.nextInt(256));

		g.setColor(c);

		g.drawLine(rnd.nextInt(width), rnd.nextInt(height),
				rnd.nextInt(width), rnd.nextInt(height));

	}

	String s = new String(sb);

	//验证码存入session里，方便在登陆校检页比对
	session.setAttribute("image", s);

	//输出到页面
	ImageIO.write(bi, "JPEG", response.getOutputStream());

	//加入下面这两句,否则报异常: 
	//java.lang.IllegalStateException: getOutputStream() 
	//has already been called for this response 
	out.clear();
	out = pageContext.pushBody();
%>

