public class Pet {
    private int id;
    private String name;
    private String type;
    private int age;

    public Pet(int id, String name, String type, int age) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public int getId() { return id; }
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setAge(int age) { this.age = age; }
    public int getAge() { return age; }
    public String getType() { return type; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Pet ID: " + id + ", Name: " + name + ", Type: " + type + ", Age: " + age;
    }
}
