package org.usc.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

@WebServlet(urlPatterns = { "/upload3" })
public class FileUpload3Servlet extends HttpServlet {
    private static final long serialVersionUID = 7916150070189856104L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<String> allowFileTypes = Arrays.asList("png", "jpg", "gif", "jpeg");
            File picParentDir = new File("D:\\1");
            FileUtils.forceMkdir(picParentDir);

            DiskFileItemFactory factory = new DiskFileItemFactory(1 * 1024 * 1024, picParentDir);

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(100 * 1024L);

            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField() || item.getSize() == 0 || !"file".equals(item.getFieldName())) {
                    System.out.println("not need handle");
                    continue;
                }

                String fileExt = FilenameUtils.getExtension(item.getName());
                if (!allowFileTypes.contains(fileExt)) {
                    System.out.println("not allow upload this type file");
                    break;
                }

                String fileName = UUID.randomUUID().toString() + "." + fileExt;
                item.write(new File(picParentDir, fileName));

                System.out.println(item.getName() + " write to " + fileName);
                break;
            }

        } catch (Exception e) {
            if (e instanceof SizeLimitExceededException) {
                System.out.println("file is too big");
            } else {
                e.printStackTrace();
            }
        }

    }
}
