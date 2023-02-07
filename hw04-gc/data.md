До оптимизации

| Размер хипа |     Время выполнения     |
|:------------|:------------------------:|
| 256 Мб      |     OutOfMemoryError     |
| 2   Гб      | spend msec:10123, sec:10 |
| 512 Мб      | spend msec:12061, sec:12 |
| 1 Гб        | spend msec:10409, sec:10 |
| 768 Мб      | spend msec:10507, sec:10 |
| 1536 Мб     | spend msec:10231, sec:10 |

После оптимизации(заменяем Integer на int)

| Размер хипа |    Время выполнения    |
|:------------|:----------------------:|
| 256 Мб      | spend msec:2028, sec:2 |
| 2   Гб      | spend msec:1451, sec:1 |
| 512 Мб      | spend msec:1438, sec:1 |
| 1 Гб        | spend msec:1469, sec:1 |
| 768 Мб      | spend msec:1417, sec:1 |
| 1536 Мб     | spend msec:1429, sec:1 |

После еще одной оптимизации(убираем listValues)


| Размер хипа |    Время выполнения    |
|:------------|:----------------------:|
| 256 Мб      | spend msec:741, sec:0 |
| 2   Гб      | spend msec:724, sec:0 |
| 512 Мб      | spend msec:743, sec:0 |
| 1 Гб        | spend msec:895, sec:0 |
| 768 Мб      | spend msec:761, sec:0 |
| 1536 Мб     | spend msec:743, sec:0 |