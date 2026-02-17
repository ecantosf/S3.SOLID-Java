# Anàlisis del principis SOLID, refactorització de la classe i reflexió sobre els canvis

## S - Single Responsibility Principle (Principi de Responsabilitat Única)

### Què estava malament?
[Explica quina part de la classe original tenia més d'una responsabilitat o feia tasques que no li correspondrien]

### Per què incomplia el principi?
[Descriu per què això viola el principi SRP - cada classe hauria de tenir només una raó per canviar]

### Quina solució has aplicat i per què?
[Explica com has separat les responsabilitats en diferents classes i per què aquesta solució respecta el principi]

---

## O - Open/Closed Principle (Principi Obert/Tancat)

### Què estava malament?
[Explica quina part del codi requeria modificacions per afegir noves funcionalitats]

### Per què incomplia el principi?
[Descriu per què això viola el principi OCP - les classes haurien d'estar obertes per a extensió però tancades per a modificació]

### Quina solució has aplicat i per què?
[Explica com has canviat el disseny per permetre extensions sense modificar codi existent (interfícies, classes abstractes, etc.)]

---

## L - Liskov Substitution Principle (Principi de Substitució de Liskov)

### Què estava malament?
[Explica si hi havia subclasses que no es podien substituir per les seves classes base sense alterar el comportament del programa]

### Per què incomplia el principi?
[Descriu per què això viola el principi LSP - les subclasses han de poder substituir les seves classes base]

### Quina solució has aplicat i per què?
[Explica com has reestructurat les jerarquies o modificat les classes per garantir la substitució correcta]

---

## I - Interface Segregation Principle (Principi de Segregació d'Interfícies)

### Què estava malament?
[Explica si hi havia interfícies "gruixudes" que obligaven a implementar mètodes que no eren necessaris]

### Per què incomplia el principi?
[Descriu per què això viola el principi ISP - és millor tenir interfícies petites i específiques que una de sola gran]

### Quina solució has aplicat i per què?
[Explica com has dividit les interfícies en altres més petites i cohesionades]

---

## D - Dependency Inversion Principle (Principi d'Inversió de Dependències)

### Què estava malament?
[Explica si les classes d'alt nivell depenien directament de classes concretes de baix nivell]

### Per què incomplia el principi?
[Descriu per què això viola el principi DIP - els mòduls d'alt nivell no han de dependre de mòduls de baix nivell, ambdós han de dependre d'abstraccions]

### Quina solució has aplicat i per què?
[Explica com has introduït abstraccions (interfícies/classes abstractes) per invertir les dependències]

---

## Reflexió final

[Opcional: Afegeix aquí una reflexió global sobre com ha millorat el codi després d'aplicar els principis SOLID, què has après, o quins reptes has trobat durant la refactorització]