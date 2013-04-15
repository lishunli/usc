package org.usc.file;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

@WebServlet(urlPatterns = { "/upload" })
@MultipartConfig(location = "D:\\", fileSizeThreshold = 1 * 1024 * 1024, maxFileSize = 300 * 1024)
public class FileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 7916150070189856104L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            Part part = request.getPart("file");

            if (part == null) {
                System.out.println("no file");
                return;
            }

            System.out.println("文件的大小" + part.getSize());

            if (part.getSize() == 0) {
                System.out.println("blank file");
                return;
            }

            System.out.println("文本框内容：" + request.getParameter("name"));
            System.out.println(UploadUtil.getFileName(part));
            System.out.println(UploadUtil.getFileType(part));

            System.out.println("==========");
            System.out.println(part.getContentType());
            System.out.println(part.getName());
            System.out.println(part.getSize());
            // System.out.println(part.getSubmittedFileName());
            System.out.println(part.getHeaderNames());

            System.out.println("==========");
            System.out.println(ToStringBuilder.reflectionToString(part));

            String name = part.getHeader("content-disposition");

            String fileName = StringUtils.substringBetween(name, "filename=\"", "\"");

            System.out.println("==>" + fileName);
            System.out.println(FilenameUtils.getExtension(fileName));

            part.write(UUID.randomUUID().toString() + "." + UploadUtil.getFileType(part));
        } catch (IllegalStateException e) {
            System.out.println("file too big");
        }

    }
}
