# Knockout Tournament Manager (Java)

A console application written in Java that manages a **16-team knockout tournament**: register the teams, draw and play each round, follow the calendar and results, and see who is eliminated and who is still in the competition.

Matches are simulated with random scores. If a match ends in a draw, it is decided by a penalty shootout, so every match always has a winner.

> The user interface (menu and messages) is in French.

---

## Table of Contents

- [Authors](#authors)
- [Features](#features)
- [Tournament rules](#tournament-rules)
- [Project structure](#project-structure)
- [Requirements](#requirements)
- [Build and run](#build-and-run)
- [How to use it](#how-to-use-it)
- [Class overview](#class-overview)
- [Known limitations](#known-limitations)
- [Possible improvements](#possible-improvements)
- [License](#license)

---

## Authors

- [Your name]
- [Teammate's name]

Developed as part of [course name] at [university], [year].

---

## Features

- Register **16 teams**, each with a name and a color.
- Input validation: no duplicate team names, and only allowed colors.
- Automatic **random draw** and simulation of every match in a round.
- Penalty shootout when the score is tied.
- Round order enforced: you cannot replay a round or skip ahead.
- Display the match calendar and the match results.
- Display eliminated teams (with their elimination round) and teams still in competition.
- Final standings with each team's number of wins.

---

## Tournament rules

- 16 teams play a single-elimination bracket: **round of 16 → quarter-finals → semi-finals → final**.
- The round is identified by the **number of matches** it contains:

| Round | Value to enter | Matches |
|---|---|---|
| Round of 16 (1/8 final) | `8` | 8 |
| Quarter-finals | `4` | 4 |
| Semi-finals | `2` | 2 |
| Final | `1` | 1 |

- Each team gets a random score from 0 to 9. The higher score wins.
- On a tie, a penalty shootout is simulated (0 to 5 goals each, repeated until the scores differ).
- The loser is eliminated and stores the round in which it was eliminated. A team with elimination level `0` is still in the competition.
- Allowed colors: `rouge`, `bleu`, `vert`, `jaune`, `noir`, `blanc`.

---

## Project structure

```
.
└── src/
    └── projett/
        ├── Main.java      # Entry point and console menu
        ├── Tournoi.java   # Tournament logic (teams, rounds, display)
        ├── Equipe.java    # A team (name, color, wins, elimination)
        └── Match.java     # A match between two teams (score, penalties, winner)
```

All files belong to the package `projett`.

---

## Requirements

- **Java JDK 8 or higher**
- A terminal that supports UTF-8 (the menu uses accents and emojis)

---

## Build and run

### With the command line

From the project root:

```bash
# Compile
javac -encoding UTF-8 -d out src/projett/*.java

# Run
java -Dfile.encoding=UTF-8 -cp out projett.Main
```

### With an IDE (Eclipse, IntelliJ, VS Code)

1. Import the project (the `src` folder is the source root).
2. Make sure the text file encoding is set to **UTF-8**.
3. Run `projett.Main`.

---

## How to use it

When the program starts, the main menu is displayed:

| Choice | Action |
|---|---|
| 1 | Enter the list of 16 teams (name + color) |
| 2 | Organize and play the matches of a round |
| 3 | Show the match calendar |
| 4 | Show the match results (with winners) |
| 5 | Show eliminated teams and their elimination round |
| 6 | Show teams still in the competition |
| 7 | Show the final standings |
| 8 | Quit |

### Typical session

1. Choose **1** and enter the 16 teams.
2. Choose **2** and enter `8` to play the round of 16.
3. Choose **2** and enter `4` to play the quarter-finals.
4. Choose **2** and enter `2` to play the semi-finals.
5. Choose **2** and enter `1` to play the final.
6. Use choices **3** to **7** at any time to view the calendar, results, eliminated teams, remaining teams and standings.

### Example output of a match

```
Match: Lions vs Eagles
Score: Lions 3 - 3 Eagles
⚽ Tirs au but : Lions 4 - 2 Eagles
Vainqueur du match: Lions
```

---

## Class overview

### `Equipe`
Represents a team: `id`, `nom`, `couleur`, `nbVictoires`, `eliminee` and `niveauElimination`.
- `gagnerMatch()` adds one win.
- `eliminer(niveau)` marks the team as eliminated and records the round.

### `Match`
Represents a match between two teams at a given round (`niveau`).
- `jouerMatch()` generates the scores, handles the penalty shootout, sets the winner, updates the winner's victories and eliminates the loser.

### `Tournoi`
Holds the list of teams and matches and contains the tournament logic.
- `entrerEquipes(Scanner)` reads and validates the 16 teams.
- `organiserMatchs(niveau)` checks the round is valid and not already played, shuffles the remaining teams, pairs them and plays the matches.
- `afficherCalendrier()`, `afficherResultats()`, `afficherClassementFinal()` display the information.
- `getEquipes()` gives the list of teams (used by `Main` for choices 5 and 6).

### `Main`
Displays the menu, reads the user's choice and calls the right `Tournoi` method.

---

## Known limitations

- **No third-place match**: the final standings do not include one, even though the standings comments describe it.
- **Final standings are not sorted**: choice 7 lists every team with its wins and elimination round, in the (shuffled) internal order, without ranking them.
- The champion keeps elimination level `0`, the same value as "still in competition".
- Entering teams (choice 1) can be run more than once, which adds 16 more teams.
- The input is not protected against non-numeric values (for example typing text where a number is expected).
- Match results are purely random: there are no team strengths or real data.

---

## Possible improvements

- Sort the final standings (champion, runner-up, then by round of elimination and wins).
- Add a third-place match.
- Handle invalid input with `try/catch` or `hasNextInt()`.
- Prevent re-entering teams once the list is complete.
- Save and load the tournament from a file.
- Add a graphical interface (JavaFX or Swing).

