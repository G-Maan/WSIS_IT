# Everybody do the flop!

Kod problemu: [FLIP](https://themis.lo14.wroc.pl/ZAISD2017GR3/FLIP)

## Treść zadania

Bajtek bardzo nudzi się na lekcjach matematyki fizyki, dlatego skonstruował sobie zabawkę. Zabawka jest w kształcie pudełka, a zawiera w środku małe klocki.
W pudełku znajduje się n kolumn. W i-tej kolumnie jest ai klocków. Na początku wszystkie klocki w kolumnie są ułożone na sobie. Bajtek może odwrócić pudełko i zgodnie z siłą grawitacji niektóre klocki zmienią swoją pozycję (patrz rysunek: klocki, które zmienią swoje miejsce zostały zaznaczone na niebiesko).

![Flip example](https://github.com/peterkowalski/WSIS_IT/blob/master/ZAISD/FLIP/FLIP.png)

Mając dany początkowy układ klocków w zabawce Bajtka, znajdź końcowy układ.

## Wejście

W pierwszej linii wejścia znajduje się liczba n (1 ≤ n ≤ 100) - liczba kolumn w zabawce Bajtka. W kolejnej linii znajduje się n dodatnich liczb ai - liczba klocków w i-tej kolumnie. Każda z tych liczb jest z zakresu [1, 100].

## Wyjście

Wypisz dokładnie n liczb w jedynym wierszu. i-ta liczba powinna oznaczać liczbę klocków w i-tej kolumnie po obróceniu przez Bajtka.

## Przykłady

Dla danych wejściowych  
`4`  
`3 2 1 2` 
 
poprawną odpowiedzią jest  
`1 2 2 3`
