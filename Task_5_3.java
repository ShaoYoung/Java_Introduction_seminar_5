//Написать метод, который переведет число из римского формата записи в арабский.
//Например, MMXXII = 2022
//http://graecolatini.bsu.by/htm-different/num-converter-roman.htm

//Найти алгоритм перевода
//https://www.cyberforum.ru/pascal/thread66998.html


public class Task_5_3 {
    public static void main(String[] args) {


        Program bez_tab;
        uses crt;
        var rz:string;
        n,ar,ar1,i,a: integer;

        Begin
                clrscr;
        Writeln ('Liczba rzymska');
        Readln(rz);
        ar:=0; n:=0;
        for i := 1 to length (rz) do
            begin
        ar1:=ar;
        if rz[i]='I' then ar:=1;
        if rz[i]='V' then ar:=5;
        if rz[i]='X' then ar:=10;
        if rz[i]='L' then ar:=50;
        if rz[i]='C' then ar:=100;
        if rz[i]='D' then ar:=500;
        if rz[i]='M' then ar:=1000;

        if ar>ar1 then a:=-2*ar1
              else a:=0;
        n:=n+a+ar
        end;

        Writeln ('Arabska =  ',n);
        Readln;
        end.






    }
}
