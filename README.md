# Игра m,n,k

Реализована игра `m,n,k` (_k_ в ряд на поле _m_*_n_).

Для запуска достаточно запустить Main и следовать инструкциям.

На каждом шаге вводится ход, записанный как пара чисел -- номер строки и столбца. 

Имплементирован дефолтный игрок -- `RandomPlayer`, который ходит в какое-то (не обязательно оптимальное) место. Таким образом, можно сыграть с компьютером.

У игрока есть возможность вместо своего хода сдаться (ввести `give up`) либо предложить ничью (ввести `draw`). `RandomPlayer` всегда принимает ничью.

В случае неправильного ввода будет предложено изменить данные на валидные.

Также добавлена модификация `Гекс` -- аналогичные условия, но доска имеет вид ромба с тремя направлениями линий.
