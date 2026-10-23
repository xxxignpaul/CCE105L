# Java RPG Battle Game (CCE105 / CCE105L)

## Project Description

Java RPG Battle Game is a simple role-playing game developed using Java and Swing. It allows players to select a character, fight randomly generated enemies, and use different battle actions through a graphical user interface.

The game demonstrates object-oriented programming concepts such as abstraction, inheritance, polymorphism, and encapsulation.

## Features

- Graphical user interface using Java Swing
- Seven playable character classes
- Character names and unique statistics
- Health bars for the player and enemy
- Normal attacks and special moves
- Special-move cooldown system
- Healing potions with limited uses
- Random enemy selection
- Automatic enemy turns
- Battle log displaying actions and damage
- Victory, defeat, and escape results
- Option to start another battle

## Character Classes

| Character | Description |
|---|---|
| Warrior | High health and defense |
| Mage | High magical attack power |
| Archer | Balanced combat statistics |
| Paladin | Durable fighter with healing abilities |
| Assassin | High burst damage |
| Necromancer | Uses life-draining abilities |
| Berserker | Deals heavy damage |

## Technologies Used

- Java (JavaSE-21)
- Java Swing
- Eclipse IDE
- Object-Oriented Programming

## Project Structure

```text
src/
└── Game/
    ├── Main.java
    ├── GameCharacter.java
    ├── Warrior.java
    ├── Mage.java
    ├── Archer.java
    ├── Paladin.java
    ├── Assassin.java
    ├── Necromancer.java
    └── Berserker.java
```

## How to Run

1. Install a compatible Java Development Kit (JDK 21 or newer).
2. Open the project in Eclipse IDE.
3. Make sure all Java files are inside the `Game` package.
4. Save all files.
5. Right-click `Main.java`.
6. Select **Run As → Java Application**.
7. Enter a character name and choose a character class.
8. Click the battle action buttons to play.

## Gameplay Instructions

- **Attack:** Perform a normal attack against the enemy.
- **Special Move:** Use a powerful character-specific ability when available.
- **Heal:** Restore health using a healing potion.
- **Run:** Escape from the current battle.

The enemy automatically takes a turn after a valid player action. The battle ends when the player or enemy is defeated, or when the player escapes.

## Object-Oriented Programming Concepts

- **Abstraction:** `GameCharacter` defines the common structure and abstract combat methods.
- **Inheritance:** Each character class extends `GameCharacter`.
- **Polymorphism:** Each character implements its own attack and special-move behavior.
- **Encapsulation:** Character data and methods are organized within their respective classes, with shared fields and accessors.
