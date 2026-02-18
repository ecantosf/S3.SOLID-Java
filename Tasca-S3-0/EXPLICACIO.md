# Anàlisis del principis SOLID, refactorització de la classe i reflexió sobre els canvis

## S - Single Responsibility Principle (Principi de Responsabilitat Única)

### Què estava malament?
A banda dels errors de disseny, la classe crida a dues llibreries que no s'utilitzen, el userConfirmed sempre serà true 
i el mètode buit register (void) conté un return que no fa cap funció. A més, els missatges de les exceptions no són 
prou precisos.

### Per què incomplia el principi?
El principi PRS diu que una classe hauria de tenir una única responsabilitat o, dit d'una altra manera,
una única raó per canviar. En el cas d'User hi ha tres:
- Representar les dades de l'usuari (name, email, password)
- Validar les dades de l'usuari, comprovant email i password
- Gestionar el registre de l'usuari, enviant email de confirmació


### Quina solució has aplicat i per què?
La solució passa per separar les responsabilitats en diferents classes, que alhora respetin el PSR.
En aquest cas, es desglossaria en vàries classes:
- **User** es pot mantenir només per a dades
- **UserValidator** per validar correu electrònic i contrasenya
- **EmailService** per a l'enviament d'emails (en aquest cas simplement és un print)
- **UserManagement** per a la gestió del registre
- **Main** per instanciar i verificar l'us.

En concret, per a cada classe:
- A **User**: es manté únicament atributs, constructor i Getters i Setter.
- A **UserValidator**: es crea el mètode validate() que crida als mètodes de validació de correu i contrasenya. En aquest
    té sentit mantenir aquests dos mètodes vinculats en una mateixa classe per estar estretament relacionats.
- A **EmailService**: envia confirmació de registre de correu. Resolt amb un print.
- A **UserManagement**: controla tot el flux del programa: validació, registre correcte i avís de confirmació
- A **Main**: instancia la classe User i verifica el funcionament en un cas favorable i un desfavorable.

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

En tots els casos, hem intentat mantenir el codi llegible, modular i fàcil de mantenir.
