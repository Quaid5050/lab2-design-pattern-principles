package Practice.abstractFactory;
// Abstract Factory Interface for UI elements
interface UIAbstractFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Button Interface
interface Button {
    void render();
}

// Concrete Checkbox Interface
interface Checkbox {
    void render();
}

// Concrete Light Theme Button
class LightThemeButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Light Theme Button");
    }
}

// Concrete Light Theme Checkbox
class LightThemeCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Light Theme Checkbox");
    }
}

// Concrete Dark Theme Button
class DarkThemeButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Dark Theme Button");
    }
}

// Concrete Dark Theme Checkbox
class DarkThemeCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Dark Theme Checkbox");
    }
}

// Concrete Factory for Light Theme UI elements
class LightThemeFactory implements UIAbstractFactory {
    @Override
    public Button createButton() {
        return new LightThemeButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LightThemeCheckbox();
    }
}

// Concrete Factory for Dark Theme UI elements
class DarkThemeFactory implements UIAbstractFactory {
    @Override
    public Button createButton() {
        return new DarkThemeButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new DarkThemeCheckbox();
    }
}

//Factory producer
class FactoryProducer{
    public static UIAbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("LightTheme")){
            return new LightThemeFactory();
        }else if(choice.equalsIgnoreCase("DarkTheme")){
            return new DarkThemeFactory();
        }
        return null;
    }
}

// Client code using UI Abstract Factory
class Client {
    public static void main(String[] args) {
        UIAbstractFactory lightThemeFactory = FactoryProducer.getFactory("LightTheme");
        assert lightThemeFactory != null;
        Button lightThemeButton = lightThemeFactory.createButton();
        Checkbox lightThemeCheckbox = lightThemeFactory.createCheckbox();
        lightThemeButton.render();
        lightThemeCheckbox.render();

        UIAbstractFactory darkThemeFactory = FactoryProducer.getFactory("DarkTheme");
        assert darkThemeFactory != null;
        Button darkThemeButton = darkThemeFactory.createButton();
        Checkbox darkThemeCheckbox = darkThemeFactory.createCheckbox();
        darkThemeButton.render();
        darkThemeCheckbox.render();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        Client.main(args);
    }
}
