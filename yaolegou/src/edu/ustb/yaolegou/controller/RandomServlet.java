package edu.ustb.yaolegou.controller;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "RandomServlet", value = "/RandomServlet")
public class RandomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        int width = 160, height = 60;

        // 建立指定宽、高和BufferedImage对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics(); // 该画笔画在image上
        Color c = g.getColor(); // 保存当前画笔的颜色，用完画笔后要回复现场
        g.fillRect(0, 0, width, height);

        char[] ch = "abcdefghjkmnpqrstuvwxyz".toCharArray(); // 随即产生的字符串
        int length = ch.length; // 随即字符串的长度
        String sRand = ""; // 保存随即产生的字符串
        Random random = new Random();
        for (int i = 0; i <= 4; i++) {
            // 设置字体
            g.setFont(getRandomFont());
            // 随即生成0-9的数字
            String rand = new Character(ch[random.nextInt(length)]).toString();
            sRand += rand;
            // 设置随机颜色
            g.setColor(new Color(255, 0, 0));
            g.drawString(rand, 25 * i + 15, 40);
        }
        // 产生随即干扰点
        for (int i = 0; i < 20; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            g.drawOval(x1, y1, 2, 2);
        }
        g.setColor(c); // 将画笔的颜色再设置回去
        g.dispose();

        // 将验证码记录到session
        request.getSession().setAttribute("random-captcha", sRand);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    // 产生随即的字体
    private Font getRandomFont() {
        Random random = new Random();
        Font font[] = new Font[5];
        font[0] = new Font("Consolas", Font.PLAIN, 42);
        return font[random.nextInt(1)];
    }
}
