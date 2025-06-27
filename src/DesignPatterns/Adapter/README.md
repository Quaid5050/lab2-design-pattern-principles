# Adapter Pattern

## 📋 Overview

The **Adapter Pattern** allows incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces by wrapping an existing class with a new interface.

## 🎯 Intent

- Allow incompatible interfaces to work together
- Wrap an existing class with a new interface
- Convert one interface to another that clients expect
- Enable classes to work together that couldn't otherwise due to incompatible interfaces

## 🏗️ Structure

### Key Components

1. **Target Interface** (`MediaPlayer.java`) - The interface that client expects
2. **Adaptee** (`AdvanceMediaPlayer.java`) - The existing interface that needs adapting
3. **Adapter** (`MediaAdapter.java`) - Implements target interface and wraps adaptee
4. **Client** (`AudioPlayer.java`) - Uses the target interface
5. **Concrete Adaptees** (`Mp4Player.java`, `VlcPlayer.java`, `WmaPlayer.java`) - Specific implementations

### Directory Structure

```
Adapter/
├── interfaces/
│   ├── MediaPlayer.java          # Target interface
│   └── AdvanceMediaPlayer.java   # Adaptee interface
├── adapterClasses/
│   ├── AudioPlayer.java          # Client class
│   └── MediaAdapter.java         # Adapter class
├── classes/
│   ├── MP3Player.java            # Default implementation
│   ├── Mp4Player.java            # Adaptee 1
│   ├── VlcPlayer.java            # Adaptee 2
│   └── WmaPlayer.java            # Adaptee 3
└── mainClass/
    └── AdapterDesignPatternDemo.java  # Demo class
```

## 💡 Key Features

- **Interface Compatibility** - Makes incompatible interfaces work together
- **Wrapper Functionality** - Wraps existing functionality with new interface
- **Transparent Integration** - Client doesn't know about adaptation
- **Multiple Format Support** - Handle different media formats seamlessly

## 🚀 Usage Example

```java
AudioPlayer audioPlayer = new AudioPlayer();

// Play MP3 (native support)
audioPlayer.play("mp3", "beyond_the_horizon.mp3");

// Play MP4 (via adapter)
audioPlayer.play("mp4", "alone.mp4");

// Play VLC (via adapter)
audioPlayer.play("vlc", "far_far_away.vlc");

// Play WMA (via adapter)
audioPlayer.play("wma", "mind_me.wma");

// Unsupported format
audioPlayer.play("avi", "mind_me.avi");
```

**Output:**

```
Playing mp3 file. Name: beyond_the_horizon.mp3
Playing mp4 file. Name: alone.mp4
Playing vlc file. Name: far_far_away.vlc
Playing wma file. Name: mind_me.wma
avi format not supported
```

## 🏃‍♂️ How to Run

```bash
# Navigate to the Adapter directory
cd src/DesignPatterns/Adapter/

# Compile all Java files
javac -cp . mainClass/*.java adapterClasses/*.java classes/*.java interfaces/*.java

# Run the demo
java mainClass.AdapterDesignPatternDemo
```

## 📊 Benefits

### ✅ Advantages

- **Reusability** - Reuse existing classes with incompatible interfaces
- **Separation of Concerns** - Business logic separated from interface conversion
- **Open/Closed Principle** - Add new adapters without modifying existing code
- **Multiple Adaptees** - Single adapter can work with multiple adaptees
- **Transparent Integration** - Client code remains unchanged

### ❌ Disadvantages

- **Code Complexity** - Additional layer of abstraction
- **Performance Overhead** - Extra method calls through adapter
- **Maintenance** - More classes to maintain
- **Design Complexity** - Can make overall design more complex

## 🎨 Real-World Applications

1. **Media Players** - Support for different audio/video formats
2. **Database Drivers** - Different database APIs with common interface
3. **Payment Gateways** - Different payment providers with unified interface
4. **Third-party Libraries** - Integrate external libraries with different interfaces
5. **Legacy System Integration** - Make old systems work with new interfaces
6. **API Wrappers** - Wrap REST APIs with different interfaces

## 🔄 Related Patterns

- **Bridge** - Adapter connects after design; Bridge connects during design
- **Decorator** - Adds behavior; Adapter changes interface
- **Facade** - Simplifies interface; Adapter makes incompatible interfaces compatible
- **Proxy** - Same interface; Adapter provides different interface

## 📝 Implementation Details

### MediaPlayer Interface (Target)

```java
public interface MediaPlayer {
    public void play(String audioType, String fileName);
}
```

### AdvanceMediaPlayer Interface (Adaptee)

```java
public interface AdvanceMediaPlayer {
    public void playVlc(String fileName);
    public void playMp4(String fileName);
    public void playWma(String fileName);
}
```

### MediaAdapter Class (Adapter)

```java
public class MediaAdapter implements MediaPlayer {
    AdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advanceMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advanceMediaPlayer = new Mp4Player();
        } else if (audioType.equalsIgnoreCase("wma")) {
            advanceMediaPlayer = new WmaPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advanceMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advanceMediaPlayer.playMp4(fileName);
        } else if (audioType.equalsIgnoreCase("wma")) {
            advanceMediaPlayer.playWma(fileName);
        }
    }
}
```

## 🔍 Key Implementation Features

- **Format Detection** - Automatically detects and handles different formats
- **Dynamic Adaptation** - Creates appropriate adaptee based on format
- **Error Handling** - Graceful handling of unsupported formats
- **Extensibility** - Easy to add new format support

## 🎯 When to Use

- **Interface Incompatibility** - When you need to use a class with incompatible interface
- **Legacy Integration** - Integrating legacy code with new systems
- **Third-party Libraries** - When third-party library has different interface
- **Multiple Implementations** - When you have multiple implementations with different interfaces

## 🚨 Common Pitfalls

- **Over-adaptation** - Don't adapt when simple inheritance/composition would work
- **Performance** - Be aware of performance impact of additional layers
- **Complex Adapters** - Keep adapters simple and focused
- **Interface Bloat** - Don't create overly complex target interfaces

## 🔧 Best Practices

1. **Keep Adapters Simple** - Focus on interface conversion only
2. **Single Responsibility** - Each adapter should handle one type of adaptation
3. **Error Handling** - Provide proper error handling for unsupported operations
4. **Documentation** - Document what interfaces are being adapted
5. **Testing** - Test all supported format conversions

## 🎪 Pattern Variations

### Object Adapter (Composition)

- Uses composition to wrap adaptee
- More flexible, can adapt multiple classes
- Used in this implementation

### Class Adapter (Inheritance)

- Uses inheritance to adapt interface
- Can only adapt one class
- Not possible in Java (single inheritance)

### Two-way Adapter

- Implements both target and adaptee interfaces
- Allows objects to be used in both systems

## 💼 Business Benefits

- **Cost Reduction** - Reuse existing code instead of rewriting
- **Time Savings** - Faster integration of existing components
- **Risk Mitigation** - Avoid changing working legacy code
- **Flexibility** - Support multiple formats/interfaces simultaneously

---

**Category**: Structural Pattern  
**Complexity**: ⭐⭐  
**Popularity**: ⭐⭐⭐⭐⭐
