Зрівняння послідовного виконання java та через бібліотеку mpj.
Ідея зрівння полягає в парсингу пдф сторінок депутатського голосування. Пдф лежать в папці votings.
Результат парсинга одної сторінки - PdfData.class.
У тестовий вибірці 11 файлів. На кожний файл запускається свій окремий процес.

 
RUN\
Послідовне:
`запустити метод main в класі Lab1`
MPI:  
`-jar ~/ParallelProgramming/mpj-v0_44/lib/starter.jar Lab2 -np 11` - де "-np" - кількість процесів

Consistance processing
page 0 parsed 3499015484 nanosec\
page 1 parsed 2708992794 nanosec\
page 2 parsed 1421468219 nanosec\
page 3 parsed 150463760 nanosec\
page 4 parsed 2318901808 nanosec\
page 5 parsed 1321152342 nanosec\
page 6 parsed 61481191 nanosec\
page 7 parsed 1330978849 nanosec\
page 8 parsed 437189476 nanosec\
page 9 parsed 314402683 nanosec\
page 10 parsed 1637191365 nanosec\
all pages parsed 104238521135939 nanosec

Page 6 parsed 8269668218 nanosec\
Page 3 parsed 8633178676 nanosec\
Page 8 parsed 10965843818 nanosec\
Page 9 parsed 11233737603 nanosec\
Page 2 parsed 19084636420 nanosec\
Page 0 parsed 20359048144 nanosec\
Page 1 parsed 20947243430 nanosec\
Page 10 parsed 22490480181 nanosec\
Page 7 parsed 23160937562 nanosec\
Page 5 parsed 23317646876 nanosec\
Page 4 parsed 24487975801 nanosec\
all pages parsed 24487975801 nanosec\

Як ми бачимо розпаралелення по процесах йде швидше. 
Також пришвидшить відносний результат збільшення файлів та сторінок в них.