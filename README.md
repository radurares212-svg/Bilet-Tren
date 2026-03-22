# 🚂 Sistem Gestiune Bilete Tren (Java)

Acest proiect este o aplicație de tip consolă dezvoltată în Java pentru simularea unui sistem de rezervări feroviare. Permite interacțiunea cu utilizatorul pentru alegerea trenului, validarea rutei și calcularea prețului biletului în funcție de distanță și tipul de rezervare.

## 📋 Caracteristici principale

* **Selecție interactivă**: Utilizatorul poate alege trenul dorit din lista disponibilă prin introducerea numelui acestuia.
* **Validare logică a rutei**: Sistemul verifică dacă stația de destinație se află după stația de plecare în itinerariul trenului.
* **Restricții temporale**: Biletele pot fi achiziționate doar dacă mai sunt între **5 minute și 48 de ore** până la plecare.
* **Calcul dinamic de preț**: 
    * Preț de bază: **10 RON / stație**.
    * Reducere: **10%** pentru rezervările de tip `FARA_LOC`.
* **Gestiune Călători**: Fiecare bilet emis este asociat automat istoricului călătorului respectiv.

---

## 🏗️ Structura Proiectului

Proiectul respectă o arhitectură stratificată simplă:

### 1. Pachetele de Model (`model`)
* `Tren`: Conține numele și lista de obiecte `Statia`.
* `Statia`: Definește numele locației și `LocalTime` pentru plecare.
* `Calator`: Reține numele și lista de bilete deținute.
* `Bilet`: Entitatea care stochează detaliile tranzacției (preț, rută, tip).
* `TipRezervare`: Enum cu valorile `CU_LOC` și `FARA_LOC`.

### 2. Pachetele de Service (`service`)
* `ServiciuTren`: Gestionează baza de date locală de trenuri și căutarea acestora.
* `ServiciuBilete`: Conține toată logica de business (validări, calcule, emitere).

---

## 🚀 Cum rulezi aplicația

1.  Asigură-te că ai **JDK 8** sau o versiune mai nouă instalată.
2.  Compilează fișierele din folderul `src`.
3.  Rulează clasa `Main`.
4.  **Fluxul în consolă**:
    * Vizualizezi lista de trenuri (ex: `IR1742`, `R3001`).
    * Introduci numele trenului.
    * Introduci stația de plecare (ex: `Bucuresti`).
    * Introduci stația de destinație (ex: `Sinaia`).
    * Primești confirmarea biletului sau un mesaj de eroare specific.

---

## 🛠️ Tehnologii utilizate
* **Limbaj**: Java 8+
* **API Timp**: `java.time` (pentru gestionarea precisă a orelor de plecare).
* **Input**: `java.util.Scanner` pentru interacțiunea cu utilizatorul.

---
*Proiect realizat pentru demonstrarea conceptelor de Programare Orientată pe Obiect (POO) și Gestiune a Excepțiilor.*
