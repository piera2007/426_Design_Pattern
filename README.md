# Taschenrechner-Projekt (Java)

Willkommen in diesem Projekt! Hier finden Sie zwei unterschiedliche Codebeispiele (ein "schlechtes" und ein "gutes"), die genau das gleiche tun: einen einfachen Taschenrechner bereitstellen, der die vier Grundrechenarten ausführen kann. Allerdings unterscheiden sich die beiden Beispiele **stark in ihrer Code-Struktur** und zeigen, wie unterschiedlich man das **Single Responsibility Principle (SRP)** umsetzen kann – oder eben dagegen verstossen kann.

---

## Inhaltsverzeichnis
1. [Überblick](#überblick)
2. [Design Principle (SRP)](#design-principle-srp)
3. [Verwendetes Design Pattern (Strategy)](#verwendetes-design-pattern-strategy)
4. [Projektstruktur](#projektstruktur)
5. [Codebeispiele](#codebeispiele)
    1. [Schlechtes Beispiel](#schlechtes-beispiel)
    2. [Gutes Beispiel](#gutes-beispiel)
6. [Warum ist das schlechte Beispiel schlecht?](#warum-ist-das-schlechte-beispiel-schlecht)
7. [Warum ist das gute Beispiel gut?](#warum-ist-das-gute-beispiel-gut)
8. [Installation & Ausführung](#installation--ausführung)
9. [Lizenz](#lizenz)

---

## Überblick
Dieses Projekt demonstriert anhand eines sehr einfachen **Taschenrechners** die Umsetzung und Verletzung des **Single Responsibility Principle (SRP)**.  

- Im Ordner `bad` befindet sich ein einfacher, jedoch schlecht strukturierter Code, der verschiedene Aufgaben in einer einzigen Klasse zusammenfasst.  
- Im Ordner `good` findet sich eine objektorientierte und SRP-freundliche Umsetzung mithilfe des **Strategy Pattern**.  

Ziel ist es, den Unterschied in der Wartbarkeit und Erweiterbarkeit aufzuzeigen.

---

## Design Principle (SRP)
**Single Responsibility Principle (SRP)**:  
> Eine Klasse oder ein Modul sollte **nur eine einzige** Aufgabe/Verantwortung haben.

Warum ist das wichtig?  
- Verbesserte **Lesbarkeit** und **Wartbarkeit**  
- Einfachere **Erweiterbarkeit**  
- **Klare** Struktur und Verantwortlichkeiten

Im schlechten Beispiel werden alle Aufgaben (Operationen, Ausgaben) in **einer** Klasse gebündelt, was gegen das SRP verstösst. Im guten Beispiel wird SRP durch die Aufteilung in verschiedene Klassen erfüllt.

---

## Verwendetes Design Pattern (Strategy)
Zur Einhaltung des SRP verwenden wir das **Strategy Pattern**. Es ermöglicht, unterschiedliche Algorithmen (hier: Rechenoperationen) auszutauschen, ohne den restlichen Code zu beeinflussen.  

**Warum Strategy Pattern?**  
- Jede **Operation** (Addition, Subtraktion usw.) ist in einer eigenen Strategie-Klasse gekapselt.  
- Der zentrale “Taschenrechner” (Context) kann beliebig zwischen Strategien wechseln, ohne selbst alle Operationen kennen zu müssen.  
- Es hilft, das Single Responsibility Principle umzusetzen, da jede Strategie (jede Operation) eine klar abgegrenzte Verantwortung hat.

---

## Projektstruktur

```
.
├── bad
│   └── BadCalculator.java
├── good
│   ├── Addition.java
│   ├── Calculator.java
│   ├── Division.java
│   ├── Multiplication.java
│   ├── Operation.java
│   └── Subtraction.java
└── README.md
```

- **bad**: Enthält den “schlechten” Code, der gegen das SRP verstösst.  
- **good**: Enthält den “guten” Code, der das SRP einhält und das Strategy Pattern umsetzt.

---

## Codebeispiele

### Schlechtes Beispiel
**Pfad**: `./bad/BadCalculator.java`  

1. **Eine einzige Klasse** (`BadCalculator`)
2. **Alles** passiert in `main()`
3. Keine Trennung von Rechenoperationen – alles ist monolithisch zusammengefasst

### Gutes Beispiel
**Pfad**: `./good/`

- **Operation.java**: Interface für unsere Strategien  
- **Addition, Subtraction, Multiplication, Division**: Jede Rechenart in einer **eigenen Klasse**  
- **Calculator.java**: Der “Context”, in dem dynamisch zwischen Strategien gewechselt wird  

---

## Warum ist das schlechte Beispiel schlecht?
- **Verstoss gegen SRP**: Eine einzige Klasse (BadCalculator) übernimmt **zu viele** Aufgaben (Ausgabe, Durchführung aller Operationen).  
- **Schwierig zu erweitern**: Für jede neue Operation müsste man diese Klasse bearbeiten und vergrössern – das erhöht das Risiko von Fehlern und führt zu unübersichtlichem Code.  
- **Hohe Kopplung**: Keine klare Trennung von Aufgaben. Änderungen an einer Rechenoperation wirken sich potenziell auf alle anderen Bereiche der Klasse aus.

---

## Warum ist das gute Beispiel gut?
- **Einhaltung des SRP**: Jede Rechenoperation ist in einer **eigenen** Klasse ausgelagert – genau **eine** Verantwortung pro Klasse.  
- **Strategy Pattern**: Der Taschenrechner wählt einfach die benötigte Operation aus. Wir können **flexibel** Strategien hinzufügen oder austauschen, ohne den Code des Calculators massiv ändern zu müssen.  
- **Bessere Wartbarkeit**: Jede Klasse ist für eine Aufgabe zuständig. Änderungen an einer Operation betreffen nur die entsprechende Klasse.

---

## Installation & Ausführung

1. **Repository klonen oder herunterladen**  
   ```bash
   git clone <REPOSITORY_URL>
   ```
2. **Projekt in einer Java-IDE (z.B. IntelliJ, Eclipse) öffnen**  
   oder in der Konsole kompilieren:
   ```bash
   javac ./bad/BadCalculator.java
   javac ./good/*.java
   ```
3. **Ausführen**  
   - **Schlechtes Beispiel**:
     ```bash
     java bad.BadCalculator
     ```
   - **Gutes Beispiel**:
     ```bash
     java good.Calculator
     ```

Beide Programme sollten identische Konsolenausgaben (für einfache Beispielzahlen) erzeugen, unterscheiden sich jedoch stark in der Code-Struktur.

---

## Lizenz
Dieses Projekt steht unter der [MIT License](https://opensource.org/licenses/MIT).  
Bitte beachten Sie die [LICENSE](LICENSE)-Datei für weitere Informationen.

---

Vielen Dank für Ihr Interesse! Wenn Sie Fragen haben oder mitwirken möchten, **freuen** wir uns über Beiträge. Viel Spass beim Erkunden dieses kleinen Beispielprojekts und beim Lernen über das Single Responsibility Principle sowie das Strategy Pattern!