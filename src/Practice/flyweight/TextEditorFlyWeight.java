package Practice.flyweight;
import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface FontFlyweight {
    void render(String text);
}

// ConcreteFlyweight representing a font style
class ConcreteFontFlyweight implements FontFlyweight {
    private String fontName;
    private int fontSize;
    private String fontColor;

    public ConcreteFontFlyweight(String fontName, int fontSize, String fontColor) {
        this.fontName = fontName;
        this.fontSize = fontSize;
        this.fontColor = fontColor;
    }

    @Override
    public void render(String text) {
        System.out.println("Rendering text '" + text + "' in font: " +
                fontName + ", Size: " + fontSize + ", Color: " + fontColor);
    }
}

// Flyweight Factory for managing font styles
class FontFlyweightFactory {
    private Map<String, FontFlyweight> fonts = new HashMap<>();

    public FontFlyweight getFont(String key, String fontName, int fontSize, String fontColor) {
        String keyString = key + "_" + fontName + "_" + fontSize + "_" + fontColor;
        return fonts.computeIfAbsent(keyString, k -> new ConcreteFontFlyweight(fontName, fontSize, fontColor));
    }
}

// Client using the FontFlyweight pattern
class TextEditorClient {
    public static void main(String[] args) {
        FontFlyweightFactory fontFactory = new FontFlyweightFactory();

        // Text areas using shared font styles
        FontFlyweight font1 = fontFactory.getFont("Arial", "Arial", 12, "Black");
        font1.render("This is text in Arial font");

        FontFlyweight font2 = fontFactory.getFont("Arial", "Arial", 12, "Black");
        font2.render("This is another text in Arial font");

        // Text area using a unique font style
        FontFlyweight font3 = fontFactory.getFont("Times New Roman", "Times New Roman", 14, "Red");
        font3.render("This is text in Times New Roman font");
    }
}
public class TextEditorFlyWeight {
    public static void main(String[] args) {
        TextEditorClient.main(args);
    }
}

