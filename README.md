How to Install
- Open Android Studio.
-	Click Open an existing Android Studio project.
- Select and open project
-	Wait for Gradle sync finish
-	Select menu Run > Edit Configurations
-	Click on ‘+’ button
-	Select Android Instrumented Tests
-	Input Configurations Name. example ‘Android Test’
-	Select Module
 •	All Module (run all UI Test in project)
 •	All Package (run all UI Test in Package) > Select Package
 •	Class (run all UI Test case in class) > Select class
   	com.sourcey.materiallogindemo.Test.LoginTest 
   	com.sourcey.materiallogindemo.Test.RegisterTest
 •	Methode (run one UI Test methode) > Select class > Select method
   	com.sourcey.materiallogindemo.Test.LoginTest
 •	testRegisterAllField_Success_TCRegis0001
 •	testRegisterIgnoreName_Fail_TCRegis002
-	Select Target (target device for run test)
 •	Open Select Deployment Target Dialog
 •	USB Device (Connected device)
 •	Emulator > Select Prefer Android Vitual Device
Example 
-	Select All Module
-	Select Target Emulator 
-	Select Prefer Android Virtual Device Emulator
-	Select configuration on Tools bar. Example ‘Android Test’
-	Click ‘Run’ or ‘Debug’
