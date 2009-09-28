package cn.itcast.strutsdemo.user.web.struts.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;

import cn.itcast.strutsdemo.user.web.struts.forms.UserForm;
import cn.itcast.strutsdemo.user.web.struts.utils.ConfigManager;
import cn.itcast.strutsdemo.user.web.struts.utils.ConfigManager2;
import cn.itcast.strutsdemo.user.web.struts.utils.ConfigManager3;
import cn.itcast.strutsdemo.user.web.struts.utils.Constants;

public class RegUser extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub

		//return new ActionForward("/WEB-INF/user/reguser.jsp");
/*		PrintWriter out = response.getWriter();
		UserForm userForm = (UserForm)form;
		out.print(
				userForm.getUser().getUsername() + ":::" + 
				userForm.getUser().getPassword() + ":::" + 
				userForm.getPassword2() */				
			/*request.getParameter("username") + ":" +
			request.getParameter("password") + ":" +		
			request.getParameter("password2")*/
			
		//);
		//return null;
		
		UserForm userForm = (UserForm)form;

		FormFile photo = userForm.getUser().getPhoto();
		response.setContentType("text/html;charset=UTF-8");
		

		ActionMessages errors = new ActionMessages();		

		saveFormFile(photo);
		
		if(userForm.getUser().getUsername().trim().equals("zxx"))
		{
			errors.add("username", new ActionMessage("error.repeated",
					getResources(request).getMessage(getLocale(request), "prompt.username")));
			/*request.setAttribute(Globals.ERROR_KEY, errors);
			return mapping.findForward("failure");*/
			/*saveErrors(request, errors);
			return mapping.getInputForward();*/			
		}
		if(!isTokenValid(request))
		{
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("表单重复提起",false));
		}
		if(!errors.isEmpty())
		{
			saveErrors(request, errors);
			return mapping.getInputForward();
		}
		
		resetToken(request);
		return mapping.findForward("success");	
	}

	
	private void saveFormFile(FormFile photo) throws FileNotFoundException,
			IOException {
		String fileName = photo.getFileName(); 
		if(!(photo.getFileSize()==0 || fileName.trim().equals("")))
		{
			InputStream contentStream = photo.getInputStream();
			File filePhote = getStoreFile(fileName);
			FileOutputStream fos = new FileOutputStream(filePhote);
			int len = 0;
			byte[] buf = new byte[1024];
			while((len=contentStream.read(buf))!=-1)
			{
				fos.write(buf, 0, len);
			}
			contentStream.close();
			fos.close();
		}
	}


	private File getStoreFile(String fileName) {
		
		ConfigManager2 configManager2 = (ConfigManager2)getServlet().getServletContext()
			.getAttribute(Constants.CONFIGMANAGERKEY);
		String saveDir = configManager2.getSaveDir();	
			
		//String saveDir = ConfigManager.getSaveDir(this.getServlet().getServletContext().getRealPath("/WEB-INF/itcast.properties"));
		//String saveDir = ConfigManager3.getSaveDir();
		UUID uuid =UUID.randomUUID();
		String prefixName = uuid.toString();
		String extName =fileName.substring(fileName.lastIndexOf('.'));
		String newFileName = prefixName + extName;
		File filePhote = new File(saveDir,newFileName);
		return filePhote;
	}
	
}
