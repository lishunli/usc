package org.usc.file.operater.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.usc.file.operater.rules.ConvertFactory;
import org.usc.file.operater.rules.ConvertRule;
import org.usc.file.operater.rules.Rule;

/**
 * 文件操作工具
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-12-11<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class FileOperaterTool {
	private ConvertRule convertRule;

	public FileOperaterTool() {
	}

	public FileOperaterTool(Rule rule) {
		this.convertRule = ConvertFactory.createConvertRule(rule);
	}

	/**
	 * 删除文件夹
	 * 
	 * @param folderPath
	 *            文件夹完整绝对路径
	 * @return
	 */
	public Boolean delFolder(String folderPath) {
		Boolean result = true;

		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	/**
	 * 删除指定文件夹下所有文件
	 * 
	 * @param path
	 *            文件夹完整绝对路径
	 * @return
	 * @return
	 */
	public boolean delAllFile(String path) {
		boolean bea = false;
		File file = new File(path);
		if (!file.exists()) {
			return bea;
		}
		if (!file.isDirectory()) {
			return bea;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				bea = true;
			}
		}
		return bea;
	}

	/**
	 * 复制整个文件夹的内容
	 * 
	 * @param oldPath
	 *            准备拷贝的目录
	 * @param newPath
	 *            指定绝对路径的新目录
	 * @return
	 */
	public Boolean copyFolder(String oldPath, String newPath) {
		Boolean result = true;
		try {
			new File(newPath).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}
				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath + "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {// 如果是子文件夹
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	/**
	 * 移动目录
	 * 
	 * @param oldPath
	 * @param newPath
	 * @return
	 */
	public Boolean moveFolder(String oldPath, String newPath) {
		if (copyFolder(oldPath, newPath) && delFolder(oldPath)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 修改path路径下所有的文件名
	 * 
	 * @param path
	 */
	public String fileRename(String path) {

		StringBuffer info = new StringBuffer();

		File file = new File(path);

		String[] tempList = file.list();

		if (tempList != null) {
			File temp = null;

			if (tempList.length == 0) {
				info.append("\"" + path + "\"路径下没有文件" + "\n");
			}

			for (int i = 0; i < tempList.length; i++) {
				if (path.endsWith(File.separator)) {
					temp = new File(path + tempList[i]);
				} else {
					temp = new File(path + File.separator + tempList[i]);
				}

				if (temp.isFile()) {
					info.append(fileRename(temp) + "\n");
				}
				if (temp.isDirectory()) {
					String folderName = path + "\\" + tempList[i];

					info.append(fileRename(folderName));
					info.append(folderRename(folderName) + "\n\n");
				}
			}
		} else {
			info.append("\"" + path + "\"路径不存在" + "\n");
		}

		return info.toString();
	}

	/**
	 * 修改path路径下所有的文件名
	 * 
	 * @param path
	 */
	public String fileRename(String path, String fix, String newFix) {

		StringBuffer info = new StringBuffer();

		File file = new File(path);

		String[] tempList = file.list();

		if (tempList != null) {
			File temp = null;

			if (tempList.length == 0) {
				info.append("\"" + path + "\"路径下没有文件" + "\n");
			}

			for (int i = 0; i < tempList.length; i++) {
				if (path.endsWith(File.separator)) {
					temp = new File(path + tempList[i]);
				} else {
					temp = new File(path + File.separator + tempList[i]);
				}

				if (temp.isFile()) {
					info.append(fileRename(temp, fix, newFix) + "\n");
				}
				if (temp.isDirectory()) {
					String folderName = path + "\\" + tempList[i];

					info.append(fileRename(folderName, fix, newFix));
					info.append(folderRename(folderName, fix, newFix, true) + "\n\n");
				}
			}
		} else {
			info.append("\"" + path + "\"路径不存在" + "\n");
		}

		return info.toString();
	}

	/**
	 * 修改文件名
	 * 
	 * @param file
	 *            文件
	 * @return N/A
	 */
	private String fileRename(File file) {

		String info = null;

		String oldName = file.getName();
		String newName = this.convertRule.reNameByRule(oldName);

		if (!oldName.equals(newName)) {
			Boolean result = file.renameTo(new File(file.getParent() + "\\" + newName));

			if (!result) {
				info = "文件\"" + file.getParent() + "\\" + oldName + "\"转换失败，请查看是否存在文件重名";
			} else {
				info = "文件\"" + file.getParent() + "\\" + oldName + "\"转换为\"" + file.getParent() + "\\" + newName + "\"";
				;
			}

		} else {
			info = "文件\"" + file.getParent() + "\\" + oldName + "\"不需要转换";
		}

		return info;

	}

	/**
	 * 修改文件夹名
	 * 
	 * @param file
	 *            文件夹
	 * @return String msg
	 */
	private String folderRename(String folderName) {
		String info = null;

		String oldPath = folderName;
		String newPath = this.convertRule.reNameByRule(oldPath);

		if (!oldPath.equals(newPath)) {

			Boolean result = moveFolder(oldPath, newPath);

			if (!result) {
				info = "文件夹\"" + oldPath + "\"转换失败，请查看是否存在文件夹重名";
			} else {
				info = "文件夹\"" + oldPath + "\"转换为\"" + newPath + "\"";
			}

		} else {
			info = "文件夹\"" + oldPath + "\"不需要转换";
		}

		return info;

	}

	/**
	 * 修改文件名
	 * 
	 * @param file
	 *            文件
	 * @return N/A
	 */
	private String fileRename(File file, String fix, String newFix) {

		String info = null;

		String oldName = file.getName();
		String newName = this.convertRule.reNameByRule(oldName, fix, newFix);

		if (!oldName.equals(newName)) {
			Boolean result = file.renameTo(new File(file.getParent() + "\\" + newName));

			if (!result) {
				info = "文件\"" + file.getParent() + "\\" + oldName + "\"转换失败，请查看是否存在文件重名";
			} else {
				info = "文件\"" + file.getParent() + "\\" + oldName + "\"转换为\"" + file.getParent() + "\\" + newName + "\"";
				;
			}

		} else {
			info = "文件\"" + file.getParent() + "\\" + oldName + "\"不需要转换";
		}

		return info;

	}

	/**
	 * 修改文件夹名
	 * 
	 * @param file
	 *            文件夹
	 * @return String msg
	 */
	private String folderRename(String folderName, String fix, String newFix, Boolean isFolder) {
		String info = null;

		String oldPath = folderName;
		String newPath = this.convertRule.reNameByRule(oldPath, fix, newFix, isFolder);

		if (!oldPath.equals(newPath)) {

			Boolean result = moveFolder(oldPath, newPath);

			if (!result) {
				info = "文件夹\"" + oldPath + "\"转换失败，请查看是否存在文件夹重名";
			} else {
				info = "文件夹\"" + oldPath + "\"转换为\"" + newPath + "\"";
			}

		} else {
			info = "文件夹\"" + oldPath + "\"不需要转换";
		}

		return info;

	}
}