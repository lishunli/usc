/*
 * FileOperater.java
 *
 * Created on __DATE__, __TIME__
 */

package org.usc.file.operater;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;

import javax.swing.JFileChooser;

import org.usc.file.operater.rules.Rule;
import org.usc.file.operater.utils.FileOperaterTool;

/**
 * 
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-11-27<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class FileOperater extends javax.swing.JFrame {

	private static final long serialVersionUID = 7088862061652290688L;

	/** Creates new form FileOperater */
	public FileOperater() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton2 = new javax.swing.JRadioButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jLabel6 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jCheckBox1 = new javax.swing.JCheckBox();
		jCheckBox2 = new javax.swing.JCheckBox();
		jCheckBox3 = new javax.swing.JCheckBox();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u6587\u4ef6\u540d\u5927\u5c0f\u5199\u6279\u91cf\u8f6c\u6362-\u987a\u5229(QQ:506817493)");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setIconImage(Toolkit.getDefaultToolkit().createImage("default.gif"));
		setResizable(false);

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel1.setText("\u6587\u4ef6\u540d\u6279\u91cf\u8f6c\u6362");

		jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel2.setText("\u987a\u5229\u00a9V0.3");

		jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 20));
		jLabel3.setText("\u8def\u5f84\u540d\u79f0");

		jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 20));
		jLabel4.setText("\u8f6c\u6362\u89c4\u5219");

		jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 20));
		jLabel5.setText("\u8f6c\u6362\u7ed3\u679c");

		jTextField1.setFont(new java.awt.Font("微软雅黑", 0, 16));

		jButton1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton1.setText("\u8f6c\u6362");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton1MouseClicked(evt);
			}
		});

		jFileChooser = new JFileChooser();
		jFileChooser.setDialogTitle("浏览");
		jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		jRadioButton1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jRadioButton1.setSelected(true);
		jRadioButton1.setText("\u5927\u5199\u8f6c\u5c0f\u5199");
		jRadioButton1
				.setToolTipText("\u5927\u5199\u8f6c\u5c0f\u5199\u5b9e\u4f8b:\u4e00 -> 1;\u5341 -> 10;\u5341\u4e8c -> 12;\u4e09\u5341 -> 30;\u4e00\u767e\u56db\u5341\u4e8c -> 42;\u4e00\u767e\u96f6\u4e8c\u70b9\u4e8c\u4e94 -> 102.25");

		jRadioButton2.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jRadioButton2.setText("\u5c0f\u5199\u8f6c\u5927\u5199");
		jRadioButton2
				.setToolTipText("\u8f6c\u6362\u89c4\u5219:1 -> \u4e00;10 -> \u5341;12 -> \u5341\u4e8c;30 -> \u4e09\u5341;142 -> \u4e00\u767e\u56db\u5341\u4e8c;102.25 -> \u4e00\u767e\u96f6\u4e8c\u70b9\u4e8c\u4e94");

		buttonGroup1.add(jRadioButton1);
		buttonGroup1.add(jRadioButton2);

		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setLocation((int) (width - this.getWidth()) / 9, (int) (height - this.getHeight()) / 10);

		jTextArea1.setColumns(20);
		jTextArea1.setEditable(false);
		jTextArea1.setFont(new java.awt.Font("微软雅黑", 0, 16));
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jLabel6.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel6.setText("\uff08\u4e3a\u4e86\u66f4\u597d\u5730\u6392\u5e8f\u548c\u663e\u793a\uff09");

		jButton2.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton2.setText("\u6e05\u7a7a");
		jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton2MouseClicked(evt);
			}
		});

		jButton3.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton3.setText("\u6d4f\u89c8");
		jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton3MouseClicked(evt);
			}
		});

		jCheckBox1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jCheckBox1.setSelected(true);

		jCheckBox2.setFont(new java.awt.Font("微软雅黑", 0, 18));

		jCheckBox3.setFont(new java.awt.Font("微软雅黑", 0, 18));

		jLabel7.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel7.setText("\u524d\u7f00");

		jLabel8.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel8.setText("\u540e\u7f00");

		jLabel9.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel9.setText("\u8f6c\u6362\u4e3a");

		jLabel10.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel10.setText("\u8f6c\u6362\u4e3a");

		jTextField2.setFont(new java.awt.Font("微软雅黑", 0, 16));

		jTextField3.setFont(new java.awt.Font("微软雅黑", 0, 16));

		jTextField4.setFont(new java.awt.Font("微软雅黑", 0, 16));
		jTextField5.setFont(new java.awt.Font("微软雅黑", 0, 16));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(31, 31, 31)
										.addGroup(
												layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel3)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																jCheckBox2,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																21,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jCheckBox3,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																21,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addGroup(
																																layout
																																		.createParallelGroup(
																																				javax.swing.GroupLayout.Alignment.LEADING)
																																		.addComponent(jLabel5)
																																		.addGroup(
																																				layout
																																						.createSequentialGroup()
																																						.addComponent(
																																								jLabel4)
																																						.addPreferredGap(
																																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																						.addComponent(
																																								jCheckBox1,
																																								javax.swing.GroupLayout.PREFERRED_SIZE,
																																								21,
																																								javax.swing.GroupLayout.PREFERRED_SIZE))))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addGroup(
																																layout
																																		.createSequentialGroup()
																																		.addGroup(
																																				layout
																																						.createParallelGroup(
																																								javax.swing.GroupLayout.Alignment.LEADING)
																																						.addComponent(
																																								jTextField1,
																																								javax.swing.GroupLayout.DEFAULT_SIZE,
																																								731,
																																								Short.MAX_VALUE)
																																						.addGroup(
																																								javax.swing.GroupLayout.Alignment.TRAILING,
																																								layout
																																										.createSequentialGroup()
																																										.addGroup(
																																												layout
																																														.createParallelGroup(
																																																javax.swing.GroupLayout.Alignment.LEADING,
																																																false)
																																														.addGroup(
																																																layout
																																																		.createSequentialGroup()
																																																		.addComponent(
																																																				jLabel7)
																																																		.addPreferredGap(
																																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																																		.addComponent(
																																																				jTextField2,
																																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																																				313,
																																																				javax.swing.GroupLayout.PREFERRED_SIZE))
																																														.addGroup(
																																																layout
																																																		.createSequentialGroup()
																																																		.addComponent(
																																																				jLabel8)
																																																		.addPreferredGap(
																																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																																				Short.MAX_VALUE)
																																																		.addComponent(
																																																				jTextField4,
																																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																																				313,
																																																				javax.swing.GroupLayout.PREFERRED_SIZE)))
																																										.addGap(
																																												5,
																																												5,
																																												5)
																																										.addGroup(
																																												layout
																																														.createParallelGroup(
																																																javax.swing.GroupLayout.Alignment.LEADING)
																																														.addGroup(
																																																layout
																																																		.createSequentialGroup()
																																																		.addComponent(
																																																				jLabel10)
																																																		.addPreferredGap(
																																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																																		.addComponent(
																																																				jTextField5,
																																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																																				313,
																																																				javax.swing.GroupLayout.PREFERRED_SIZE))
																																														.addGroup(
																																																layout
																																																		.createSequentialGroup()
																																																		.addComponent(
																																																				jLabel9)
																																																		.addPreferredGap(
																																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																																		.addComponent(
																																																				jTextField3,
																																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																																				313,
																																																				javax.swing.GroupLayout.PREFERRED_SIZE))))
																																						.addComponent(
																																								jScrollPane1,
																																								javax.swing.GroupLayout.Alignment.TRAILING,
																																								javax.swing.GroupLayout.DEFAULT_SIZE,
																																								731,
																																								Short.MAX_VALUE))
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED))
																														.addGroup(
																																layout
																																		.createSequentialGroup()
																																		.addComponent(
																																				jRadioButton1)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				jRadioButton2)
																																		.addGap(508, 508, 508))))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								layout.createSequentialGroup().addComponent(jLabel6).addGap(
																										276, 276, 276))).addGroup(
																				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(jButton2).addComponent(jButton3).addComponent(jLabel2)
																						.addComponent(jButton1)))).addGap(29, 29, 29)).addGroup(
								layout.createSequentialGroup().addGap(407, 407, 407).addComponent(jLabel1).addContainerGap(419, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(17, 17, 17).addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(jLabel6)).addGap(
								42, 42, 42).addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(jTextField1,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jButton3)).addGap(15, 15, 15).addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jCheckBox1).addComponent(jLabel4))
										.addGroup(
												layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jRadioButton1)
														.addComponent(jRadioButton2).addComponent(jButton1))).addGap(14, 14, 14).addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
										layout.createSequentialGroup().addGroup(
												layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7).addComponent(
														jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel9).addComponent(jTextField3,
														javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(
												layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
														layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel10)
																.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(jLabel8))).addGroup(
										layout.createSequentialGroup().addComponent(jCheckBox2).addGap(25, 25, 25).addComponent(jCheckBox3)))
						.addGap(17, 17, 17).addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel5).addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jButton2))
						.addContainerGap(38, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	// GEN-END:initComponents

	private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
		jFileChooser.setVisible(true);
		int open = jFileChooser.showOpenDialog(this);

		if (open == JFileChooser.APPROVE_OPTION) {
			String path = jFileChooser.getSelectedFile().getAbsolutePath();

			jTextField1.setText(path);
		}

	}

	private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
		jTextArea1.setText("");
	}

	private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
		Rule rule = null;
		jTextArea1.setText("");

		String path = jTextField1.getText().trim();

		if (path == null || path.length() == 0) {
			jTextArea1.setText("请输入路径");
		}
		else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");

			long start = System.currentTimeMillis();
			jTextArea1.setText(jTextArea1.getText() + "------------------------------------------------\n");
			jTextArea1.setText(jTextArea1.getText() + "开始时间：" + dateFormat.format(new java.util.Date()) + "\n");

			StringBuffer info = new StringBuffer();

			if (jCheckBox1.isSelected()) {
				if (jRadioButton1.isSelected()) {
					rule = Rule.BigToSmall;
				}
				else if (jRadioButton2.isSelected()) {
					rule = Rule.SmallToBig;
				}
				
				info.append(new FileOperaterTool(rule).fileRename(path));

			}
			if (jCheckBox2.isSelected()) {
				rule = Rule.Prefix;
				
				info.append(new FileOperaterTool(rule).fileRename(path,jTextField2.getText(),jTextField3.getText()));
			}
			if (jCheckBox3.isSelected()) {
				rule = Rule.Suffix;
				
				info.append(new FileOperaterTool(rule).fileRename(path,jTextField4.getText(),jTextField5.getText()));
			}
			else {
				jTextArea1.setText(jTextArea1.getText() + "请选择转换规则\n");
			}

			long end = System.currentTimeMillis();

			jTextArea1.setText(jTextArea1.getText() + "结束时间：" + dateFormat.format(new java.util.Date()) + "\n");
			jTextArea1.setText(jTextArea1.getText() + "总用时：" + (end - start) + " ms\n");
			jTextArea1.setText(jTextArea1.getText() + "------------------------------------------------\n");

			jTextArea1.setText(jTextArea1.getText() + info.toString());
		}

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FileOperater().setVisible(true);
			}
		});
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JCheckBox jCheckBox2;
	private javax.swing.JCheckBox jCheckBox3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private JFileChooser jFileChooser;
	// End of variables declaration//GEN-END:variables

}