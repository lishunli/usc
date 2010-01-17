package org.benjamin.javadoc2chm;

import java.io.File;

public class Parameters
{

	/*
	 * define necessary filetype and directories for generating chm file
	 */
	public static final String _ROOT = "E:\\tmp2\\";
	public static final String _FILE_TYPE = ".html";
	public static final String _NEWLINE = System.getProperty("line.separator");

	/*
	 * define parameters for generating .hhp files
	 */
	public static final String Project = "Eclipse 3.5";
	public static final String Default_topic = "about\\about.html";
	public static final String Display_Compile_Progress = ProjectDefaultFormat._OPTION_YES;
	public static final String Create_CHI = ProjectDefaultFormat._OPTION_NO;
	public static final String Full_Text_Search = ProjectDefaultFormat._OPTION_YES;
	public static final String Language = ProjectDefaultFormat._DEFAULT_LANGUAGE;
	public static final String Title = "Eclipse 3.5 Documentation";

	/*
	 * define file type for filefilter
	 */
	public static final String[] _OTHER_FILETYPE = { _FILE_TYPE };
	public static final String[] _API_FILETYPE = { _FILE_TYPE };
	public static final String[] _ACCEPT_FILETYPE = { ".html", ".htm" };
	public static final String[] _IGNORE_FILETYPE = { ".jpg", ".gif", ".css", ".jpeg", ".bmp", ".java", ".zip", ".rar" };
	public static final String[] _API_CLASS_FILEFILTER = { APIFile._PACKAGE_FRAME, APIFile._PACKAGE_SUMMARY, APIFile._PACKAGE_TREE, APIFile._PACKAGE_USE };
	public static final String[] _API_DIR_FILEFILTER = { APIDirectory._INDEX_DIR, APIDirectory._RESOURCE_DIR };
	public static final String[] _API_ROOT_FILEFILTER = { APIFile._CLASS_FRAME, APIFile._CLASS_NOFRAME, APIDirectory._CLASS_USE, APIFile._CONST_VALUE,
			APIFile._DEPRECATED_LIST, APIFile._HELP_DOC, APIFile._INDEX, APIFile._OVERVIEW_FRAME, APIFile._OVERVIEW_SUMMARY, APIFile._OVERVIEW_TREE,
			APIFile._SERIALIZED_FORM, APIFile._PACKAGE_FRAME, APIFile._PACKAGE_SUMMARY, APIFile._PACKAGE_TREE, APIFile._PACKAGE_USE, APIFile._INDEX_ALL };
	// public static final String[] _PROJECT_FILEFILTER = {Compiled_File + ChmProjectFormat._CHM_TYPE, Project_File + ChmProjectFormat._PROJECT_TYPE,
	// Contents_File + ChmProjectFormat._CONTENT_TYPE, Index_File + ChmProjectFormat._INDEX_TYPE};

	/*
	 * define pattern for index-file and topic-file analysis
	 */
	public static final String _INDEX_PATTERN = "<DT><A HREF=\"([\\p{Graph}|\\p{Blank}]*?)\"(\\p{Space}\\p{Alpha}+?=\".*?\")?+><B>(.*?)</B></A>(.*?)\\p{Space}-";
	public static final String _CONTEXT_PATTERN = "<TD><CODE><B><A HREF=\"((\\p{Graph}*?)#(\\p{Graph}*?))\">(.*?)</A></B>(.*?)</CODE>";
	public static final String _TITLE_PATTERN = "<title>(.*?)</title>";

	public final static class APIDirectory
	{
		public static final String _INDEX_DIR = "index-files";
		public static final String _RESOURCE_DIR = "resources";
		public static final String _CLASS_USE = "class-use";
	}

	public final static class APIFile
	{
		public static final String _CLASS_FRAME = "allclasses-frame" + _FILE_TYPE;
		public static final String _CLASS_NOFRAME = "allclasses-noframe" + _FILE_TYPE;
		public static final String _CONST_VALUE = "constant-values" + _FILE_TYPE;
		public static final String _DEPRECATED_LIST = "deprecated-list" + _FILE_TYPE;
		public static final String _HELP_DOC = "help-doc" + _FILE_TYPE;
		public static final String _INDEX = "index" + _FILE_TYPE;
		public static final String _OVERVIEW_FRAME = "overview-frame" + _FILE_TYPE;
		public static final String _OVERVIEW_SUMMARY = "overview-summary" + _FILE_TYPE;
		public static final String _OVERVIEW_TREE = "overview-tree" + _FILE_TYPE;
		public static final String _SERIALIZED_FORM = "serialized-form" + _FILE_TYPE;
		public static final String _PACKAGE_SUMMARY = "package-summary" + _FILE_TYPE;
		public static final String _PACKAGE_FRAME = "package-frame" + _FILE_TYPE;
		public static final String _PACKAGE_TREE = "package-tree" + _FILE_TYPE;
		public static final String _PACKAGE_USE = "package-use" + _FILE_TYPE;
		public static final String _INDEX_ALL = "index-all" + _FILE_TYPE;

		public static final String[] _defaultName = { "Index", "Overview", "All Classes", "API Help", "Constant Field Values", "Deprecated List",
				"Class Hierarchy", "Serialized Form" };
		public static final String[] _defaultList = { _INDEX, _OVERVIEW_SUMMARY, _CLASS_NOFRAME, _HELP_DOC, _CONST_VALUE, _DEPRECATED_LIST, _OVERVIEW_TREE,
				_SERIALIZED_FORM };
	}

	public final static class SysFile
	{
		public static final String _FORBIDDEN_FILE = "option\\excluded.txt";
		public static final String _APIDIR_FILE = "option\\apidir.txt";
	}

	public final static File[] _TOC_EXCLUDE_SYS_FILES = { new File(_ROOT, Project + ProjectDefaultFormat._CHM_TYPE),
			new File(_ROOT, Project + ProjectDefaultFormat._INDEX_TYPE), new File(_ROOT, Project + ProjectDefaultFormat._CONTENT_TYPE),
			new File(_ROOT, Project + ProjectDefaultFormat._PROJECT_TYPE) };
}
