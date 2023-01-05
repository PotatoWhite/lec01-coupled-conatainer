# Lecture 01 - Section 01 : Tightly Coupled 
- Steam Launcher 가 Game을 실행하는 상황을 가정하여 표현한다면 다음과 같다.

### Assassin's Creed
```java
public class AssassinsCreed {
    public void launch() {
        this.loadGame();
        this.keyUp();
        this.keyDown();
        this.keyLeft();
        this.keyRight();
    }

    private void loadGame() {System.out.println("Loading Assassins Creed...");}

    private void keyUp() {System.out.println("Move forward...");}

    private void keyDown() {System.out.println("Move backward...");}

    private void keyLeft() {System.out.println("Move left...");}

    private void keyRight() {System.out.println("Key right...");}
}
```

### Steam Launcher
```java
public class Steam {
    public void launchGame(AssassinsCreed assassinsCreed) {
        assassinsCreed.launch();
    }
}
```

- 위의 상황에서 Steam Launcher 가 Game 을 실행하는 것을 명시적으로 알고 있다.
- 만일 새로운 게임인 Counter Strike 를 추가하고 싶다면, Steam Launcher 에서 Counter Strike 를 실행하는 코드를 추가해야 한다.

### Counter Strike
```java
public class CounterStrike {
    public void launch() {
        this.loadGame();
        this.keyUp();
        this.keyDown();
        this.keyLeft();
        this.keyRight();
    }

    private void loadGame() {System.out.println("Loading Counter Strike...");}

    private void keyUp() {System.out.println("Move forward...");}

    private void keyDown() {System.out.println("Move backward...");}

    private void keyLeft() {System.out.println("Move left...");}

    private void keyRight() {System.out.println("Key right...");}
}
```

### Steam Launcher
```java
public class Steam {
    public void launchGame(AssassinsCreed assassinsCreed) {
        assassinsCreed.launch();
    }

    public void launchGame(CounterStrike counterStrike) {
        counterStrike.launch();
    }
}
```
## 정리
- Steam Launcher 가 Game 을 실행하는 것을 명시적으로 알고 있다.
- 새로운 게임인 Counter Strike 를 추가하고 싶다면, Steam Launcher 에서 Counter Strike 를 실행하는 코드를 추가해야 한다.
- 만일 100개의 게임이 추가된다면, Steam Launcher 에서 100개의 코드를 추가해야 한다.
- 이렇게 Steam Launcher 가  Game 이 추가될 때마다 Steam Launcher 에 코드를 추가해야 하는 상황을 Tight Coupling 이라고 한다.
- Tight Coupling 은 유지보수가 어렵고, 확장성이 떨어지는 문제를 가지고 있다.(Game 이 추가 될 때 마다 재개발)
- Tight Coupling 을 해결하기 위해 Loose Coupling 을 사용한다.
---

# Lecture 01 - Section 02 : Loosely Coupled

- Loose Coupling 은 Tight Coupling 을 해결하기 위해 사용하는 방법이다.
- Loose Coupling 은 Steam Launcher 가 어떤 Game 이 실행되는지 알지 못한다. (관심도 없다.)
- Java의 Interface 를 사용하여 Loosely Coupled 를 구현한다.

### Game Interface
```java
public interface Game {
    void launch();
}
```

### Assassin's Creed
```java
public class AssassinsCreed implements Game {
    public void launch() {
        this.loadGame();
        this.keyUp();
        this.keyDown();
        this.keyLeft();
        this.keyRight();
    }

    private void loadGame() {System.out.println("Loading Assassins Creed...");}

    private void keyUp() {System.out.println("Move forward...");}

    private void keyDown() {System.out.println("Move backward...");}

    private void keyLeft() {System.out.println("Move left...");}

    private void keyRight() {System.out.println("Key right...");}
}
```

### Counter Strike
```java
public class CounterStrike implements Game {
    public void launch() {
        this.loadGame();
        this.keyUp();
        this.keyDown();
        this.keyLeft();
        this.keyRight();
    }

    private void loadGame() {System.out.println("Loading Counter Strike...");}

    private void keyUp() {System.out.println("Move forward...");}

    private void keyDown() {System.out.println("Move backward...");}

    private void keyLeft() {System.out.println("Move left...");}

    private void keyRight() {System.out.println("Key right...");}
}
```

### Steam Launcher
```java
public class Steam {
    public void launchGame(Game game) {
        game.launch();
    }
}
```
## 정리
- Steam Launcher 가 Game 을 실행하는 것을 알지 못한다.
- 새로운 게임인 Counter Strike 를 추가하고 싶다면, Steam Launcher 에서 Counter Strike 를 실행하는 코드를 추가할 필요가 없다.
- Loose Coupling 을 사용하면, Game 이 추가 될 때 마다 재개발을 하지 않아도 된다.
- Loose Coupling 은 유지보수가 쉽고, 확장성이 좋다.
---

# Lecture 02 - Section 01 : way of spring

- Spring 은 Container 라는 것을 사용한다.
- Container 는 객체를 생성하고, 관리하는 방법을 Bean 이라고 한다.
- Spring 은 Bean 을 관리하기 위해 Annotation 을 사용한다.

### Steam Launcher (Service)
```java
@Service
public class Steam {
    public void launchGame(Game game) {
        game.launch();
    }
}
```

- @Service 는 Steam 이라는 객체를 Bean 으로 등록한다. (Spring Container 가 관리) Spring Container 의 이름은 ApplicationContext 이다.
- Steam 은 Spring Container 에 등록되어 있기 때문에, Steam 을 사용하기 위해서는 ApplicationContext 를 사용해야 한다.

### Container에서 Steam 가져오기
```java
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Steam.class);
        var steam = context.getBean(Steam.class);

        System.out.println("Launching Steam...");

        steam.launchGame(new AssassinsCreed());
        steam.launchGame(new CounterStrike());

        System.out.println("Closing Steam...");
    }
}
```
- getBean() 을 사용하여 ApplicationContext 에서 Steam 을 가져온다.

## 정리
- Spring 은 Loose Coupling 을 구현하기 위해 Container 를 사용하고 등록 된 객체를 Bean 이라고 한다. (@Service, @Component...)
- Steam 은 Spring Container 에 등록되어 있기 때문에, Steam 을 사용하기 위해서는 ApplicationContext 를 사용해야 한다.
- getBean() 을 사용하여 ApplicationContext 에서 Steam 을 가져온다. 
- Spring에서 Bean을 생성하고 관리하는 것을 IoC(Inversion of Control) 라고 한다.
- IoC 는 객체의 생성과 관리를 Container 에게 위임하는 것을 의미한다.

---

# Lecture 02 - Section 02 : spring web

- Spring 은 Web Application 을 만들기 위한 여러가지 기능을 제공한다.
- Spring에서 loosely coupled 를 지원하기 위해 IoC 를 사용한다.
- 개별 Bean에서 다른 Bean을 사용하기 위해서는 @Autowired 를 사용한다.

### Steam Controller
- @RestController 는 SteamController 라는 객체를 Bean 으로 등록한다.
- SteamController 내부에서 Steam에 접근하기 위해 @Autowired 를 사용한다.
- @Autowired 는 SteamController 가 생성될 때, ApplicationContext 에서 Steam 을 가져와서 SteamController 에 주입된다.

```java
@RestController
@RequestMapping("steam")
public class SteamController {
    @Autowired
    private Steam steam;

    @PostMapping("launch")
    public void launch(@RequestBody GameRequest game) {
        switch (game.getName()) {
            case "Assassin's Creed":
                steam.launchGame(new AssassinsCreed());
                break;
            case "Counter-Strike":
                steam.launchGame(new CounterStrike());
                break;
            default:
                throw new IllegalArgumentException("Game not found");
        }
    }
}
```
- GameRequest 는 @RequestBody 를 사용하여 JSON 형식으로 받는다. (DTO 객체)
```java
public class GameRequest {
    private String name;

    public GameRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GameRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

- SteamController 가 추가 되더라도 Steam에는 영향이 없다. (loosely coupled)
- SteamController 에서 Steam 을 사용하기 위해 @Autowired 를 사용한다.
- 

## 정리
- 개별 Bean에서 다른 Bean을 사용하기 위해서는 @Autowired 를 사용한다.
  - IoC 는 객체의 생성과 관리를 Container 에게 위임하는 것을 의미한다.
  - @Autowired 는 SteamController 가 생성될 때, ApplicationContext 에서 Steam 을 가져와서 SteamController 에 주입된다. (IoC)
- SteamController 가 추가 되더라도 Steam 에는 영향이 없다. (loosely coupled)
    - Steam이라는 객체는 SteamController, Assassin's Creed, Counter-Strike 에 의존하지 않는다.
  

