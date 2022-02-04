package moontreasure;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room rooms[];
    private Thing things[];
    private Player player;
    private Wall walls[];
    private Water waters[];

    public Game() {
    }
    public void initGame(){
        things = new Thing[8];
        walls = new Wall[4];
        waters = new Water[10];
        rooms = new Room[16];

        for(int i =0 ;i< 4 ;i++)
            walls[i] = new Wall();

        for(int i =0 ;i< 10 ;i++)
            waters[i] = new Water();


        things[0] = new Thing("Gold", "A gold is hidden in this room");
        things[1] = new Thing("Silver", "A Silver is hidden in this room");
        things[2] = new Thing("Diamond", "Diamond is hidden in this room");
        things[3] = new Thing("Food",   "Food for Health");
        things[4] = new Thing("Junk", "Useless item");
        things[5] = new Thing("Compass", "A compass to navigate");
        things[6] = new Thing("Locked Item", "unknown item");


        rooms[0] = new Room("Cave","Cave contains 2 Golds and pick up items command");
        rooms[0].addObject(things[0]);
        rooms[0].addObject(things[0]);



        rooms[1] = new Room("desert","no items here");
        rooms[2] = new Room("Beach","Beach pick up items");
        rooms[3] = new Room("Boat","Boat pick up items and start position");

        rooms[4] = new Room("Cave","Cave contains pick up items and Army");
        rooms[4].addObject(things[4]);

        rooms[5] = new Room("Tree house","Tree house contains pick up items and Compass");
        rooms[5].addObject(things[1]);

        rooms[6] = new Room("New Island","New island contains pick up items, Reqruired command,Gold and Compass");
        rooms[6].addObject(things[0]);
        rooms[6].addObject(things[5]);

        rooms[7] = new Room("Country","Country contains pick up items, Reqruired command,Silver and Diamond");
        rooms[7].addObject(things[1]);
        rooms[7].addObject(things[2]);

        rooms[8] = new Room("City","The city contains pick up items, Reqruired command,Food and Diamond");
        rooms[8].addObject(things[3]);
        rooms[8].addObject(things[2]);

        rooms[9] = new Room("Town","Town contains pick up items, Reqruired command,locked item and 2 Diamond");
        rooms[9].addObject(things[6]);
        rooms[9].addObject(things[2]);
        rooms[9].addObject(things[2]);

        rooms[10] = new Room("City 2","City 2 contains pick up items and Food");
        rooms[10].addObject(things[3]);

        rooms[11] = new Room("Village","Village contains pick up items, Gold and Food");
        rooms[11].addObject(things[2]);
        rooms[11].addObject(things[3]);

        rooms[12] = new Room("Motorway","Motorway contains pick up items, Gold and Food");
        rooms[12].addObject(things[0]);
        rooms[12].addObject(things[2]);

        rooms[13] = new Room("Gate","Gate contains pick up items, Gold and Food");
        rooms[13].addObject(things[2]);


        rooms[14] = new Room("Capital City","Capital City contains pick up items,Items required,Gold and Compass");
        rooms[14].addObject(things[2]);
        rooms[14].addObject(things[3]);

        rooms[15] = new Room("Castle(You win!)","Castle(End) and items required Diamond ,Gold, and Compass");
        rooms[15].addObject(things[1]);
        rooms[15].addObject(things[2]);
        rooms[15].addObject(things[4]);


        //maping wall direction

        walls[0].addDirection("east", walls[1]);
        walls[0].addDirection("south", rooms[0]);

        walls[1].addDirection("east", walls[2]);
        walls[1].addDirection("south", rooms[1]);
        walls[1].addDirection("west", walls[0]);

        walls[2].addDirection("east", walls[3]);
        walls[2].addDirection("south", waters[2]);
        walls[2].addDirection("west", walls[1]);

        walls[3].addDirection("east", waters[4]);
        walls[3].addDirection("south", waters[3]);
        walls[3].addDirection("west", walls[2]);


        //maping waters direction
        waters[0].addDirection("east", waters[1]);
        waters[0].addDirection("south", waters[4]);
        waters[0].addDirection("west", walls[3]);

        waters[1].addDirection("south", rooms[2]);
        waters[1].addDirection("west", waters[0]);

        waters[2].addDirection("east", waters[3]);
        waters[2].addDirection("west", rooms[1]);
        waters[2].addDirection("north", walls[2]);
        waters[2].addDirection("south", rooms[5]);

        waters[3].addDirection("east", waters[4]);
        waters[3].addDirection("west", waters[2]);
        waters[3].addDirection("north", walls[3]);
        waters[3].addDirection("south", waters[5]);

        waters[4].addDirection("east", rooms[2]);
        waters[4].addDirection("west", waters[3]);
        waters[4].addDirection("north", waters[0]);
        waters[4].addDirection("south", rooms[6]);

        waters[5].addDirection("east", rooms[6]);
        waters[5].addDirection("west", rooms[5]);
        waters[5].addDirection("north", waters[3]);
        waters[5].addDirection("south", rooms[10]);

        waters[6].addDirection("east", rooms[10]);
        waters[6].addDirection("west", rooms[9]);
        waters[6].addDirection("north", rooms[5]);
        waters[6].addDirection("south", waters[7]);

        waters[7].addDirection("east", rooms[15]);
        waters[7].addDirection("west", rooms[14]);
        waters[7].addDirection("north", waters[6]);

        waters[8].addDirection("east", waters[9]);
        waters[8].addDirection("west", rooms[15]);
        waters[8].addDirection("north", rooms[11]);

        waters[9].addDirection("west", waters[8]);
        waters[9].addDirection("north", rooms[12]);


        //maping rooms direction
        rooms[0].addDirection("east", rooms[1]);
        rooms[0].addDirection("north",walls[0]);
        rooms[0].addDirection("south",rooms[3]);


        rooms[1].addDirection("east",waters[2]);
        rooms[1].addDirection("west",rooms[0]);
        rooms[1].addDirection("north",walls[1]);
        rooms[1].addDirection("south",rooms[4]);

        rooms[2].addDirection("west",waters[4]);
        rooms[2].addDirection("north",waters[1]);
        rooms[2].addDirection("south",rooms[7]);

        rooms[3].addDirection("east",rooms[4]);
        rooms[3].addDirection("north",rooms[0]);
        rooms[3].addDirection("south",rooms[8]);

        rooms[4].addDirection("east",rooms[5]);
        rooms[4].addDirection("west",rooms[3]);
        rooms[4].addDirection("north",rooms[1]);
        rooms[4].addDirection("south",rooms[9]);

        rooms[5].addDirection("east",waters[5]);
        rooms[5].addDirection("west",rooms[4]);
        rooms[5].addDirection("north",waters[2]);
        rooms[5].addDirection("south",waters[6]);

        rooms[6].addDirection("east",rooms[7]);
        rooms[6].addDirection("west",waters[5]);
        rooms[6].addDirection("north",waters[4]);
        rooms[6].addDirection("south",rooms[11]);

        rooms[7].addDirection("west",rooms[6]);
        rooms[7].addDirection("north",rooms[2]);
        rooms[7].addDirection("south",rooms[12]);

        rooms[8].addDirection("east",rooms[9]);
        rooms[8].addDirection("north",rooms[3]);
        rooms[8].addDirection("south",rooms[13]);

        rooms[9].addDirection("east",waters[6]);
        rooms[9].addDirection("west",rooms[8]);
        rooms[9].addDirection("north",rooms[4]);
        rooms[9].addDirection("south",rooms[14]);

        rooms[10].addDirection("east",rooms[11]);
        rooms[10].addDirection("west",waters[5]);
        rooms[10].addDirection("north",waters[6]);
        rooms[10].addDirection("south",rooms[15]);

        rooms[11].addDirection("east",rooms[12]);
        rooms[11].addDirection("west",rooms[6]);
        rooms[11].addDirection("north",rooms[10]);
        rooms[11].addDirection("south",waters[8]);

        rooms[12].addDirection("west",rooms[11]);
        rooms[12].addDirection("north",rooms[7]);
        rooms[12].addDirection("south",waters[9]);

        rooms[13].addDirection("east",rooms[14]);
        rooms[13].addDirection("north",rooms[8]);

        rooms[14].addDirection("east",waters[7]);
        rooms[14].addDirection("west",rooms[13]);
        rooms[14].addDirection("north",rooms[9]);


        rooms[15].addDirection("east",waters[8]);
        rooms[15].addDirection("west",waters[7]);
        rooms[15].addDirection("north",rooms[10]);

        player = new Player(rooms[6],null,0);
    }
    public void startGame(){
        initGame();
        Scanner input = new Scanner(System.in);
        String cmd;
        Location currentLoc ,newLoc= null;
        int takeThing;

        boolean b = false;
        do{
            currentLoc = player.getLocation();
            showHelpMenu();
            cmd = input.next();
            if(cmd.equalsIgnoreCase("Go")){
                do {
                    System.out.println("Current Location : "+ currentLoc);
                    System.out.println("Choose direction:");
                    System.out.println("one of north, south, east, west");
                    String direc = input.next();

                    b = checkPathExist(direc,currentLoc);
                    if(b) {
                        newLoc = playerNextLocation(direc,currentLoc);
                        player.setLocation((Room) newLoc);
                    }

                    else {
                        System.out.println("Here is Water or Wall");
                        System.out.println("You can't Move to this direction");
                    }
                }while(b==false);
            }
            else if(cmd.equalsIgnoreCase("Look")){
                if(currentLoc instanceof Room)
                    ((Room) currentLoc).viewRoomContent();
                player.viewPlayerInventory();
            }
            else if(cmd.equalsIgnoreCase("Take")){
                if(currentLoc instanceof Room) {
                    ((Room) currentLoc).viewRoomContent();
                    System.out.println("Take the thing 0/1/2/3 .. from the room : ");
                    takeThing = Integer.parseInt(input.next());
                    Thing t = ((Room) currentLoc).getRoomItem(takeThing);
                    player.take(t);
                    player.viewPlayerInventory();
                }

            }
            else if(cmd.equalsIgnoreCase("Drop")){
                player.viewPlayerInventory();
                System.out.println("Drop the thing 0/1/2/3 .. from the Inventory to room : ");
                takeThing = Integer.parseInt(input.next());
                if(currentLoc instanceof Room) {
                    Thing t =player.getInventoryItem(takeThing);
                    ((Room) currentLoc).addObject(t);
                    ((Room) currentLoc).viewRoomContent();
                }

            }
            else if(cmd.equalsIgnoreCase("Use")){
                player.viewPlayerInventory();
                System.out.println("Use the thing 0/1/2/3 .. from the Inventory : ");
                takeThing = Integer.parseInt(input.next());
                Thing t =player.getInventoryItem(takeThing);
                player.drop(t);
            }
            else if(cmd.equalsIgnoreCase("Exit")){
                System.exit(0);
            }
            else{
                System.out.println("Invalid command");
            }

        }while(true);

    }
    public void showHelpMenu() {
        System.out.println("Choose command: ");
        System.out.println("Go");
        System.out.println("Look");
        System.out.println("Take");
        System.out.println("Drop");
        System.out.println("Use");
        System.out.println("Exit ");
        System.out.println();
    }

    public boolean checkPathExist(String path , Location loc) {

        HashMap<String ,Location> hm = loc.getRoomDir();
        if(hm.containsKey(path)) {
            if(hm.get(path) instanceof Room)
                return true;
        }
        return false;
    }

    public Location playerNextLocation(String path , Location loc) {

        HashMap<String ,Location> hm = loc.getRoomDir();
        if(hm.containsKey(path)) {
            if(hm.get(path) instanceof Room)
                return hm.get(path);
        }
        return loc;

    }
}