// Написать метод, который переведёт данное целое число в римский формат.

//Найти алгоритм перевода

public class Task_5_4 {
    public static void main(String[] args) {



        var
        a:array[1..13]of string;
        b:array[1..13]of integer;
        i,k,n:integer;
        st,chislo:string;
        begin
        st:='MCMDCDCXCLXLXIXVIVI';
        for i:=1 to 13 do
            begin
        if i mod 2<>0 then k:=1 else k:=2;
        a[i]:=copy(st,1,k);
        delete(st,1,k);
        case i of
        1:b[i]:=1000;
        2:b[i]:=900;
        3:b[i]:=500;
        4:b[i]:=400;
        5:b[i]:=100;
        6:b[i]:=90;
        7:b[i]:=50;
        8:b[i]:=40;
        9:b[i]:=10;
        10:b[i]:=9;
        11:b[i]:=5;
        12:b[i]:=4;
        13:b[i]:=1;
        end;
        end;
        writeln('Arabskoe chislo=');
        readln(n);
        i:=0;
        repeat
        inc(i);
        while(n>=b[i]) do
            begin
        n:=n-b[i];
        chislo:=chislo+a[i];
        end;
        until n=0;
        writeln('Rimskoe chislo=',chislo);
        end.



    }

}
