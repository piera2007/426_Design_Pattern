﻿
# Taschenrechner-Projekt (Java)

## Inhaltsverzeichnis
1. [Projektbeschreibung](#projektbeschreibung)  
2. [Zweck des Projekts](#zweck-des-projekts)  
3. [Warum ist das Projekt nützlich?](#warum-ist-das-projekt-nützlich)  
4. [Design Principle – Single Responsibility Principle (SRP)](#design-principle--single-responsibility-principle-srp)  
5. [Verwendetes Design Pattern – Strategy](#verwendetes-design-pattern--strategy)  
6. [Projektstruktur](#projektstruktur)  
7. [Codebeispiele](#codebeispiele)  
   1. [Schlechtes Beispiel](#schlechtes-beispiel)  
   2. [Gutes Beispiel](#gutes-beispiel)  
8. [Warum ist das schlechte Beispiel schlecht?](#warum-ist-das-schlechte-beispiel-schlecht)  
9. [Warum ist das gute Beispiel gut?](#warum-ist-das-gute-beispiel-gut)  
10. [Anleitung zum Ausführen](#anleitung-zum-ausführen)  

---

## Projektbeschreibung
Dieses Repository enthält zwei Versionen eines **Taschenrechners**, der die vier Grundrechenarten (Addition, Subtraktion, Multiplikation und Division) ausführt:
- **Schlechtes Beispiel**: Eine einzige Klasse, die alles (Rechenlogik und Ausgabe) enthält und dadurch das Single Responsibility Principle (SRP) nicht beachtet.
- **Gutes Beispiel**: Eine saubere Lösung, bei der das SRP eingehalten wird. Hier wird das **Strategy Pattern** eingesetzt, um die verschiedenen Rechenoperationen flexibel zu nutzen.

---

## Zweck des Projekts
Ziel ist es zu zeigen, wie man Code übersichtlicher und wartbarer schreiben kann, indem man Verantwortlichkeiten trennt. Oft packt man alle Funktionen in eine Klasse – das macht späteres Anpassen schwierig. Dieses Projekt macht deutlich, wie man mit einem Design Pattern (Strategy) und dem SRP eine bessere Struktur erreicht.

---

## Warum ist das Projekt nützlich?
- **Lerneffekt**: Es wird anschaulich, wie saubere Code-Struktur (Clean Code) die Wartung erleichtert.  
- **Einfache Einführung in Design Patterns**: Man sieht, wie das Strategy Pattern Rechenoperationen austauschbar macht.  
- **Praxisnah**: Ein Taschenrechner ist ein leicht verständliches Beispiel, um das Prinzip zu demonstrieren.

---

## Design Principle – Single Responsibility Principle (SRP)
**Definition**: Das SRP besagt, dass eine Klasse nur eine klar abgegrenzte Aufgabe haben soll.  
**Vorteile**:  
- Mehr **Übersicht** im Code  
- Einfachere **Anpassungen** (weniger Risiko, andere Teile zu beschädigen)  
- Bessere **Erweiterbarkeit**, da jede Klasse nur eine Verantwortung übernimmt

---

## Verwendetes Design Pattern – Strategy
**Idee**: Das Strategy Pattern ermöglicht es, verschiedene Algorithmen (z. B. Rechenoperationen) leicht auszutauschen.  
**Umsetzung im Projekt**:  
- Jede Rechenoperation (Addition, Subtraktion, Multiplikation, Division) ist in einer eigenen Klasse.  
- Der Taschenrechner (`Calculator`) kann jederzeit entscheiden, welche Operation er verwenden will.  
- Das SRP wird unterstützt, weil jede Klasse nur für ihre Rechenart zuständig ist.

---

## Projektstruktur

```plaintext
calculator
 ├─ bad
 │   └─ BadCalculator.java
 ├─ good
 │   ├─ Calculator.java
 │   ├─ Operation.java
 │   ├─ Addition.java
 │   ├─ Subtraction.java
 │   ├─ Multiplication.java
 │   └─ Division.java
 └─ README.md
```

- **calculator/bad**: Eine einzige Klasse, die alles (Logik und Ausgabe) zusammenfasst.  
- **calculator/good**: Mehrere Klassen (je eine für jede Rechenoperation und eine `Calculator`-Klasse), um SRP und Strategy Pattern zu veranschaulichen.

---

## Codebeispiele

### Schlechtes Beispiel
- **Pfad**: `calculator/bad/BadCalculator.java`  
- **Merkmale**:  
  - Alle Rechenoperationen (Add, Sub, Mul, Div) und die Ausgabe sind in **einer** Klasse.  
  - Verstoss gegen das SRP.

### Gutes Beispiel
- **Pfad**: `calculator/good/`  
- **Wichtige Klassen**:  
  - `Operation.java`: Interface für Rechenoperationen  
  - `Addition.java`, `Subtraction.java`, `Multiplication.java`, `Division.java`: Konkrete Implementierungen für die jeweilige Operation  
  - `Calculator.java`: Verwaltet die Auswahl der Operationen (Strategy Pattern)

---

## Warum ist das schlechte Beispiel schlecht?
- **Verstoss gegen SRP**: Zu viele Aufgaben (Rechnen, Ausgabe, Organisation) liegen in **einer** Klasse.  
- **Schwer zu erweitern**: Eine neue Rechenoperation erfordert Eingriffe in denselben Codeblock.  
- **Unübersichtlich**: Änderungen oder Fehler lassen sich nur schwer isolieren und beheben.

---

## Warum ist das gute Beispiel gut?
- **SRP**: Jede Operation hat eine eigene Klasse mit genau einer Aufgabe.  
- **Strategy Pattern**: Der `Calculator` kann zwischen verschiedenen Operationen wechseln, ohne selbst angepasst zu werden.  
- **Wartbarkeit**: Änderungen an einer Operation betreffen nur deren eigene Klasse.

---

## Anleitung zum Ausführen
1. **Repository klonen** oder als ZIP herunterladen:  
   ```bash
   git clone https://github.com/piera2007/426_Design_Pattern
   ```
2. **Java-IDE** verwenden oder in der Konsole kompilieren:  
   - **Schlechtes Beispiel**:
     ```bash
     javac calculator/bad/BadCalculator.java
     java BadCalculator.java
     ```
   - **Gutes Beispiel**:
     ```
     javac calculator/good/*.java
     java Calculator.java
     ```
3. Beide Varianten geben denselben Output (Addition, Subtraktion, Multiplikation, Division) in der Konsole aus, unterscheiden sich aber stark im Codeaufbau.

---
