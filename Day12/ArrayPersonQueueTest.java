public class ArrayPersonQueueTest extends PersonQueueTest {
    protected PersonQueue createQueue() {
        return new ArrayPersonQueue();
    }
}