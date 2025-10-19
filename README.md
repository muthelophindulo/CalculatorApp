# CalculatorApp

A simple calculator Android app implemented in Kotlin using Jetpack Compose. This repository demonstrates a single-screen calculator UI and local state management with Compose — ideal as a small example or learning project.

The main UI and logic live in: app/src/main/java/com/example/myapplication/CalculatorApp.kt

---

## What this app does

- Displays a calculator UI built with Jetpack Compose (Material3).
- Shows a display area and a 4x5 grid of buttons (digits, operators, and functions).
- Handles basic arithmetic: addition (+), subtraction (-), multiplication (x), and division (/).
- Supports percent (%), delete (del), clear (C), sign toggle (±), decimal point (.), and equals (=).
- Keeps state in Compose using mutableStateOf / mutableDoubleStateOf for:
  - displayValue: String shown on screen
  - operator: current operator selected
  - num1: stored first operand (Double)

Key behaviors implemented in CalculatorApp.kt:
- handleclick(value: String): appends digits to the display, replacing initial "0".
- handledel(): removes the last character or resets to "0".
- handleclear(): resets display, stored operand and operator.
- handleoperator(type: String): stores operator and num1 or computes interim result if chaining operations.
- handlePercent(): divides the current display value by 100.
- handleequal(): computes the result using stored operator and display value, then resets operator and num1.
- handleSing(): toggles the sign of the current displayed number.
- handlepoint(): appends a decimal point (handles initial zero case).

UI details:
- Calculator is composed within a Card with padding and fixed height.
- The display is a Text composable aligned to the end with a large font size.
- Buttons are implemented via a reusable Buttons() composable that accepts text, onclick, and isfunction flag to change color (function buttons are blue; digits are dark gray).
- Layout uses Columns and Rows for the button grid; each button uses Modifier.weight to size evenly.

---
## Screenshot
- <img width="296" height="635" alt="image" src="https://github.com/user-attachments/assets/b4644685-0be9-466a-8be4-cf480f66c8c1" />
---
## Files of interest
- app/src/main/java/com/example/myapplication/CalculatorApp.kt — main Composable and button logic

---

## How to run

Prerequisites
- Android Studio (Arctic Fox or newer recommended)
- JDK 11+
- Android SDK with appropriate API level
- Gradle (the project includes a Gradle wrapper)

Run from Android Studio
1. Open the project folder in Android Studio.
2. Let Gradle sync dependencies.
3. Run the app on an emulator or physical device.

Run from command line
- Build debug APK:
  ./gradlew assembleDebug
- Install to a connected device:
  ./gradlew installDebug

---

## Dependencies (inferred)
- Kotlin
- Jetpack Compose (Material3 is used in the code)
- AndroidX libraries for Compose and tooling
