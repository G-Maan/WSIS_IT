# Babki

Kod problemu: [SELSORTM](https://themis.lo14.wroc.pl/ZAISD2017GR3/SELSORTM)

## Treść zadania

Jaś zrobił na plaży rządek n babek z piasku. Teraz chce je poustawiać według ich wielkości. Wybiera największą z nich i przenosi ją na początek (a dokładniej: zamienia ją z babką, która znajdowała się na pierwszym miejscu). Następnie spośród pozostałych babek wybiera największą i zamienia ją z babką znajdującą się na drugim miejscu, itd... . Jeśli w trakcie szukania największej babki Jaś znajdzie kilka o takiej samej maksymalnej wysokości, wówczas bierze pierwszą z nich.  
Można by powiedzieć, że Jaś odkrył algorytm select sort, gdyby nie fakt, że to sortowanie nie bardzo mu wyszło. Otóż w trakcie przenoszenia piasek z babek osypuje się i babki tracą na wielkości. Tym więcej tracą im na dalszy dystans Jaś je przenosi. A dokładniej:  

* wielkości babek opisane są liczbami naturalnymi,
* babka przeniesiona o k pozycji traci na wielkości k jednostek,
* oczywiście babka o wielkości 0 już nie traci na wielkości (przyjmujemy jednak, że nadal jest babką).

Napisz program, który wczyta ciąg liczb opisujący wielkości kolejnych babek i wypisze wielkości kolejnych babek po "uporządkowaniu" ich przez Jasia.

## Wejście

W pierwszym wierszu znajduje się n - liczba babek (n ≤ 10000). W drugim wiersz znajduje się n liczba naturalnych nie większych od 10^9.

## Wyjście

W jedynym wierszu znajduje się ciąg n liczb opisujących wielkości babek po "uporządkowaniu".

## Przykład

Dla danych wejściowych  
`3`  
`1 2 3`

poprawną odpowiedzią jest  
`1 2 0`

dla danych wejściowych  
`3`  
`2 2 2`

poprawną odpowiedzią jest  
`2 2 2`

a dla danych  
`5`  
`1 2 3 2 4`

poprawną odpowiedzią jest  
`0 2 1 0 0`