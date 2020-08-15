package linked_lists;

/**
 * 2.3 
 * Delete Middle Node : Implement an algorithm to delete a node in the middle (i.e. any node
 * but the first and last node, not necessarily the exact middle) of a singly linked list, given 
 * access to only that node.
 * 
 * EXAMPLE
 * Input: the node c from the linked lst a->b->c->d->e->f
 * Result: Nothing is returned, but the new linked list looks like a->b->d->e->f
 * 
 */

public class DeleteNodeInMiddle<T> {
    public void removeNode(Node<T> node) {
        Node<T> pointer = node, last = null;
        while(pointer.next!= null) {
            pointer.data = pointer.next.data;
            last = pointer;
            pointer = pointer.next;
        }
        last.next = null;
    }
}