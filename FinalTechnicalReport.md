# Blackwell PT Trainer
## Chris Lail
## 5-2-2018

### Abstract
  Soldiers in the United States military are required to stay in top physical shape in order to do their jobs effectively. Soldiers are required to take a Physical Training Test (PT Test) that demonstrates that they are within the required physical standards. In the United State Army, the PT Test is structured around two minutes of max push-ups, two minutes of max situps, and a timed two mile run. The standards are based off of age and while most soldiers easily meet these requirements, some struggle. To combat this problem I developed an Android application that has the ability to keep users on a two week program in order to improve peak physical fitness. 

The areas in which the workout program focuses are core strength, and endurance. The workout program came from a friend of mine, Justin Perry. After he struggled to pass the PT Test his unit, Blackwell, gave him the workouts that are described in my application. Using this program Justin was able to pass his next PT Test and attested to the effectiveness of this program. 

This paper describes process of creating my Android application solution I call Blackwell PT Trainer. The application is a lightweight solution to achieving peak physical fitness and maintaining that level of fitness. Blackwell PT Trainer achieves a simple, effective way to keep track of your workouts, maintain a regular workout schedule, and has the capability to launch all of the tools needed to complete each workout.

### Table of Contents

### Introduction and Project Overview

#### Problem and Objectives
Soldiers that fail the PT Test are put under immense pressure to make sure they are able to at least reach the minimum requirements. Sometimes punishment can go as far as being demoted to a previous rank and pay grade until you can meet the minimum requirements again. So, it was imperative to make a solution that would be able to quickly improve physical fitness and maintain ease of use. Blackwell PT Trainer includes a two week program which requires the user to workout five times a week. The simple two week program is a viable solution that can deliver results fast. The application aims to allow the user to complete workouts, keep track of previously completed workouts, and have access to all the tools needed to complete them. For example, the workouts can require the user to run for a workout; Blackwell PT Trainer has a button near the bottom of the workout screen that can launch a GPS tracked run. The workouts can also require the user to do as many push-ups, and situps as they can in x amount of minutes. Blackwell PT Trainer also has the capability to launch the default timer application on your Android device. To my knowledge, there is no other application on the market that is geared towards helping improve PT scores. The only applications that are available are apps that calculate your PT score or are generic workout programs created as a one size fits all. This is part of the reason that Blackwell PT Trainer is unique.    

#### Potential Users
Blackwell PT Trainer is specifically aimed at members of the United States military who are looking to improve their scores on the PT Test. Although the application is not limited to members of the military; it can be geared towards anyone who is looking to improve their level of physical fitness. Blackwell PT Trainer does not confirm if you are a member of the military because that information is not needed. Anyone may use this app if they are looking for a simple workout program.

#### Value
The benefit of Blackwell PT Trainer is its ability to adapt to you and your style. The application comes with built in dark and light themes to fit the users preference. On top of that, whenever the application tries to launch a GPS tracked run it will look through all of the apps on your phone and allow you to choose your favorite fitness app to complete the run. This allows the user to continue using their preferred GPS tracking fitness app. Many times those applications have built in sharing mechanisms. This allows the user to also share the results of runs in a way that they are already familiar with. Being able to share runs can improve accountability by allowing your friends to keep tabs on your workouts. Blackwell PT Trainer also eliminates the need for keeping up with the program in paper form. With the Android application you have access to the entire list of workouts at the touch of your fingertips.

#### Problem Scope
Ideally I would have liked to implement my own GPS tracking and timers right into the application. Although, I decided against it because I did not know much of the Google Maps API and I have no experience with creating timers in Android applications. Due to the time restriction of this course I was unable to explore those options. In the end, I am happy with my decision to launch any app the user prefers because they do not have to learn another platform. One big problem is that that begin run button will not work without a third party GPS application to launch. As for the start timer button, everyone Android phone comes preinstalled with a clock application that has the capability of launching a timer. Deferring to other applications saved time and allowed me to work on other key features of the application.

#### Features
* *Different Themes* - Built-in Light and Dark mode themes.
* *Clickable Workout Checklist* - When clicking on a workout each task has a checkbox indicating whether the task is completed or not.
* *Uses Your Preferred GPS Fitness App* - When pressing the begin run button Blackwell PT Trainer launches a fitness intent which allows the user to use their preferred tracking application.
* *Start Timers Without Leaving The App* - When pressing the start timer button Blackwell PT Trainer launches your default clock timer application where you can input the exact time you want.
* *Ability To Snap To Current Workout* - When pressing on the floating action button in the bottom right corner of the screen it opens up the next unfinished workout. 
* *Fitness Safety Tips* - In the navigation drawer in the upper lefthand corner of the screen there is a tips options. It opens a screen that directs you to download a pdf called “Army Pocket Physical Training Guide”. This document is provided by GoArmy.com and include tons of safety tips and workout demonstrations.

### Design, Development and Test

#### Design
Blackwell PT Trainer was developed in Android Studio using the Java and XML programming languages. The Android application is built off of one main Activity that a Fragment placeholder for all of the different views that you see as you traverse through the app. When a new Fragment needs to be displayed the application creates a new Fragment of that specific type and then uses the built in SupportFragmentManager to replace the old Fragment with the newly created one. The SupportFragmentManager is crucial to how Blackwell PT Trainer updates its display. Inside of MainActivity there is a blank Fragment that serves as a template where the SupportFragmentManager manages the current and future Fragments that are displayed.

Blackwell PT Trainer remembers user settings and input by storing it into Android's SharedPreferences which essentially performs like a local database. Since I do not need to process user data then I felt no need to include a full fledged database although originally I had planned on it anyways. I lost a couple of days of programming it in SQLite when I soon realized that it was too much work and was overkill for the scope of this project.

In Android there is a simple way to create two basic themes that I used to create a Light and Dark theme for Blackwell PT Trainer. There is a default method called AppCompatDelegate.setDefaultNightMode(int) that I used to switch between the two themes. The great part about using the built in functionality to create themes is that Android handles the changing of assets such as text color, background color, etc needed to make the new theme work.

#### Development
In the initial stages of development the application was simply just a bunch of different Fragments that were not connected. The application was just all about design early on. I was creating XML files that would be inflated and brought to life in the Android Studio design page for each Fragment. A different XML layout file was used to create every UI page in the application. While I was working on the layouts my friend, Justin, created a custom icon for the Blackwell PT Trainer app that I incorporated into the design. Justin also created a custom floating action button that is currently in use.

After creating the layouts I moved onto creating the model to store the data. The main classes that hold the data are Workout.java and WorkoutsList.java. The Workout class is used to store specific data about any particular workout such as a unique ID number, workout name, description, content, and whether or not the workout is complete. The WorkoutsList class is a Singleton class used to access the list of workouts throughout the application. This way making any modifications to a workouts data inside any Fragment will reflect the same result to any other Fragment.

Lastly, I implemented the controller classes that interact with the data based on user input. This portion of development expanded on the Fragment classes allowing them to access data and display it on screen. Simply adding onClickListeners to buttons and other elements allowed the Fragment classes to truly become controller classes since they took user input and responded with the correct action on the data. Android programming is purely built on the MVC (Model View Controller) architecture due to its nature so this method of development made the most sense.

#### Test
In order to assure that the program was working as intended I created test programs that would make sure everything was still correct even after making a change. The simplest way to create test programs in Android is to use the Espresso Test Recorder. Essentially, the application runs in an emulator allowing you to interact with it like normal. Behind the scenes the Espresso Test Recorder is generating code to perform the same actions that you are inputting. This made creating tests much faster and it was easier to understand what the test cases were doing since you were simply interacting with the app as normal.

The problems that I ran into with the Espresso Test Recorder is it would not validate that certain things are actually on the screen. The only things that it would automate was the actual touches and interactions that the user inputs. So, I had to go through and manually write the test code that would verify when objects should and should not appear on the screen. For example, the floating action button in Blackwell PT Trainer application should not be shown after clicking on it. If you are already on the current workout then there is no need to press a button to go to the current workout. Writing these extra checks assured that not only the user interface was still working, but that the data shown was correct as well. I was unable to test the begin run button in the Android emulator because it doesn't have a GPS tracking fitness app preinstalled and you cannot install apps from the Play Store on the emulator. For this I used my own Android device to make sure it was still running smoothly.

### Results
In the end, Blackwell PT Trainer is a functional solution to the problem that I set out to solve. In the early stages of the project I had ambitious hopes for the amount of features that I could implement in a semester. I had a vision to create a platform that would allow users the opportunity to share their progress as they completed the program. In a way a achieved that goal by allowing the user to use their favorite GPS tracking fitness app where most support some flavor of statistics and a sharing mechanism. I also had aspirations of creating my own timers inside the Blackwell PT Trainer application. Although I found it much easier to also divert this task to another application that is trusted and more functional than something I would have rushed to create.

Performance of Blackwell PT Trainer is as smooth as I imagined; there is relatively no delay between interacting with the UI and the data. The only real performance hit is when switching between themes in the settings menu. This is due to the application restarting the MainActivity after the theme change is completed. This causes the application to kick you back to the main workouts menu every single time which can feel a little clunky and not particularly intended. The layout of Blackwell PT Trainer is easy to navigate    

### Conclusions and Future Work

### References

### Appendices
