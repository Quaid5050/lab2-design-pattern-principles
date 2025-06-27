# Facade Pattern

## 📋 Overview

The **Facade Pattern** provides a simplified interface to a complex subsystem. It defines a higher-level interface that makes the subsystem easier to use by hiding the complexities of multiple classes and their interactions.

## 🎯 Intent

- Provide a simplified interface to a complex subsystem
- Hide the complexities of the subsystem from clients
- Promote loose coupling between subsystem and clients
- Define a single entry point to a subsystem

## 🏗️ Structure

### Key Components

1. **Facade** (`VideoConversionFacade.java`) - Simplified interface to the subsystem
2. **Subsystem Classes** - Complex classes that do the actual work
   - `VideoFile.java` - Represents video files
   - `CodecFactory.java` - Creates appropriate codecs
   - `BitrateReader.java` - Reads bitrate information
   - `AudioMixer.java` - Handles audio mixing
   - `MPEG4CompressionCodec.java`, `OggCompressionCodec.java` - Compression codecs
3. **Client** (`VideoConverter.java`) - Uses the facade interface

### Directory Structure

```
Facade/
└── ComplexMediaLibrary/
    ├── classes/
    │   ├── AudioMixer.java              # Audio processing
    │   ├── BitrateReader.java           # Bitrate reading
    │   ├── CodecFactory.java            # Codec creation
    │   ├── MPEG4CompressionCodec.java   # MPEG4 codec
    │   ├── OggCompressionCodec.java     # OGG codec
    │   └── VideoFile.java               # Video file handling
    ├── facadeController/
    │   └── VideoConversionFacade.java   # Facade class
    ├── interfaces/
    │   └── Codec.java                   # Codec interface
    └── mainClass/
        └── VideoConverter.java          # Client/Demo class
```

## 💡 Key Features

- **Simplified Interface** - Single, easy-to-use interface for complex operations
- **Subsystem Decoupling** - Clients don't need to know about subsystem classes
- **Reduced Dependencies** - Fewer dependencies for client code
- **Flexible Implementation** - Can change subsystem without affecting clients

## 🚀 Usage Example

```java
VideoConversionFacade converter = new VideoConversionFacade();

// Simple video conversion without knowing the complexity
File mp4File = converter.convertVideo("youtubevideo.ogg", "mp4");
System.out.println("Video converted successfully: " + mp4File.getName());

// Behind the scenes, the facade handles:
// 1. Video file loading
// 2. Codec factory creation
// 3. Bitrate reading
// 4. Audio mixing
// 5. Compression
// 6. File saving
```

**Output:**

```
VideoFile: Reading file youtubevideo.ogg
CodecFactory: Extracting OGG audio data...
BitrateReader: Reading bitrate for youtubevideo.ogg
AudioMixer: Fixing audio for youtubevideo.ogg
MPEG4CompressionCodec: Compressing video using MPEG4
VideoFile: Writing file result.mp4
Video converted successfully: result.mp4
```

## 🏃‍♂️ How to Run

```bash
# Navigate to the Facade directory
cd src/DesignPatterns/Facade/ComplexMediaLibrary/

# Compile all Java files
javac -cp . mainClass/*.java facadeController/*.java classes/*.java interfaces/*.java

# Run the demo
java mainClass.VideoConverter
```

## 📊 Benefits

### ✅ Advantages

- **Simplified Interface** - Easy-to-use interface for complex operations
- **Reduced Coupling** - Clients loosely coupled with subsystem
- **Improved Maintainability** - Changes in subsystem don't affect clients
- **Better Organization** - Clear separation between interface and implementation
- **Easier Testing** - Can mock the facade for testing

### ❌ Disadvantages

- **Limited Functionality** - May not expose all subsystem capabilities
- **Additional Layer** - Adds another layer of abstraction
- **Potential Bottleneck** - All requests go through facade
- **God Object Risk** - Facade might become too complex

## 🎨 Real-World Applications

1. **Operating System APIs** - Simplified OS interfaces (Windows API, POSIX)
2. **Database Access** - ORM frameworks hiding SQL complexity
3. **Web Services** - REST APIs hiding business logic complexity
4. **Compiler Interfaces** - Simplified compilation process
5. **Payment Processing** - Payment gateway APIs
6. **Email Systems** - Email libraries hiding SMTP/POP3 complexity

## 🔄 Related Patterns

- **Adapter** - Changes interface; Facade simplifies interface
- **Mediator** - Defines communication; Facade defines simplified interface
- **Singleton** - Facade is often implemented as Singleton
- **Abstract Factory** - Can be used together to create subsystem objects

## 📝 Implementation Details

### VideoConversionFacade (Facade)

```java
public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");

        // Step 1: Load video file
        VideoFile file = new VideoFile(fileName);

        // Step 2: Create appropriate codec
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }

        // Step 3: Read bitrate
        BitrateReader reader = new BitrateReader();
        reader.read(file, sourceCodec);

        // Step 4: Mix audio
        AudioMixer mixer = new AudioMixer();
        mixer.fix(file);

        // Step 5: Compress and save
        File result = destinationCodec.compress(file, format);

        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}
```

### Subsystem Classes

Each subsystem class handles a specific aspect:

- **VideoFile** - File I/O operations
- **CodecFactory** - Codec selection logic
- **BitrateReader** - Technical file analysis
- **AudioMixer** - Audio processing
- **Compression Codecs** - Video compression algorithms

## 🔍 Key Design Decisions

1. **Single Responsibility** - Each subsystem class has one job
2. **Factory Pattern** - CodecFactory creates appropriate codecs
3. **Interface Segregation** - Clean Codec interface
4. **Encapsulation** - All complexity hidden behind facade

## 🎯 When to Use

- **Complex Subsystem** - When you have a complex set of classes
- **Multiple Integration Points** - When clients need to interact with many classes
- **Layered Architecture** - When you want to create layers in your system
- **Legacy Integration** - When wrapping legacy or third-party systems

## 🚨 Common Pitfalls

- **Oversimplification** - Don't hide too much useful functionality
- **God Object** - Don't make facade do everything
- **Tight Coupling** - Facade shouldn't be tightly coupled to all subsystem classes
- **Static Methods** - Avoid making facade purely static (harder to test)

## 🔧 Best Practices

1. **Keep It Simple** - Facade should simplify, not complicate
2. **Single Purpose** - Each facade should serve one major use case
3. **Composition Over Inheritance** - Use composition to access subsystem
4. **Interface Definition** - Define clear interface for facade
5. **Documentation** - Document what the facade hides and exposes

## 🎪 Pattern Variations

### Layered Facade

```java
// Application Layer Facade
public class ApplicationFacade {
    private BusinessFacade businessFacade;
    private DataFacade dataFacade;
}

// Business Layer Facade
public class BusinessFacade {
    private ValidationService validator;
    private CalculationService calculator;
}
```

### Facade with Factory

```java
public class MediaFacadeFactory {
    public static MediaFacade createVideoFacade() {
        return new VideoConversionFacade();
    }

    public static MediaFacade createAudioFacade() {
        return new AudioConversionFacade();
    }
}
```

### Configurable Facade

```java
public class ConfigurableVideoFacade {
    private Configuration config;

    public File convertVideo(String fileName, String format, Configuration config) {
        this.config = config;
        // Use config to customize behavior
    }
}
```

## 💼 Business Benefits

- **Reduced Development Time** - Simpler API reduces learning curve
- **Lower Maintenance Cost** - Changes isolated to subsystem
- **Better User Experience** - Easier to use APIs
- **Reduced Training** - Developers need to learn fewer APIs

## 🔍 Advanced Features

### Error Handling

```java
public class VideoConversionFacade {
    public Result<File> convertVideo(String fileName, String format) {
        try {
            // Conversion logic with proper error handling
            return Result.success(convertedFile);
        } catch (Exception e) {
            return Result.failure("Conversion failed: " + e.getMessage());
        }
    }
}
```

### Asynchronous Operations

```java
public class AsyncVideoFacade {
    public CompletableFuture<File> convertVideoAsync(String fileName, String format) {
        return CompletableFuture.supplyAsync(() -> {
            return convertVideo(fileName, format);
        });
    }
}
```

---

**Category**: Structural Pattern  
**Complexity**: ⭐⭐  
**Popularity**: ⭐⭐⭐⭐⭐
