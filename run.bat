@echo off
echo ===================================================
echo Compiling SDA-Pro Threat Intel Proxy Java Project...
echo ===================================================

:: Ensure bin directory exists
if not exist bin mkdir bin

:: Compile using javac with sourcepath pointing to src/main/java
javac -d bin -sourcepath src\main\java src\main\java\com\sdapro\Main.java

if %errorlevel% neq 0 (
    echo [ERROR] Compilation failed!
    exit /b %errorlevel%
)

echo [SUCCESS] Compilation completed successfully.
echo.
echo ===================================================
echo Running Threat Intel Demo Application...
echo ===================================================
echo.

:: Run the compiled Java program
java -cp bin com.sdapro.Main

echo.
echo ===================================================
echo Demo Finished.
echo ===================================================
pause
