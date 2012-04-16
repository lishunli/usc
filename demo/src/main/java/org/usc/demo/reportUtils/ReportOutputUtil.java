package org.usc.demo.reportUtils;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author ShunLi
 */
public class ReportOutputUtil {
	private boolean isOutputToTemporaryDirectory = true;
	private String reportOutputBasePath;

	public ReportOutputUtil() {
	}

	public ReportOutputUtil(boolean isOutputToTemporaryDirectory, String reportOutputBasePath) {
		this.isOutputToTemporaryDirectory = isOutputToTemporaryDirectory;
		this.reportOutputBasePath = reportOutputBasePath;
	}

	public FileOutputStream getReportOutputStream(String templatePath, ReportFormat reportFormat) throws Exception {
		String value = System.getProperty("report.output.path");
		if (!StringUtils.isEmpty(value)) {
			this.isOutputToTemporaryDirectory = false;
			this.reportOutputBasePath = value;
		}

		String reportName = FilenameUtils.getBaseName(templatePath);

		FileOutputStream reportOutputStream = null;
		if (isOutputToTemporaryDirectory) {
			File file = File.createTempFile(reportName, reportFormat.suffix());
			file.deleteOnExit();
			System.out.println(file.getAbsolutePath());
			reportOutputStream = new FileOutputStream(file);
		} else {
			System.out.println(reportOutputBasePath + "/" + reportName + reportFormat.suffix());
			reportOutputStream = new FileOutputStream(reportOutputBasePath + "/" + reportName + reportFormat.suffix());
		}

		return reportOutputStream;
	}

	public static void main(String[] args) throws Exception {
		ReportOutputUtil util = new ReportOutputUtil(false, "c:/temp");
		String reportPDFTemplatePath = "com/taifook/mtss/mss/frr/report/template/accountBalanceMovementDetailsReportPDF.jrxml";

		FileOutputStream output = util.getReportOutputStream(reportPDFTemplatePath, ReportFormat.XLS);
		output.flush();

	}
}
