import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        /*System.out.print("Hello -- ");
        String name = console.nextLine();

        System.out.print("You are -- ");
        int age = console.nextInt();

        System.out.print("Hello "+ name  +" with " + age + " age");*/

        /*String str = "10 20 40 60";
        Scanner scanner = new Scanner(str);
        //int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println( b);*/

        /*System.out.print(" Today is -- ");
        int temp = console.nextInt();
        System.out.println("");
        if(temp <= 0) System.out.println("  Outside is cold");
        else System.out.println("  Outside is good");*/

        /*System.out.print(" You have -- ");
        double temp = console.nextDouble();
        boolean isHigh = (temp >= 37);
        boolean isLow = (temp <= 36);

        if (isHigh) System.out.println("\n You are sick");
        else if (isLow)  System.out.println("\n You have a low temperature");
        else System.out.println("\n You are all good");*/

        /*System.out.print(" Enter first number --  ");
        int a = console.nextInt();
        System.out.print(" \n Enter second number -- ");
        int b = console.nextInt();
        //int max = a>b ? a : b;
        if(a>b)
            System.out.print("\n First number -- " + a + " is more than " + b) ;
        if(a==b)
            System.out.print("\n First number -- " + a + " is equals with Second number -- " + b) ;
        else
        System.out.print("\n Second number -- " + b + " is more than " + a);

        while(console.hasNextShort())
        {
            short x = console.nextShort();
        }

        boolean isExit = false;
        while (!isExit)
        {
            String s = console.nextLine();
            isExit = s.equals("exit");
        }*/

        /*System.out.println(" Enter the numbers for calculate :: ");
        boolean isEnter = true;
        int summ = 0;
        while (isEnter){
            if(console.hasNextInt()){
                int x = console.nextInt();
                summ += x;
            }
            else if (console.hasNextLine()){
                String enter = console.nextLine();
                if(enter.equals("enter")){
                    isEnter = false;
                }
            }


        }
        System.out.println(" All the numbers  :: " + summ);8*/

        //public static void main(String args[]){
            // Ускорение свободного падения (м/с^2):
            final double g=9.8;
            // Масса (кг):
            double m=0.1;
            // Начальная скорость (м/с):
            double V=100;
            // Угол в градусах:
            double alpha=60;
            // Уровни воздушных зон (м):
            double H1=100,H2=300;
            // Коэффициенты для силы сопротивления
            // воздуха (Нс/м) и (Hc^2/м^2):
            double gamma1=0.0001,gamma2=0.0001;
            // Интервал времени (с):
            double dt=1E-6;
            // Координаты (м) и скорость (м/с)
            double Xn=0,Yn=0,Vn,Un;
            // Проекция силы сопротивления (Н):
            double Fx,Fy;
            // Время полета (с), дальность (м) и высота (м):
            double Tmax,Smax,Hmax=0;
            // Индикатор высоты (номер зоны):
            int height;
            // Перевод угла в радианы:
            alpha=toRadians(alpha);
            // Проекции начальной скорости:
            Vn=V*cos(alpha);
            Un=V*sin(alpha);
            for(int n=1;true;n++){
                // Координата по вертикали:
                Yn+=Un*dt;
                // Критерий завершения вычислений
                // и расчетные параметры:
                if(Yn<0){
                    Tmax=round((n-1)*dt*100)/100.0;
                    Smax=round(Xn*100)/100.0;
                    Hmax=round(Hmax*100)/100.0;
                    break;
                }
                // Координата по горизонтали:
                Xn+=Vn*dt;
                // Максимальная высота:
                if(Yn>Hmax) Hmax=Yn;
                // Вычисление номера зоны
                height=Yn<H1?1:Yn<H2?2:3;
                // Сила сопротивления:
                switch(height){
                    // Первая зона:
                    case 1:
                        Fx=gamma1*Vn*sqrt(Vn*Vn+Un*Un);
                        Fy=gamma1*Un*sqrt(Vn*Vn+Un*Un);
                        break;
                    // Вторая зона:
                    case 2:
                        Fx=gamma2*Vn;
                        Fy=gamma2*Un;
                        break;
                    // Третья зона:
                    default:
                        Fx=0;
                        Fy=0;
                }
                // Проекция скорости по горизонтали:
                Vn+=-Fx*dt/m;
                // Проекция скорости по вертикали:
                Un+=-g*dt-Fy*dt/m;
            }
            // Результаты вычислений:
            System.out.println(
                    "Время полета тела Tmax="+Tmax+" секунд."
            );
            System.out.println(
                    "Дальность полета тела Smax="+Smax+" метров."
            );
            System.out.println(
                    "Максимальная высота подъема тела Hmax="+
                            Hmax+" метров."
            );
    }
}