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
   * Assignment 4a: Standalone Person Info App
   *
   * @author Nathan W. Barros (nwbarros@students.unwsp.edu)
   * @course COS 3271
   * @version 1.1.0
   */
  
public class Stratego {

    private static Scanner userin = new Scanner(System.in);

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
    
    private void editSettings() {}

    private static void showStats() {}

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
                case "o", "3" -> showGameObjectives();
                case "h", "4" -> showHistoryOfStratego();
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

    private static void showGameObjectives() {}

    private static void showHistoryOfStratego() {}
}

// EOF
