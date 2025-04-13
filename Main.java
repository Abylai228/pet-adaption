import java.util.*;

public class Main {

    static class Pet {
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

        public String toString() {
            return "Pet ID: " + id + ", Name: " + name + ", Type: " + type + ", Age: " + age;
        }
    }

    static class PetAdoptionManager {
        private Map<Integer, Pet> pets = new HashMap<>();
        private int nextId = 1;
        private Scanner scanner = new Scanner(System.in);

        public void start() {
            while (true) {
                System.out.println("\n🐾 Pet Adoption System");
                System.out.println("1. Add Pet");
                System.out.println("2. Update Pet");
                System.out.println("3. Remove Pet");
                System.out.println("4. List All Pets");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int option;
                try {
                    option = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid input. Try again.");
                    continue;
                }

                switch (option) {
                    case 1 -> addPet();
                    case 2 -> updatePet();
                    case 3 -> removePet();
                    case 4 -> listPets();
                    case 5 -> {
                        System.out.println("Exiting... Goodbye! 🐶🐱");
                        return;
                    }
                    default -> System.out.println("Invalid option, try again.");
                }
            }
        }

        private void addPet() {
            System.out.print("Enter pet name: ");
            String name = scanner.nextLine();
            System.out.print("Enter pet type (e.g., Dog, Cat): ");
            String type = scanner.nextLine();
            System.out.print("Enter pet age: ");
            int age = Integer.parseInt(scanner.nextLine());

            Pet pet = new Pet(nextId++, name, type, age);
            pets.put(pet.getId(), pet);
            System.out.println("✅ Pet added successfully!");
        }

        private void updatePet() {
            System.out.print("Enter pet ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            Pet pet = pets.get(id);
            if (pet == null) {
                System.out.println("❌ Pet not found.");
                return;
            }

            System.out.print("Enter new name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) pet.setName(name);

            System.out.print("Enter new type (leave blank to keep current): ");
            String type = scanner.nextLine();
            if (!type.isEmpty()) pet.setType(type);

            System.out.print("Enter new age (-1 to keep current): ");
            int age = Integer.parseInt(scanner.nextLine());
            if (age >= 0) pet.setAge(age);

            System.out.println("✅ Pet updated successfully!");
        }

        private void removePet() {
            System.out.print("Enter pet ID to remove: ");
            int id = Integer.parseInt(scanner.nextLine());

            if (pets.remove(id) != null) {
                System.out.println("✅ Pet removed successfully.");
            } else {
                System.out.println("❌ Pet not found.");
            }
        }

        private void listPets() {
            if (pets.isEmpty()) {
                System.out.println("No pets available for adoption.");
                return;
            }

            System.out.println("\nAvailable Pets:");
            for (Pet pet : pets.values()) {
                System.out.println(pet);
            }
        }
    }

    public static void main(String[] args) {
        PetAdoptionManager manager = new PetAdoptionManager();
        manager.start();
    }
}
