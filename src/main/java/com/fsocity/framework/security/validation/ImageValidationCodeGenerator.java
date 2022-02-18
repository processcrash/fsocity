package com.fsocity.framework.security.validation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author zail
 * @since 2018-09-27
 */
public class ImageValidationCodeGenerator implements ValidationCodeGenerator {
    
    private static final int RGB_NUMBER = 255;
    
    // 验证码长度
    private int length;
    
    // 过期时间
    private int expireIn;
    
    // 宽度
    private int width;
    
    // 高度
    private int height;
    
    // 字体大小
    private int fontSize;
    
    // 干扰线数量
    private int lines;
    
    @Override
    public ImageValidationCode generate() {
        String code = ValidateCodeUtils.randomChars(length);
        BufferedImage image = createBufferedImage(code);
        return new ImageValidationCode(code, expireIn, image);
    }
    
    private BufferedImage createBufferedImage(String code) {
        // 1.创建空白图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        // 2.获取图片画笔
        Graphics graphic = image.getGraphics();
        
        // 3.设置画笔颜色
        graphic.setColor(Color.LIGHT_GRAY);
        
        // 4.绘制矩形背景
        graphic.fillRect(0, 0, width, height);
        
        // 5.画字符
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            // 设置随机颜色
            graphic.setColor(getRandomColor());
            // 设置字体大小
            graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC, fontSize));
            // 画字符
            graphic.drawString(c + "", i * width / code.length(), height * 2 / 3);
        }
        
        // 6.画干扰线
        Random random = new Random();
        for (int i = 0; i < lines; i++) {
            // 设置随机颜色
            graphic.setColor(getRandomColor());
            // 随机画线
            graphic.drawLine(
                    random.nextInt(width),
                    random.nextInt(height),
                    random.nextInt(width),
                    random.nextInt(height));
        }
        return image;
    }
    
    /**
     * 随机取色
     */
    private Color getRandomColor() {
        Random ran = new Random();
        
        return new Color(
                ran.nextInt(RGB_NUMBER + 1),
                ran.nextInt(RGB_NUMBER + 1),
                ran.nextInt(RGB_NUMBER + 1));
    }
    
    public int getLength() {
        return length;
    }
    
    public void setLength(int length) {
        this.length = length;
    }
    
    public int getExpireIn() {
        return expireIn;
    }
    
    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getFontSize() {
        return fontSize;
    }
    
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
    
    public int getLines() {
        return lines;
    }
    
    public void setLines(int lines) {
        this.lines = lines;
    }
    
}
