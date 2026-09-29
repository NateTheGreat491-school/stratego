
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
   * Stratego: Pieces Helper Class 
   *
   * @author Nathan W. Barros (nwbarros@students.unwsp.edu)
   * @course COS 3271
   * @version 1.0.0
   */
 
public class Pieces {
    
    // ORDER:
    //      Spy, Scout, Miner, Sergant, Lieutenant,
    //      Captain, Major, Colonel, General, Marshal,
    //      Bomb, Flag
    public final String[] STYLES = {"standard", "hidden"};
    private final String[] STYLESDATA = {
        "S23456789MBF",
        "************",
    };

    public final  String[] COLORS     = {"red", "blue", "cyan", "green"};
    private final String   RESETCOLOR = "\033[0m";
    private final String[] COLORSDATA = {
        "\033[31m", // red
        "\033[34m", // blue
        "\033[36m", // cyan
        "\033[32m"  // green
    };

    private String[] configurations = {
        new String[40],
        new String[40], 
        new String[40]
    };

    private String activeStyle;
    private String activeColor;
    private String activeConfig;

    public Pieces() {

    };
    
    public void setStyle(String type) {}
    public void setColor(String color) {}
    public int getStyleIdx() {}
    public int getColorIdx() {}

    public String getActiveConfig() {}
    public void editConfig() {}
    public void selectConfig() {}
    public void showConfigs() {}

    private static String convertConfigStyle(String config, String style) {}

}

// EOF
