# Практическая работа №1

## Задание 1
### Создать экран, приведенный в практическом занятии на рис. 4.4
В модуле layouttype в папке res/layout был создан макет LinearLayout.
В ходе выполнения задания был создан следующий экран:
![Экран к заданию 1](/screenshots/задание_1.jpg)

## Задание 2
### Создать экран, приведенный в практическом занятии на рис. 4.3
В модуле layouttype в папке res/layout был создан макет TableLayout.
В ходе выполнения задания был создан следующий экран:
![Экран к заданию 2](/screenshots/задание_2.jpg)

## Задание 3
### Добавить на экран несколько элементов и привязать их между собой
В модуле layouttype в папке res/layout был создан макет ConstraintLayout.
В ходе выполнения задания был создан следующий экран:
![Экран к заданию 3](/screenshots/задание_3.jpg)

## Задание 4
### Требуется создать собственный экран с использованием изученных элементов
Был создан модуль control_lesson1. В разметке в папке res/layout был создан экран на примере рис. 4.6, приведенного в практическом занятии.
Получившийся экран приведен далее:
![Экран к заданию 4](/screenshots/задание_4.jpg)

## Задание 5
### Создать layout-файл «activity_second.xml».
В модуле layouttype был создан новый файл разметки activity_second.xml. Получился следующий экран из элемента PlainText и 6 кнопок:
![Экран к заданию 5](/screenshots/задание_5.jpg)
В файле MainActivity.java, для корректного запуска соответствующей разметки, был изменен метод onCreate():
```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
```
В строке setContentView(R.layout.activity_second) в аргументе идет обращение к id соответствующего файла разметки activity_second.xml.

## Задание 6
### Требуется открыть файл activity_second.xml (land) и изменить расположение кнопок так, чтобы все из них были отображены. 
В модуле layouttype был создан файл альтернативной разметки для горизонтальной ориентации экрана. Для этого в директории res был создан New Layout Resource File. Для элемента Orientation в ниспадающем списке Screen orientation был выбран Landscape.
После этого в структуре модуля появилась папка res/layout-land, в которой размещен созданный файл разметки. 
Далее в файл разметки также были добавлены элементы PlainText и 6 кнопок, получившийся экран представлен ниже.
![Экран к заданию 6](/screenshots/задание_6.1.jpg)

### Открыть модуль «control_lesson1». Добавить горизонтальную разметку. 
В модуле control_lesson1 также был создан файл альтернативной разметки для горизонтальной ориентации экрана, в результате чего в структуре модуля появилась соответствующая папка res/layout-land, в которой располагается файл разметки.
Получившийся экран для горизонтальной ориентации представлен ниже:
![Экран к заданию 6](/screenshots/задание_6.2.jpg)

## Задание 7
### Создать новый модуль ButtonClicker. Требуется, чтобы по нажатию кнопки менялось содержимое «TextView». По нажатию кнопки «WhoAmI» – выводится текст: «Мой номер по списку № Х (по журналу)», по нажатию « ItIsNotMe» – «Это не я сделал».
В ходе выполнения задания был создан модуль buttonclicker и в нем - следующий экран:
![Экран к заданию 7](/screenshots/задание_7.jpg)
Для выполнения задания в файле MainActivity.java были объявлены глобальные переменные text, btnWhoAmI, btnItsNotMe, отвечающие за элементы TextView и две кнопки соответственно. В методе onCreate() с помощью findViewById() им были присвоены ссылки соответсвующих элементов.
Для реализации нажатий на кнопки был создан объект c интерфейсом View.OnClickListener, который передается в качестве аргумента методу setOnClickListener.

### Создайте обработчик события для кнопки «btnItIsNotMe» вторым способом. Добавьте элемент «CheckBox» изменяющий свое состояние при нажатии на кнопки вместе «TextView».
Была объявлена глобальная переменная checkbox, которой в методе onCreate присваивается ссылка на соответствующий элемент CheckBox.
В качестве альтернативного способа обработки событий нажатия для кнопки btnItsNotMe в атрибуте onClick указывается название метода onButtonClick, который изменяет текст TextView на "Это не я сделал" и изменяет состояние элемента CheckBox.
Итоговый код выглядит следующим образом:
```
public class MainActivity extends AppCompatActivity {
    private TextView text;
    private Button btnWhoAmI;
    private Button btnItsNotMe;
    private CheckBox checkbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.tvOut);
        btnWhoAmI = findViewById(R.id.btnWhoAmI);
        btnItsNotMe = findViewById(R.id.btnItIsNotMe);
        checkbox = findViewById(R.id.checkBox);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        View.OnClickListener oclBtnWhoAmI = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Мой номер по списку № 20");
            }
        };
        btnWhoAmI.setOnClickListener(oclBtnWhoAmI);
    }
    public void onButtonClick(View view) {
        text.setText("Это не я сделал");
        checkbox.setChecked(true);
    }
}
```