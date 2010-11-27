/*
 * FileOperater.java
 *
 * Created on __DATE__, __TIME__
 */

package org.usc.file.operater;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;

/**
 * 
 * @author __USER__
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
	//GEN-BEGIN:initComponents
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

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u6587\u4ef6\u540d\u5927\u5c0f\u5199\u6279\u91cf\u8f6c\u6362-\u987a\u5229(QQ:506817493)");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setResizable(false);

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel1.setText("\u6587\u4ef6\u540d\u5927\u5c0f\u5199\u6279\u91cf\u8f6c\u6362");

		jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel2.setText("\u987a\u5229\u5236\u4f5cV0.1");

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
		setLocation((int) (width - this.getWidth()) / 6, (int) (height - this.getHeight()) / 8);

		jTextArea1.setColumns(20);
		jTextArea1.setEditable(false);
		jTextArea1.setFont(new java.awt.Font("微软雅黑", 0, 16));
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jLabel6.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel6.setText("\uff08\u4e3a\u4e86\u66f4\u597d\u5730\u6392\u5e8f\u548c\u663e\u793a\uff09");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(
								javax.swing.GroupLayout.Alignment.LEADING,
								layout.createSequentialGroup().addGap(61, 61, 61).addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
												layout.createSequentialGroup().addComponent(jLabel4).addGap(18, 18, 18).addComponent(jRadioButton1).addGap(18,
														18, 18).addComponent(jRadioButton2)).addGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup().addGroup(
														layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																layout.createSequentialGroup().addComponent(jLabel5).addGap(18, 18, 18).addComponent(
																		jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)).addGroup(
																layout.createSequentialGroup().addComponent(jLabel3).addGap(18, 18, 18).addComponent(
																		jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))).addGap(18,
														18, 18).addComponent(jButton1).addGap(18, 18, 18)))).addGroup(
								layout.createSequentialGroup().addContainerGap().addComponent(jLabel6).addGap(226, 226, 226).addComponent(jLabel2))).addGap(48,
						48, 48)).addGroup(layout.createSequentialGroup().addGap(346, 346, 346).addComponent(jLabel1).addContainerGap(375, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(28, 28, 28).addComponent(jLabel1).addGap(18, 18, 18).addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(jLabel6)).addGap(42, 42, 42)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(jTextField1,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jButton1)).addGap(18, 18, 18).addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4).addComponent(jRadioButton1)
										.addComponent(jRadioButton2)).addGap(18, 18, 18).addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel5).addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(35,
								Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

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
			jTextArea1.setText(jTextArea1.getText() +"------------------------------------------------\n");
			jTextArea1.setText(jTextArea1.getText() +"开始时间：" + dateFormat.format(new java.util.Date()) + "\n");
			
			if (jRadioButton1.isSelected()) {
				rule = Rule.BigToSmall;
			}
			else if (jRadioButton2.isSelected()) {
				rule = Rule.SmallToBig;
			}

			String info = new FileOperaterTool(rule).fileRename(path);

			
			long end = System.currentTimeMillis();
			
			jTextArea1.setText(jTextArea1.getText() +"结束时间：" + dateFormat.format(new java.util.Date())  + "\n");
			jTextArea1.setText(jTextArea1.getText() +"总用时：" + (end - start)  + " ms\n");
			jTextArea1.setText(jTextArea1.getText() +"------------------------------------------------\n");
			
			jTextArea1.setText(jTextArea1.getText() + info);
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

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables

}