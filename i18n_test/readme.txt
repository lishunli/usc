1、了解缺省Locale是由操作系统决定的，Locale是由语言和国家代码组成

2、国际化资源文件是由baseName+locale组成，如：MessageBundle_en_US.properties
baseName是任意合法的文件名

3、native2ascii命令的位置和用法
	* 位置：JAVA_HOME/bin
	* 使用native2ascii.exe  o.properties MessagesBundle_zh_CN.properties
	