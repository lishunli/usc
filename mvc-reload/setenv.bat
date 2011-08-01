@rem allow them to be specified in setenv.bat, in rare case when it is needed.(from tomcat catalina.bat conf infos)
set JAVA_HOME=C:\Program Files\Java\jdk1.6.0_26

@rem Clear the pre_classpath here in case an application template wants to set it before the larger pre_classpath is invoked below
set PRE_CLASSPATH=%CATALINA_HOME%\extconf
set CLASSPATH=%PRE_CLASSPATH%%CLASSPATH%