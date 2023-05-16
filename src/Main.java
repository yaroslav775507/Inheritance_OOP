import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException,IllegalClassFormatException {
        try{
            Scanner s = new Scanner(System.in);
            String author = s.nextLine();
            String title = s.nextLine();
            double price = Double.parseDouble(s.nextLine());
            String[] arr = author.split(" ");
            try {
                if(arr.length >2 || Character.isDigit(arr[0].charAt(0))||
                        Character.isDigit(arr[1].charAt(0))){
                    throw new IllegalArgumentException("Некорректный ввод");
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            try { if (price<1){
                throw  new IllegalArgumentException("Некорректная цена");
            }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            Book book = new Book(author,title,price);
            GoldenEditionBook goldenEditionBook = new
                    GoldenEditionBook(author,title,price);
            Method[] goldenBookDeclaredMethod = GoldenEditionBook.class.getDeclaredMethods();
            if(goldenBookDeclaredMethod.length>1){
                throw new IllegalClassFormatException("Код повторяется в GoldenEditionBook!");
            }
            System.out.println(book.toString());
            System.out.println(goldenEditionBook.toString());
        }catch (IllegalArgumentException | IllegalClassFormatException error){
            System.out.println("Что-то не так(");


        }
    }
}