  /*                                                                                                                                                                                                                
   * Copyright (c) 2026 Nathan William Barros. All rights reserved.
   *
   * Licensed under the MIT License (the "License");
   * you may not use this file except in compliance with the License.
   * You may obtain a copy of the License at
   *
   *    https://opensource.org/licenses/MIT
   *    OR
   *    see repo LICENSE
   */
  
  /**
   * Final Project: CLI Statego Game
   *
   * @author Nathan W. Barros (nwbarros@students.unwsp.edu)
   * @course COS 3271
   * @version 1.0.0
   */
  
public class Stratego {

    private static Scanner userin = new Scanner(System.in);

    private stats = new Stats(Utility.SAVEFILE);

    public static void main() {
        
        while (true) {

            showHome();

            String response = userin.nextLine();
            System.out.print("\n\n");
            
            switch (response.toLowercase()) {
                case "p", "1" -> playGame();
                case "e", "2" -> editConfig();
                case "v", "3" -> showStats();
                case "r", "4" -> ruleViewer();
                case "s", "5" -> editSettings();
                case "q"      -> Utility.handleExit();
                default       -> Utility.showWarning("Invalid Selection!");
            }

            userin.nextLine();
        }
    } 

    private void editConfig() {}
    
    private void editSettings() {

        String menuTemplate = """
            [M]ap: %s

            [P]ieces:
                player [1] -> %s
                player [2] -> %s

            [C]olor:
                player [1] -> %s
                player [2] -> %s

            Examples:
            ------------------------------------------------------
                m standard   = set map to standard
                p 2 standard = set player 2 pieces to standard
                c 1 blue     = set player 1 color to blue

             : 
            """;
    
        while (true) {
            Utility.showBanner("b=back");
            System.out.printf(
                menuTemplate,
                Utility.markStrArrayItem( "[]", this.board.activeMapIdx ),
                Utility.markStrArrayItem( "[]", this.player1.activeStyleIdx ),
                Utility.markStrArrayItem( "[]", this.player2.activeStyleIdx ),
                Utility.markStrArrayItem( "[]", this.player1.activeColorIdx ),
                Utility.markStrArrayItem( "[]", this.player2.activeColorIdx)
            );
            

            // [command] [map type || player] [color || style]
            String[] response = userin.nextLine().trim().toLowerCase();
            System.out.print("\n\n");
            
            // check for no input
            if (input.isEmpty()) {
                Utility.showWarning("Invalid Selection!");
                continue;
            }
            
            // ensure there is at least 2 strings
            String[] parts = input.split("\\s+");
            if (parts.length < 2) {
                Utility.showWarning("Invalid Selection!");
                continue
            }
            
            String command = parts[0];

            switch (command) {
                case "m", "map"   -> this.board.setMapType(parts[1]);
                case "p", "piece" -> parseSettingsCommand(parts, "style"); 
                case "c", "color" -> parseSettingsCommand(parts, "color");
                case "b", "back"  -> return;
                case "q", "quit"  -> Utility.handleExit();
                default -> Utility.showWarning("Invalid Selection!");
            }
        }
    }
    
    /*
     * called in editSettings(): changes player 1||2  color && style
     *
     * @param parts = {player, selection}
     * @param type  = color || style
     */
    private void parseSettingsCommand(String[] parts, String type) {
        if (parts.length < 3) {
            Utility.showWarning("Invalid Selection!");
            return;
        }
        
        // handle player
        Player target = switch (parts[1]) {
            case "1" -> this.player1;
            case "2" -> this.player2;
            default  -> {Utility.showWarning("Invalid Selection!"); return;}
        }

        if ("style".equals(type)) {
            target.setStyle(parts[2]);
        } else if ("color".equals(type)) {
            target.setColor(parts[2]);
        }
    }
    
    private static void showStats() {
        System.out.printf(
            "Total Games: %d\n"+
            "    p1 wins: %d\n"+
            "    p2 wins: %d\n"+
            "      draws: %d\n\n"+

            "Captures Made: %d\n"+
            "Bombs Defused: %d\n"+
            "Marshalls KIA: %d\n\n"+

            "Time Played: %s\n"+
            "[return to home]",
            stats.gameCount, stats.p1WinCount,
            stats.p2WinCount, stats.drawCount,
            stats.captureCount, stats.defuseCount,
            stats.marshallBodyCount,
            Utility.getStrTime(stats.secondsPlayed)
        );
    }

    private static void showHome() {
        Utility.showBanner();
        System.out.print(
            "Options:\n"+
            "-----------------------\n"+
            "    1. [P]lay Game\n"+
            "    2. [E]dit Configs\n"+
            "    3. [V]iew Stats\n"+
            "    4. [R]ules\n"+
            "    5. [S]ettings\n\n"+

            " : "
        );
    }

    private static void ruleViewer() {
        
        while (true) {
            Utility.showBanner("b=back;");
            System.out.print(
                "RuleBook\n"+
                "----------------------\n"+
                "    1. [M]ovement & Captures\n"+
                "    2. [P]iece Overview\n"+
                "    3. [O]bjectives\n"+
                "    4. [H]istory\n\n"+

                " : "
            );

            String response = userin.nextLine();
            System.out.print("\n\n");

            switch (response.toLowerCase()) {
                case "m", "1" -> showMovementRules();
                case "p", "2" -> showPieceOverview();
                case "o", "3" -> showGameObjective();
                case "h", "4" -> showHistoryOfGame();
                case "b"      -> return;
                case "q"      -> Utility.handleExit();
                default       -> Utility.showWarning("Invalid Selection!");
            }
            
            System.out.print("[continue]");
            userin.nextLine();
        }   
    }

    private static void showMovementRules() {}

    private static void showPieceOverview() {}

    private static void showGameObjective() {}

    private static void showHistoryOfGame() {}
}

// EOF
