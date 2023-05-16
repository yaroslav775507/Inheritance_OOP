public class Book {
    private String author;
    private String title;
    private double price;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        String[] arr = author.split(" ");
        if(arr.length >2 || Character.isDigit(arr[0].charAt(0))||
                Character.isDigit(arr[1].charAt(0))){
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IllegalArgumentException {
        if(title.length()>3){
            throw new IllegalArgumentException("Название должно быть больше 3 символов!");
        }
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IllegalArgumentException {
        if (price<1){
            throw  new IllegalArgumentException("Некорректная цена");
        }
        this.price = price;
    }

    public Book(String author, String title, double price) {
        this.author = author;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName()).append(System.lineSeparator())
                .append("Title: ").append(this.getTitle()).append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor()).append(System.lineSeparator())
                .append("Price: ").append(this.getPrice()).append(System.lineSeparator());
        return sb.toString();
    }
}
