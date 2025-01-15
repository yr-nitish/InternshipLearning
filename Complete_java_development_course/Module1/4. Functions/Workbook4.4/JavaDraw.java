import java.util.Scanner;

public class JavaDraw {
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        int choice;

        System.out.println("Which animal would you like to draw?\n");
        System.out.println("1. for Butterfly");
        System.out.println("2. for Elephant");
        System.out.println("3. for Teddy Bear");
        System.out.println("4. for Snake");

        choice=sc.nextInt();
        draw(choice);     
        sc.close();
    }


    /**
     * Function name: draw
     * @param choice
     * 
     * Inside the function:
     * 1. Based on the choice, draw the selected figure:
     *      1. Butterfly
     *      2. Elephant
     *      3. Bear
     *      4. Snake
     */
    public static void draw(int choice)
    {
        switch (choice) {
            case 1:
            System.out.println("  .==-.                   .-==.     ");
            System.out.println("   \\()8`-._  `.   .'  _.-'8()/     ");
            System.out.println("   (88\"   ::.  \\./  .::   \"88)     ");
            System.out.println("    \\_.'`-::::.(#).::::-'`._/      ");
            System.out.println("      `._... .q(_)p. ..._.'         ");
            System.out.println("        \"\"-..-'|=|`-..-\"\"       ");
            System.out.println("        .\"\"' .'|=|`. `\"\".       ");
            System.out.println("      ,':8(o)./|=|\\.(o)8:`.        ");
            System.out.println("     (O :8 ::/ \\_/ \\:: 8: O)      ");
            System.out.println("      \\O `::/       \\::' O/       ");
            System.out.println("       \"\"--'         `--\"\"      ");
            break;
            case 2:
            System.out.println("       _..--\"\"-.                  .-\"\"--.._ ");
            System.out.println("   _.-'         \\ __...----...__ /         '-._");
            System.out.println(" .'      .:::...,'              ',...:::.      '.");
            System.out.println("(     .'``'''::;                  ;::'''``'.     )");
            System.out.println(" \\             '-)              (-'             /");
            System.out.println("  \\             /                \\             /");
            System.out.println("   \\          .'.-.            .-.'.          /");
            System.out.println("    \\         | \\0|            |0/ |         /");
            System.out.println("    |          \\  |   .-==-.   |  /          |");
            System.out.println("     \\          `/`;          ;`\\`          /");
            System.out.println("      '.._      (_ |  .-==-.  | _)      _..'");
            System.out.println("          `\"`\"-`/ `/'        '\\` \\`-\"`\"`");
            System.out.println("               / /`;   .==.   ;`\\ \\");
            System.out.println("         .---./_/   \\  .==.  /   \\ \\");
            System.out.println("        / '.    `-.__)       |    `\"");
            System.out.println("       | =(`-.        '==.   ;");
            System.out.println("        \\  '. `-.           /");
            System.out.println("         \\_:_)   `\"--.....-'");
            break;
            case 3:
            System.out.println("            ___   .--. ");
            System.out.println("      .--.-\"   \"-' .- |");
            System.out.println("     / .-,`          .'");
            System.out.println("     \\   `           \\");
            System.out.println("      '.            ! \\");
            System.out.println("        |     !  .--.  |");
            System.out.println("        \\        '--'  /.____");
            System.out.println("       /`-.     \\__,'.'      `\\");
            System.out.println("    __/   \\`-.____.-' `\\      /");
            System.out.println("    | `---`'-'._/-`     \\----'    _");
            System.out.println("    |,-'`  /             |    _.-' `\\");
            System.out.println("   .'     /              |--'`     / |");
            System.out.println("  /      /\\              `         | |");
            System.out.println("  |   .\\/  \\      .--. __          \\ |");
            System.out.println("   '-'      '._       /  `\\         /");
            System.out.println("               `\\    '     |------'`");
            System.out.println("                 \\  |      |");
            System.out.println("                  \\        /");
            System.out.println("                   '._  _.'");
            System.out.println("                      ``");
            break;    
            case 4:
            System.out.println("         ,,'6''-,.");
            System.out.println("        <====,.;;--.");
            System.out.println("        _`---===. \"\"\"==__");
            System.out.println("      //\"\"@@-\\===\\@@@@ \"\"\\\\");
            System.out.println("     |( @@@  |===|  @@@  ||");
            System.out.println("      \\\\ @@   |===|  @@  //");
            System.out.println("        \\\\ @@ |===|@@@ //");
            System.out.println("         \\\\  |===|  //");
            System.out.println("___________\\\\|===| //_____,----\"\"\"\"\"\"\"\"\"\"-----,_");
            System.out.println("  \"\"\"\"---,__`\\===`/ _________,---------,____    `,");
            System.out.println("             |==||                           `\\   \\");
            System.out.println("            |==| |                             )   |");
            System.out.println("           |==| |       _____         ______,--'   '");
            System.out.println("           |=|  `----\"\"\"     `\"\"\"\"\"\"\"\"         _,-'");
            System.out.println("            `=\\     __,---\"\"\"-------------\"\"\"''");
            System.out.println("                \"\"\"\"		");
            break;
            default: break;
        } 
    }
}
