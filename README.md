# Втора лабораториска вежба по Софтверско инженерство

## Ана Марија Краус, бр. на индекс 226135

###  Control Flow Graph

![image](https://github.com/anamarijakraus/SI_2024_lab2_226135/assets/166819863/ef8609bd-d2a3-4634-a76e-1777d40e47d6)
 
### Цикломатска комплексност

Цикломатската комплексност на овој код е 10, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=9, па цикломатската комплексност изнесува 10. 
Исто така според формулата бр_ребра - бр_јазли + 2 = 10, каде бр_ребра=42, бр_јазли=34, по што се добива 42-34+2=10.

### Тест случаи според критериумот  Every Branch

Минимум 5 тестови се потребни за критериумот EveryBranch
Најпрво да ги покриеме сите Exceptions 

Test case 1:  allItems == null, payment = X (не е битно колку е payment)
	за throw new RuntimeException("allItems list can't be null!"); 

Test case 2: allItems = [new Item("cheese" , "180s" , X , X)], payment = X
	за throw new RuntimeException("Invalid character in item barcode!");
	не е битно за цена, попуст и payment, бидејќи фрла RuntimeException за баркодот 

Test case 3: allItems = [new Item("cheese" , null , X , X)], payment = X
	за throw new RuntimeException("No barcode!");

Test case 4: Во листата allItems се: item1 =  ["null" , "0612" , 350 , 0.2] и item2 =  ["cheese" , "0804" , 400 , 0.3], payment = 1000
	Имаме item којшто има име null. Сите елементи во листата ќе бидат со попуст, нивните цени се поголеми од 300, во баркодот првиот број е 0.
	На крај sum < payment.
	Програмата ќе врати true.

Test case 5: Во листата allItems се: item1 =  ["ham" , "1312" , 350 , 0] и item2 =  ["cheese", "1804", 400 , 0], payment = 100
	Сите елементи во листата нема да имаат попуст, при што на крај sum > payment.
	Програмата ќе врати false.

### Тест случаи според критериумот Multiple Condition
За условот:
if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0)== '0') 
Нека:
item.getPrice() > 300 = a
item.getDiscount() > 0 = b
item.getBarcode().charAt(0)== '0' = c

a && b && c
F && X && X 	e false
T && F && X 	e false
T && T && F 	e false
T && T && T 	e true
каде Х е било што T/F бидејќи условот не стига да го провери, паѓа на претходните
Следствено ни се потребни 4 Test cases:

Test case 1: 
item =  ["cheese" , "1804" , 200 , 0.3], payment = 10
Условот со овој Test case нема да биде исполнет, бидејки а (item.getPrice() > 300) е false. односно 200<300;
(F && X && X e false);

Test case 2:
item =  ["cheese" , "1804" , 400 , 0], payment = 10
Условот со овој Test case нема да биде исполнет, бидејки b (item.getDiscount() > 0) e false, односно прозиводот нема попуст, и покрај тоа што item.getPrice() > 300;
(T && F && X е false);

Test case 3: 
item =  ["cheese", "1804" , 400 , 0.3], payment = 10
Условот со овој Test case нема да биде исполнет, бидејки c (tem.getBarcode().charAt(0)== '0') e false, односно баркодот не започнува на 0;
(T && T && F e false);

Test case 4:
item =  ["cheese" , "0804" , 400 , 0.3], payment = 1000
Условот со овој Test case ќе да биде исполнет. Сите a, b и c се исполнети односно цената е поголема од 300, има попуст и баркодот започнува на 0.

