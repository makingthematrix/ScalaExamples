public class Test {
    public static int add(int n) {
        return n + 1;
    }

    public static void main(String[] args) {
        WeekDay day = WeekDay.valueOf("Fri");
        String field = "";
        System.out.println("Hello World " + day.label());

        int result = Test.add(1);
        System.out.println(result);
    }
}
