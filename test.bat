@echo off
setlocal enabledelayedexpansion

set MAINCLASS=com.codemanship.refactoring.legacycode.ShippingAppKt
set JAR=

for /f "delims=" %%f in ('dir /b /s target\*.jar 2^>nul') do (
    set JAR=%%f
    goto :found
)

:found
if "%JAR%"=="" (
    echo No JAR found in target/. Run mvn package first.
    exit /b 1
)

echo Using JAR: %JAR%
echo.

echo ================================
echo Running order 1001
echo ================================
java -cp "%JAR%" %MAINCLASS% 1001
echo.

echo ================================
echo Running order 1002
echo ================================
java -cp "%JAR%" %MAINCLASS% 1002
echo.

echo ================================
echo Running order 1003
echo ================================
java -cp "%JAR%" %MAINCLASS% 1003
echo.

pause