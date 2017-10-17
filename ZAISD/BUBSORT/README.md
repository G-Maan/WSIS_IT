# Sortowanie bąbelkowe

Kod problemu: [BUBSORT](https://themis.lo14.wroc.pl/ZAISD2017GR3/BUBSORT)

*Sortowanie bąbelkowe (ang. bubble sort) - prosta metoda sortowania o złożoności czasowej O(n^2) i pamięciowej O(1). Polega na porównywaniu dwóch kolejnych elementów i zamianie ich kolejności, jeżeli zaburza ona porządek, w jakim się sortuje tablicę. Sortowanie kończy się, gdy podczas kolejnego przejścia nie dokonano żadnej zmiany. - Wikipedia*

## Treść zadania

Napisz algorytm sortowania bąbelkowego.

## Wejście

W pierwszej linii wejścia dana jest jedna liczba całkowita n (1 ≤ n ≤ 1000). W drugiej linii dane jest n liczb naturalnych ai - ciąg liczb do posortowania (1 ≤ ai ≤ 1 000 000 000).

## Wyjście

Należy wypisać k wierszy, gdzie k to jest wymagana liczba iteracji po tablicy, aby posortować ciag. W każdym wierszu należy wypisać n liczb - w i-tym wierszu ma zostać wypisany ciąg po i-tej iteracji (patrz przykład). W ostatnim wierszu należy wypisać posortowany ciąg. W przypadku, gdy ciąg na wejściu jest posortowany, nie trzeba nic wypisywać.

## Przykłady

Dla danych wejsciowych:  
`5`  
`1 2 3 5 4`

poprawną odpowiedzią jest:  
`1 2 3 4 5`

Z kolei dla danych wejściowych:  
`5`  
`5 9 3 1 2`

poprawną odpowiedzią jest:  
`5 3 1 2 9`  
`3 1 2 5 9`  
`1 2 3 5 9`

A dla danych wejściowych:  
`5`  
`10 100 1000 10000 100000`

poprawną odpowiedzią jest:

## Uwaga

To zadanie jest przystosowane jedynie do sprawdzenia sortowania bąbelkowego i jego udziwnienia nie powinny wpływać na samą metodę. Zastanów się jedynie, w którym miejscu musisz wypisywać wyniki.