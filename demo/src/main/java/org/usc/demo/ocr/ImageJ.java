package org.usc.demo.ocr;

import ij.IJ;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageJ {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        String savepath = "D:\\Tesseract-OCR\\1354356381887_2.jpg";

        // 打开图片
        IJ.open("D:\\Tesseract-OCR\\1354356381887.jpg");

        // 设置大小
        // IJ.run("Size...", "width=30 height=30 constrain interpolate");

        // 去噪
        IJ.run("Remove Outliers...", "radius=2 threshold=50 which=Dark");
        IJ.run("Despeckle");

        // 二值
        IJ.run("Make Binary");

        // 另存图片
        IJ.save(savepath);

        // // 读取另存图片
        // BufferedImage img = ImageIO.read(new FileInputStream(savepath));
        //
        // // 切割
        // BufferedImage[] bimg = cutter(img);
        //
        // for (int i = 0; i < bimg.length; i++)
        // {
        // if (bimg[i] != null)
        // ImageIO.write(bimg[i], "BMP", new File("D:\\myworkspace\\Ftp\\checkCode\\" + (i + 1) + ".bmp"));
        // }
    }

    /**
     * 切割图片(对于数据不重叠有效)
     *
     * @param img
     * @return
     * @throws IOException
     */
    public static BufferedImage[] cutter(BufferedImage image) throws IOException
    {
        BufferedImage checkCode[] = null;
        int height = image.getHeight();
        int width = image.getWidth();

        List<List<Integer>> all = new ArrayList<List<Integer>>();
        List<Integer> tmp = null;

        // 纵向扫描
        for (int w = 0; w < width - 0; w++)
        {
            int h = 0;
            for (; h < height - 0; h++)
            {
                int px = image.getRGB(w, h);

                // System.out.print(px == -1 ? "-" : "0");
                // 如果遇到非白 色，则记录该y值的值
                if (px != -1)
                {
                    if (tmp == null)
                    {
                        tmp = new ArrayList<Integer>();
                    }

                    tmp.add(w);
                    break;
                }
            }
            // 如果tmp有记录值，并且上一次扫描中纵向没有任何颜色,那么将记录加入all并截段重计
            // 或者最后一个数据超过边框
            if ((tmp != null && (h == height)) || (w == (width - 1)))
            {
                all.add(tmp);
                tmp = null;
            }
            // System.out.println();
        }

        checkCode = new BufferedImage[all.size()];

        for (int i = 0; i < all.size(); i++)
        {
            List<Integer> list = all.get(i);

            if (list == null)
                continue;

            // 开始y轴
            int yStart = list.get(0);
            // 结束y轴
            int yEnd = list.get(list.size() - 1);

            System.out.println(yStart + "," + yEnd);

            // 截取开始与结束的记录
            BufferedImage bimg = image.getSubimage(yStart, 0, yEnd - yStart, height);

            checkCode[i] = bimg;
        }

        return checkCode;
    }
}
