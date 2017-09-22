package demo;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class AppMain {
	public static void main(String[] args) {
		//初始化
//		System.out.println("初始化数据：");
//		String[] imgsArr = new String[30];
//		for(int i = 0; i< 30; i++) {
//			int temp = (int)(Math.random() * 100);
//			imgsArr[i] = String.valueOf(temp) + ".jpg";
//			
//			System.out.println(imgsArr[i]);
//		}

		//从选择的图片路径下读数据
		//图片路径
		System.out.println("从文件路径下获取图片数据：");
		String imgPath = "D:/mcworld/map_resource/images/resources/";
		LinkedList<String> imgsList = new LinkedList<String>();
		
		File root = new File(imgPath);
		File[] files = root.listFiles();
		for(File file : files) {
			if(file.isDirectory())
				continue;//如果是目录，暂时不遍历子目录下的图片文件
			
			if(file.isFile()) {
				//是文件，
				//先获取文件的文件名
				String fileName = file.getName();
				//则判断扩展文件是不是.jpg或者.png
				//暂时先识别这两种格式文件
				if (fileName.toLowerCase().endsWith(".jpg")||fileName.toLowerCase().endsWith(".png")) {
					//toLowerCase方法是统一把字符串转换成小写
					//endsWith表示文件名是不是以.jpg或者.png结尾
					imgsList.add(fileName);//加入到图片文件名列表
				}
			}
		}
		
		//显示获取到数据
		for(String fileName : imgsList) {
			System.out.println(fileName);
		}
		
		//输入图片文件名，进行查找
		System.out.println("请输入数据：");
		Scanner reader = new Scanner(System.in);
		String imageName = reader.nextLine();
		reader.close();
		System.out.println("正在搜索...");
		
//		for(int i = 0; i< 30 ; i++) {
//			//找到了，进行输出
//			if(imgsArr[i].equals(imageName)) {
//				System.out.println("搜索结果：");
//				System.out.println(i + ":" + imgsArr[i]);
//			}
//		}
		
		//从文件列表中进行搜索
		for(String fileName : imgsList) {
			if(fileName.equals(imageName)) {
				System.out.println("搜索结果：");
				System.out.println(fileName);
			}
		}
		System.out.println("搜索结束！");
	}
	
 }
