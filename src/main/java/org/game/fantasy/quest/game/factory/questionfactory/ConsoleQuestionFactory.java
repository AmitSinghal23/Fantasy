package org.game.fantasy.quest.game.factory.questionfactory;

import java.util.Arrays;
import java.util.List;

import org.game.fantasy.quest.game.challenge.CategoryPrompt.Category;
import org.game.fantasy.quest.game.challenge.question.ConsoleQuestion;
import org.game.fantasy.quest.game.challenge.question.Level;
import org.game.fantasy.quest.game.option.ConsoleOption;

public class ConsoleQuestionFactory extends AbstractQuestionFactory<ConsoleQuestion>{
	private static volatile ConsoleQuestionFactory consoleQuestionFactory;
	
	public static ConsoleQuestionFactory getInstance(){
		if(consoleQuestionFactory == null){
			synchronized(ConsoleQuestionFactory.class){
				if(consoleQuestionFactory == null){
					consoleQuestionFactory = new ConsoleQuestionFactory();
				}
			}
		}
		return consoleQuestionFactory;
	}
	
	private ConsoleQuestionFactory() {

	}

	public String toString(){
		return "This is Console Question Factory";
	}

	@Override
	public List<ConsoleQuestion> getQuestionList() {
		return getConsoleQuestionList();
	}
	
	private List<ConsoleQuestion> getConsoleQuestionList(){
		return Arrays.asList(
				new ConsoleQuestion(1, "1. How are you going to prove your worth to be the heir of the great throne?", 
						Arrays.asList(new ConsoleOption(1, "Reinvading our lost city of Ronar by defeating cunning ruler Romulus.", true), new ConsoleOption(2, "Winning the city of Alasmus and marry the princess Solandra", false)), Level.EASY, Category.HISTORY, false),
				new ConsoleQuestion(2, "2. What does the prophecy of Goddess Mara say about reinvasion of Ronar?", 
						Arrays.asList(new ConsoleOption(1, "The prophecy says, One who holds the blue sword with ruby hilt, has alliance of elves, defeats the gatekeeper golden dragon of Naru, wins the trust of North dwarfs, can only lift the magical mist surrounding Ronar.", true), new ConsoleOption(2, "The prophecy says, One who crosses the mighty river Hannah, scale the snow covered mountain Soloman, and enter the temple of God Apollo by defeating the tribes of Chola, can only  lift the magical mist surrounding Ronar.", false)), Level.EASY, Category.HISTORY, false),
				new ConsoleQuestion(3, "3. Where is the blue sword and who is worthy of it?", 
						Arrays.asList(new ConsoleOption(1, "The blue sword is kept in the chambers of temple of the war God Damus. One who can defeat the two headed serpant guarding the chamber door can only enter the chambers and the sword is his/her.", true), new ConsoleOption(2, "The blue sword of kept under the stone of Nafrah. One who can move the stone with bare hands are worthy of having the blue sword.", false)), Level.EASY, Category.HISTORY, false),
				new ConsoleQuestion(4, "4. After getting the sword, what is the next course of action?", 
						Arrays.asList(new ConsoleOption(1, "To ride out towards east. The Land of Gorgons is a two day ride, they may be a friend or a foe. Best to deal when reach there. The nearest safe location is City of Dohar with queen Hida as an alliance to the kingdom.", true), new ConsoleOption(2, "To ride towards north. The land of Harruns the fighters. Make them your ally by marrying their princes Nazarah.", false)), Level.EASY, Category.HISTORY, false),
				new ConsoleQuestion(5, "5. The head of Gorgons is behaving antipathic, even refusing food or shelter. What would you do now?", 
						Arrays.asList(new ConsoleOption(1, "The best way to win the alliance of Gorgons is to defeat them in the board game of Khos. I would invite their head Nid to this game and its well known that I am the best player in Khos in the Kingdom of New Age. Not all war needs to shed blood. ", true), new ConsoleOption(2, "Blue sword can cut the air, show its wrath to Gorgons. Invite their best fighter and his blood will make Gorgons to surrender them to your whims.", false)), Level.EASY, Category.HISTORY, false),
				new ConsoleQuestion(6, "6. What’s the next destination?", 
						Arrays.asList(new ConsoleOption(1, "Winning Nid's support was crucial. Now i should head for Dohar, where queen Hida will set meeting with the Ancient elf Wise Aiva who will write me a letter to carry to the Elfen Land of Eisha.", true), new ConsoleOption(2, "To cross the deserts of Yamara to find the lost city of Nemar where Wise Aiva’s father is jailed by cruel ruler Nemar. Kill Nemar to free Aiva’s father and take him to Elfen Land of Eisha.", false)), Level.MEDIUM, Category.HISTORY, false),
				new ConsoleQuestion(7, "7. How would you reach the Land of Eisha?", 
						Arrays.asList(new ConsoleOption(1, "Land of Eisha is invisible to the mortals. Only the human carrying letter from an ancient elf can invite the guard of Eisha to appear before him/ her after reaching the giant tree of life. If satisfied with the lineage, the guard grants entry to the city.", true), new ConsoleOption(2, "When the planets are aligned and sun is rising, follow the first ray of the sunshine, which will hit the shining stone of lost temple of Gods of Elfen, follow the light and you will reach Land of Eisha.", false)), Level.MEDIUM, Category.HISTORY, false),
				new ConsoleQuestion(8, "8. You now entered Eisha. How would you convince the council of elves for alliance?", 
						Arrays.asList(new ConsoleOption(1, "The council of elves consists of the wisest four elves with four distinguished powers. I will be asked to display my prowess in magic, swordsmanship, war tactics and dragon riding.", true), new ConsoleOption(2, "The council of elves consists of the four cunning elves. I will give them gold from the temple of Apollo to get their alliance.", false)), Level.MEDIUM, Category.HISTORY, false),
				new ConsoleQuestion(9, "9. How is the Elven alliance be beneficial?", 
						Arrays.asList(new ConsoleOption(1, "The elves gave a blue dragon, the same race whose blood was used to temper my sword. They gifted me the fire magic with which I can lift the magical mist surrounding Ronar.", true), new ConsoleOption(2, "They gave me the blue shield, the perfect companion of blue sword. No weapon was ever made which can penetrate the blue shield.", false)), Level.MEDIUM, Category.HISTORY, false),
				new ConsoleQuestion(10, "10. Where would you go next?", 
						Arrays.asList(new ConsoleOption(1, "The abandoned city of Naru is still guarded by the golden dragon Tor. Naru lies near the coast of Odiv Sea from where the city of Ronar is 2 days sail. It can serve as our strategic post while we prepare for war.", true), new ConsoleOption(2, "I will go back to deserts of Yamara to awaken the army of sand. The one who command the blue sword and blue dragon will be able to raise the army of sand. ", false)), Level.MEDIUM, Category.HISTORY, false),
				new ConsoleQuestion(11, "11. How would you defeat Tor and capture Naru?", 
						Arrays.asList(new ConsoleOption(1, "Tor is an equal match to my blue dragon Sinu but due to old age Tor lacks the agility specially during mid-air strike. Sinu flew aiming Tor's head but turned sidewise and glided moments before collision. It gave me proximity to the golden dragon and i pierced his heart with my sword. We set up camp in Naru.	", true), new ConsoleOption(2, "Tor has the blessings of king of Gods Apollo. Tor has a fire ball which gives him immense power to defeat his enemies. By killing the 3 head Lion, I will capture the fire ball, which is the only weapon in universe to kill Tor.", false)), Level.HARD, Category.HISTORY, false),
				new ConsoleQuestion(12, "12. Once Naru is captured, how would you peruse the seafarer dwarves to join forces?", 
						Arrays.asList(new ConsoleOption(1, "The seafarer dwarves have always hold their grudge against king Romulus as he has blocked their way with the magical mist. I will meet with their king Gokan and convince him that I have gift from Elves to lift up the mist.", true), new ConsoleOption(2, " I will make them the ruler of Naru. Their king Gokan will get the throne and in return I will receive his friendship. ", false)), Level.HARD, Category.HISTORY, false),
				new ConsoleQuestion(13, "13. So, what’s your strategy to defeat Romulus?", 
						Arrays.asList(new ConsoleOption(1, "I will set up my camp in Naru. They have abandoned ships. The elven craftsmen will make them working again. The dwarves with help with the war and food supplies. We will surround Ronar in three direction with ships and with the dragon army from sky as well.", true), new ConsoleOption(2, "Ronar has secret passageway which only dwarves are aware of. During the night, we will enter the fort of Ronar and attack in surprise.", false)), Level.HARD, Category.HISTORY, false),
				new ConsoleQuestion(14, "14. How would you lift the magical mist?", 
						Arrays.asList(new ConsoleOption(1, "I have the power of fire magic from the elves. When we will reach Ronar, I will spell the power magic and concentrate at the edge of my blue sword. The fire from the magic will struck the mist as lightening and the mist will be lifted.", true), new ConsoleOption(2, "I will remove the ruby from the blue sword. When sunshine will pass through the ruby, it will melt the mist and it will disappear in the air", false)), Level.HARD, Category.HISTORY, false),
				new ConsoleQuestion(15, "15. How would you conquer Ronar - the once lost city?", 
						Arrays.asList(new ConsoleOption(1, "Once the mist is lifted, they are defenceless. we would land in the city coast. The dwarves and my lieutenants will attack from the shore. Me and my dragon army will attack from the free spitting fire. But it would be me who will defeat and kill Romulus, not by gifted magic but with bravado, skilled swordsmanship, quick thinking and a brutal blow. We will recapture Ronar and pay tribute to Goddess Mara and God Damus", true), new ConsoleOption(2, "The magic of mist of Ronar will go with the mist itself. People of Ronar will awake and in one clean sweep, Ronar will get its freedom from Romulus. People of Ronar will kill him. He does not deserve a kill from blue sword.", false)), Level.HARD, Category.HISTORY, true),

				new ConsoleQuestion(1, "1. How will you start the search for the treasure of Ganzala?",
						Arrays.asList(new ConsoleOption(1, "Legends say the treasure map is hidden somewhere in the paintings of temple of Aska.", true), 
								new ConsoleOption(2, "Treasure map is hidden somewhere in the Palace of Pandora.", false)), Level.EASY, Category.SCIENCE, false),
		
				new ConsoleQuestion(2, "2. Which painting is having the hidden map?",
						Arrays.asList(new ConsoleOption(1, "The painting which is having the picture of goddess Ganza will show the path.", true), 
								new ConsoleOption(2, "The painting which is having three stars will show the path.", false)), Level.EASY, Category.SCIENCE, false),
				
				new ConsoleQuestion(3, "3. Now you have got the painting, but the question is, how to read the crypt?",
						Arrays.asList(new ConsoleOption(1, "Goddes Ganza’s sword is pointing towards the pyramids of ancient Yukatan, so this is the next destination.", true), 
								new ConsoleOption(2, "Goddes Ganza is holding a book which is having picture of great mountains of Soloman, so this is the next destination.", false)), Level.EASY, Category.SCIENCE, false),
				
				new ConsoleQuestion(4, "4. How will you reach the Pyramids of Yukatan?",
						Arrays.asList(new ConsoleOption(1, "Aska tribe is known for their craftmanship, let me take their help to build a boat which can take me to Yukatan through the waters of river Nilu.", true), 
								new ConsoleOption(2, "Let me steal the dragon of Aska, it can take me to Yukatan in no time.", false)), Level.MEDIUM, Category.SCIENCE, false),
				
				new ConsoleQuestion(5, "5. Pyramids of Yukatan are so vast, how to find the entrance?",
						Arrays.asList(new ConsoleOption(1, "There are no entrance, I have to scale the pyramids, looks like there is a hole on the top.", true), 
								new ConsoleOption(2, "Let me remove the blue stone. All the pyramid is built of red stone, only one stone is blue.", false)), Level.MEDIUM, Category.SCIENCE, false),
				
				new ConsoleQuestion(6, "6. After lots of effort, I have scaled the pyramid but there is no way to go inside. Now what?",
						Arrays.asList(new ConsoleOption(1, "Remove the stone, at the bottom of it there might be engravings….some kind of map. ", true), 
								new ConsoleOption(2, "From top, I can see far distances for the clues.", false)), Level.MEDIUM, Category.SCIENCE, false),
				
				new ConsoleQuestion(7, "7. So you got the map but this seems to be encoded in some ancient language , how you will proceed from here?",
						Arrays.asList(new ConsoleOption(1, "Let me take it to the elders of Yukatan tribe. Somewhere I heard that they can read ancient language of Gods.", true), 
								new ConsoleOption(2, "There are few markings which I can’t understand, one symbol looks like a serpent.  Can this be the great God of Anubis. Let’s head towards temple of Anubis.", false)), Level.HARD, Category.SCIENCE, false),
				
				new ConsoleQuestion(8, "8. How will you make Yukatan elders to help you in your quest?",
						Arrays.asList(new ConsoleOption(1, "The best way to win the alliance of Yukatan is to defeat them in the board game of Khos. I would invite their head Nid to this game and its well known that I am the best player in Khos in the Kingdom of New Age. Not all war needs to shed blood.", true), 
								new ConsoleOption(2, "My sword can cut the air, show its wrath to Yukatans. Invite their best fighter and his blood will make Yukatan to surrender themselves to my whims.", false)), Level.HARD, Category.SCIENCE, true));
	}
}
