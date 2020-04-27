package No2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class RGBChange {


    private static File imageFile = new File("E:\\Univeristy\\Discrete离散数学\\PractivalWork\\src\\Resources\\img.jpg");
    public static void main(String[] args) throws Exception{


        PixelDIYChangeFunction(0.1);
        PixelDIYChangeFunction(0.4);
        PixelDIYChangeFunction(0.6);
        PixelDIYChangeFunction(0.8);
        PixelDIYChangeFunction(1.0);
        PixelDIYChangeFunction(1.2);
        PixelDIYChangeFunction(1.5);
        PixelDIYChangeFunction(1.8);
        PixelDIYChangeFunction(2.0);
        PixelDIYChangeFunction(2.5);
        PixelDIYChangeFunction(5.0);

        PixelDIYChangeFunction(10.0);

    }

    private static void PixelDIYChangeFunction(double R) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(new FileInputStream(imageFile));
        int[] rgbPixels = new int[bufferedImage.getWidth()*bufferedImage.getHeight()];
        // 开始X Y坐标  宽度 高度 像素数组  数组起始坐标 扫面的大小
        bufferedImage.getRGB(0,0,bufferedImage.getWidth(),bufferedImage.getHeight(),rgbPixels,0,bufferedImage.getWidth());

        // 设置每个像素的变换
        for (int i = 0 ; i < rgbPixels.length ; i ++) {
            Color color = new Color(rgbPixels[i]);
            int red = color.getRed();
            int blue = color.getBlue();
            int green = color.getGreen();

            rgbPixels[i] = new Color(pixelChange(red,R),pixelChange(green,R),pixelChange(blue,R)).getRGB();

        }

        bufferedImage.setRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), rgbPixels, 0, bufferedImage.getWidth());
        ImageIO.write(bufferedImage,"jpg",new File("E:\\Univeristy\\Discrete离散数学\\PractivalWork\\src\\Resources\\Processed" + String.valueOf(R) + ".jpg"));
    }




    private static int pixelChange(int value, double R) {
        return Math.min((int) Math.pow(value, R), 255);
    }
}
