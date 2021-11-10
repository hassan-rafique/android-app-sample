# Android Sample Project
This repository contains a sample Android App that shows Plants data from a Mock API in Home Screen and plants from loacal db in Local Screen. This is a sample app that shows how different jetpack libraries interact with each other. The app code follows SOLID principles by implementing Clean Architecture. The basic purpose of this project is to show how Android apps are structured and developed at [DevCrew.IO](https://devcrew.io/).

## Clean architecture Implementation 
The project has the following three packages.
- **Data**
Layer that contains repositories, API (Network), Persistence DB.
- **Domain**
Layer that  contains Entities, Use Cases, and Repository interfaces.
- **Presentation**
Layer that contains UI related stuff like Views and ViewModel etc

## Screenshorts

Home                       |  Local                    |  Drawer                   |  Add Plant
:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------
![Screenshot_1632745063](/uploads/3c62a65ac0e9a7904a21fbce4a54f552/Screenshot_1632745063.png) | ![Screenshot_1632745131](/uploads/dd7a95d91f641a9cb4a0a83865661f5f/Screenshot_1632745131.png) | ![Screenshot_1632745068](/uploads/05eb837f614e2070e4a47c6117a0cc24/Screenshot_1632745068.png) | ![Screenshot_1632745161](/uploads/3a028613afc33562af28d23b80f6387a/Screenshot_1632745161.png)
## Build With
This project follow MVVM base Clean Architecture. The following tools and technologies have been used to develop:

### Tools and Technology

|**Tool**|**Version**|
| :- | :- |
|Android Studio|4.2.2 or above|
|Kotlin|1.5.30|
|XML||
|Gradle|7.0.2|
|JDK|11|

### JetPack Libraries
The following libraries have used in this project:
- Hilt DI
- Data Bindings
- Navigation Component
- Room
- ViewModel
- LiveData
- Retrofit
- Kotlin Coroutines
- Event Bus
- Lifecycle aware 

## Getting Starting

### Prerequisite
Before you set up the project please make sure you have installed required min versions of tools installed mentioned in above **Development Tools table**. Otherwise you may come to build errors.

### Installation
Here are simple steps to setup project:

- Clone the repo

|https://gitlab.com/devcrew.io/android-app-sample.git|
| - |
- Make sure you have checked out master branch
- Open project in your preferred IDE (Android Studio)

### Usage
You can run and test the app on Android devices. To build and & run the app simply press the RUN button from Android Studio.

## Author
Ali Rehan (Software Engineer at [DevCrew.IO](https://devcrew.io/)).

## Contributing
Contributions, issues, and feature requests are welcome!

## Show your Support
Give a start if this project helped you.

## License
Copyright © 2021, [DevCrew.IO](https://devcrew.io/)

