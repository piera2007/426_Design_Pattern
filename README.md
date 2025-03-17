# Taschenrechner-Projekt (Java)

## Inhaltsverzeichnis
1. [Projektbeschreibung](#projektbeschreibung)  
2. [Design Principle – Single Responsibility Principle (SRP)](#design-principle--single-responsibility-principle-srp)  
3. [Verwendetes Design Pattern – Strategy](#verwendetes-design-pattern--strategy)  
4. [Projektstruktur](#projektstruktur)  
5. [Codebeispiele](#codebeispiele)  
   1. [Schlechtes Beispiel](#schlechtes-beispiel)  
   2. [Gutes Beispiel](#gutes-beispiel)  
6. [Erläuterung zur schlechten Variante](#erläuterung-zur-schlechten-variante)  
7. [Erläuterung zur guten Variante](#erläuterung-zur-guten-variante)  
8. [Anleitung zum Ausführen](#anleitung-zum-ausführen)  
9. [Lizenz](#lizenz)  

---

## Projektbeschreibung
Dieses Projekt zeigt anhand eines **Taschenrechners** zwei Versionen eines Codes, um das **Single Responsibility Principle (SRP)** zu veranschaulichen. Beide Programme geben denselben Output, unterscheiden sich jedoch in ihrer Struktur. In der guten Variante wird zusätzlich das **Strategy Pattern** eingesetzt, um die Einhaltung des SRP zu gewährleisten.

---

## Design Principle – Single Responsibility Principle (SRP)
- **Definition**: Eine Klasse sollte **nur** eine klar definierte Verantwortung besitzen.  
- **Vorteile**:  
  - Bessere Lesbarkeit und Wartbarkeit  
  - Einfachere Erweiterung und Fehlersuche  
  - Geringere Kopplung zwischen Klassen  

Bei Verstoß übernimmt eine Klasse mehrere Verantwortlichkeiten, was zu hohem Wartungsaufwand und unübersichtlichem Code führt.

---

## Verwendetes Design Pattern – Strategy
- **Zweck**: Ermöglicht, verschiedene Algorithmen (Strategien) austauschbar zu machen, ohne dass der Kontext davon stark beeinflusst wird.  
- **Nutzen im Projekt**:  
  - Jede Rechenoperation (Addition, Subtraktion, Multiplikation, Division) ist als eigene **Strategie** realisiert.  
  - Der Taschenrechner kann dynamisch zwischen diesen Strategien wechseln.  
  - Das **Single Responsibility Principle** wird unterstützt, da jede Strategie nur eine klar definierte Aufgabe hat.

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

1. **bad**: Enthält eine Klasse, die sämtliche Aufgaben des Taschenrechners bündelt.  
2. **good**: Enthält getrennte Klassen für jede Operation sowie eine zentrale `Calculator`-Klasse, die Strategien nutzt.

---

## Codebeispiele

### Schlechtes Beispiel

**Pfad**: `calculator/bad/BadCalculator.java`  
Bündelt alle Operationen (Addition, Subtraktion, Multiplikation, Division) und deren Ausgabe in **einer** Klasse.

### Gutes Beispiel

**Pfad**: `calculator/good/`  
- **Operation**: Interface für alle Rechenstrategien  
- **Addition, Subtraction, Multiplication, Division**: Konkrete Implementierungen des Interfaces  
- **Calculator**: Verwaltet und wechselt zwischen den Strategien (Operationen)

---

## Erläuterung zur schlechten Variante
- **Verstößt gegen das SRP**: Eine Klasse hat mehrere Verantwortlichkeiten (Arithmetik, Eingabe/Output).  
- **Erweiterung erschwert**: Neue Funktionen erfordern größere Änderungen in derselben Klasse.  
- **Hohe Kopplung**: Jede Änderung der Logik oder der Ausgabe betrifft die gesamte Klasse.

---

## Erläuterung zur guten Variante
- **Einhaltung des SRP**: Jede Rechenoperation ist in einer eigenen Klasse gekapselt.  
- **Strategy Pattern**: Ermöglicht flexibles Austauschen und Hinzufügen von Rechenoperationen.  
- **Wartbarkeit**: Änderungen an einer bestimmten Operation erfolgen in einer separaten Klasse, ohne andere Teile zu beeinflussen.

---

## Anleitung zum Ausführen
1. **Repository klonen oder herunterladen**  
   ```bash
   git clone <GITHUB-URL>
   ```
2. **In einer Java-IDE (z. B. IntelliJ, Eclipse) oder über die Konsole öffnen**  
3. **Schlechtes Beispiel kompilieren und ausführen**  
   ```bash
   javac calculator/bad/BadCalculator.java
   java calculator.bad.BadCalculator
   ```
4. **Gutes Beispiel kompilieren und ausführen**  
   ```bash
   javac calculator/good/*.java
   java calculator.good.Calculator
   ```
Beide Varianten geben denselben Output aus (z. B. das Ergebnis von Addition, Subtraktion, Multiplikation und Division bestimmter Zahlen).

---

## Lizenz
Die Inhalte dieses Projekts stehen unter der [MIT License](https://opensource.org/licenses/MIT). Weitere Informationen in der [LICENSE](LICENSE)-Datei.