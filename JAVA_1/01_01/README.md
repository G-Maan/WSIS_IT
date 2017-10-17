# Zadanie 01_01

## Treść zadania

Napisz program, który na wejściu przyjmie trzy parametry wywołania z linii poleceń - imię, nazwisko, wiek, a następnie wyświetli napis

`Cześć <imię> <nazwisko>. Twój wiek to <wiek> lat.`

## Przykład

Przykład uruchomienia programu:  
`java MojaAplikacja -imie Jan -nazwisko Kowalski -wiek 37`

Przykładowy wynik:  
`Cześć Jan Kowalski. Twój wiek to 37 lat.`

## Uwagi

Twój program powinien uwzględnić, że parametry wywołania moga być przekazane w różnej kolejności, np.

`java MojaAplikacja -nazwisko Kowalski -wiek 37 -imie Jan`

Do   porównywania   obiektów   typu   `String`   używaj   metody   `equals`.