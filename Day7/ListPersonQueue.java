/*
 * A PersonQueue implementation using linked lists
 */

 class ListPersonQueue implements PersonQueue {
     private static class ListPersonQueueNode {
         public Person p;
         public ListPersonQueueNode next;
     }

     private ListPersonQueueNode first = null;
     private ListPersonQueueNode last = null;

     public void insert(Person p) {
         ListPersonQueueNode newNode = new ListPersonQueueNode();
         newNode.p = p;
         newNode.next = null;
         if (first == null) {
             first = last = newNode;
         } else {
             last = last.next = newNode;
         }
     }

     public Person retrieve() {
         if (first == null) {
             return null;
         }

         Person ret = first.p;
         
         first = first.next;
         if (first == null) {
             last = null;
         }

         return ret;
     }
 }