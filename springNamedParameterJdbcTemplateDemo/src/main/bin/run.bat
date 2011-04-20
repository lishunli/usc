@ECHO OFF
SET version=1.0-SNAPSHOT

java -classpath ..\..\..\target\egiogInstrExport-%version%-jar-with-dependencies.jar;..\..\..\target\egiogInstrExport-%version%-SNAPSHOT.jar;..\extconf com.taifook.mtss.mss.integration.egioginstrexport.Main -config ..\extconf\config.properties


@PAUSE
