public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        field.eraseField();
        field.showFields();

        field = new Field(10);
        field.eraseField();
        field.showFields();


    }

}