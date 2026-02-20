
# 🔌 I - Principi de Segregació d’Interfícies (ISP)

## 🧠 Què és?

El **Principi de Segregació d’Interfícies (ISP)** estableix que:

> **Una classe no hauria d’estar obligada a implementar mètodes que no necessita.**

Això vol dir que les interfícies **han de ser específiques i estar ben delimitades segons la funcionalitat**. Si una interfície és massa gran o genèrica, pot forçar les classes a implementar mètodes que no tenen sentit per a elles.

⚠️ Aquest problema és conegut com a **interfícies grasses** (fat interfaces) o **"code smell"** `*` d’**interfícies inflades** o amb massa responsabilitats.

`*` **"Code smell"** fa referència a una característica del codi font que suggereix un problema més profund o un **possible error en el disseny o l'estructura del codi**.

## 🚨 Per què és important?
Tenir **interfícies més petites i específiques**, és més fàcil **reutilitzar** les mateixes interfícies en diferents parts del sistema **sense causar problemes de compatibilitat.**

### 👩‍🏫 **Exemple:**

Suposem que estàs dissenyant una aplicació que treballa amb **diversos tipus d’impressores** i ofereixes una interfície com aquesta:

```java
public interface Impressora {
    void imprimir(String document);
    void escanejar(String document);
    void enviarFax(String document);
}

public class ImpressoraBasica implements Impressora {
    @Override
    public void imprimir(String document) {
        System.out.println("Imprimint: " + document);
    }

    @Override
    public void escanejar(String document) {
        throw new UnsupportedOperationException("Aquesta impressora no escaneja.");
    }

    @Override
    public void enviarFax(String document) {
        throw new UnsupportedOperationException("Aquesta impressora no envia faxos.");
    }
}

```
🔴 El Problema d’aquesta interfície és que agrupa **massa responsabilitats en una sola interfície**. No totes les impressores tenen capacitat per escanejar o enviar faxos, però igualment estan **obligades a implementar aquests mètodes**.

⚠️Això viola el **Principi de Segregació d’Interfícies (ISP)**
 
✅ Solució amb ISP: 
> Dividir la interfície Impressora en **interfícies més petites i específiques** (Impressora, Escaner, Fax), i fer **que cada classe implementi només les que necessita**.

- **1️⃣ Interfícies segregades segons funcionalitat:**

```java
public interface Impressora {
    void imprimir(String document);
}

public interface Escaner {
    void escanejar(String document);
}

public interface Fax {
    void enviarFax(String document);
}
```
- **2️⃣ Impressora bàsica: només imprimeix:**

```java
public class ImpressoraBasica implements Impressora {
    @Override
    public void imprimir(String document) {
        System.out.println("Imprimint: " + document);
    }
}
```
- **3️⃣ Impressora amb escàner: imprimeix i escaneja:**

```java
public class ImpressoraEscaner implements Impressora, Escaner {
    @Override
    public void imprimir(String document) {
        System.out.println("Imprimint: " + document);
    }

    @Override
    public void escanejar(String document) {
        System.out.println("Escanejant: " + document);
    }
}
```
- **4️⃣ Impressora multifunció: imprimeix, escaneja i envia faxos:**

```java
public class ImpressoraMultifuncio implements Impressora, Escaner, Fax {
    @Override
    public void imprimir(String document) {
        System.out.println("Imprimint: " + document);
    }

    @Override
    public void escanejar(String document) {
        System.out.println("Escanejant: " + document);
    }

    @Override
    public void enviarFax(String document) {
        System.out.println("Enviant fax: " + document);
    }
}
```

---

## 🎯 Objectiu de l’exercici

A l’arxiu Java adjunt trobaràs una classe o jerarquia de classes que implementa una **interfície massa gran**.

🔧 El teu repte és:

1. Detectar quins mètodes **no tenen sentit** per a algunes de les classes.
2. Refactoritzar la interfície en **interfícies més petites i enfocades**.
3. Fer que cada classe implementi **només les interfícies que necessita**.

---

## 📌 Consells per aplicar ISP

✅ **Si una classe ha d’implementar un mètode que només llença una excepció o queda buit... potser estàs violant ISP.**

✅ **Prefereix diverses interfícies específiques a una de sola i genèrica.**

✅ **Les interfícies petites i enfocades afavoreixen un disseny més flexible i mantenible.**

---


## 💬 Reflexió

Quan se segueix **ISP**:
- Les classes són més simples i coherents.
- Evitem implementacions absurdes o innecessàries.
- Es facilita l’ús de composició en lloc d’herència forçada.

🔁 **Més modularitat, menys acoblament.**

---

🚀 Endavant! Revisa la interfície, aplica el principi **ISP** i refactoritza amb elegància.

❓ **La teva interfície fa massa coses? Quines parts podrien dividir-se?**
 


