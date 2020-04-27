package No2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.*;

public class ImageHelper {

    // 项目根目录路径
    // 到WPracticalWork目录
    public static final String path = System.getProperty("user.dir");


    /**
     * 生成缩略图
     * 保存:ImageIO.write(BufferedImage, imgType[jpg/png/...], File);
     *
     * @param source
     *            原图片
     * @param width
     *            缩略图宽
     * @param height
     *            缩略图高
     * @param b
     *            是否等比缩放
     * */
    public static BufferedImage thumb(BufferedImage source, int width, int height, boolean b) {
        // 目标长和宽
        int type = source.getType();

        BufferedImage target = null;
        // X 的缩放
        double sx = (double) width / source.getWidth();
        // Y 的缩放
        double sy = (double) height / source.getHeight();

        // 等比缩放
        if (b) {
            if (sx > sy) {
                sx = sy;
                width = (int) (sx * source.getWidth());
            } else {
                sy = sx;
                height = (int) (sy * source.getHeight());
            }
        }

        if (type == BufferedImage.TYPE_CUSTOM) {
            ColorModel cm = source.getColorModel();
            WritableRaster raster = cm.createCompatibleWritableRaster(width,
                    height);
            boolean alphaPremultiplied = cm.isAlphaPremultiplied();
            target = new BufferedImage(cm, raster, alphaPremultiplied, null);
        } else
            target = new BufferedImage(width, height, type);
        Graphics2D g = target.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
        g.dispose();
        return target;
    }

    /**
     * 读取图片
     * @param filename 文件名
     * @return BufferedImage 图片对象
     */
    public static BufferedImage readImage(String filename)
    {
        try {
            File inputFile = new File(filename);
            BufferedImage sourceImage = ImageIO.read(inputFile);
            return sourceImage;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 灰度值计算
     * @param pixels 像素
     * @return int 灰度值
     */
    public static int rgbToGray(int pixels) {
        // int _alpha = (pixels >> 24) & 0xFF;
        int _red = (pixels >> 16) & 0xFF;
        int _green = (pixels >> 8) & 0xFF;
        int _blue = (pixels) & 0xFF;
        return (int) (0.3 * _red + 0.59 * _green + 0.11 * _blue);
    }

    /**
     * 计算数组的平均值
     * @param pixels 数组
     * @return int 平均值
     */
    public static int average(int[] pixels) {
        float m = 0;
        for (int i = 0; i < pixels.length; ++i) {
            m += pixels[i];
        }
        m = m / pixels.length;
        return (int) m;
    }
}