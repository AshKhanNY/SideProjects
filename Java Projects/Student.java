public class Student {
    private int age;
    private int id;
    private String name;

    public Student(int age, int id, String name){
        this.age = age;
        this.id = id;
        this.name = name;
    }
    public void setAge(int num){
        age = num > 17 ? num : 18;
    }
    public String idToString(){
        String result = Integer.toString(id);
        return result;
    }
}