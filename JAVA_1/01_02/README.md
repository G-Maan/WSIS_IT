# Zadanie 01_02

## Treść zadania

Ciągiem Fibonacciego nazywamy ciąg, którego dwa pierwsze elementy są równe 1, a każdy kolejny jest sumą dwóch poprzednich:  
F(0) = 1  
F(1) = 1  
F(2) = 2  
F(3) = 3  
...  
F(n) = F(n-2) + F(n-1)

Napisz program, który na wejściu przyjmie dwa parametry, które są łańcuchami znaków a i b oraz trzeci parametr liczbę N, a następnie wyświetli N elementów ciągu Fibonacciego dla dwóch pierwszych parametrów.

## Przykład

Dla wywołania  
`java FibonacciApplication a b 6`

Otrzymamy wynik  
`a`  
`b`  
`ab`  
`bab`  
`abbab`  
`bababbab`
  
(Każdy kolejny element ciągu jest konkatenacją/złączeniem dwóch poprzednich)