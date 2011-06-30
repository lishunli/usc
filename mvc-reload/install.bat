@echo off
cd %~dp0

set JAVA_HOME=C:\Program Files\Java\jdk1.6.0_26
set PATH=%JAVA_HOME%\bin;%PATH%

call mvn clean install -o

pause