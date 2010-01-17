package org.benjamin.javadoc2chm;

public final class ProjectDefaultFormat
{

	/*
	 * define file type for building a CHM project
	 */
	public static final String _CONTENT_TYPE = ".hhc";
	public static final String _INDEX_TYPE = ".hhk";
	public static final String _PROJECT_TYPE = ".hhp";
	public static final String _CHM_TYPE = ".chm";

	/*
	 * define .hhp necessary sections
	 */
	public static final String _OPTION_SECTION = "[OPTIONS]";
	public static final String _WINDOWS_SECTION = "[WINDOWS]";
	public static final String _FILES_SECTION = "[FILES]";
	public static final String _INFOTYPES_SECTION = "[INFOTYPES]";

	/*
	 * define some default values for sections
	 */
	public static final String _DEFAULT_LANGUAGE = "0x804 ����(�й�)";
	public static final String _OPTION_YES = "Yes";
	public static final String _OPTION_NO = "No";

	public final static class OptionSection
	{
		public static final String Compatibility = "Compatibility=1.1 or later";
		public static final String Compiled_File = "Compiled file=%s";
		public static final String Contents_File = "Contents file=%s";
		public static final String Default_Window = "Default Window=win";
		public static final String Default_topic = "Default topic=%s";
		public static final String Display_Compile_Progress = "Display compile progress=%s";
		public static final String Full_Text_Search = "Full-text search=%s";
		public static final String Index_File = "Index file=%s";
		public static final String Language = "Language=%s";
		public static final String Title = "Title=%s";
		public static final String CHI = "Create CHI file=%s";
	}

	public final static class WindowsSection
	{
		/*
		 * the '%s' format location stands for following: Title, content-file, index-file, default topic, main topic(default topic)
		 */
		public static final String Windows = "win=\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",,,,,0x63520,260,0x10304E,[289,122,796,490],0x1000000,,,,,,0";
	}

	public final static class InfoTypesSection
	{

	}

	public final static class HTMLFormat
	{
		public static final String _LI_HEAD = "<LI> <OBJECT type=\"text/sitemap\">";
		public static final String _PARAM_NAME = "<param name=\"Name\" value=\"%s\">";
		public static final String _PARAM_LOCAL = "<param name=\"Local\" value=\"%s\">";
		public static final String _PARAM_IMAGE_NUMBER = "<param name=\"ImageNumber\" value=\"%s\">";
		public static final String _LI_TAIL = "</OBJECT> </LI>";

		public static final String _UL_HEAD = "<UL>";
		public static final String _UL_TAIL = "</UL>";
	}

	public final static class FileType
	{

	}
}
