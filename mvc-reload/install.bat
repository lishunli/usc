@echo off
cd %~dp0

rem set JAVA_HOME=C:\Program Files\Java\jdk1.6.0_26
rem set PATH=%JAVA_HOME%\bin;%PATH%

call mvn clean install 
rem -o

pause