import java.util.*;

public class PetAdoptionManager {
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
            System.out.println("5. Search Pet by Name");
            System.out.println("6. Search Pet by Type");
            System.out.println("7. List Pets by Age Range");
            System.out.println("8. Count Total Pets");
            System.out.println("9. Sort Pets by Age");
            System.out.println("10. Clear All Pet Records");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");

            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            switch (option) {
                case 1:
                    addPet();
                    break;
                case 2:
                    updatePet();
                    break;
                case 3:
                    removePet();
                    break;
                case 4:
                    listPets();
                    break;
                case 5:
                    searchByName();
                    break;
                case 6:
                    searchByType();
                    break;
                case 7:
                    listByAgeRange();
                    break;
                case 8:
                    countPets();
                    break;
                case 9:
                    sortByAge();
                    break;
                case 10:
                    clearAllPets();
                    break;
                case 11:
                    System.out.println("Exiting... Goodbye! 🐶🐱");
                    return;
                default:
                    System.out.println("Invalid option, try again.");
                    break;
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

    private void searchByName() {
        System.out.print("Enter pet name to search: ");
        String name = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Pet pet : pets.values()) {
            if (pet.getName().toLowerCase().contains(name)) {
                System.out.println(pet);
                found = true;
            }
        }
        if (!found) System.out.println("No pets found with that name.");
    }

    private void searchByType() {
        System.out.print("Enter pet type to search (e.g., Dog, Cat): ");
        String type = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Pet pet : pets.values()) {
            if (pet.getType().toLowerCase().contains(type)) {
                System.out.println(pet);
                found = true;
            }
        }
        if (!found) System.out.println("No pets found of that type.");
    }

    private void listByAgeRange() {
        System.out.print("Enter minimum age: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum age: ");
        int max = Integer.parseInt(scanner.nextLine());

        boolean found = false;
        for (Pet pet : pets.values()) {
            if (pet.getAge() >= min && pet.getAge() <= max) {
                System.out.println(pet);
                found = true;
            }
        }
        if (!found) System.out.println("No pets found in that age range.");
    }

    private void countPets() {
        System.out.println("Total pets available: " + pets.size());
    }

    private void sortByAge() {
        List<Pet> petList = new ArrayList<>(pets.values());
        petList.sort(Comparator.comparingInt(Pet::getAge));
        System.out.println("Pets sorted by age:");
        for (Pet pet : petList) {
            System.out.println(pet);
        }
    }

    private void clearAllPets() {
        System.out.print("Are you sure you want to clear all pet records? (yes/no): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            pets.clear();
            System.out.println("✅ All pet records have been cleared.");
        } else {
            System.out.println("❌ Operation cancelled.");
        }
    }
}
