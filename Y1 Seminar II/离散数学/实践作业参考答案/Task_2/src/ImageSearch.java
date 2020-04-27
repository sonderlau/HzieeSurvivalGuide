package No2;


import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class ImageSearch  {

    public static void main(String[] args) {
        ArrayList<String> hashCodes = new ArrayList<String>();

        String fileName = ImageHelper.path + "\\images\\";


        for (int i = 0 ; i< 3 ; i++){
            String hashCode = produceFingerPrint(fileName + "demo" + (i + 1) +  ".jpg");
            hashCodes.add(hashCode);
        }

        System.out.println("目标文件们的哈希值: " + hashCodes);

        System.out.println("源文件: "+ produceFingerPrint(fileName + "source.jpg"));

        for (int i = 0 ; i < hashCodes.size() ; i ++ ){
            int difference = HammingDistance(produceFingerPrint(fileName+ "source.jpg"),hashCodes.get(i));
            System.out.println("Hamming Distance :  " + difference);
            CompareHammingDistance(difference,i);

        }
    }

    private static String produceFingerPrint (String fileName) {
        BufferedImage source = ImageHelper.readImage(fileName);

        int width = 8;
        int height = 8;

        // 1 : 缩小尺寸
        BufferedImage thumb = ImageHelper.thumb(source,width,height,false);

        // 2: 简化色彩 - 64级灰度
        int[] pixels = new int[width*height];

        for (int i = 0 ; i < width ; i++){
            for (int j = 0 ; j < height ; j ++) {
                pixels[i*height + j] = ImageHelper.rgbToGray(thumb.getRGB(i, j));
            }
        }


        // 3 : 计算灰度平均值
        int avgPixelValue = ImageHelper.average(pixels);

        // 4 : 与平均值比较

        int[]  comparativeResult = new int[width*height];

        for (int i = 0 ; i < comparativeResult.length ; i ++ ){
            if (pixels[i] >= avgPixelValue) {
                comparativeResult[i] = 1;
            }else {
                comparativeResult[i] = 0;
            }
        }

        // 5 : 计算哈希值
        StringBuffer hashCode = new StringBuffer();

        for (int i = 0 ; i < comparativeResult.length ; i += 4 ) {
            int result = comparativeResult[i] * (int) Math.pow(2, 3) + comparativeResult[i+1]*(int)Math.pow(2, 2) + comparativeResult[i + 2]*(int) Math.pow(2, 1) + comparativeResult[i+3];
            hashCode.append(binaryToHex(result));
        }

        return hashCode.toString();

    }

    private static int HammingDistance (String sourceHashCode, String hashCode) {
        int difference = 0;

        for (int i = 0; i < sourceHashCode.length(); i++) {
            if (sourceHashCode.charAt(i) != hashCode.charAt(i)) {
                difference++;
            }

        }
        return difference;
    }

    private static void CompareHammingDistance(int difference, int i){
        if (difference == 0){
            System.out.println("Source.jpg与demo"+ (i+1) + ".jpg 一样" );
        } else if (difference <= 5) {
            System.out.println("Source.jpg与demo"+ (i+1) + ".jpg 很相似" );
        } else if (difference <= 10 ) {
            System.out.println("Source.jpg与demo"+ (i+1) + ".jpg 有点像" );
        } else {
            System.out.println("Source.jpg与demo"+ (i+1) + ".jpg 几乎不一样" );
        }
    }



    // 二进制到16进制
    private static char binaryToHex(int binary) {
        char ch = ' ';
        switch (binary)
        {
            case 0:
                ch = '0';
                break;
            case 1:
                ch = '1';
                break;
            case 2:
                ch = '2';
                break;
            case 3:
                ch = '3';
                break;
            case 4:
                ch = '4';
                break;
            case 5:
                ch = '5';
                break;
            case 6:
                ch = '6';
                break;
            case 7:
                ch = '7';
                break;
            case 8:
                ch = '8';
                break;
            case 9:
                ch = '9';
                break;
            case 10:
                ch = 'a';
                break;
            case 11:
                ch = 'b';
                break;
            case 12:
                ch = 'c';
                break;
            case 13:
                ch = 'd';
                break;
            case 14:
                ch = 'e';
                break;
            case 15:
                ch = 'f';
                break;
            default:
                ch = ' ';
        }
        return ch;
    }


}

