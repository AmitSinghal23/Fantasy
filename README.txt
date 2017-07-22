Go to the directory where you have unzipped the project, go to quest folder and do maven clean install:

mvn clean install

Post that please run the below command to run the project:

java -jar -Dquest.file=C:\quest.dat target\quest-1.0.jar

You can provide any file path as quest.file property. (This is the file where game state will be saved).

1.) You should get the following prompt:

Main Menu..

1. Start a new Quest..
2. Embark on existing Quest..

2.) For the first time, please type 1 and hit enter. You shold see the following prompt:

Starting New Quest..

Please Type Your Name..

Please type the name of your choice and hit enter. A short story of the game will render slowly.
Once story is finished, You will be asked to choose a quest type:

TO SAVE THE GAME AT ANY STAGE, PRESS 9
Please Choose the Quest....


1. Liberate the lost city of Ronar..
2. Search for the lost treasure of Ganzala..


Please choose the quest of your choice. You will see some instructions rendered over the screen.
After that you will be asked questions as per the quest you have choosen. 

For ease, correct answer of all the questions is option 1.
If you keep on chosing opton 1, you will keep on winning.

To Answer any questin, please type the choosen option number (either 1 or 2) and hit enter.

While you are at any of the questions, if you enter 9 and hit enter, the game will save and you will see followin prompt:

Game Saved !!


Post that game will continue. 
To exit the game at any time, you can exit by ctrl+c (well.... I should have provided some better way to exit).

Once last question is answered correctly, you will see a success message and game will exit.

Also, questions are categorized based on complexity. As you proceed, you gain experience and level of questions increase (hypothetically I would say, but programmatically it increases)


To load the saved game, Please start the game using same quest.file and in main menu type 2 and hit enter.
It will take you to the same question where you had saved the game.

 