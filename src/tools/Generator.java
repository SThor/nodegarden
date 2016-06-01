/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author silmathoron
 */
public class Generator {

    private static Random random = new Random();

    public static Color getRandomColor() {
        return new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
    }
    
    public static Color getTransparentColor(Color color, int alpha ) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
    }
    
    public static Color getRandomTransparentColor(int alpha ) {
        Color color = getRandomColor();
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
    }
}
