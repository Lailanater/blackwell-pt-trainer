# Blackwell PT Trainer
## Chris Lail
## 5-2-2018

### Abstract
	Soldiers in the United States military are required to stay in top physical shape in order to do their jobs effectively. Soldiers are required to take a Physical Training Test (PT Test) that demonstrates that they are within the required physical standards. In the United State Army, the PT Test is structured around two minutes of max push-ups, two minutes of max situps, and a timed two mile run. The standards are based off of age and while most soldiers easily meet these requirements, some struggle. To combat this problem I developed an Android application that has the ability to keep users on a two week program in order to improve peak physical fitness. 
	The areas in which the workout program focuses are core strength, and endurance. The workout program came from a friend of mine, Justin Perry. After he struggled to pass the PT Test his unit, Blackwell, gave him the workouts that are described in my application. Using this program Justin was able to pass his next PT Test and attested to the effectiveness of this program. 
	This paper describes process of creating my Android application solution I call Blackwell PT Trainer. The application is a lightweight solution to achieving peak physical fitness and maintaining that level of fitness. Blackwell PT Trainer achieves a simple, effective way to keep track of your workouts, maintain a regular workout schedule, and has the capability to launch all of the tools needed to complete each workout.
Table of Contents

Introduction and Project Overview (800-1200 words)
Problem and Objectives (200 - 300)
	Soldiers that fail the PT Test are put under immense pressure to make sure they are able to at least reach the minimum requirements. Sometimes punishment can go as far as being demoted to a previous rank and pay grade until you can meet the minimum requirements again. So, it was imperative to make a solution that would be able to quickly improve physical fitness and maintain ease of use. Blackwell PT Trainer includes a two week program which requires the user to workout five times a week. The simple two week program is a viable solution that can deliver results fast. The application aims to allow the user to complete workouts, keep track of previously completed workouts, and have access to all the tools needed to complete them. For example, the workouts can require the user to run for a workout; Blackwell PT Trainer has a button near the bottom of the workout screen that can launch a GPS tracked run. The workouts can also require the user to do as many push-ups, and situps as they can in x amount of minutes. Blackwell PT Trainer also has the capability to launch the default timer application on your Android device. To my knowledge, there is no other application on the market that is geared towards helping improve PT scores. The only applications that are available are apps that calculate your PT score or are generic workout programs created as a one size fits all. This is part of the reason that Blackwell PT Trainer is unique.    
Potential Users (200 - 300)
	Blackwell PT Trainer is specifically aimed at members of the United States military who are looking to improve their scores on the PT Test. Although the application is not limited to members of the military; it can be geared towards anyone who is looking to improve their level of physical fitness. Blackwell PT Trainer does not confirm if you are a member of the military because that information is not needed. Anyone may use this app if they are looking for a simple workout program.
Value (200 - 300)
	The benefit of Blackwell PT Trainer is its ability to adapt to you and your style. The application comes with built in dark and light themes to fit the users preference. On top of that, whenever the application tries to launch a GPS tracked run it will look through all of the apps on your phone and allow you to choose your favorite fitness app to complete the run. This allows the user to continue using their preferred GPS tracking fitness app. Many times those applications have built in sharing mechanisms. This allows the user to also share the results of runs in a way that they are already familiar with. Being able to share runs can improve accountability by allowing your friends to keep tabs on your workouts. Blackwell PT Trainer also eliminates the need for keeping up with the program in paper form. With the Android application you have access to the entire list of workouts at the touch of your fingertips.
Problem Scope
	Ideally I would have liked to implement my own GPS tracking and timers right into the application. Although, I decided against it because I did not know much of the Google Maps API and I have no experience with creating timers in Android applications. Due to the time restriction of this course I was unable to explore those options. In the end, I am happy with my decision to launch any app the user prefers because they do not have to learn another platform. One big problem is that that begin run button will not work without a third party GPS application to launch. As for the start timer button, everyone Android phone comes preinstalled with a clock application that has the capability of launching a timer. Deferring to other applications saved time and allowed me to work on other key features of the application.
Features (200 - 300)
Different Themes - Built-in Light and Dark mode themes.
Clickable Workout Checklist - When clicking on a workout each task has a checkbox indicating whether the task is completed or not.
Uses Your Preferred GPS Fitness App - When pressing the begin run button Blackwell PT Trainer launches a fitness intent which allows the user to use their preferred tracking application.
Start Timers Without Leaving The App - When pressing the start timer button Blackwell PT Trainer launches your default clock timer application where you can input the exact time you want.
Ability To Snap To Current Workout - When pressing on the floating action button in the bottom right corner of the screen it opens up the next unfinished workout. 
Fitness Safety Tips - In the navigation drawer in the upper lefthand corner of the screen there is a tips options. It opens a screen that directs you to download a pdf called “Army Pocket Physical Training Guide”. This document is provided by GoArmy.com and include tons of safety tips and workout demonstrations.
Design, Development and Test (800-1200 words)
Design(~266 - 400)
	
Development (~266 - 400)
Test (~266 - 400)
Results (800-1200 words)

Conclusions and Future Work (400-800 words)

References
