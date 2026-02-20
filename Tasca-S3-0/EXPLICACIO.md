# Anàlisis del principis SOLID, refactorització de la classe i reflexió sobre els canvis

## S - Single Responsibility Principle (SRP)

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
- **MainD** per instanciar i verificar l'us.

En concret, per a cada classe:
- A **User**: es manté únicament atributs, constructor i Getters i Setter.
- A **UserValidator**: es crea el mètode validate() que crida als mètodes de validació de correu i contrasenya. En aquest
    té sentit mantenir aquests dos mètodes vinculats en una mateixa classe per estar estretament relacionats.
- A **EmailService**: envia confirmació de registre de correu. Resolt amb un print.
- A **UserManagement**: controla tot el flux del programa: validació, registre correcte i avís de confirmació. 
    Es prescindeix de userConfirmed per ser dead code (sempre retornaria true)
- A **MainS**: instancia la classe User i verifica el funcionament en un cas favorable i un desfavorable.

---

## O - Open/Closed Principle (Principi Obert/Tancat)

### Què estava malament?
El codi original tenia una cadena d'instruccions condicionals if/else dins del mètode play() per determinar quin so 
reproduir segons l'instrument. Per afegir un nou instrument hauríem de modificar la classe InstrumentPlayer 
afegint un nou else if.

### Per què incomplia el principi?
Viola l'OCP perquè la classe no estava tancada a modificacions i, cada vegada que volguéssim afegir un nou instrument, 
hauríem de modificar el codi existent. Això pot provocar errors, dificulta el manteniment i viola el principi que les 
classes han d'estar obertes a l'extensió però tancades a la modificació.

### Quina solució has aplicat i per què?
- He creat una interfície Instrument que defineix el contracte comú
- He implementat classes concretes per a cada instrument
- He creat una InstrumentFactory que centralitza la creació d'instruments
- Així, per afegir un nou instrument només cal crear una nova classe que implementi la interfície i registrar-la, sense 
  modificar el codi existent.

En concret, per a cada classe i interficie:
- A **Instrument**: defineix el contracte (mètodes play() i getName()) que totes les classes d'instruments han de 
   complir, permetent el polimorfisme
- A **Guitar, Piano, Drums**: implementen la interfície Instrument amb el comportament específic de cada instrument
- A **UnkownInstrument**: implementa Instrument per manejar casos d'instruments no trobats
- A **InstrumentPlayer**: queda tancat a modificacions perquè només invoca el mètode play() polimòrficament sense saber
   quin instrument concret és
- A **InstrumentCatalog**: actua com a punt central d'extensió on es registren els instruments disponibles; és l'únic 
   lloc que cal modificar per afegir-ne de nous
- A **MainO**: només fa servir InstrumentPlayer sense necessitar canvis en afegir nous instruments, demostrant que el 
   sistema és extensible.

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
La interfície MachineActions era una fat interface que contenia 5 mètodes: turnOn(), turnOff(), heat(), cool() i wash().
Això obligava a les classes AirConditioner i WashingMachine a implementar tots els mètodes, encara que alguns no 
tinguessin sentit per a elles: AirConditioner havia d'implementar wash() encara que no renta res o WashingMachine havia 
d'implementar heat() i cool() encara que no escalfa ni refreda

### Per què incomplia el principi?
- Les classes estan obligades a implementar mètodes que no necessiten.
- En el codi actual, AirConditioner.wash() imprimeix "Wash operation not supported", la qual cosa és un senyal clar 
   que aquest mètode no hauria d'estar aquí.
- Una interfície hauria de contenir només els mètodes que són realment necessaris per a les classes que la implementen.
- Les interfícies massa grans fan que el codi sigui menys flexible i més difícil de mantenir.

### Quina solució has aplicat i per què?
He dividit la interfície gran en tres interfícies més petites i cohesionades:
1. SwitchControl: Conté els mètodes bàsics que totes les màquines necessiten (turnOn(), turnOff())
2. TemperatureControl: Conté els mètodes relacionats amb el control de temperatura (heat(), cool())
3. WashControl: Conté el mètode específic per rentar (wash())

Aquesta solució:
- Permet que cada classe implementi només les interfícies que necessita
- Evita mètodes buits o que llancen excepcions
- És més flexible i permet afegir noves màquines fàcilment
- Segueix el principi de responsabilitat única a nivell d'interfície

En concret, per a cada classe i interficie:
- A **SwitchControl, TemperatureControl, WashControl**: són interfícies específiques i cohesionades, cadascuna amb una 
   única responsabilitat ben definida.
- A **AirConditioner**: implementa SwitchControl i TemperatureControl, ja que necessita engegar-se, apagar-se, escalfar 
   i refredar, però no rentar.
- A **WashingMachine**: implementa SwitchControl i WashControl, ja que necessita engegar-se, apagar-se i rentar, però 
   no controlar temperatura.
- A **MainI**: es poden instanciar ambdós tipus de màquines i utilitzar només els mètodes que realment tenen sentit 
   per a cadascuna.

---

## D - Dependency Inversion Principle (DIP)

### Què estava malament?
En el codi actual, ServicePerson (mòdul d'alt nivell) depèn directament de MySql (mòdul de baix nivell). 
Això crea un acoblament fort no desitjat.

### Per què incomplia el principi?
- El mòdul d'alt nivell (ServicePerson) depèn d'un mòdul de baix nivell (MySql). Segons DIP, ambdós haurien
  de dependre d'abstraccions, no d'implementacions concretes.
- És difícil canviar la implementació. Si volguéssim canviar de MySQL a PostgreSQL, hauríem de modificar
  la classe ServicePerson.
- Dificulta les proves unitàries.
- L'acoblament fa que l'aplicació sigui més rígida i menys adaptable a canvis.

### Quina solució has aplicat i per què?
Cal introduir abstraccions per invertir les dependències. Així, tant el mòdul d'alt nivell 
com el de baix nivell depenen de la mateixa abstracció, invertint la direcció de la dependència 
original. En concret:
- Crear una abstracció (interfície)
- Fer que la classe de baix nivell implementi l'abstracció
- Fer que el mòdul d'alt nivell depengui de l'abstracció. Amb injecció per constructor

En concret, per a cada classe:
- A **Database**: nova interfície
- A **MySQL**: modificar amb implements. Ara depèn de l'abstracció (Database) enlloc de ser una dependència 
  directa per a ServicePerson.
- A **Person**: sense canvis doncs no conté dependències externes
- A **ServicePerson**:  injecció de dependència per constructor. Ara depèn de l'abstracció Database enlloc de 
  la implementació concreta MySql. La dependència es rep per constructor.
- A **MainD**: classe nova d'exemple.


---

## Reflexió final

En tots els casos, hem intentat mantenir el codi llegible, modular i fàcil de mantenir.
