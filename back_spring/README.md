# Dlabs (back: Java/Spring)

## Description

API Spring fournissant les données au format JSON.

### Dérouler

L'API est déployée à l'adresse
```
localhost:8080
```

**Format des données:**

<table>
    <tr>
        <td><b>Deal</b></td><td>ID</td><td>TITLE</td><td>SHOP_NAME</td><td>SHOP_LINK</td>
        <td>PRICE_OLD</td><td>PRICE_NEW</td><td>PROMO_CODE</td><td>DATE_POST</td>
        <td>IMG_URL</td><td>DESCRIPTION</td><td>FK_CREATOR</td>
    </tr>
</table>

<table>
    <tr>
        <td><b>User</b></td><td>ID</td><td>PSEUDO</td><td>FIRST_NAME</td>
        <td>LAST_NAME</td><td>PASSWORD</td>
    </tr>
</table>

<table>
    <tr>
        <td><b>Temperature</b></td><td>ID</td><td>VALUE</td><td>FK_USER</td>
        <td>FK_DEAL</td>
    </tr>
</table>

**Liste des Endpoints:**
```
GET /deal/all
```
Retourne une liste de tous les **Deal** présent dans la base de données

```
GET /deal/{id}
```
Retourne le **Deal** possédant l'*ID* passée en paramètres

```
GET /user/all
```
Retourne une liste de tous les **User** présent dans la base de données

```
GET /user/{id}
```
Retourne le **User** possédant l'*ID* passée en paramètres

```
GET /temperature/all
```
Retourne une liste de toutes les **Temperature** présente dans la base de données

```
GET /temperature/{id}
```
Retourne la **Temperature** possédant l'*ID* passée en paramètres

```
GET /singlepage/all
```
Retourne une liste de tous les **Deal** contenant la somme des **Temperature** liées.
(C'est cet URL qui est "consommée" par le serveur web)

```
GET /singlepage/{id}
```
Retourne le **Deal** contenant la somme des **Temperature** liée possédant l'*ID* passée en paramètres
(C'est cet URL qui est "consommée" par le serveur web)

```
POST /singlepage/add
```
Envoie un nouveau **Deal** dans la base de donnée.
(C'est cet URL qui est "consommée" par le serveur web)

### Fonctionnalitées

#### Fait

* Mise en place de la base de donnée (MySQL)
    * Création de la base de données
    * Création des tables dans la base de données
    * Insertion des Tuples dans la base de données
    
* Accès à la base de données (Couches Persistance)
* Traitement des données (Couche Métier)
* Mise en place des *endpoints* et gestion des requêtes (Couche présentation)

#### En cours

* Protéger l'API en écriture & authentifié les utilisateurs

#### À faire / Souhaitées (Idées)

## Utilisation

### Dépendances

[Java (JVM > 8.0)](https://www.java.com/fr/download/)

[Maven](https://maven.apache.org/index.html)

### Lancement/run

```bash
$ chmod +x mvnw
$ ./mvnw clean spring-boot:run
OR
$ mvn clean spring-boot:run
```

### À savoir






