﻿# app-cteni-cisel
Konzolovou aplikace, která přečte a zpracuje řadu čísel. Čísla se čtou buď ze souboru nebo ze standardního vstupu. Přečtená čísla se zpracovávají podle těchto pravidel:
- počet přečtených čísel je sudé číslo, aplikace vypíše z této řady pouze sudá čísla
- počet přečtených čísel je liché číslo, aplikace vypíše jenom lichá čísla
Výsledek zapíše do souboru nebo na standardní výstup. Chováni aplikace, odkud se čte a zapisuje, se bude řídit parametry při spuštění. 
První parametr určuje odkud se budou čísla číst a je povinný. Parametr může být celé kladné číslo n (čísla se budou zadávat ze s. vstupu) nebo cesta k souboru s čísly. 
Druhý parametr je nepovinný. Když se nezadá, bude se výsledek zapisovat na s. výstup, v opačném případě je to souboru.
 
Příklady spuštění aplikace:
 
Aplikace přečte čísla ze s. vstupu, výsledek zapíše na s. výstup:
aplikace 4

Aplikace přečte čísla ze souboru, výsledek zapíše do souboru:
aplikace input.txt output.txt

Aplikace přečte čísla ze souboru, výsledek zapíše na s. výstup:
aplikace input.txt 
