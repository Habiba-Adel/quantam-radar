
## 🎥 Brainstorming & Design Thinking
**Before writing any code, I first thought through the full design on a whiteboard.**
This video walks through that thinking process:

**[▶ Watch the brainstorming video](YOUR_VIDEO_LINK_HERE)**

---

## 💻 Code Walkthrough & Run Demo
**This video shows the final implementation, running it, and the output.**

**[▶ Watch the code & demo video](YOUR_VIDEO_LINK_HERE)**

---

## 🧩 UML Class Diagram

```mermaid
classDiagram
    class Rule {
        <<abstract>>
        -int fees
        +getFees() int
        +isViolated(CarInfo) boolean*
        +getViolationMessage(CarInfo) String*
    }
    class SpeedRule {
        -CarType type
        -int maxSpeed
    }
    class SeatBeltRule {
        -boolean requiredStatus
    }
    class CarInfo {
        -String plateNumber
        -Date snapShoted
        -CarType carType
        -int speed
        -boolean seatBeltStatus
    }
    class AllRulesHandler {
        -List~Rule~ rules
        +addRule(Rule)
        +deleteRule(Rule)
        +getRules() List~Rule~
    }
    class Observation {
        -CarInfo car
        -ArrayList~Rule~ violatedRules
        +getTotalFees() int
        +display()
    }
    class History {
        -Map~String,Integer~ totalFees
        -Map~String,Integer~ violatedRulesCount
        +recordObservationIntoHistory(Observation)
        +getAllFines() Map
        +getAllViolatedRulesWithCount() Map
    }
    class Radar {
        -String name
        -String location
        -History history
        +checkRules(CarInfo, List~Rule~) Observation
    }

    Rule <|-- SpeedRule
    Rule <|-- SeatBeltRule
    Radar --> History
    Radar --> Observation
    Radar ..> CarInfo
    Radar ..> Rule
    Observation --> CarInfo
    Observation --> Rule
    History --> Observation
```
