/**
 * @program: JavaProgromming
 * @description: This is a demo.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-09-19 22:46
 */
class Student {
    private String name;
    private String sex;
    private int age;
    static String classes;//创建一个静态变量，这个变量所有的实例都会使用同一个

    // 无参的构造方法,即使不书写,默认也是这个
    // 当有参构造方法存在时,无参的构造方法最好也书写上,不然无法通过 new 类名()的方式实例对象
    public Student() {
    }

    // 有参构造方法,实例对象的同时给属性赋值
    public Student(String n, String sex, int a) {
        name = n;
        this.sex = sex;
        age = a;
    }

    public void speak() {
        System.out.println("name:" + name + "\tsex:" + sex + "\tage:" + "\tclass:" + classes);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Tom", "male", 10);
        Student.classes = "2班";
        s1.speak();
        Student s2 = new Student("Rose", "female", 10);
        Student.classes = "1班";
        s1.speak();
        s2.speak();


    }
}
