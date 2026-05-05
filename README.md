# Convertisseur-Temp-rature-Distance-Fragments-Onglets-
Une application Android simple permettant de convertir des températures et des distances via une interface à onglets.

---

##  Démonstration


---

##  Fonctionnalités

- 🌡 **Onglet Température** — Convertir entre Celsius et Fahrenheit
- 📏 **Onglet Distance** — Convertir entre Kilomètres et Miles
- ⬅ **Bouton Retour** — Affiche une boîte de dialogue de confirmation avant de quitter

---

##  Technologies utilisées

- Java
- Android SDK (API minimum 24)
- Material Design (TabLayout)
- ViewPager2 + FragmentStateAdapter

---


##  Structure du projet
app/
├── java/com/example/convertertabsjava/
│   ├── MainActivity.java
│   ├── TabsPagerAdapter.java
│   ├── TemperatureFragment.java
│   └── DistanceFragment.java
└── res/layout/
├── activity_main.xml
├── fragment_temperature.xml
└── fragment_distance.xml

---
