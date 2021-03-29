# EmailSender
This app is for learning and demonstration of **Java Mail** for sending emails.

## Introduction
EmailSender app is meant to send email directly without disturbing user by creating IntentChooser to choose app to send email. Also Alarm Manager can be used to schedule mail so it can be sent from background service without interrupting user.

## Preview

<img width="333" src="https://github.com/PatelVatsalB21/EmailSender/blob/master/EmailSenderImage.jpeg"/>


## Setup

Libraries used in thses app can be downloaded from https://code.google.com/archive/p/javamail-android/downloads and should be pasted in libs/app of project. 

After that edit build.gradle(app) file and add following line:

    implementation fileTree(dir: "libs", include: ["*.jar"])
    
After completing successfully sync your can run the project. But app password is needed for sender email-id else you can not send email, it will show authentication error. For app password follow these steps.

1) Go to https://myaccount.google.com/apppasswords

2) Login with email id from which you want to send email.

3) Then from Select App option select Others and write your App Name eg- EmailSender.

4) Click on Generate button

5) 16 digit key you get in yellow box is App Password.  Copy and store these password.

6) When you send email fill these password with it.

This password is used by javamail to authenticate you with gmail. If you enter wrong password you will get authentication error. Also if you want to send email multiple times and frequently you can make changes in constructor of SendMail class of app and directly put password instead of filling every time.

If this app helps you, please give a STAR to it.

Thank You
