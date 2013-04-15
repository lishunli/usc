package org.usc.file;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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

@WebServlet(urlPatterns = { "/upload2" })
@MultipartConfig(location = "D:\\1", fileSizeThreshold = 1 * 1024 * 1024)
public class FileUpload2Servlet extends HttpServlet {
    private static final long serialVersionUID = 7916150070189856104L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            Part part = request.getPart("file");

            if (part == null || part.getSize() == 0) {
                System.out.println("empty file");
                return;
            }

            if (part.getSize() > 300 * 1024L) {
                System.out.println("file is too big");
                return;
            }

            String fileName = extractFileName(part);
            String fileExt = FilenameUtils.getExtension(fileName);

            List<String> allowFileTypes = Arrays.asList("png", "jpg", "gif", "jpeg");

            if (!allowFileTypes.contains(fileExt)) {
                System.out.println("not allow upload this type file");
                return;
            }

            String destFileName = UUID.randomUUID().toString() + "." + fileExt;
            part.write(destFileName);
            System.out.println(fileName + " write to file " + destFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String extractFileName(Part part) {
        String name = part.getHeader("content-disposition");
        String fileName = StringUtils.substringBetween(name, "filename=\"", "\"");

        return fileName;
    }
}
