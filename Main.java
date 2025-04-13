public class Main {
    public static void main(String[] args) {
        System.out.println("--- Testing MyLinkedList ---");
        MyList<String> linkedList = new MyLinkedList<>();

        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.addFirst("First");
        linkedList.addLast("Last");
        linkedList.add(2, "Inserted");

        System.out.println("List content:");
        for (String item : linkedList) {
            System.out.println(item);
        }

        System.out.println("First: " + linkedList.getFirst());
        System.out.println("Last: " + linkedList.getLast());
        System.out.println("Element at index 2: " + linkedList.get(2));

        linkedList.remove(2);
        linkedList.removeFirst();
        linkedList.removeLast();

        System.out.println("\nAfter deletions:");
        for (String item : linkedList) {
            System.out.println(item);
        }

        System.out.println("Contains 'Apple'? " + linkedList.exists("Apple"));
        System.out.println("Index of 'Apple': " + linkedList.indexOf("Apple"));

        Object[] array1 = linkedList.toArray();
        System.out.println("\nArray from linked list:");
        for (Object obj : array1) {
            System.out.println(obj);
        }

        linkedList.clear();
        System.out.println("\nLinkedList size after clear: " + linkedList.size());

        // ----------------------------

        System.out.println("\n--- Testing MyArrayList ---");
        MyList<String> arrayList = new MyArrayList<>();

        arrayList.add("One");
        arrayList.add("Two");
        arrayList.addFirst("Zero");
        arrayList.addLast("Three");
        arrayList.add(2, "Middle");

        System.out.println("ArrayList content:");
        for (String item : arrayList) {
            System.out.println(item);
        }

        System.out.println("First: " + arrayList.getFirst());
        System.out.println("Last: " + arrayList.getLast());
        System.out.println("Element at index 2: " + arrayList.get(2));

        arrayList.remove(2);
        arrayList.removeFirst();
        arrayList.removeLast();

        System.out.println("\nAfter deletions:");
        for (String item : arrayList) {
            System.out.println(item);
        }

        System.out.println("Contains 'One'? " + arrayList.exists("One"));
        System.out.println("Index of 'One': " + arrayList.indexOf("One"));

        Object[] array2 = arrayList.toArray();
        System.out.println("\nArray from array list:");
        for (Object obj : array2) {
            System.out.println(obj);
        }

        arrayList.clear();
        System.out.println("\nArrayList size after clear: " + arrayList.size());
    }
}