import java.io.*;
import java.util.*;
public class complex
{
	static String CLS = "\033[2J\033[1;1H";
    static String Default = "\033[0m"; // default gray color & reset background to black
    static String Red = "\033[31;1m";
    static String Pink = "\033[38;5;213m";
    static String Green = "\033[32;1m";
    static String SeaGreen = "\033[38;5;158m";
    static String Yellow = "\033[33;1m";
    static String Navy = "\033[34;1m";
    static String Blue = "\033[38;5;117m";
    static String Cyan = "\033[36;1m";
    static String Purple = "\033[35;1m";
    static String Orange = "\033[38;5;208m";
    static String Coral = "\033[38;5;204m";
    static String White = "\033[37;1m";

    static String WhiteOnRed = "\033[41;1m";
    static String WhiteOnGreen = "\033[42;1m";
    static String WhiteOnYellow = "\033[43;1m";
    static String WhiteOnBlue = "\033[44;1m";
    static String WhiteOnPurple = "\033[45;1m";
    static String WhiteOnCyan = "\033[46;1m";
	
	static ArrayList<Room> Vertex = new ArrayList<Room>();
	static ArrayList<Room> Path = new ArrayList<Room>();
    
	//main program starts here
	public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
		// read in vertices
		Scanner infile = new Scanner(new File("vertex.txt"));
		String Input = "";
		while (infile.hasNextLine())
		{
			Input = infile.nextLine();
			Vertex.add(new Room(Input));
		}
		System.out.println(Cyan + Vertex.size() + " vertices read from file" + Default);

        // read in edges
		infile = new Scanner(new File("edge.txt"));
		String From, Direction, To;
		int Count=0;
		while (infile.hasNext())
		{
			Count++;
			From = infile.next();
			Direction = infile.next();
			To = infile.next();

			// locate From Vertex in ArrayList
			int IndexFrom = 0;
			while (!Vertex.get(IndexFrom).RoomName.equals(From))
			{  IndexFrom++;  }
			// locate To Vertex in ArrayList
			int IndexTo = 0;
			while (!Vertex.get(IndexTo).RoomName.equals(To))
			{  IndexTo++;  }
			// create edge
			if (Direction.equals("North"))
			{
				Vertex.get(IndexFrom).North = Vertex.get(IndexTo);
				Vertex.get(IndexTo).South = Vertex.get(IndexFrom);
			}
			if (Direction.equals("South"))
			{
				Vertex.get(IndexFrom).South = Vertex.get(IndexTo);
				Vertex.get(IndexTo).North = Vertex.get(IndexFrom);
			}
			if (Direction.equals("East"))
			{
				Vertex.get(IndexFrom).East = Vertex.get(IndexTo);
				Vertex.get(IndexTo).West = Vertex.get(IndexFrom);
			}
			if (Direction.equals("West"))
			{
				Vertex.get(IndexFrom).West = Vertex.get(IndexTo);
				Vertex.get(IndexTo).East = Vertex.get(IndexFrom);
			}
		}
		//intro
		System.out.println(Pink + Count + " edges read from file" + Default);
		System.out.println(Yellow + "Welcome to my project of a Complex. This Complex will feature a map from the game "
							+"Tom Clancy's Rainbow Six Siege called " + Coral + "'Club House'" + Default + Yellow + "." + Default);
							System.out.println("                           +-------------------+   ");                        
							System.out.println("                           |  |\\\\| ,,-. .::.   |      ");                     
							System.out.println("                           |  | \\|((  )) .:'   |         ");                  
							System.out.println("                           |       ``-' ::..   |            ");               
							System.out.println("                           |   BANDIT'S CLUB   |             ");              
							System.out.println("                 ______....+-------------------+....______    ");             
							System.out.println("....------''''''' ______....LLLLLLLLLLLLLLLLLLL....______ ```````------....	");
							System.out.println(" ....------'''''''                                       ```````------....|	");
							System.out.println("|   +--------------+         _______________             +------------+   |	");
							System.out.println("|   | Tonite Only! |        /               \\            |DJ Blackwing|   |	");
							System.out.println("|   | ReMixer LIVE |       /_________________\\           | Fri Sat 9PM|   |	");
							System.out.println("|   +--------------+       | |      |      | |           +------------+   |	");
							System.out.println("|                          | |______|______| |                            |	");
							System.out.println("|__________________________|/|_____[|]_____|\\|____________________________|	");
							System.out.println("|__________________________|/|      |      |\\|____________________________|	");
							System.out.println("|                          | |______|______| |                            |	");
							System.out.println("|__________________________|/               \\|_________________________MJP|	");
							System.out.println("                                    |                                    ");
							System.out.println("                          /         |         \\                          ");      
							System.out.println("                         /          |          \\                         ");    
							System.out.println("                        /           |           \\                        ");    
							System.out.println("                       /            |            \\                       ");  
							System.out.println("                      /             |             \\                      ");
							System.out.println("                     /              |              \\                     ");  
							System.out.println("                    /               |               \\                    ");  
		System.out.println(WhiteOnYellow +"Note:"+ Default + Purple + " This is not a representation of the whole map. "
							+ "I have only focused on the first floor(Base floor) of the map." + Default);
		System.out.println(Yellow + "Follow the PowerPoint Slide or the Png file provided for the Map to navigate around." + Default);
		System.out.println(Green + "Enjoy moving around!!" + Default);
		System.out.println("Press " + SeaGreen +"<Enter>"+ Default + " to Continue");
		in.nextLine();
        // game loop
        char Choice = ' ';
        Room Temp = Vertex.get(0);
		String lastMessage = ""; //For invalid texts
        while (Choice != 'X') //loop for the room
        {
            System.out.println(CLS); //clears the screen every time a new room is shown
			if (!lastMessage.isEmpty()) 
			{
                System.out.println(lastMessage); // Display last message
				System.out.println(""); 
            }
            lastMessage = ""; // Reset after displaying

			//ASCII arts for the rooms
			if (Temp.RoomName.equals("JunkYard_Entrance"))
			{
				System.out.println("You are in " + WhiteOnYellow + Temp.RoomName + Default);
				System.out.println("");
				System.out.println("       ________   ");
				System.out.println("      |        |	");
				System.out.println("      |  Fence |	");
				System.out.println("  ____|________|_____");
				System.out.println(" /                  \\	");
				System.out.println("|   _____    _____    |   	");
				System.out.println("|  |     |  |     |   |	");
				System.out.println("|  |     |  |     |   |	");
				System.out.println("|  |_____|  |_____|   |	");
				System.out.println("|                    Entry	");
				System.out.println("|====================|	");
				System.out.println("|      GROUND        |	");
				System.out.println("|____________________|	");
			}

			if (Temp.RoomName.equals("Club_Room"))
			{
				System.out.println("You are in " + WhiteOnGreen + Temp.RoomName + Default);
				System.out.println("");
				System.out.println("     .-.       .-.	");
				System.out.println("    |   |     |   |	");
				System.out.println("    |   |_____|   |   * Lights *	");
				System.out.println("    |   |     |   |	");
				System.out.println("    |   |     |   |  ");
				System.out.println("    |___|     |___|	");
				System.out.println("     |           |	");
				System.out.println("     |  STAGE    |	");
				System.out.println("     |___________|	");
				System.out.println("   |   |       |   |	");
				System.out.println("   |   |  BAR  |   |	");
				System.out.println("   |   |_______|   |	");
				System.out.println("  /                 \\	");
				System.out.println(" /                   \\	");
				System.out.println(" |     SEATING       |	");
				System.out.println(" |___________________|	");
			}

			if (Temp.RoomName.equals("Hallway"))
			{
				System.out.println("You are in " + WhiteOnGreen + Temp.RoomName + Default);
				System.out.println("");
				System.out.println("        ________________  ");    
				System.out.println("       +      			");
				System.out.println("       |       _________	");
				System.out.println("       |      |		");
				System.out.println("       +      |		");
				System.out.println("       |      |		");
				System.out.println("       |      |		");
				System.out.println("       |      |		");
				System.out.println("       |      |		");
				System.out.println("       +--  --+		");
			}

			if (Temp.RoomName.equals("Side_Entrance"))
			{
				System.out.println("You are in " + WhiteOnYellow + Temp.RoomName + Default);
				System.out.println("");
				System.out.println("    +----------------------+ ");
				System.out.println("    |      Brick Wall      |  ");
				System.out.println("    |   [MORRAD FABRIK]    |	");
				System.out.println("    +----------------------+	");
				System.out.println("         |          |        	");
				System.out.println("     [Wooden Pallets]        	");
				System.out.println("   ~~~~~~~~~~~~~~~~~~~~~     * Side Entry *	");
				System.out.println("   |   _______              |  	");
				System.out.println("   |  |       |             |  	");
				System.out.println("   |  |       |             |   	");
				System.out.println("   |  |_______|   ______    |	");
				System.out.println("   |            __|    |___ |	");
				System.out.println("   |___________|          | |	");
				System.out.println("       [Blue Covers]   [Treads]	");
				System.out.println("    ___________________________	");
				System.out.println("   /                           \\	");
				System.out.println("  |          Muddy Path         |	");
				System.out.println("  |_____________________________|	");
			}

			if (Temp.RoomName.equals("Bathroom"))
			{
				System.out.println("You are in " + WhiteOnGreen + Temp.RoomName + Default);
				System.out.println("");
				System.out.println("                                                         | ");
				System.out.println("                                            __________   |	");
				System.out.println("                           _    __    _    |          |  |	");
				System.out.println("                          /_\\  /  \\  /_\\   |          |  |	");
				System.out.println("                          =|= | // | =|=   |          |  |	");
				System.out.println("                           !   \\__/   !    |          |  |	");
				System.out.println("                                 _         |          |  |	");
				System.out.println(" ___               ___          //'        |          |  |	");
				System.out.println("[___]       _   :=|   |=:   __T_||_T__     |p=        |  |	");
				System.out.println("|  ~|     =)_)=   |   |    [__________]    |          |  |	");
				System.out.println("|   |      (_(    |xXx|     \\_      _/     |          |  |	");
				System.out.println("|   |      )_)    \"\"\"\"\"       \\    /       |          |  |	");
				System.out.println("\\___|                          |  |        |          |  |	");
				System.out.println(" |  `========,                 |  |        |          |  |	");
				System.out.println("__`.        .'_________________|  |________|__________lc_|	");
				System.out.println("    `.    .'                  (____)                      \\	");
				System.out.println("    _|    |_...             .;;;;;;;;.                     \\	");
				System.out.println("   (________);;;;          :;;;;;;;;;;:	");
				System.out.println("        :::::::'            '::::::::'	");
			}

			if (Temp.RoomName.equals("Kitchen"))
			{
				System.out.println("You are in " + WhiteOnGreen + Temp.RoomName + Default);
				System.out.println("");
				System.out.println("   ____________________________________________________________________   ");  
				System.out.println(" /|    |__I__I__I__I__I__I__I__I__I_|       _-       %       %         |\\	");
				System.out.println("  | _- |_I__I__I__I__I__I__I__I__I__|-_              %       %     _-  | 	");
				System.out.println("  |    |__I__I__I__I__I__I__I__I__I_|                %       %         |	");
				System.out.println("  |  - |_I__I__I__I__I__I__I__I__I__|               ,j,      %w ,      |	");
				System.out.println("  | -  |__I__I__I__I__I__I__I__I__I_|  -_ -        / ) \\    /%mMmMm.   |	");
				System.out.println("  |    |_I__I__I__I__I__I__I__I__I__|             //|  |   ;  `.,,'    |	");
				System.out.println("  |-_- /                            \\             w |  |   `.,;`       |    ");
				System.out.println("  |   /                              \\    -_       / ( |    ||         |    ");
				System.out.println("  |  /                                \\           //\\\\_'/    (.\\    -_ |    ");
				System.out.println("  | /__________________________________\\          w  \\\\/   -  ``\\'     |    ");
				System.out.println("  | |__________________________________|                               |	");
				System.out.println("  |    |   _______________________   |     _-            -             |	");
				System.out.println("  |_-  |  |                       |  |                        _-       |	");
				System.out.println("  |    |  |                     _ |  |  T  T  T  T  T                  |	");
				System.out.println("  | _-_|  |    __.'`'`'`''`;__ /  |  |  |  |  |  |  |        _-     -  |	");
				System.out.println("  |    |  | _/U  `'.'.,.,\".'  U   |  |  | (_) |  |  |                  |	");
				System.out.println("  |    |  |   |               |   |  | / \\    @ [_]d b    _@_     |    |   	");
				System.out.println("  |    |  |   |      `', `,   |   |  | |_|   ____         [ ]     |    |	");
				System.out.println("  |_-  |  |   |   `') ( )'    |   |  | ______\\__/_________[_]__   |    | 	");
				System.out.println("  |    |  |   |____(,`)(,(____|   |  |/________________________\\  |    |	");
				System.out.println("  |    |  |  /|   `@@(@@)@)'  |\\  |  | ||            _____   ||   |    |	");
				System.out.println("  |    |  | //!\\  @@)@@)@@@( /!\\ |  | ||   _--      \\   /   ||  /|\\    |	");
				System.out.println("  |__lc|__|/_____________________\\|__|_||____________/###\\___||_|||||__|	");
				System.out.println(" / -_  _ -      _ -   _-_    -  _ - _ -|| -_    _  - \\___/_- || |||||-_ \\ 	");
			}

			if (Temp.RoomName.equals("Stock_Room"))
			{
				System.out.println("You are in " + WhiteOnGreen + Temp.RoomName + Default);
				System.out.println("");
				System.out.println(" +------------------------------------+ ");
				System.out.println("   | [Shelf 1]     [Shelf 2]          |	");
				System.out.println("   |  ________      ________          |	");
				System.out.println("   | | Boxes  |    | Tools  |         |	");
				System.out.println("   | |________|    |________|         |	");
				System.out.println("   |                                  |	");
				System.out.println("   |  ________      ________          |	");
				System.out.println("   | | Supplies|    | Equipment|      |	");
				System.out.println("   | |_________|    |__________|      |	");
				System.out.println("   |                                  |	");
				System.out.println("   |   Workbench                      |	");
				System.out.println("   |  +-----------------------+       |	");
				System.out.println("   |  |   Tools and Parts     |       |	");
				System.out.println("   |  +-----------------------+       |	");
				System.out.println("   |                                  |	");
				System.out.println("   | [Shelf 3]     [Shelf 4]          |	");
				System.out.println("   |  ________      ________          |	");
				System.out.println("   | | Chemicals|   | Containers|     |	");
				System.out.println("   | |__________|   |___________|     |	");
				System.out.println("   +-----------------------------------+	");
			}

			if (Temp.RoomName.equals("Bar"))
			{
				System.out.println("You are in " + WhiteOnGreen + Temp.RoomName + Default);
				System.out.println("");
				System.out.println("      .======================================. ");
				System.out.println("      | ___ ___ ___               _   _   _  |	");
				System.out.println("      | \\_/ \\_/ \\_/ C|||C|||C||| |-| |-| |-| |	");
				System.out.println("      | _|_ _|_ _|_  ||| ||| ||| |_| |_| |_| |	");
				System.out.println("      '===================================== ,sSSSs	");
				System.out.println("                Welcome to BANDIT'S BAR       SSSS \"(	");
				System.out.println("           .:.                              SSS@ =/  \\~/	");
				System.out.println("          C|||'                             SSSS_(_  _Y_	");
				System.out.println("        ___|||______________________________SS/ _)_) /.-	");
				System.out.println("       [____________________________________] \\   /\\//	");
				System.out.println("        |   ____    ____    ____    ____   | \\|==(\\_/	");
				System.out.println("        |  (____)  (____)  (____)  (____)  | (/   ;	");
				System.out.println("        |  |    |  |    |  |    |  |    |  | |____|	");
				System.out.println("        |  |    |  |    |  |    |  |    |  |  \\  |\\	");
				System.out.println("        |  |    |  |    |  |    |  |    |  |   ) ) )	");
				System.out.println("        |  |____|  |____|  |____|  |____|  |  (  |/	");
				System.out.println("        |  I====I  I====I  I====I  I====I  |  /\\ |	");
				System.out.println("       jgs |    |  |    |  |    |  |    |  | /.(=\\	");
				System.out.println("                                               Y\\_\\	");
			}

			if (Temp.RoomName.equals("Changing_Room"))
			{
				System.out.println("You are in " + WhiteOnGreen + Temp.RoomName + Default);
				System.out.println("");
				System.out.println(" ___________________________________	");
				System.out.println("|                                   |	");
				System.out.println("|          CHANGING ROOM            |	");
				System.out.println("|-----------------------------------|	");
				System.out.println("|                                   |	");
				System.out.println("|      .-------------.              |	");
				System.out.println("|      |             |              |	");
				System.out.println("|      |   MIRROR    |              |	");
				System.out.println("|      |             |              |	");
				System.out.println("|      '-------------'              |	");
				System.out.println("|                                   |	");
				System.out.println("|  +---------------------------+    |	");
				System.out.println("|  |                          ||    |	");
				System.out.println("|  |        CURTAIN           ||    |	");
				System.out.println("|  |__________________________||    |	");
				System.out.println("|  |                          ||    |	");
				System.out.println("|  |       +-----------+      ||    |	");
				System.out.println("|  |       |           |      ||    |	");
				System.out.println("|  |       |   BENCH   |      ||    |	");
				System.out.println("|  |       |___________|      ||    |	");
				System.out.println("|  |                          ||    |	");
				System.out.println("|  |       +-----------+      ||    |	");
				System.out.println("|  |       |           |      ||    |	");
				System.out.println("|  |       |  BENCH  2 |      ||    |	");
				System.out.println("|  |       |___________|      ||    |	");
				System.out.println("|  |                          ||    |	");
				System.out.println("|  +---------------------------+    |	");
				System.out.println("|___________________________________|	");
			}

			if (Temp.RoomName.equals("Lounge"))
			{
				System.out.println("You are in " + WhiteOnGreen + Temp.RoomName + Default);
				System.out.println("");
				System.out.println("==================================================================================== ");
				System.out.println("|    ~@~      ~@~            LIFE BEGINS AT BANDIT'S CLUB        ~@~      ~@~    |	");
				System.out.println("|\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/\\__/ 	");
				System.out.println("|. . . . . . . . . . .[___|___|___|___|___|__]. . . . . . . . . . . . . . . .|	");
				System.out.println("| . . . . . . . . . . [_|___|___|___|___|___|] . . . . . . . . . . . . . . . |	");
				System.out.println("|. . . . . . . . . . .[___|___|___|___|___|__]. . . . . . . . . . . . . . . .|	");
				System.out.println("| . . . .  _  . . . . [_|___|___|___|___|___|] . .  _  . . . . . . .  _  . . |	");
				System.out.println("|. . . .  /_\\  . . . .[__|___|___|___|___|___]. .  /_\\  . . . . . .  /_\\  . .|	");
				System.out.println("| . . . . =|= . . . . [_|___/          \\___|_] . . =|= . . . . . . . =|= . . |	");
				System.out.println("|. . . . . . . . . . .[|___| ~ LOUNGE ~ |___|]. . . . . . . . . . . . . . . .|	");
				System.out.println("|=====================[__|__\\__________/_|___]================____===========|	");
				System.out.println("|                     [___|___|___|___|___|__]               | |  \\          |	");
				System.out.println("|           ,         [_|___|___|___|___|___|]               | |   \\_______  |	");
				System.out.println("|          ,I,    ,;,/________________________\\,;,          _|_|___________) |	");
				System.out.println("|/|   ____;(;);__;(;);                        ;(;); /|     /   | ,.________) |	");
				System.out.println("|||__ !!!!!;;;!!!!=;============================;=  ||__  /____|/ .________| |	");
				System.out.println("||/_/|!!!!!!;!!!!!![_|_|_]================[_|_|_]___|/_/|_|______/_______)(__lc	");
				System.out.println("/|' |'  |'     '|  [__|__]       `(       [__|__]   |' |'[|)(            ()   \\	");
				System.out.println(" '  '   '       '  [_|_|_] o     ) (    o [_|_|_]   '  '   ()                   	");
				System.out.println("                   [__|__] |    ( ) )   | [__|__]                      ,	");
				System.out.println("                   [_|_|_] |---@@@@@@---| [_|_|_]           /|        ,I,       |\\	");   
				System.out.println("                   [__|__]/!\\ @@@@@@@@ /!\\[__|__]           ||   ____;(;);____  ||	");
				System.out.println("                  /______________________________\\          ||__ !!!!!;;;!!!!!__||	");
				System.out.println("   ,             |________________________________|         |/_/|!!!!!!;!!!!!!\\_\\|	");
				System.out.println("  ,I,       |\\   `================================`         || ||  ||     || || ||	");
				System.out.println("_;(;);____  ||  `==================================`        |  |   |       |  |  |	");
				System.out.println("!!;;;!!!!!__|| `====================================`	");
				System.out.println("!!!;!!!!!!\\_\\|	");
				System.out.println("==================================================================================== ");
			}

			if (Temp.RoomName.equals("Garage"))
			{
				System.out.println("You are in " + WhiteOnGreen + Temp.RoomName + Default);
				System.out.println("");
				System.out.println("  ________________________________________________________	");
				System.out.println(" /                                                        \\	");
				System.out.println("|      ___                     ___                        |	");
				System.out.println("|     |   |                   |   |                       |	");
				System.out.println("|     |___|                   |___|                       |	");
				System.out.println("|       |       CAR LIFT         |         CAR LIFT       |	");
				System.out.println("|       |   _______              |   _______              |	");
				System.out.println("|       |  |       |             |  |       |             |	");
				System.out.println("|       |  |  SUV  |             |  | CLASSIC|            |	");
				System.out.println("|       |  |_______|             |  |_______|             |	");
				System.out.println("|       |  |       |             |  |       |             |	");	
				System.out.println("|       |  |_______|             |  |_______|             |	");
				System.out.println("|   ____|                       ____|                     |	");	
				System.out.println("|  |    |                      |    |                     |	");
				System.out.println("|  |____|                      |____|                     |	");
				System.out.println("|                                                         |	");
				System.out.println("|                [GARAGE WALL WITH SIGNS]                 |	");
				System.out.println("|                                                         |	");
				System.out.println("|      ______                       ______                |	");
				System.out.println("|     |      |                     |      |               |	");
				System.out.println("|     | PUMP |                     | PUMP |               |	");
				System.out.println("|     |______|                     |______|               |	");
				System.out.println("|                                                         |	");
				System.out.println(" \\_______________________________________________________/	");
			}

			if (Temp.RoomName.equals("Garage_Storage"))
			{
				System.out.println("You are in " + WhiteOnGreen + Temp.RoomName + Default);
				System.out.println("");
				System.out.println("  ____________________________________________	");
				System.out.println(" |                                            |	");
				System.out.println(" |            GARAGE STORAGE                  |	");
				System.out.println(" |--------------------------------------------|	");
				System.out.println(" |   _______    _______    _______            |	");
				System.out.println(" |  |       |  |       |  |       |           |	");
				System.out.println(" |  | TOOLS |  |  BOX  |  | BIN   |           |	");
				System.out.println(" |  |_______|  |_______|  |_______|           |	");
				System.out.println(" |                                            |	");
				System.out.println(" |  +-------+  +-------+  +-------+           |	");
				System.out.println(" |  | SCREW |  |  NUT  |  | WRENCH|           |	");
				System.out.println(" |  | DRIVER|  |& BOLT |  |  SET  |           |	");
				System.out.println(" |  +-------+  +-------+  +-------+           |	");
				System.out.println(" |                                            |	");
				System.out.println(" |  _______________________________           |	");
				System.out.println(" | /                               \\          |	");
				System.out.println(" | |       SHELVES WITH ITEMS       |         |	");
				System.out.println(" | |   [o]   [x]   [x]   [o]        |         |	");
				System.out.println(" | |   [x]   [o]   [o]   [x]        |         |	");
				System.out.println(" | \\_______________________________/          |	");
				System.out.println(" |                                            |	");
				System.out.println(" |  WORKBENCH:                                |	");
				System.out.println(" |  +-----------------------------+           |	");
				System.out.println(" |  |                             |           |	");
				System.out.println(" |  |  VISE & TOOLS               |           |	");
				System.out.println(" |  |_____________________________|           |	");
				System.out.println(" |____________________________________________|	");
			}

			if (Temp.RoomName.equals("Exit"))
			{
				System.out.println("You are in " + WhiteOnRed + Temp.RoomName + Default);
				System.out.println("");
				System.out.println("Nothing here but emptiness. Just an infinite void of emptiness.....");
				System.out.println("You still have the door to go back though :)");
				System.out.println("    /|	");
				System.out.println("    / |	");
				System.out.println("   /__|______	");
				System.out.println("  |  __  __  |	");
				System.out.println("  | |  ||  | | 	");
				System.out.println("  | |__||__| |== sh!	");
				System.out.println("  |  __  __()|/      ...I'm not really here.	");
				System.out.println("  | |  ||  | |	");
				System.out.println("  | |  ||  | |	");
				System.out.println("  | |__||__| |	");
				System.out.println("  |__________|   ejm	");
			}
		//Tells you what directions you can move into
		System.out.println("");
		System.out.print(Yellow + "You can move in these directions: " + Default);
		if (Temp.North != null)
			System.out.print(Coral + "North " + Default);
		if (Temp.South != null)
			System.out.print(Coral + "South " + Default );
		if (Temp.East != null)
			System.out.print(Coral + "East " + Default);
		if (Temp.West != null)
			System.out.print(Coral + "West " + Default);

		System.out.println("");

		System.out.println(WhiteOnYellow +"Commands:"+ Default + Cyan +" n"+ Default + " = North, " + Cyan +"s"+ Default +" = South, " + Cyan +"e"+ Default +" = East, "
																				+ Cyan +"w"+ Default+ " = West, "+ Orange +"f"+ Default + " = Find shortest path");
		System.out.println("(Press " + Red +"'X'"+ Default +" to quit the game at any moment)");
		System.out.print(Orange +"Enter your choice: " + Default);
		Choice = in.next().charAt(0);
		if (Choice != 'X')
		{
			Choice = Character.toLowerCase(Choice);
		}
		//moving around rooms
		if (Choice == 's')
		{
			if(Temp.South == null)
				lastMessage = WhiteOnRed +"You cannot move that direction! Please enter a valid direction."+ Default;
			else
				Temp = Temp.South;  //move south
		}

		if (Choice == 'n')
		{
			if(Temp.North == null)
				lastMessage = WhiteOnRed +"You cannot move that direction! Please enter a valid direction."+ Default;
			else
				Temp = Temp.North;  //move east
		}

		if (Choice == 'e')
		{
			if(Temp.East == null)
				lastMessage = WhiteOnRed +"You cannot move that direction! Please enter a valid direction."+ Default;
			else
				Temp = Temp.East;  //move east
		}

		if (Choice == 'w')
		{
			if(Temp.West == null)
				lastMessage = WhiteOnRed +"You cannot move that direction! Please enter a valid direction."+ Default;
			else
				Temp = Temp.West;  //move west
		}

		if(Choice == 'f')
		{
			//ask user to destination
			//locate RoomName within Vertex Arraylist, and let the user know if not found
			//create a pointer to that destination element
			System.out.println(Yellow + "Enter the name of the destination room: " + Default );
			String destinationName = in.next();
			
			Room Destiny = null;
			for (int i = 0; i < Vertex.size(); i++)
			{
				if (Vertex.get(i).RoomName.equalsIgnoreCase(destinationName))
				{
					Destiny = Vertex.get(i);
					break;
				}
			}
			if(Destiny == null)
			{
				lastMessage = WhiteOnRed + "Room not found! Please enter a valid room." + Default;
			}
			else
			{
				Dijkstra(Temp, Destiny);
				System.out.println(Blue + "Shortest path: " + Default);
				for (int i = 0; i<Path.size(); i++)
					System.out.println(Path.get(i).RoomName + " ");
					System.out.println();
					System.out.println(WhiteOnBlue + "Press <Enter> to Continue" + Default);
					in.nextLine(); in.nextLine();
			}
    	}

		//Outro
		if (Choice == 'X')
		{
			System.out.println(CLS);
			System.out.println(SeaGreen +"The Game has been terminated. Thank you for playing the game. Hope that you have enjoyed it!!"+ Default);
			System.out.println("      ||||||||||||||	");
			System.out.println("     =              \\      	");
			System.out.println("     =               |	");
			System.out.println("    _=            ___/	");
			System.out.println("   / _\\           (o)\\	");
			System.out.println("  | | \\            _  \\	");
			System.out.println("  | |/            (____)	");
			System.out.println("   \\__/          /   |	");
			System.out.println("    /           /  ___)	");
			System.out.println("   /    \\       \\    _)                       )	");
			System.out.println("  \\      \\           /                       (	");
			System.out.println("\\/ \\      \\_________/   |\\_________________,_ )	");
			System.out.println(" \\/ \\      /            |     ==== _______)__)	- - - - " + Red + "BYE!!" + Default );
			System.out.println("  \\/ \\    /           __/___  ====_/	");
			System.out.println("   \\/ \\  /           (O____)\\\\_(_/	");
			System.out.println("                    (O_ ____)	");
			System.out.println("                     (O____)	");
		}

		if (Choice !='X' && Choice !='n' && Choice !='s' && Choice !='e' && Choice !='w')
		{
			lastMessage = WhiteOnRed + "Invalid input! Please enter a valid command from the options provided." + Default;
		}

    }


 }
    static void Dijkstra(Room Start, Room Finish)
	{
		// set distance to all rooms (except for Start) to 1000 and visited = false
		for (int i=0; i<Vertex.size(); i++)
		{
			if (Vertex.get(i) == Start)
				Vertex.get(i).Distance = 0;
			else
				Vertex.get(i).Distance = 1000;  // set distance to "infinity"
			Vertex.get(i).Visited = false;
		}
		// Do Dijkstra - find Distance to each room
		Room Temp = Start;
		while (!Finish.Visited)
		{
			Temp.Visited = true;
			if (Temp.North!=null && !Temp.North.Visited && Temp.North.Distance > Temp.Distance+1)
				Temp.North.Distance = 1 + Temp.Distance;
			if (Temp.South!=null && !Temp.South.Visited && Temp.South.Distance > Temp.Distance+1)
				Temp.South.Distance = 1 + Temp.Distance;
			if (Temp.East!=null && !Temp.East.Visited && Temp.East.Distance > Temp.Distance+1)
				Temp.East.Distance = 1 + Temp.Distance;
			if (Temp.West!=null && !Temp.West.Visited && Temp.West.Distance > Temp.Distance+1)
				Temp.West.Distance = 1 + Temp.Distance;

			int Smallest = 1000;
			int SmallestIndex = 0;
			for (int i=0; i<Vertex.size(); i++)
			{
				if (!Vertex.get(i).Visited && Vertex.get(i).Distance < Smallest)
				{
					Smallest = Vertex.get(i).Distance;
					SmallestIndex = i;
				}
			}
			Temp = Vertex.get(SmallestIndex);
		}

		// populate Path ArrayList with Rooms of shortest path
		Temp = Finish;
		Path.clear();
		Path.add(0,Finish);
		while (Temp != Start)
		{
			int N = 1000, S = 1000, E = 1000, W = 1000;
			if (Temp.North != null)  N = Temp.North.Distance;
			if (Temp.South != null)  S = Temp.South.Distance;
			if (Temp.East != null)  E = Temp.East.Distance;
			if (Temp.West != null)  W = Temp.West.Distance;
			if (N < S && N < E && N < W)
				Temp = Temp.North;
			else if (S < E && S < W)
				Temp = Temp.South;
			else if (E < W)
				Temp = Temp.East;
			else
				Temp = Temp.West;
			Path.add(0,Temp);
		}
	}
}

class Room
{
    String RoomName;
    Room North, South, East, West;
    boolean Visited;   // used for Dijkstra
    int Distance;      // used for Dijkstra

    Room (String theRoomName)
    {  RoomName = theRoomName;  }
}